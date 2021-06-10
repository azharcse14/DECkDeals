package com.azhar.deckdeals.RecyclerView.Brand;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.deckdeals.R;

public class BrandViewHolder extends RecyclerView.ViewHolder {
    ImageView logo;
    TextView brandName;
    public BrandViewHolder(@NonNull View itemView) {
        super(itemView);
        logo = itemView.findViewById(R.id.brand_logo_id);
        brandName = itemView.findViewById(R.id.brand_name_id);
    }
}