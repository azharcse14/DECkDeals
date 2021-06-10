package com.azhar.deckdeals.RecyclerView.CardStackView;

import android.content.Context;
import android.graphics.Paint;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.deckdeals.Database.Entity.DEALS;
import com.azhar.deckdeals.ItemModel;
import com.azhar.deckdeals.R;

import java.util.ArrayList;
import java.util.List;

public class CardStackViewAdapter extends RecyclerView.Adapter<CardStackViewHolder> {

    private List<ItemModel> items;

    public CardStackViewAdapter(List<ItemModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CardStackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_item_card, parent, false);

        CardStackViewHolder cardStackViewAdapter = new CardStackViewHolder(view);

        return cardStackViewAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull CardStackViewHolder holder, int position) {

//        holder.setData(items.get(position));

        ImageView productImage = holder.productImage;
//        productImage.setImageResource(image.get(position));
//
//        TextView productName = holder.productName;
//        productName.setText(dataSet.get(position).name+"");
//
//        TextView percentage = holder.percentage;
//        percentage.setText(dataSet.get(position).percentage+"");
//
//        TextView brandName = holder.brandName;
//        brandName.setText(dataSet.get(position).brandName+"");
//
//        TextView branchName = holder.branchName;
//        branchName.setText(dataSet.get(position).branchName+"");
//
//        TextView distance = holder.distance;
//        distance.setText(dataSet.get(position).distance+"");
//
//        TextView price = holder.price;
//        price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
//        price.setText(dataSet.get(position).price+"");
//
//        TextView discountPrice = holder.discountPrice;
//        discountPrice.setText(dataSet.get(position).discountPrice+"");
//
//        TextView date = holder.date;
//        date.setText(dataSet.get(position).date+"");

//        productImage.setOnTouchListener(new View.OnTouchListener() {
//            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
//                @Override
//                public void onLongPress(MotionEvent e) {
//                    super.onLongPress(e);
//                    iconBundleCl.setVisibility(View.VISIBLE);
////                    Toast.makeText(getApplicationContext(), "long press", Toast.LENGTH_LONG).show();
//                }
//
//
//                @Override
//                public boolean onSingleTapUp(MotionEvent e) {
//
//                    return super.onSingleTapUp(e);
//                }
//            });
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
////                iconBundleCl.setVisibility(View.GONE);
//
//                gestureDetector.onTouchEvent(event);
//                return false;
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public List<ItemModel> getItems() {
        return items;
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }
}
