package com.azhar.deckdeals.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.azhar.deckdeals.Database.Entity.BRAND;
import com.azhar.deckdeals.Database.Repository;
import com.azhar.deckdeals.R;
import com.azhar.deckdeals.RecyclerView.Brand.BrandAdapter;

import java.util.ArrayList;
import java.util.List;

public class BrandActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<BRAND> brandArrayList;
    BrandAdapter myBrandAdapter;

    List<Integer> image;
    List<String> brand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);

        image = new ArrayList<>();

        image.add(R.drawable.lotto_logo);
        image.add(R.drawable.apex_logo);
        image.add(R.drawable.bata_logo);
        image.add(R.drawable.bay_logo);
        image.add(R.drawable.adidas_logo);
        image.add(R.drawable.nike_logo);
        image.add(R.drawable.huspupies);
        image.add(R.drawable.lv);
        image.add(R.drawable.genesis);

        brand = new ArrayList<>();

        brand.add("Lotto");
        brand.add("Apex");
        brand.add("Bata");
        brand.add("Bay");
        brand.add("adidas");
        brand.add("nike");
        brand.add("Hush Puppies");
        brand.add("LOUIS VUITTON");
        brand.add("Genesis");


        recyclerView = findViewById(R.id.brand_recyclerViewId);
        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        myBrandAdapter = new BrandAdapter(BrandActivity.this, image, brand);
        recyclerView.setAdapter(myBrandAdapter);


//        new LoadDataTask().execute();
    }

    class LoadDataTask extends AsyncTask<Void, Void, Void> {

        Repository repository;
        List<BRAND> brandList;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            repository = new Repository(getApplicationContext());
        }

        @Override
        protected Void doInBackground(Void... voids) {
            brandList = repository.getAllBrandName();
            brandArrayList = new ArrayList<>();


            for (int i = 0; i < brandList.size(); i++) {
                brandArrayList.add(brandList.get(i));
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
//            myAdapter = new Adapter(BrandActivity.this, image, brandArrayList);
//            recyclerView.setAdapter(myAdapter);
        }
    }

}