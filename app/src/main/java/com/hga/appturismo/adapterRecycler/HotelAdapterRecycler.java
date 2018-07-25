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
import com.hga.appturismo.activity.DescripcionHotelActivity;
import com.hga.appturismo.activity.EditarHotelActivity;
import com.hga.appturismo.bdFirebase.TurismoAplicacion;
import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloPuntaje;
import com.hga.appturismo.modelo.ModeloUsuario;
import com.hga.appturismo.util.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by HGA on 12/09/2017
 */

public class HotelAdapterRecycler extends RecyclerView.Adapter<HotelAdapterRecycler.HotelViewHolder> implements Filterable {
    private ArrayList<ModeloHotel> hoteles;
    private ArrayList<ModeloHotel> hotelesFilter;
    private ArrayList<ModeloPuntaje> modeloPuntajes;
    private int resource;
    private Activity activity;
    private SharedPreferences sharedPreferences;
    private String email;
    private TurismoAplicacion app;

    public HotelAdapterRecycler(ArrayList<ModeloHotel> hoteles,ArrayList<ModeloPuntaje> modeloPuntaje, int resource, Activity activity) {
        this.hoteles = hoteles;
        this.hotelesFilter = hoteles;
        this.modeloPuntajes = modeloPuntaje;

        this.resource = resource;
        this.activity = activity;
        this.sharedPreferences = activity.getSharedPreferences("USER", MODE_PRIVATE);
        this.email = sharedPreferences.getString("email", "");
        this.app = (TurismoAplicacion)activity.getApplicationContext();
    }

