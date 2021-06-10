package com.azhar.deckdeals.RecyclerView.Inbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.deckdeals.R;

import java.util.List;

public class InboxAdapter extends RecyclerView.Adapter<InboxViewHolder> {

    Context context;
    List<Integer> image;
    List<String> brand;
    List<String> offer;
    List<String> branch;

    public InboxAdapter(Context context, List<Integer> image, List<String> brand, List<String> offer, List<String> branch) {
        this.context = context;
        this.image = image;
        this.brand = brand;
        this.offer = offer;
        this.branch = branch;
    }

    @NonNull
    @Override
    public InboxViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.like_child_card, parent, false);

        InboxViewHolder inboxViewHolder = new InboxViewHolder(view);

        return inboxViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InboxViewHolder holder, int position) {

        holder.circleImageView.setImageResource(image.get(position));
        holder.brandTv.setText(brand.get(position));
        holder.offerTv.setText(offer.get(position));
        holder.branchTv.setText(branch.get(position));

    }

    @Override
    public int getItemCount() {
        return brand.size();
    }
}
