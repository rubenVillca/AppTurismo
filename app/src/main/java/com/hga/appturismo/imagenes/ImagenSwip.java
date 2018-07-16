package com.hga.appturismo.imagenes;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageReference;
import com.hga.appturismo.R;
import com.hga.appturismo.bdFirebase.TurismoAplicacion;
import com.hga.appturismo.modelo.ModeloImagen;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImagenSwip extends PagerAdapter {
    private ArrayList<ModeloImagen> imagesResources;
    private Context context;

    public ImagenSwip(ArrayList<ModeloImagen> imagesResources, Context context) {
        this.imagesResources = imagesResources;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imagesResources.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView= layoutInflater.inflate(R.layout.viewpager_turismo,container,false);
        itemView.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        itemView.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;

        ImageView imageView= itemView.findViewById(R.id.imageViewTurismo);
        imageView.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        imageView.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
        imageView.refreshDrawableState();
        final ImageView imageViewCopy=imageView;

        ModeloImagen modeloImagen =imagesResources.get(position);
        if (!modeloImagen.getUrlApp().isEmpty()) {
            try {
                Integer.parseInt(modeloImagen.getUrlApp());
                Picasso.with(context).load(Integer.parseInt(modeloImagen.getUrlApp())).into(imageView);
            }catch (NumberFormatException e){
                Picasso.with(context).load(modeloImagen.getUrlApp()).into(imageView);
            }
        }else {
            String urlImagen = modeloImagen.getUrlServer();
            TurismoAplicacion app = (TurismoAplicacion)context.getApplicationContext();
            StorageReference storageRef = app.getStorageReferenceImagen(modeloImagen.getTipoImagen()+"/"+urlImagen);
            storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    // Got the download URL for 'users/me/profile.png'
                    // Pass it to Picasso to download, show in ImageView and caching
                    Picasso.with(context).load(uri.toString()).into(imageViewCopy);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    System.out.println("Error al cargar imagenes");
                }
            });
        }

        container.addView(itemView);
        return itemView;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
