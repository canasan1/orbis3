package com.example.myapplication.Product;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

public class Product_FirebaseAdapter extends FirebaseRecyclerAdapter<Product,Product_FirebaseAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Product_FirebaseAdapter(@NonNull FirebaseRecyclerOptions<Product> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull Product model) {
        Picasso.get().load(model.getImagePath()).into(holder.product_image);
        holder.product_id.setText(model.getId());
        holder.product_name.setText(model.getName());
        holder.product_score.setText(String.valueOf(model.getScore()));
        holder.product_description.setText(model.getDescription());
        holder.product_imagePath.setText(model.getImagePath());

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_product, parent, false);
        return new myViewHolder(v);
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView product_id,product_name,product_score,product_description,product_brand,product_imagePath;
        ImageView product_image;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            product_id=itemView.findViewById(R.id.product_id);
            product_name=itemView.findViewById(R.id.product_name);
            product_image=itemView.findViewById(R.id.product_image);
            product_score=itemView.findViewById(R.id.product_score);
            product_description=itemView.findViewById(R.id.product_description);
            product_imagePath=itemView.findViewById(R.id.product_image_path);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(view.getContext(), ProductActivity.class);
                    intent.putExtra("product_id",product_id.getText().toString());
                    intent.putExtra("product_image_path",product_imagePath.getText().toString());
                    intent.putExtra("product_name",product_name.getText().toString());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}
