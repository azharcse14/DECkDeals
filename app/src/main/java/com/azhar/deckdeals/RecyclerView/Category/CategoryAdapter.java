package com.azhar.deckdeals.RecyclerView.Category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.deckdeals.R;
import com.azhar.deckdeals.RecyclerView.Brand.BrandViewHolder;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    Context context;
    List<Integer> categoryImage;
    List<String> categoryName;

    public CategoryAdapter(Context context, List<Integer> categoryImage, List<String> categoryName) {
        this.context = context;
        this.categoryImage = categoryImage;
        this.categoryName = categoryName;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_child_layout, parent, false);

        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);

        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        holder.catImgView.setImageResource(categoryImage.get(position));
        holder.catNameTv.setText(categoryName.get(position));
    }

    @Override
    public int getItemCount() {
        return categoryName.size();
    }
}
