package com.azhar.deckdeals.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.azhar.deckdeals.R;
import com.azhar.deckdeals.RecyclerView.Inbox.InboxAdapter;

import java.util.ArrayList;
import java.util.List;

public class InboxActivity extends AppCompatActivity {

    List<Integer> image;
    List<String> brand;
    List<String> offer;
    List<String> branch;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    InboxAdapter inboxAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);

        image = new ArrayList<>();

        image.add(R.drawable.summer_campaign);
        image.add(R.drawable.sports_shoes);
        image.add(R.drawable.lotto_posh);
        image.add(R.drawable.ls);
        image.add(R.drawable.lotto_new_arival);
        image.add(R.drawable.ap_leggenda);
        image.add(R.drawable.sports_shoes);
        image.add(R.drawable.lotto_performer_sport_sandal);
        image.add(R.drawable.lotto_works_safety_shoe);

        brand = new ArrayList<>();

        brand.add("Lotto");
        brand.add("Lotto");
        brand.add("Lotto");
        brand.add("Lotto");
        brand.add("Lotto");
        brand.add("Lotto");
        brand.add("Lotto");
        brand.add("Lotto");
        brand.add("Lotto");


        //=============================================================
        offer = new ArrayList<>();

        offer.add("BUY 1 GET 1");
        offer.add("Up to 50% off");
        offer.add("BIG SALE 20% off");
        offer.add("BUY 1 GET 1");
        offer.add("Up to 50% off");
        offer.add("BIG SALE 20% off");
        offer.add("BUY 1 GET 1");
        offer.add("Up to 50% off");
        offer.add("BIG SALE 20% off");

        //==================================================================

        branch = new ArrayList<>();

        branch.add("Dhanmondi");
        branch.add("Mirpur");
        branch.add("Uttara");
        branch.add("Banani");
        branch.add("Nikunjo");
        branch.add("Shantinagar");
        branch.add("Mohamadpur");
        branch.add("Wary");
        branch.add("Khilgaon");

        //===========================================================================
        //===========================================================================
        //===========================================================================
        recyclerView = findViewById(R.id.inboxRecyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        inboxAdapter = new InboxAdapter(this, image, brand, offer, branch);
        recyclerView.setAdapter(inboxAdapter);
    }
}