package com.hga.appturismo.imagenes;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageReference;
import com.hga.appturismo.R;
import com.hga.appturismo.bdFirebase.TurismoAplicacion;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImagenAcontecimientosSwip extends PagerAdapter {
    private ArrayList<ModeloLugarTuristico> imagesResources;
    private Context context;

    public ImagenAcontecimientosSwip(ArrayList<ModeloLugarTuristico> imagesResources, Context context) {
        this.imagesResources = imagesResources;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imagesResources.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        FrameLayout frameLayout = new FrameLayout(container.getContext());

        //contenedor de textos
        LinearLayout linearLayoutText = new LinearLayout(container.getContext());
        linearLayoutText.setOrientation(LinearLayout.VERTICAL);
        linearLayoutText.setGravity(Gravity.BOTTOM);
        linearLayoutText.setBackgroundColor(53292929);

        ViewPager.LayoutParams params = getLayoutParams();

        TextView acontecimiento = getAcontecimientoTextView(imagesResources.get(position).getNombre(), params);
        TextView fecha = getAcontecimientoTextView(imagesResources.get(position).getFecha(), params);

        linearLayoutText.addView(acontecimiento);
        linearLayoutText.addView(fecha);

        //contenedor de imagen
        View itemView = getView(container);
        setImageView(position, itemView);

        //agregar contenedorres de texto e imagen al contenedor principal
        frameLayout.addView(itemView);
        frameLayout.addView(linearLayoutText);

        container.addView(frameLayout);

        return frameLayout;
    }

    @NonNull
    private TextView getAcontecimientoTextView(String text, ViewPager.LayoutParams params) {
        TextView acontecimiento = new TextView(context);
        acontecimiento.setText(text);
        acontecimiento.setBackgroundColor(Color.GRAY);
        acontecimiento.setGravity(Gravity.CENTER);
        acontecimiento.setLayoutParams(params);
        acontecimiento.setTextColor(0xff000000);
        return acontecimiento;
    }

    @NonNull
    private ViewPager.LayoutParams getLayoutParams() {
        final ViewPager.LayoutParams params = new ViewPager.LayoutParams();
        params.height = ViewPager.LayoutParams.WRAP_CONTENT;
        params.width = ViewPager.LayoutParams.MATCH_PARENT;
        return params;
    }

    @NonNull
    private View getView(ViewGroup container) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView= layoutInflater.inflate(R.layout.viewpager_turismo,container,false);
        itemView.setPadding(0,0,0,0);
        itemView.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        itemView.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
        return itemView;
    }

    private void setImageView(int position, View itemView) {
        ImageView imageView = getImageView(itemView);
        final ImageView imageViewCopy = getImageView(itemView);

        cargarImagen(position, imageView, imageViewCopy);
    }

    @NonNull
    private ImageView getImageView(View itemView) {
        ImageView imageView= itemView.findViewById(R.id.imageViewTurismo);
        imageView.setBackgroundColor(Color.GRAY);
        imageView.setPadding(0, 0, 0, 0);
        imageView.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        imageView.getLayoutParams().height = 720;
        imageView.refreshDrawableState();
        return imageView;
    }

    private void cargarImagen(int position, ImageView imageView, final ImageView imageViewCopy) {
        ModeloImagen modeloImagen =imagesResources.get(position).getImagenes().get(0);
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
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