    @Override
    public HotelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new HotelViewHolder(view);
    }
    private double getPromedio(HotelAdapterRecycler.HotelViewHolder holder, ModeloHotel modeloHotel) {
        double promedio = 0;
        int calificados=0;

        for (ModeloPuntaje puntaje : modeloPuntajes) {
            if (puntaje.getIdUsuarioFirebase().equals(ModeloUsuario.encriptar(email))
                    && puntaje.getIdLugarFirebase().equals(modeloHotel.getIdFirebase())
                    && puntaje.getTipo().equals(ModeloImagen.TIPO_HOTEL)) {
                setCheckEstrellas(puntaje.getPuntaje(),holder);
            }
            if (puntaje.getIdLugarFirebase().equals(modeloHotel.getIdFirebase()) && puntaje.getTipo().equals(ModeloImagen.TIPO_HOTEL)) {
                promedio += puntaje.getPuntaje();//
                calificados++;
            }
        }
        promedio=promedio>0?(promedio/calificados):0;

        return promedio;
    }
    @Override
    public void onBindViewHolder(final HotelViewHolder holder, final int position) {
        ModeloHotel modeloHotel = hotelesFilter.get(position);
        double promedio=getPromedio(holder,modeloHotel);
        holder.promedio.setText(String.format("%.1f", promedio));

        setTextHolder(holder, modeloHotel, promedio);//ponser valor promedio de estrellas
        setImageHolder(holder, modeloHotel);
        setEstrellasHolder(holder, modeloHotel);//marcar estrellas
        setButtonHolder(holder, position, modeloHotel);
        setVisivilityHolder(holder,modeloHotel.getRegistradoPor());
    }

    private void setVisivilityHolder(HotelViewHolder holder, String registradoPor) {
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
                holder.btn_editar.setVisibility(View.GONE);
                holder.btn_eliminar.setVisibility(View.GONE);
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

    private void setButtonHolder(HotelViewHolder holder, final int position, final ModeloHotel modeloHotel) {
        holder.imageCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, DescripcionHotelActivity.class);
                intent.putExtra("modeloHotel", modeloHotel);
                activity.startActivity(intent);
            }
        });

        holder.btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, EditarHotelActivity.class);
                intent.putExtra("modeloHotel", modeloHotel);
                activity.startActivity(intent);
            }
        });
        holder.btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarHotel(position,modeloHotel);
            }
        });
    }

    private void setEstrellasHolder(final HotelViewHolder holder,final ModeloHotel modeloHotel) {
        holder.estrella1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarMarcarEstrellas(Integer.parseInt(v.getTag().toString()), holder, modeloHotel);
            }
        });
        holder.estrella2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarMarcarEstrellas(Integer.parseInt(v.getTag().toString()), holder, modeloHotel);
            }
        });
        holder.estrella3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarMarcarEstrellas(Integer.parseInt(v.getTag().toString()), holder, modeloHotel);
            }
        });
        holder.estrella4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarMarcarEstrellas(Integer.parseInt(v.getTag().toString()), holder, modeloHotel);
            }
        });
        holder.estrella5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarMarcarEstrellas(Integer.parseInt(v.getTag().toString()), holder, modeloHotel);
            }
        });
    }
    private void setCheckEstrellas(int cantidad, HotelAdapterRecycler.HotelViewHolder holder) {
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
     * @param estrellasMarcadas: cantidad de estrellas marcadas en un recyclerView
     * @param holder: contenedor del recyclerView
     * @param modeloHotel:
     */
    private void actualizarMarcarEstrellas(int estrellasMarcadas, HotelAdapterRecycler.HotelViewHolder holder, ModeloHotel modeloHotel) {
        TurismoAplicacion app = (TurismoAplicacion) activity.getApplicationContext();
        DatabaseReference postReference = app.getDataBaseReferencePuntaje();
        setCheckEstrellas(estrellasMarcadas, holder);

        boolean isInsert=false;
        for (ModeloPuntaje puntaje : modeloPuntajes) {
            if (ModeloUsuario.encriptar(email).equals(puntaje.getIdUsuarioFirebase())
                    &&puntaje.getTipo().equals(ModeloImagen.TIPO_HOTEL)
                    &&puntaje.getIdLugarFirebase().equals(modeloHotel.getIdFirebase())) {
                puntaje.setPuntaje(estrellasMarcadas);
                puntaje.setIdLugarFirebase(modeloHotel.getIdFirebase());
                puntaje.setIdUsuarioFirebase(email);
                puntaje.setTipo(ModeloImagen.TIPO_HOTEL);
                if (!puntaje.getIdFirebase().isEmpty()) {
                    postReference.child(puntaje.getIdFirebase()).setValue(puntaje);//actualizar puntaje del lugar (hotel, restaurante o lugar tour) en bdFirebase
                    isInsert=true;
                }
            }
        }
        if (!isInsert){
            ModeloPuntaje modeloPuntaje=new ModeloPuntaje();
            modeloPuntaje.setPuntaje(estrellasMarcadas);
            modeloPuntaje.setIdLugarFirebase(modeloHotel.getIdFirebase());
            modeloPuntaje.setIdUsuarioFirebase(email);
            modeloPuntaje.setTipo(ModeloImagen.TIPO_HOTEL);
            modeloPuntajes.add(modeloPuntaje);//actualizar lista android

            postReference.push().setValue(modeloPuntaje);//insertar en bdFirebase

            holder.promedio.setText(String.valueOf(modeloPuntaje.getPuntaje()));
        }
    }
    private void setImageHolder(final HotelViewHolder holder, ModeloHotel modeloHotel) {
        if (modeloHotel.getImagenes().size() > 0) {
            if (!modeloHotel.getImagenes().get(0).getUrlApp().equals("")) {
                try {
                    int idImage = Integer.parseInt(modeloHotel.getImagenes().get(0).getUrlApp());
                    Picasso.with(activity).load(idImage).into(holder.imageCardView);
                } catch (NumberFormatException e) {
                    Picasso.with(activity).load(modeloHotel.getImagenes().get(0).getUrlApp()).into(holder.imageCardView);
                }
            } else {
                String urlImagenServer=modeloHotel.getImagenes().get(0).getUrlServer();

                StorageReference storageRef = app.getStorageReferenceHotel(urlImagenServer);
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

    private void setTextHolder(HotelViewHolder holder, ModeloHotel modeloHotel, double promedio) {
            holder.promedio.setText(String.format("%.1f", promedio));//promedio con 1 decimal
            holder.nameCardView.setText(modeloHotel.getNombre());
    }

    private void eliminarHotel(int position, ModeloHotel modeloHotel) {
        DatabaseReference databaseReference=app.getDataBaseReferenceHotel(modeloHotel.getIdFirebase());
        databaseReference.removeValue();//eliminar de bdFirebase

        hotelesFilter.remove(modeloHotel);
        hoteles.remove(modeloHotel);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return hotelesFilter.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString().toLowerCase();

                if (charString.isEmpty()) {
                    hotelesFilter = hoteles;
                } else {
                    ArrayList<ModeloHotel> filteredList = new ArrayList<>();

                    for (ModeloHotel modeloHotel : hoteles) {

                        if (modeloHotel.getNombre().toLowerCase().contains(charString) ||
                                modeloHotel.getProvincia().toLowerCase().contains(charString)) {

                            filteredList.add(modeloHotel);
                        }
                    }

                    hotelesFilter = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = hotelesFilter;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                hotelesFilter = (ArrayList<ModeloHotel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class HotelViewHolder extends RecyclerView.ViewHolder {
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

        private HotelViewHolder(View itemView) {
            super(itemView);
            nameCardView = (TextView) itemView.findViewById(R.id.nameCardView);
            imageCardView = (ImageView) itemView.findViewById(R.id.imageCardView);
            btn_editar = (FloatingActionButton) itemView.findViewById(R.id.btn_editar);
            btn_eliminar = (FloatingActionButton) itemView.findViewById(R.id.btn_eliminar);
            estrella1 = (CheckBox) itemView.findViewById(R.id.star1);
            estrella2 = (CheckBox) itemView.findViewById(R.id.star2);
            estrella3 = (CheckBox) itemView.findViewById(R.id.star3);
            estrella4 = (CheckBox) itemView.findViewById(R.id.star4);
            estrella5 = (CheckBox) itemView.findViewById(R.id.star5);
            promedio=(TextView)itemView.findViewById(R.id.promedioCardView);
            layoutEstrellas=(LinearLayout)itemView.findViewById(R.id.calificacion);
        }
    }
}
