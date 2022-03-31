package com.example.myapplication.Env_Certicate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Env_CertificateActivity extends AppCompatActivity {

    DatabaseReference ref;
    FirebaseRecyclerOptions<Env_Certificate> options;
    FirebaseRecyclerAdapter<Env_Certificate,ViewHolder_Certificate> adapter;

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_env_certificate);

        ref= FirebaseDatabase.getInstance().getReference().child("Certificates");
        recyclerView=findViewById(R.id.certificate_recycler_view);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        options=new FirebaseRecyclerOptions.Builder<Env_Certificate>().setQuery(ref,Env_Certificate.class).build();
        adapter=new FirebaseRecyclerAdapter<Env_Certificate, ViewHolder_Certificate>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ViewHolder_Certificate holder, int position, @NonNull Env_Certificate model) {
                holder.certificate_id.setText(model.getId());
                holder.certificate_name.setText(model.getName());
                holder.certificate_description.setText(model.getDescription());

            }

            @NonNull
            @Override
            public ViewHolder_Certificate onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
               View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_certificate,parent,false);
                return new ViewHolder_Certificate(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}