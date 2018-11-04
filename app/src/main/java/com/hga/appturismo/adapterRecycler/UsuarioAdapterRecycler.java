package com.hga.appturismo.adapterRecycler;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.hga.appturismo.R;
import com.hga.appturismo.activity.EditarUsuarioActivity;
import com.hga.appturismo.bdFirebase.TurismoAplicacion;
import com.hga.appturismo.modelo.ModeloUsuario;

import java.util.ArrayList;

/**
 * Created by HGA on 26/11/2017
 */

public class UsuarioAdapterRecycler extends RecyclerView.Adapter<UsuarioAdapterRecycler.UsuarioViewHolder> implements Filterable {
    private ArrayList<ModeloUsuario> usuarios;
    private ArrayList<ModeloUsuario> usuariosFilter;
    private int resource;
    private Activity activity;
    private TurismoAplicacion app;

    public UsuarioAdapterRecycler(ArrayList<ModeloUsuario> usuarios, int resource, Activity activity) {
        this.usuarios = usuarios;
        this.usuariosFilter = usuarios;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public UsuarioAdapterRecycler.UsuarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        this.app = (TurismoAplicacion)activity.getApplicationContext();
        return new UsuarioViewHolder(view);

    }

    @Override
    public void onBindViewHolder(UsuarioViewHolder holder, final int position) {
        final ModeloUsuario modeloUsuario = usuariosFilter.get(position);

        holder.nameUserCardView.setText(modeloUsuario.getNombre()+" "+modeloUsuario.getApellido());
        holder.emailUserCardView.setText(modeloUsuario.getEmail());
        holder.btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, EditarUsuarioActivity.class);
                intent.putExtra("modeloUsuario",modeloUsuario);
                activity.startActivity(intent);
            }
        });
        holder.btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarUsuario(position,modeloUsuario);
            }
        });

    }

    @Override
    public int getItemCount() {
        return usuariosFilter.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString().toLowerCase();

                if (charString.isEmpty()) {
                    usuariosFilter = usuarios;
                } else {
                    ArrayList<ModeloUsuario> filteredList = new ArrayList<>();

                    for (ModeloUsuario modeloUsuario : usuarios) {

                        if (modeloUsuario.getNombre().toLowerCase().contains(charString) ||
                                modeloUsuario.getApellido().toLowerCase().contains(charString) ||
                                modeloUsuario.getEmail().toLowerCase().contains(charString) ||
                                String.valueOf(modeloUsuario.getTelefono()).contains(charString)) {

                            filteredList.add(modeloUsuario);
                        }
                    }

                    usuariosFilter = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = usuariosFilter;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                usuariosFilter = (ArrayList<ModeloUsuario>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    private void eliminarUsuario(final int position, final ModeloUsuario modeloUsuario){
        //eliminar usuario autenticate bdFirebase
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();//recuoerra usuario logeado
        assert user != null;
        user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
    @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    DatabaseReference databaseReference= app.getDataBaseReferenceUsuario(modeloUsuario.getIdFirebase());
                    databaseReference.removeValue();//eliminar de bdFirebase
                    usuarios.remove(position);
                    usuariosFilter=usuarios;
                    notifyDataSetChanged();

                    Log.d("Eliminado usuario", "Cuenta de usuario en bdFirebase eliminada.");
            }
            }
        });
    }

    class UsuarioViewHolder extends RecyclerView.ViewHolder {
        private FloatingActionButton btn_editar;
        private FloatingActionButton btn_eliminar;
        private TextView nameUserCardView;
        private TextView emailUserCardView;

        private UsuarioViewHolder(View itemView) {
            super(itemView);
            btn_editar = itemView.findViewById(R.id.btn_editar_usuario);
            btn_eliminar = itemView.findViewById(R.id.btn_eliminar_usuario);
            nameUserCardView = itemView.findViewById(R.id.nameUserCardView);
            emailUserCardView = itemView.findViewById(R.id.emailUserCardView);
        }

    }
}
