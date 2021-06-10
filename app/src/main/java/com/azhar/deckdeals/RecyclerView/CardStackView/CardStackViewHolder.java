package com.azhar.deckdeals.RecyclerView.CardStackView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.deckdeals.ItemModel;
import com.azhar.deckdeals.R;
import com.squareup.picasso.Picasso;

public class CardStackViewHolder extends RecyclerView.ViewHolder {

    ImageView productImage;
    TextView productName, percentage, brandName, branchName, distance, price, discountPrice, date;

    public CardStackViewHolder(@NonNull View itemView) {
        super(itemView);

        productImage = itemView.findViewById(R.id.product_img_id);
        productName = itemView.findViewById(R.id.productNameId);
        percentage = itemView.findViewById(R.id.percentageId);
        brandName = itemView.findViewById(R.id.brandNameId);
        branchName = itemView.findViewById(R.id.branchNameId);
        distance = itemView.findViewById(R.id.distanceId);
        price = itemView.findViewById(R.id.priceId);
        discountPrice = itemView.findViewById(R.id.discountPriceId);
        date = itemView.findViewById(R.id.dateId);
    }

    void setData(ItemModel data){
        Picasso.get()
                .load(data.getProductImage())
                .fit()
                .centerCrop()
                .into(productImage);
        productName.setText(data.getProductName());
        percentage.setText(data.getPercentage());
        brandName.setText(data.getBrandName());
        branchName.setText(data.getBranchName());
        distance.setText(data.getDistance());
        price.setText(data.getPrice());
        discountPrice.setText(data.getDiscountPrice());
        date.setText(data.getDate());
    }
}
