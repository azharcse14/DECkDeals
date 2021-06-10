package com.azhar.deckdeals.RecyclerView.Brand;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.deckdeals.R;

import java.util.List;

public class BrandAdapter extends RecyclerView.Adapter<BrandViewHolder> {

    Context context;
    List<Integer> image;
    List<String> brand;
//    ArrayList<BRAND> dataSet;

    public BrandAdapter(Context context, List<Integer> image, List<String> brand) {
        this.context = context;
        this.image = image;
        this.brand = brand;
    }

    @NonNull
    @Override
    public BrandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.child_card, parent, false);

        BrandViewHolder brandViewHolder = new BrandViewHolder(view);

        return brandViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BrandViewHolder holder, int position) {

        holder.logo.setImageResource(image.get(position));
        holder.brandName.setText(brand.get(position));

    }

    @Override
    public int getItemCount() {
        return brand.size();
    }
}
