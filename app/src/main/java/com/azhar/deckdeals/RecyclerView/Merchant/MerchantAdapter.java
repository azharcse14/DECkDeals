package com.azhar.deckdeals.RecyclerView.Merchant;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.deckdeals.Database.Entity.MERCHANT;
import com.azhar.deckdeals.ImageProcessing.ImageDecoder;
import com.azhar.deckdeals.R;
import com.azhar.deckdeals.RecyclerView.Category.CategoryViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MerchantAdapter extends RecyclerView.Adapter<MerchantViewHolder> {


    Context context;
    ArrayList<MERCHANT> merchantArrayList;
    List<Integer> image;
    List<String> brand;
    ImageDecoder imageDecoder;

    public MerchantAdapter(Context context, List<Integer> image, List<String> brand) {
        this.context = context;
        this.image = image;
        this.brand = brand;
    }

    @NonNull
    @Override
    public MerchantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.category_child_layout, parent, false);

        MerchantViewHolder merchantViewHolder = new MerchantViewHolder(view);

        return merchantViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MerchantViewHolder holder, int position) {
//        Bitmap img = imageDecoder.convert(merchantArrayList.get(position).logo);
//        holder.catImgView.setImageBitmap(img);
        holder.catImgView.setImageResource(image.get(position));
//        holder.catNameTv.setText(merchantArrayList.get(position).brandName);
        holder.catNameTv.setText(brand.get(position));

    }

    @Override
    public int getItemCount() {
        return brand.size();
    }
}
