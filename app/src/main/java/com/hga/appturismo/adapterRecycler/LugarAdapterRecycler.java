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
import com.google.firebase.storage.StorageReference;
import com.hga.appturismo.R;
import com.hga.appturismo.activity.DescripcionLugarTuristicoActivity;
import com.hga.appturismo.activity.EditarLugarActivity;
import com.hga.appturismo.bdFirebase.TurismoAplicacion;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.modelo.ModeloPuntaje;
import com.hga.appturismo.modelo.ModeloUsuario;
import com.hga.appturismo.util.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by HGA:P on 12/09/2017
 */

public class LugarAdapterRecycler extends RecyclerView.Adapter<LugarAdapterRecycler.LugarViewHolder> implements Filterable {
    private ArrayList<ModeloLugarTuristico> modeloLugarTuristicos;
    private ArrayList<ModeloLugarTuristico> modeloLugarTuristicosFilter;
    private ArrayList<ModeloPuntaje> modeloPuntajes;
    private int resource;
    private Activity activity;
    private String email;
    private TurismoAplicacion app;

    public LugarAdapterRecycler(ArrayList<ModeloLugarTuristico> modeloLugarTuristicos, ArrayList<ModeloPuntaje> modeloPuntaje, int resource, Activity activity) {
        this.modeloLugarTuristicos = modeloLugarTuristicos;
        this.modeloLugarTuristicosFilter = modeloLugarTuristicos;
        this.modeloPuntajes = modeloPuntaje;

        this.resource = resource;
        this.activity = activity;
        SharedPreferences sharedPreferences = activity.getSharedPreferences("USER", MODE_PRIVATE);
        email = sharedPreferences.getString("email", "");
        app = (TurismoAplicacion) activity.getApplicationContext();

    }

