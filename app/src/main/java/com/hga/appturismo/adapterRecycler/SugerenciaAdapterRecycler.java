package com.hga.appturismo.adapterRecycler;

import android.app.Activity;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageReference;
import com.hga.appturismo.R;
import com.hga.appturismo.bdFirebase.TurismoAplicacion;
import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.modelo.ModeloRestaurante;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by HGA on 26/11/2017
 */

public class SugerenciaAdapterRecycler extends RecyclerView.Adapter<SugerenciaAdapterRecycler.SugerenciaViewHolder>
        implements Filterable {
    private ArrayList<ModeloHotel> modeloHotels;
    private ArrayList<ModeloRestaurante> modeloRestaurantes;
    private ArrayList<ModeloLugarTuristico> modeloLugarTuristicos;
    private ArrayList<ModeloHotel> modeloHotelsFilter;
    private ArrayList<ModeloRestaurante> modeloRestaurantesFilter;
    private ArrayList<ModeloLugarTuristico> modeloLugarTuristicosFilter;
    private int resource;
    private Activity activity;
    private TurismoAplicacion app;

    public SugerenciaAdapterRecycler(ArrayList<ModeloHotel> modeloHotels, ArrayList<ModeloRestaurante> modeloRestaurantes, ArrayList<ModeloLugarTuristico> modeloLugarTuristicos, int resource, Activity activity) {
        this.modeloHotels = modeloHotels;
        this.modeloHotelsFilter = modeloHotels;
        this.modeloRestaurantes = modeloRestaurantes;
        this.modeloRestaurantesFilter = modeloRestaurantes;
        this.modeloLugarTuristicos = modeloLugarTuristicos;
        this.modeloLugarTuristicosFilter = modeloLugarTuristicos;
        this.resource = resource;
        this.activity = activity;
    }


    @Override
    public SugerenciaAdapterRecycler.SugerenciaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        this.app = (TurismoAplicacion)activity.getApplicationContext();
        return new SugerenciaViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final SugerenciaViewHolder holder, final int position) {
        int a=modeloHotelsFilter.size();
        int b=modeloRestaurantesFilter.size();

        if (position<a){
            final ModeloHotel modeloHotel= modeloHotelsFilter.get(position);
            holder.nombreCardView.setText(modeloHotel.getNombre());
            holder.tipoCardView.setText("Hotel");

            String urlImagenServer = modeloHotel.getImagenes().get(0).getUrlServer();
            StorageReference storageRef = app.getStorageReferenceImagen("");
            storageRef.child(urlImagenServer).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    // Got the download URL for 'users/me/profile.png'
                    // Pass it to Picasso to download, show in ImageView and caching
                    Picasso.with(activity).setIndicatorsEnabled(true);
                    Picasso.with(activity).load(uri.toString()).error(R.drawable.ic_delete).fit().into(holder.imageViewSugerencia);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    System.out.println("Error al cargar imagenes");
                }
            });
            Picasso.with(activity).load(modeloHotel.getImagenes().get(0).getUrlServer()).into(holder.imageViewSugerencia);
            holder.imageViewSugerencia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
        if (position>=a&&position<(a+b)){
            final ModeloRestaurante modeloRestaurante= modeloRestaurantesFilter.get(position-modeloHotels.size());
            holder.nombreCardView.setText(modeloRestaurante.getNombre());
            holder.tipoCardView.setText("Restaurante");

            String urlImagenServer = modeloRestaurante.getImagenes().get(0).getUrlServer();
            StorageReference storageRef = app.getStorageReferenceImagen("");
            storageRef.child(urlImagenServer).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Picasso.with(activity).setIndicatorsEnabled(true);
                    Picasso.with(activity).load(uri.toString()).error(R.drawable.ic_delete).fit().into(holder.imageViewSugerencia);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    System.out.println("Error al cargar imagenes");
                }
            });

            holder.imageViewSugerencia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
        if (position>=(a+b)){
            final ModeloLugarTuristico modeloLugarTuristico= modeloLugarTuristicosFilter.get(position-modeloRestaurantes.size()-modeloHotels.size());
            holder.nombreCardView.setText(modeloLugarTuristico.getNombre());
            holder.tipoCardView.setText("Lugares Turisticos");

            String urlImagenServer = modeloLugarTuristico.getImagenes().get(0).getUrlServer();
            StorageReference storageRef = app.getStorageReferenceImagen("");
            storageRef.child(urlImagenServer).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Picasso.with(activity).setIndicatorsEnabled(true);
                    Picasso.with(activity).load(uri.toString()).error(R.drawable.ic_delete).fit().into(holder.imageViewSugerencia);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    System.out.println("Error al cargar imagenes");
                }
            });


            holder.imageViewSugerencia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return modeloLugarTuristicos.size()+modeloHotels.size()+modeloRestaurantes.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString().toLowerCase();

                if (charString.isEmpty()) {
                    modeloHotelsFilter=modeloHotels;
                    modeloRestaurantesFilter=modeloRestaurantes;
                    modeloLugarTuristicosFilter=modeloLugarTuristicos;
                } else {
                    ArrayList<ModeloHotel> filteredListHotel = new ArrayList<>();
                    for (ModeloHotel modeloHotel : modeloHotels) {

                        if (modeloHotel.getNombre().toLowerCase().contains(charString)) {
                            filteredListHotel.add(modeloHotel);
                        }
                    }
                    modeloHotels=filteredListHotel;

                    ArrayList<ModeloRestaurante> filteredListRestaurante = new ArrayList<>();
                    for (ModeloRestaurante modelo: modeloRestaurantes) {

                        if (modelo.getNombre().toLowerCase().contains(charString)) {
                            filteredListRestaurante.add(modelo);
                        }
                    }
                    modeloRestaurantes=filteredListRestaurante;

                    ArrayList<ModeloLugarTuristico> filteredListLugar = new ArrayList<>();
                    for (ModeloLugarTuristico modeloLugarTuristico : modeloLugarTuristicos) {

                        if (modeloLugarTuristico.getNombre().toLowerCase().contains(charString)) {
                            filteredListLugar.add(modeloLugarTuristico);
                        }
                    }
                    modeloLugarTuristicos=filteredListLugar;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = modeloHotels;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                modeloHotelsFilter = (ArrayList<ModeloHotel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class SugerenciaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewSugerencia;
        private TextView nombreCardView;
        private TextView tipoCardView;

        private SugerenciaViewHolder(View itemView) {
            super(itemView);
            imageViewSugerencia=itemView.findViewById(R.id.imageSugerenciaCardView);
            nombreCardView =itemView.findViewById(R.id.nombreTextCardView);
            tipoCardView=itemView.findViewById(R.id.tipoTextCardView);
        }

    }
}
