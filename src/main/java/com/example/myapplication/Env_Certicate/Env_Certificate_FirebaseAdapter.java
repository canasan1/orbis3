package com.example.myapplication.Env_Certicate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Env_Certicate.Env_Certificate;
import com.example.myapplication.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

public class Env_Certificate_FirebaseAdapter extends FirebaseRecyclerAdapter<Env_Certificate,Env_Certificate_FirebaseAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Env_Certificate_FirebaseAdapter(@NonNull FirebaseRecyclerOptions<Env_Certificate> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull Env_Certificate model) {
        Picasso.get().load(model.getImagePath()).into(holder.certificate_image);
        holder.certificate_id.setText(model.getId());
        holder.certificate_name.setText(model.getName());
        holder.certificate_description.setText(model.getDescription());

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_certificate, parent, false);
        return new myViewHolder(v);
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView certificate_id,certificate_name,certificate_description;
        ImageView certificate_image;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            certificate_id=itemView.findViewById(R.id.certificate_id);
            certificate_name=itemView.findViewById(R.id.certificate_name);
            certificate_description=itemView.findViewById(R.id.certificate_description);
            certificate_image=itemView.findViewById(R.id.certificate_image);

        }

    }
}