    private void eliminarLugar(int position, ModeloLugarTuristico modeloLugarTuristico) {
        DatabaseReference provincia = getPostReferenceProvincia(modeloLugarTuristico.getIdFirebase(), modeloLugarTuristico.getProvincia());
        provincia.removeValue();

        modeloLugarTuristicos.remove(position);
        LugarAdapterRecycler.this.notifyItemRemoved(position);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString().toLowerCase();

                if (charString.isEmpty()) {
                    modeloLugarTuristicosFilter = modeloLugarTuristicos;
                } else {
                    ArrayList<ModeloLugarTuristico> filteredList = new ArrayList<>();

                    for (ModeloLugarTuristico modeloLugarTuristico : modeloLugarTuristicos) {

                        if ((modeloLugarTuristico.getNombre().toLowerCase()).contains(charString)
                                || modeloLugarTuristico.getProvincia().toLowerCase().contains(charString)) {

                            filteredList.add(modeloLugarTuristico);
                        }
                    }

                    modeloLugarTuristicosFilter = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = modeloLugarTuristicosFilter;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                modeloLugarTuristicosFilter = (ArrayList<ModeloLugarTuristico>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getItemCount() {
        return modeloLugarTuristicosFilter.size();
    }

    /**
     * comvertir la ruta de bdFirebase para usarlo...
     *
     * @param urlFirebase: ruta de la ruta en bdFirebase
     * @return DatabaseReference:direccion de la ruta bdFirebase en formato bdFirebase
     */
    private DatabaseReference getPostReferenceProvincia(String urlFirebase, String provincia) {
        DatabaseReference databaseReference;
        provincia = provincia.toLowerCase();
        switch (provincia) {
            case "arani":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_ARANI + urlFirebase);
                break;
            case "cercado":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_CERCADO + urlFirebase);
                break;
            case "arque":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_ARQUE + urlFirebase);
                break;
            case "ayopaya":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_AYOPAYA + urlFirebase);
                break;
            case "bolivar":
            case "bolívar":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_BOLIVAR + urlFirebase);
                break;
            case "campero":
            case "narciso campero":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_CAMPERO + urlFirebase);
                break;
            case "chapare":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_CHAPARE + urlFirebase);
                break;
            case "capinota":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_CAPINOTA + urlFirebase);
                break;
            case "esteban arze":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE + urlFirebase);
                break;
            case "jordán":
            case "jordan":
            case "germán jordán":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_GERMAN_JORDAN + urlFirebase);
                break;
            case "carrasco":
            case "josé carrasco":
            case "José Carrasco":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_JOSE_CARRASCO_TORRICO + urlFirebase);
                break;
            case "mizque":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_MIZQUE + urlFirebase);
                break;
            case "punata":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_PUNATA + urlFirebase);
                break;
            case "quillacollo":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_QUILLACOLLO + urlFirebase);
                break;
            case "tapacarí":
            case "tapacari":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_TAPACARI + urlFirebase);
                break;
            case "tiraque":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_TIRAQUE + urlFirebase);
                break;
            default:
                databaseReference = null;
                break;
        }
        return databaseReference;

    }

    private double getPromedio(LugarViewHolder holder, ModeloLugarTuristico modeloLugarTuristico) {
        double promedio = 0;
        int calificados=0;

        for (ModeloPuntaje puntaje : modeloPuntajes) {
            if (puntaje.getIdUsuarioFirebase().equals(ModeloUsuario.encriptar(email))
                    && puntaje.getIdLugarFirebase().equals(modeloLugarTuristico.getIdFirebase())
                    && puntaje.getTipo().equals(ModeloImagen.TIPO_LUGAR)) {
                setCheckEstrellas(puntaje.getPuntaje(),holder);
            }
            if (puntaje.getIdLugarFirebase().equals(modeloLugarTuristico.getIdFirebase()) && puntaje.getTipo().equals(ModeloImagen.TIPO_LUGAR)) {
                promedio += puntaje.getPuntaje();//
                calificados++;
            }
        }
        promedio=promedio>0?(promedio/calificados):0;

        return promedio;
    }

    /**
     * Cambiar de vista a la descripcon del lugar turistico
     *
     * @param modeloLugarTuristico:
     */
    private void goDescripcionLugarTuristico(ModeloLugarTuristico modeloLugarTuristico) {
        Intent intent = new Intent(activity, DescripcionLugarTuristicoActivity.class);
        intent.putExtra("lugar", modeloLugarTuristico);
        activity.startActivity(intent);
    }

    /**
     * cambiar vista  a EditarLugarTuristicoActivity
     *
     * @param modeloLugarTuristico:
     */
    private void goEditarLugarTuristico(ModeloLugarTuristico modeloLugarTuristico) {
        Intent intent = new Intent(activity, EditarLugarActivity.class);
        intent.putExtra("lugar", modeloLugarTuristico);
        activity.startActivity(intent);
    }

    /**
     * guardar estrellas marcadas en bdFirebase
     * @param estrellasMarcadas: cantidad de estrellas marcadas en un recyclerView
     * @param holder: contenedor del recyclerView
     * @param modeloLugarTuristico:
     */
    private void actualizarMarcarEstrellas(int estrellasMarcadas, LugarViewHolder holder, ModeloLugarTuristico modeloLugarTuristico) {
        TurismoAplicacion app = (TurismoAplicacion) activity.getApplicationContext();
        DatabaseReference postReference = app.getDataBaseReferencePuntaje();
        setCheckEstrellas(estrellasMarcadas, holder);

        boolean isInsert=false;
        for (ModeloPuntaje puntaje : modeloPuntajes) {
            if (ModeloUsuario.encriptar(email).equals(puntaje.getIdUsuarioFirebase())
                    &&puntaje.getTipo().equals(ModeloImagen.TIPO_LUGAR)
                    &&puntaje.getIdLugarFirebase().equals(modeloLugarTuristico.getIdFirebase())) {
                puntaje.setPuntaje(estrellasMarcadas);
                puntaje.setIdLugarFirebase(modeloLugarTuristico.getIdFirebase());
                puntaje.setIdUsuarioFirebase(email);
                puntaje.setTipo(ModeloImagen.TIPO_LUGAR);
                if (!puntaje.getIdFirebase().isEmpty()) {
                    postReference.child(puntaje.getIdFirebase()).setValue(puntaje);//actualizar puntaje de lugar en bdFirebase
                    isInsert=true;
                }
            }
        }
        if (!isInsert){
            ModeloPuntaje modeloPuntaje=new ModeloPuntaje();
            modeloPuntaje.setPuntaje(estrellasMarcadas);
            modeloPuntaje.setIdLugarFirebase(modeloLugarTuristico.getIdFirebase());
            modeloPuntaje.setIdUsuarioFirebase(email);
            modeloPuntaje.setTipo(ModeloImagen.TIPO_LUGAR);
            modeloPuntajes.add(modeloPuntaje);//actualizar lista android

            postReference.push().setValue(modeloPuntaje);//insertar en bdFirebase

            holder.promedio.setText(String.valueOf(modeloPuntaje.getPuntaje()));
        }
    }

    @Override
    public void onBindViewHolder(final LugarViewHolder holder, final int position) {
        final ModeloLugarTuristico modeloLugarTuristico = modeloLugarTuristicosFilter.get(position);
        double promedio = getPromedio(holder, modeloLugarTuristico);//marcar todas las estrellas del recycler

        setTextHolder(holder, modeloLugarTuristico, promedio);//ponser valor promedio de estrellas
        setImageHolder(holder, modeloLugarTuristico);//leer imagen desde bdFirebase
        setEstrellasHolder(holder, modeloLugarTuristico);//marcar estrellas
        setButtonHolder(holder, position, modeloLugarTuristico);//estableces acciones de botones en cardview
        setVisivilityHolder(holder,modeloLugarTuristico.getRegistradoPor());//mostrar valores dependiendo los roles y permisos
    }

    @Override
    public LugarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new LugarViewHolder(view);
    }

    private void setButtonHolder(LugarViewHolder holder, final int position, final ModeloLugarTuristico modeloLugarTuristico) {
        holder.imageCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goDescripcionLugarTuristico(modeloLugarTuristico);
            }
        });

        holder.btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goEditarLugarTuristico(modeloLugarTuristico);
            }
        });
        holder.btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarLugar(position, modeloLugarTuristico);
            }
        });
    }

    private void setCheckEstrellas(int cantidad, LugarViewHolder holder) {
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

    private void setEstrellasHolder(final LugarViewHolder holder, final ModeloLugarTuristico modeloLugarTuristico) {
        holder.estrella1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarMarcarEstrellas(Integer.parseInt(v.getTag().toString()), holder, modeloLugarTuristico);
            }
        });
        holder.estrella2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarMarcarEstrellas(Integer.parseInt(v.getTag().toString()), holder, modeloLugarTuristico);
            }
        });
        holder.estrella3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarMarcarEstrellas(Integer.parseInt(v.getTag().toString()), holder, modeloLugarTuristico);
            }
        });
        holder.estrella4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarMarcarEstrellas(Integer.parseInt(v.getTag().toString()), holder, modeloLugarTuristico);
            }
        });
        holder.estrella5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarMarcarEstrellas(Integer.parseInt(v.getTag().toString()), holder, modeloLugarTuristico);
            }
        });
    }

    private void setImageHolder(final LugarViewHolder holder, ModeloLugarTuristico modeloLugarTuristico) {
        if (modeloLugarTuristico.getImagenes().size() > 0) {
            if (!modeloLugarTuristico.getImagenes().get(0).getUrlApp().equals("")) {
                try {
                    int idImage = Integer.parseInt(modeloLugarTuristico.getImagenes().get(0).getUrlApp());
                    Picasso.with(activity).load(idImage).into(holder.imageCardView);
                } catch (NumberFormatException e) {
                    Picasso.with(activity).load(modeloLugarTuristico.getImagenes().get(0).getUrlApp()).into(holder.imageCardView);
                }
            } else {
                String urlImagenServer = modeloLugarTuristico.getImagenes().get(0).getUrlServer();

                StorageReference storageRef = app.getStorageReferenceLugarTuristico("");
                storageRef.child(urlImagenServer).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        // Got the download URL for 'users/me/profile.png'
                        // Pass it to Picasso to download, show in ImageView and caching
                        Picasso.with(activity).setIndicatorsEnabled(true);
                        Picasso.with(activity).load(uri.toString()).error(R.drawable.ic_delete).fit().into(holder.imageCardView);
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

    private void setTextHolder(LugarViewHolder holder, ModeloLugarTuristico modeloLugarTuristico, double promedio) {
        holder.promedio.setText(String.format("%.1f", promedio));//promedio con 1 decimal

        holder.nameCardView.setText(modeloLugarTuristico.getNombre());
    }

    private void setVisivilityHolder(LugarViewHolder holder,String registradoPor) {
        SharedPreferences sharedPreferences=activity.getSharedPreferences("USER",MODE_PRIVATE);
        int rol=sharedPreferences.getInt("rol",0);
        switch (rol){
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
        if (!email.isEmpty()&&email.equals(registradoPor)){
            holder.btn_editar.setVisibility(View.VISIBLE);
            holder.btn_eliminar.setVisibility(View.VISIBLE);
        }
    }

    class LugarViewHolder extends RecyclerView.ViewHolder {
        private TextView nameCardView;
        private ImageView imageCardView;
        private FloatingActionButton btn_editar;
        private FloatingActionButton btn_eliminar;
        private CheckBox estrella1;
        private CheckBox estrella2;
        private CheckBox estrella3;
        private CheckBox estrella4;
        private CheckBox estrella5;
        private TextView promedio;
        private LinearLayout layoutEstrellas;

        private LugarViewHolder(View itemView) {
            super(itemView);
            nameCardView = itemView.findViewById(R.id.nameCardView);
            imageCardView = itemView.findViewById(R.id.imageCardView);
            btn_editar = itemView.findViewById(R.id.btn_editar);
            btn_eliminar = itemView.findViewById(R.id.btn_eliminar);
            estrella1 = itemView.findViewById(R.id.star1);
            estrella2 = itemView.findViewById(R.id.star2);
            estrella3 = itemView.findViewById(R.id.star3);
            estrella4 = itemView.findViewById(R.id.star4);
            estrella5 = itemView.findViewById(R.id.star5);
            promedio = itemView.findViewById(R.id.promedioCardView);
            layoutEstrellas = itemView.findViewById(R.id.calificacion);
        }
    }
}
