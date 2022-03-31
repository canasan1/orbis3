package com.example.myapplication.Product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Env_Certicate.Env_Certificate;
import com.example.myapplication.Env_Certicate.Env_Certificate_FirebaseAdapter;
import com.example.myapplication.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class ProductActivity extends AppCompatActivity {

    //Firebase init
    RecyclerView recyclerView;
    Env_Certificate_FirebaseAdapter adapter;
    ImageView product_image;
    TextView product_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);


        //todo:intent
        Bundle intent=getIntent().getExtras();
        String product_id=intent.getString("product_id");
        String product_name_text=intent.getString("product_name");
        String product_image_path=intent.getString("product_image_path");

        //todo:firebase get certificates
        FirebaseRecyclerOptions<Env_Certificate> options =
                new FirebaseRecyclerOptions.Builder<Env_Certificate>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("Products").child(product_id).child("Certificates"), Env_Certificate.class)
                        .build();
        adapter=new Env_Certificate_FirebaseAdapter(options);
        recyclerView=findViewById(R.id.certificate__recycler_view_per_product);
        adapter.startListening();
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);




        //todo:init component
        product_image=findViewById(R.id.product_page_product_image);
        product_name=findViewById(R.id.product_page_product_name);

        product_name.setText(product_name_text);
        Picasso.get().load(product_image_path).into(product_image);

    }
}