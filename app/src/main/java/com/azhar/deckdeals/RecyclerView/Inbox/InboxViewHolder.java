package com.azhar.deckdeals.RecyclerView.Inbox;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.deckdeals.R;

public class InboxViewHolder extends RecyclerView.ViewHolder {

    ImageView circleImageView;
    TextView brandTv, offerTv,branchTv;

    public InboxViewHolder(@NonNull View itemView) {
        super(itemView);

        circleImageView = itemView.findViewById(R.id.circleImageViewId);
        brandTv = itemView.findViewById(R.id.brandTvId);
        offerTv = itemView.findViewById(R.id.offerTvId);
        branchTv = itemView.findViewById(R.id.branchTvId);
    }
}
