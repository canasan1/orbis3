package com.example.myapplication.Env_Certicate;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class ViewHolder_Certificate extends RecyclerView.ViewHolder {
    TextView certificate_id,certificate_name,certificate_description;
    public ViewHolder_Certificate(@NonNull View itemView) {
        super(itemView);
        certificate_description=itemView.findViewById(R.id.certificate_id);
        certificate_id=itemView.findViewById(R.id.certificate_id);
        certificate_name=itemView.findViewById(R.id.certificate_name);

    }
}
