package com.hga.appturismo.imagenes;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
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
import com.hga.appturismo.util.Constants;
import com.squareup.picasso.Picasso;

import java.io.File;
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

        View itemView = layoutInflater.inflate(R.layout.viewpager_turismo, container, false);
        itemView.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        itemView.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
        itemView.setPadding(0, 0, 0, 0);

        ImageView imageView = itemView.findViewById(R.id.imageViewTurismo);
        imageView.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        imageView.getLayoutParams().height = 500;
        imageView.setBackgroundColor(Color.GRAY);
        imageView.setPadding(0, 0, 0, 0);
        imageView.refreshDrawableState();

        setImageView(position, imageView);

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    private void setImageView(int position, final ImageView imageView) {
        ModeloImagen modeloImagen = imagesResources.get(position);
        TurismoAplicacion app = (TurismoAplicacion) context.getApplicationContext();

        if (!modeloImagen.getUrlApp().isEmpty()) {
            String urlImagenApp = modeloImagen.getUrlApp();
            try {
                int imagen = Integer.parseInt(urlImagenApp);
                Picasso.with(context).load(imagen).into(imageView);
            } catch (NumberFormatException e) {
                Picasso.with(context).load(urlImagenApp).into(imageView);//si la imagen esta en el celular
                //modeloImagen.setUrlApp("");
            }
        }

        if (modeloImagen.getUrlApp().isEmpty()) {
            String urlImagenServer = modeloImagen.getTipoImagen() + "/" + modeloImagen.getUrlServer();
            if (modeloImagen.getUrlServer().contains(modeloImagen.getTipoImagen())) {
                urlImagenServer = modeloImagen.getUrlServer();
            }

            StorageReference storageRef = app.getStorageReferenceImagen(urlImagenServer);
            storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Picasso.with(context).load(uri.toString()).into(imageView);
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
