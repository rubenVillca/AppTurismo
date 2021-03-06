package com.hga.appturismo.adapterRecycler;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;
import com.hga.appturismo.R;
import com.hga.appturismo.activity.DescripcionRestauranteActivity;
import com.hga.appturismo.activity.EditarRestauranteActivity;
import com.hga.appturismo.bdFirebase.TurismoAplicacion;
import com.hga.appturismo.bdSQLite.SqliteLugar;
import com.hga.appturismo.bdSQLite.SqlitePuntaje;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloPuntaje;
import com.hga.appturismo.modelo.ModeloRestaurante;
import com.hga.appturismo.modelo.ModeloUsuario;
import com.hga.appturismo.util.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by on 12/09/2017
 */
public class RestauranteAdapterRecycler extends RecyclerView.Adapter<RestauranteViewHolder> implements Filterable {
    private final ArrayList<ModeloPuntaje> modeloPuntajes;
    private ArrayList<ModeloRestaurante> modeloRestaurantes;
    private ArrayList<ModeloRestaurante> restaurantesFilter;
    private int resource;
    private Activity activity;
    private SharedPreferences sharedPreferences;
    private String email;
    private TurismoAplicacion app;

    public RestauranteAdapterRecycler(ArrayList<ModeloRestaurante> modeloRestaurantes, ArrayList<ModeloPuntaje> modeloPuntaje, int resource, Activity activity) {
        this.modeloRestaurantes = modeloRestaurantes;
        this.restaurantesFilter = modeloRestaurantes;
        this.modeloPuntajes = modeloPuntaje;
        this.resource = resource;
        this.activity = activity;
        sharedPreferences = activity.getSharedPreferences("USER", MODE_PRIVATE);
        email = sharedPreferences.getString("email", "");
        this.app = (TurismoAplicacion) activity.getApplicationContext();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString().toLowerCase();

                if (charString.isEmpty()) {
                    restaurantesFilter = modeloRestaurantes;
                } else {
                    ArrayList<ModeloRestaurante> filteredList = new ArrayList<>();

                    for (ModeloRestaurante modeloRestaurante : modeloRestaurantes) {

                        if (modeloRestaurante.getNombre().toLowerCase().contains(charString) ||
                                modeloRestaurante.getProvincia().toLowerCase().contains(charString)) {

                            filteredList.add(modeloRestaurante);
                        }
                    }

                    restaurantesFilter = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = restaurantesFilter;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                restaurantesFilter = (ArrayList<ModeloRestaurante>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public RestauranteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new RestauranteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RestauranteViewHolder holder, final int position) {
        final ModeloRestaurante modeloRestaurante = restaurantesFilter.get(position);
        double promedio = getPromedio(holder, modeloRestaurante);

        setTextHolder(holder, modeloRestaurante, promedio);//ponser valor promedio de estrellas
        setImageHolder(holder, modeloRestaurante);

        int estrellas=getEstrellasFirebase(modeloRestaurante);
        setEstrellasHolder(holder, modeloRestaurante);//marcar estrellas
        setButtonHolder(holder, position, modeloRestaurante);
        setVisivilityHolder(holder, modeloRestaurante.getRegistradoPor());

    }

    private int getEstrellasFirebase(ModeloRestaurante modeloRestaurante) {
        int estrellasSeleccionadas=0;
        DatabaseReference mDatabase=app.getDataBaseReferencePuntaje(modeloRestaurante.getIdFirebasePuntaje(Constants.FIREBASE_TIPO_RESTAURANTE,email));
        mDatabase = FirebaseDatabase.getInstance().getReference();
        return estrellasSeleccionadas;
    }

    @Override
    public int getItemCount() {
        return restaurantesFilter.size();
    }

    private double getPromedio(RestauranteViewHolder holder, ModeloRestaurante modeloRestaurante) {
        double promedio = 0;
        int calificados = 0;

        for (ModeloPuntaje puntaje : modeloPuntajes) {
            String emailEncript = ModeloUsuario.codificarNombre(puntaje.getIdUsuarioFirebase());
            if (emailEncript.equals(ModeloUsuario.encriptar(email))
                    && puntaje.getIdLugarFirebase().equals(modeloRestaurante.getIdFirebase())
                    && puntaje.getTipo().equals(ModeloImagen.TIPO_RESTAURANTE)) {
                showCheckEstrellas(puntaje.getPuntaje(), holder);
            }
            if (puntaje.getIdLugarFirebase().equals(modeloRestaurante.getIdFirebase()) && puntaje.getTipo().equals(ModeloImagen.TIPO_RESTAURANTE)) {
                promedio += puntaje.getPuntaje();//
                calificados++;
            }
        }
        promedio = promedio > 0 ? (promedio / calificados) : 0;

        return promedio;
    }

    private void setVisivilityHolder(RestauranteViewHolder holder, String registradoPor) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences("USER", MODE_PRIVATE);
        int rol = sharedPreferences.getInt("rol", 0);
        switch (rol) {
            case Constants.USUARIO_ROL_ADMIN:
                holder.btn_editar.setVisibility(View.VISIBLE);
                holder.btn_eliminar.setVisibility(View.VISIBLE);
                holder.layoutEstrellas.setVisibility(View.VISIBLE);
                holder.estrella1.setVisibility(View.VISIBLE);
                holder.estrella2.setVisibility(View.VISIBLE);
                holder.estrella3.setVisibility(View.VISIBLE);
                holder.estrella4.setVisibility(View.VISIBLE);
                holder.estrella5.setVisibility(View.VISIBLE);
                break;
            case Constants.USUARIO_ROL_REVISOR:
                holder.btn_editar.setVisibility(View.VISIBLE);
                holder.btn_eliminar.setVisibility(View.VISIBLE);
                holder.layoutEstrellas.setVisibility(View.VISIBLE);
                holder.estrella1.setVisibility(View.VISIBLE);
                holder.estrella2.setVisibility(View.VISIBLE);
                holder.estrella3.setVisibility(View.VISIBLE);
                holder.estrella4.setVisibility(View.VISIBLE);
                holder.estrella5.setVisibility(View.VISIBLE);
                break;
            default://para usuario no logueado
                holder.btn_editar.setVisibility(View.GONE);
                holder.btn_eliminar.setVisibility(View.GONE);
                holder.layoutEstrellas.setVisibility(View.VISIBLE);
                holder.estrella1.setVisibility(View.VISIBLE);
                holder.estrella2.setVisibility(View.VISIBLE);
                holder.estrella3.setVisibility(View.VISIBLE);
                holder.estrella4.setVisibility(View.VISIBLE);
                holder.estrella5.setVisibility(View.VISIBLE);
                break;
        }

        String email = sharedPreferences.getString("email", "");
        if (!email.isEmpty() && email.equals(registradoPor)) {
            holder.btn_editar.setVisibility(View.VISIBLE);
            holder.btn_eliminar.setVisibility(View.VISIBLE);
        }
    }

    private void setButtonHolder(RestauranteViewHolder holder, final int position, final ModeloRestaurante modeloRestaurante) {
        holder.imageCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, DescripcionRestauranteActivity.class);
                intent.putExtra("modeloRestaurante", modeloRestaurante);
                activity.startActivity(intent);
            }
        });

        holder.btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, EditarRestauranteActivity.class);
                intent.putExtra("modeloRestaurante", modeloRestaurante);
                activity.startActivity(intent);
            }
        });
        holder.btn_eliminar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        eliminarRestaurante(position, modeloRestaurante);
                    }
                });
    }

    private void setEstrellasHolder(final RestauranteViewHolder holder, final ModeloRestaurante modeloRestaurante) {
        holder.estrella1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarFirebaseEstrellas(Integer.parseInt(v.getTag().toString()), holder, modeloRestaurante);
            }
        });
        holder.estrella2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarFirebaseEstrellas(Integer.parseInt(v.getTag().toString()), holder, modeloRestaurante);
            }
        });
        holder.estrella3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarFirebaseEstrellas(Integer.parseInt(v.getTag().toString()), holder, modeloRestaurante);
            }
        });
        holder.estrella4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarFirebaseEstrellas(Integer.parseInt(v.getTag().toString()), holder, modeloRestaurante);
            }
        });
        holder.estrella5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarFirebaseEstrellas(Integer.parseInt(v.getTag().toString()), holder, modeloRestaurante);
            }
        });
    }

    private void showCheckEstrellas(int cantidad, RestauranteViewHolder holder) {
        switch (cantidad) {
            case 1:
                holder.estrella1.setChecked(true);
                holder.estrella2.setChecked(false);//desmarcar mayores a 1
                holder.estrella3.setChecked(false);
                holder.estrella4.setChecked(false);
                holder.estrella5.setChecked(false);
                break;
            case 2:
                holder.estrella1.setChecked(true);
                holder.estrella2.setChecked(true);
                holder.estrella3.setChecked(false);
                holder.estrella4.setChecked(false);
                holder.estrella5.setChecked(false);
                break;
            case 3:
                holder.estrella1.setChecked(true);
                holder.estrella2.setChecked(true);
                holder.estrella3.setChecked(true);
                holder.estrella4.setChecked(false);
                holder.estrella5.setChecked(false);
                break;
            case 4:
                holder.estrella1.setChecked(true);
                holder.estrella2.setChecked(true);
                holder.estrella3.setChecked(true);
                holder.estrella4.setChecked(true);
                holder.estrella5.setChecked(false);
                break;
            case 5:
                holder.estrella1.setChecked(true);
                holder.estrella2.setChecked(true);
                holder.estrella3.setChecked(true);
                holder.estrella4.setChecked(true);
                holder.estrella5.setChecked(true);
                break;
            default:
                holder.estrella1.setChecked(false);
                holder.estrella2.setChecked(false);
                holder.estrella3.setChecked(false);
                holder.estrella4.setChecked(false);
                holder.estrella5.setChecked(false);
                break;
        }
    }

    /**
     * guardar estrellas marcadas en bdFirebase
     *
     * @param estrellasMarcadas: cantidad de estrellas marcadas en un recyclerView
     * @param holder:            contenedor del recyclerView
     * @param modeloRestaurante:
     */
    private void guardarFirebaseEstrellas(int estrellasMarcadas, RestauranteViewHolder holder, ModeloRestaurante modeloRestaurante) {
        TurismoAplicacion app = (TurismoAplicacion) activity.getApplicationContext();
        DatabaseReference postReference = app.getDataBaseReferencePuntaje();
        showCheckEstrellas(estrellasMarcadas, holder);

        ModeloPuntaje modeloPuntaje = new ModeloPuntaje();
        boolean isInsert = false;

        for (ModeloPuntaje puntaje : modeloPuntajes) {
            if (ModeloUsuario.encriptar(email).equals(puntaje.getIdUsuarioFirebase())
                    && puntaje.getTipo().equals(ModeloImagen.TIPO_RESTAURANTE)
                    && puntaje.getIdLugarFirebase().equals(modeloRestaurante.getIdFirebase())) {
                puntaje.setPuntaje(estrellasMarcadas);
                puntaje.setIdLugarFirebase(modeloRestaurante.getIdFirebase());
                puntaje.setIdUsuarioFirebase(email);
                puntaje.setTipo(ModeloImagen.TIPO_RESTAURANTE);
                if (!puntaje.getIdFirebase().isEmpty()) {
                    modeloPuntaje=puntaje;
                    isInsert=true;
                    break;
                }
            }
        }
        if (!isInsert) {
            modeloPuntaje.setPuntaje(estrellasMarcadas);
            modeloPuntaje.setIdLugarFirebase(modeloRestaurante.getIdFirebase());
            modeloPuntaje.setIdUsuarioFirebase(email);
            modeloPuntaje.setTipo(ModeloImagen.TIPO_RESTAURANTE);
            modeloPuntajes.add(modeloPuntaje);//actualizar lista android

            postReference.child(modeloRestaurante.getIdFirebasePuntaje(Constants.FIREBASE_TIPO_RESTAURANTE,email)).setValue(modeloPuntaje);//insertar en bdFirebase
            holder.promedio.setText(String.valueOf(modeloPuntaje.getPuntaje()));
        }else{
            postReference.child(modeloPuntaje.getIdFirebase()).setValue(modeloPuntaje);//actualizar puntaje del lugar (hotel, restaurante o lugar tour) en bdFirebase
        }

        SqlitePuntaje sqlitePuntaje=new SqlitePuntaje(activity);
        sqlitePuntaje.update(modeloPuntajes,modeloPuntaje.getTipo());
    }

    private void setImageHolder(final RestauranteViewHolder holder, ModeloRestaurante modeloRestaurante) {
        if (modeloRestaurante.getImagenes().size() > 0) {
            if (!modeloRestaurante.getImagenes().get(0).getUrlApp().equals("")) {
                try {
                    int idImage = Integer.parseInt(modeloRestaurante.getImagenes().get(0).getUrlApp());
                    Picasso.with(activity).load(idImage).into(holder.imageCardView);
                } catch (NumberFormatException e) {
                    Picasso.with(activity).load(modeloRestaurante.getImagenes().get(0).getUrlApp()).into(holder.imageCardView);
                }
            } else {
                String urlImagenServer = modeloRestaurante.getImagenes().get(0).getUrlServer();

                StorageReference storageRef = app.getStorageReferenceRestaurante(urlImagenServer);
                storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        // Got the download URL for 'users/me/profile.png'
                        // Pass it to Picasso to download, show in ImageView and caching
                        Picasso.with(activity).load(uri.toString()).into(holder.imageCardView);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        System.out.println("Error al cargar imagenes");
                    }
                });
            }
        }
    }

    private void setTextHolder(RestauranteViewHolder holder, ModeloRestaurante modeloRestaurante, double promedio) {
        holder.promedio.setText(String.format("%.1f", promedio));//promedio con 1 decimal
        holder.nameCardView.setText(modeloRestaurante.getNombre());
    }

    private void eliminarRestaurante(int position, ModeloRestaurante modeloRestaurante) {
        DatabaseReference databaseReference = app.getDataBaseReferenceRestaurante(modeloRestaurante.getIdFirebase());
        databaseReference.removeValue();//eliminar de bdFirebase

        int p = restaurantesFilter.indexOf(modeloRestaurante);
        restaurantesFilter.remove(modeloRestaurante);
        modeloRestaurantes.remove(modeloRestaurante);
        //notifyDataSetChanged();
        notifyItemRemoved(p);
    }
}
