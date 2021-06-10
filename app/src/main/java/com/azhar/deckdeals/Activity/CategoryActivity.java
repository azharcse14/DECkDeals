package com.azhar.deckdeals.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.azhar.deckdeals.R;
import com.azhar.deckdeals.RecyclerView.Category.CategoryAdapter;
import com.azhar.deckdeals.RecyclerView.Inbox.InboxAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class CategoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CategoryAdapter categoryAdapter;
    List<Integer> categoryImage;
    List<String> categoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        recyclerView = findViewById(R.id.categoryRecyclerViewId);

        categoryImage = new ArrayList<>();
        categoryImage.add(R.drawable.icon_sneakers_64);
        categoryImage.add(R.drawable.icons_food_100);
//        categoryImage.add(R.drawable.ic_clip_blue);
//        categoryImage.add(R.drawable.ic_baseline_store_mall_directory_24);
//        categoryImage.add(R.drawable.ic_baseline_grid_view_24);
//        categoryImage.add(R.drawable.ic_clip_blue);
//        categoryImage.add(R.drawable.ic_fence_on);
//        categoryImage.add(R.drawable.ic_clip_blue);
//        categoryImage.add(R.drawable.ic_baseline_store_mall_directory_24);
//        categoryImage.add(R.drawable.ic_baseline_grid_view_24);

        categoryName = new ArrayList<>();

//        categoryName.add("Airlines");
//        categoryName.add("Automobiles");
//        categoryName.add("Bakery");
//        categoryName.add("Books");
//        categoryName.add("Cosmetics");
        categoryName.add("Footwear");
        categoryName.add("Food & Restaurant");
//        categoryName.add("Grocery");
//        categoryName.add("Games");
//        categoryName.add("Gift & Flowers");

        categoryAdapter = new CategoryAdapter(this, categoryImage, categoryName);
        recyclerView.setAdapter(categoryAdapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }

    String deletedCategory;

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            int position = viewHolder.getAdapterPosition();
            List<String> archive = new ArrayList<>();

            switch (direction){
                case ItemTouchHelper.LEFT:
//                    categoryImage.remove(position);
                    categoryAdapter.notifyItemRemoved(position);
                    deletedCategory = categoryName.get(position);
                    categoryName.remove(position);
                    Snackbar.make(recyclerView, deletedCategory, Snackbar.LENGTH_LONG)
                            .setAction("Undo", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    categoryName.add(position, deletedCategory);
                                    categoryAdapter.notifyItemInserted(position);
                                }
                            }).show();
                    break;

                case ItemTouchHelper.RIGHT:
                    String cName = categoryName.get(position);
                    archive.add(cName);

                    categoryName.remove(position);
                    categoryAdapter.notifyItemRemoved(position);

                    Snackbar.make(recyclerView, "Archived", Snackbar.LENGTH_LONG)
                            .setAction("Undo", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    archive.remove(archive.lastIndexOf(cName));
                                    categoryName.add(position, cName);
                                    categoryAdapter.notifyItemInserted(position);
                                }
                            }).show();

                    break;
            }
        }

        // You must use @RecyclerViewSwipeDecorator inside the onChildDraw method
        @Override
        public void onChildDraw (Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive){
            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addSwipeLeftBackgroundColor(ContextCompat.getColor(CategoryActivity.this, R.color.colorPrimary))
                    .addSwipeLeftActionIcon(R.drawable.ic_baseline_delete_24)
                    .addSwipeRightBackgroundColor(ContextCompat.getColor(CategoryActivity.this, R.color.green))
                    .addSwipeRightActionIcon(R.drawable.ic_baseline_archive_24)
                    .addSwipeRightLabel(getString(R.string.archive))
                    .setSwipeRightLabelColor(Color.WHITE)
                    .addSwipeLeftLabel(getString(R.string.delete))
                    .setSwipeLeftLabelColor(Color.WHITE)
                    .create()
                    .decorate();
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };


}