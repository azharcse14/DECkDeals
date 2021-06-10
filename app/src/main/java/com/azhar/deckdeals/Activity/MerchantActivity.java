package com.azhar.deckdeals.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.azhar.deckdeals.Database.Entity.MERCHANT;
import com.azhar.deckdeals.Database.Repository;
import com.azhar.deckdeals.R;
import com.azhar.deckdeals.RecyclerView.Brand.BrandAdapter;
import com.azhar.deckdeals.RecyclerView.Merchant.MerchantAdapter;

import java.util.ArrayList;
import java.util.List;

public class MerchantActivity extends AppCompatActivity {

    Repository repository;
    ArrayList<MERCHANT> merchantArrayList;
    List<Integer> image;
    List<String> brand;

    RecyclerView recyclerView;
    MerchantAdapter merchantAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant);

        recyclerView = findViewById(R.id.merchantRecyclerViewId);


        image = new ArrayList<>();

        image.add(R.drawable.lotto_logo);
        image.add(R.drawable.herfy_logo);

        brand = new ArrayList<>();

        brand.add("Lotto");
        brand.add("Herfy");

        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        merchantAdapter = new MerchantAdapter(MerchantActivity.this, image, brand);
        recyclerView.setAdapter(merchantAdapter);



//        new LoadDataTask().execute();
    }

    //================================== AsyncTask Data Retrieve from table ============================================================

    class LoadDataTask extends AsyncTask<Void, Void, Void> {

        Repository repository;
        List<MERCHANT> merchantList;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            repository = new Repository(getApplicationContext());
        }

        @Override
        protected Void doInBackground(Void... voids) {
            merchantList = repository.getAllMerchant();
            merchantArrayList = new ArrayList<>();

            merchantArrayList.addAll(merchantList);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

//            merchantAdapter = new MerchantAdapter(getApplicationContext(), merchantArrayList, image);
//            recyclerView.setAdapter(merchantAdapter);

        }
    }

}