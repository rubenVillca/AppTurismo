package com.hga.appturismo.imagenes;

import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageReference;
import com.hga.appturismo.R;
import com.hga.appturismo.activity.DescripcionLugarTuristicoActivity;
import com.hga.appturismo.activity.MainActivity;
import com.hga.appturismo.bdFirebase.TurismoAplicacion;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.util.Constants;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
    public Object instantiateItem(ViewGroup container, final int position) {
        FrameLayout frameLayout = new FrameLayout(container.getContext());

        //contenedor de textos
        LinearLayout linearLayoutText = new LinearLayout(container.getContext());
        linearLayoutText.setOrientation(LinearLayout.VERTICAL);
        linearLayoutText.setGravity(Gravity.BOTTOM);
        linearLayoutText.setAlpha(0.8f);

        ViewPager.LayoutParams params = getLayoutParams();

        TextView acontecimiento = getAcontecimientoTextView(imagesResources.get(position).getNombre(), params);
        acontecimiento.setTextColor(Color.WHITE);

        Calendar calendar=new GregorianCalendar();
        calendar.setTimeInMillis(Long.parseLong(imagesResources.get(position).getFecha()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM, yyyy");
        dateFormat.setTimeZone(calendar.getTimeZone());
        String dateAconteciminto="";
        try {
            dateAconteciminto=dateFormat.format(calendar.getTime());
        }catch (NumberFormatException e){
            System.out.println("Error al parsear datos");
        }

        TextView fecha = getAcontecimientoTextView(dateAconteciminto, params);
        fecha.setTextColor(Color.WHITE);

        linearLayoutText.addView(acontecimiento);
        linearLayoutText.addView(fecha);
        linearLayoutText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DescripcionLugarTuristicoActivity.class);
                intent.putExtra("lugar", imagesResources.get(position));
                context.startActivity(intent);
            }
        });

        //contenedor de imagen
        View itemView = getView(container);
        setImageView(position, itemView);

        //agregar contenedorres de texto e imagen al contenedor principal
        frameLayout.addView(itemView);
        frameLayout.addView(linearLayoutText);

        container.addView(frameLayout);

        return frameLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
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

        View itemView = layoutInflater.inflate(R.layout.viewpager_turismo, container, false);
        itemView.setBackgroundColor(Color.GREEN);
        itemView.setPadding(0, 0, 0, 0);
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
        ImageView imageView = itemView.findViewById(R.id.imageViewTurismo);
        imageView.setBackgroundColor(Color.GRAY);
        imageView.setPadding(0, 0, 0, 0);
        imageView.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        imageView.getLayoutParams().height = 500;
        //imageView.refreshDrawableState();
        return imageView;
    }

    private void cargarImagen(int position, ImageView imageView, final ImageView imageViewCopy) {
        ModeloLugarTuristico modeloLugarTuristico = imagesResources.get(position);
        if (!modeloLugarTuristico.getImagenes().isEmpty()) {
            ModeloImagen modeloImagen = modeloLugarTuristico.getImagenes().get(0);

            String urlImagen = Constants.FIREBASE_STORAGE_URL + modeloImagen.getTipoImagen() + "/" + modeloImagen.getUrlServer();
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
    }
}
