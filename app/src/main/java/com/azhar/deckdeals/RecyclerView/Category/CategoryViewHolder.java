package com.azhar.deckdeals.RecyclerView.Category;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.deckdeals.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    ImageView catImgView;
    TextView catNameTv;
    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);

         catImgView = itemView.findViewById(R.id.catImgVid);
         catNameTv = itemView.findViewById(R.id.catNameTvId);
    }
}
