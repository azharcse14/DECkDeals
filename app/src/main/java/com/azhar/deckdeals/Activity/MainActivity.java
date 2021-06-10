package com.azhar.deckdeals.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.azhar.deckdeals.Activity.Geofence.GeofenceActivity;
import com.azhar.deckdeals.Database.Entity.DEALS;
import com.azhar.deckdeals.Database.Entity.MERCHANT;
import com.azhar.deckdeals.Database.Repository;
import com.azhar.deckdeals.ImageProcessing.ImageEncoder;
import com.azhar.deckdeals.ItemModel;
import com.azhar.deckdeals.R;
import com.azhar.deckdeals.RecyclerView.CardStackView.CardStackViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    FloatingActionButton gridFAB, refreshFAB, attachFAB, callFAB, backFAB;
    ImageView navMenu;
    NavigationView navigationView;

    TextView deckPointsCountTv;
    ConstraintLayout iconBundleCl;

    private static final String TAG = "MainActivity";
    private CardStackLayoutManager manager;
    private CardStackViewAdapter adapter;
    CardStackView cardStackView;

    Repository repository;
    ArrayList<DEALS> dealsArrayList;
    List<ItemModel> items;


    String lottoLogo, herfyLogo;
    int deckPoints = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);

        navMenu = findViewById(R.id.nav_menue_icon_id);
        navigationView=findViewById(R.id.navigation_view);
        iconBundleCl = findViewById(R.id.iconBundleClId);
        gridFAB = findViewById(R.id.gridFBid);
        refreshFAB = findViewById(R.id.refreshFBid);
        attachFAB = findViewById(R.id.fileFBid);
        callFAB = findViewById(R.id.callFbId);
        backFAB = findViewById(R.id.backFBid);
        deckPointsCountTv = findViewById(R.id.deckPointsCountTvId);

        iconBundleCl.setVisibility(View.GONE);

        //========================= Brand Name Input In Database ====================

//        Repository  repository = new Repository(getApplicationContext());
//
//        repository.InsertBrandTask(new BRAND("Lotto"));
//        repository.InsertBrandTask(new BRAND("Apex"));
//        repository.InsertBrandTask(new BRAND("Bata"));
//        repository.InsertBrandTask(new BRAND("Bay"));
//        repository.InsertBrandTask(new BRAND("adidas"));
//        repository.InsertBrandTask(new BRAND("nike"));
//        repository.InsertBrandTask(new BRAND("Hush Puppies"));
//        repository.InsertBrandTask(new BRAND("LOUIS VUITTON"));
//        repository.InsertBrandTask(new BRAND("Genesis"));


// ========================= Brand Name Input In Database ====================

        Repository  repository = new Repository(getApplicationContext());
        repository.DeleteAllMerchantTask();

        ImageEncoder imageEncoder = new ImageEncoder();
        lottoLogo = imageEncoder.convert(R.drawable.lotto_logo_mini);
        herfyLogo = imageEncoder.convert(R.drawable.herfy_logo_mini);

        repository.InsertMerchantTask(new MERCHANT("Lotto", "Mawna Union, Bangladesh", 23.813287730911888, 90.41033836812475, lottoLogo));
        repository.InsertMerchantTask(new MERCHANT("Herfy", "1 Gulshan Avenue, Road-1, House-1. GL Bhaban Ground Floor,1st Floor, Dhaka 1212",23.774547870610586, 90.41636126389888, herfyLogo));


        //===================================================================================================

        //=============================== Floating Action Button Click Action =======================

        gridFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BrandActivity.class);
                startActivity(intent);
            }
        });

        refreshFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        attachFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InboxActivity.class);
                startActivity(intent);
            }
        });

        callFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "tel:" + "+8801704163838";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(phone));

                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    return;

                }
                startActivity(intent);

            }
        });

        //======================================== SharedPreferences for Deck Points======================================================

        SharedPreferences sp = getSharedPreferences("DeckPoints", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (sp.contains("deckPoints")) {
            int deckPointSp = sp.getInt("deckPoints", deckPoints);
            deckPointsCountTv.setText(String.valueOf(deckPointSp));
        }

        //==================================== CardStackView  for Card Swipe ==========================================================

        cardStackView = findViewById(R.id.card_stack_view);
        manager = new CardStackLayoutManager(this, new CardStackListener() {
            @Override
            public void onCardDragging(Direction direction, float ratio) {
                Log.d(TAG, "onCardDragging: d=" + direction.name() + " ratio=" + ratio);
            }

            @Override
            public void onCardSwiped(Direction direction) {
                Log.d(TAG, "onCardSwiped: p=" + manager.getTopPosition() + " d=" + direction);
                if (direction == Direction.Right) {

                    SharedPreferences sp = getSharedPreferences("DeckPoints", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();

                    if (sp.contains("deckPoints")) {
                        int deckPointSp = sp.getInt("deckPoints", 0);

                        deckPoints = deckPointSp + 2;
                    }

                    editor.putInt("deckPoints", deckPoints);

                    editor.apply();

                    editor.commit();

                    deckPointsCountTv.setText(String.valueOf(deckPoints));
                }
//                if (direction == Direction.Top){
//                    Toast.makeText(MainActivity.this, "Direction Top", Toast.LENGTH_SHORT).show();
//                }
//                if (direction == Direction.Left){
//                    Toast.makeText(MainActivity.this, "Direction Left", Toast.LENGTH_SHORT).show();
//                }
//                if (direction == Direction.Bottom){
//                    Toast.makeText(MainActivity.this, "Direction Bottom", Toast.LENGTH_SHORT).show();
//                }

                // Paginating
                if (manager.getTopPosition() == adapter.getItemCount() - 5) {
                    paginate();
                }

            }

            @Override
            public void onCardRewound() {
                Log.d(TAG, "onCardRewound: " + manager.getTopPosition());
            }

            @Override
            public void onCardCanceled() {
                Log.d(TAG, "onCardRewound: " + manager.getTopPosition());
            }

            @Override
            public void onCardAppeared(View view, int position) {
                TextView tv = view.findViewById(R.id.productNameId);
                Log.d(TAG, "onCardAppeared: " + position + ", name: " + tv.getText());
            }

            @Override
            public void onCardDisappeared(View view, int position) {
                TextView tv = view.findViewById(R.id.productNameId);
                Log.d(TAG, "onCardAppeared: " + position + ", name: " + tv.getText());
            }
        });

        manager.setStackFrom(StackFrom.Bottom);
        manager.setVisibleCount(3);
        manager.setTranslationInterval(2.5f);
        manager.setScaleInterval(0.99f);
        manager.setSwipeThreshold(0.3f);
        manager.setMaxDegree(20.0f);
        manager.setDirections(Direction.HORIZONTAL);
        manager.setCanScrollHorizontal(true);
        manager.setSwipeableMethod(SwipeableMethod.Manual);
        manager.setOverlayInterpolator(new LinearInterpolator());
        adapter = new CardStackViewAdapter(addList());
        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(adapter);
        cardStackView.setItemAnimator(new DefaultItemAnimator());

        //============================= GestureDetector ======================================

        cardStackView.setOnTouchListener(new View.OnTouchListener() {

            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
                @Override
                public void onLongPress(MotionEvent e) {
                    super.onLongPress(e);
                    iconBundleCl.setVisibility(View.VISIBLE);
//                    Toast.makeText(getApplicationContext(), "long press", Toast.LENGTH_LONG).show();
                }


                @Override
                public boolean onSingleTapUp(MotionEvent e) {

                    return super.onSingleTapUp(e);
                }
            });

            @Override
            public boolean onTouch(View v, MotionEvent event) {

//                iconBundleCl.setVisibility(View.GONE);

                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        //====================================================================================================
        navigationView.setNavigationItemSelectedListener( this);

    }

    private void paginate() {
//        List<ItemModel> old = adapter.getItems();
//        List<ItemModel> baru = new ArrayList<>(addList());
//        CardStackCallback callback = new CardStackCallback(old, baru);
//        DiffUtil.DiffResult hasil = DiffUtil.calculateDiff(callback);
//        adapter.setItems(baru);
//        hasil.dispatchUpdatesTo(adapter);
    }

    //=================================================== Data for Card =========================================
    private List<ItemModel> addList() {
         items = new ArrayList<>();

        items.add(new ItemModel(R.drawable.herpy_v_card, "Herfy wishes", "Herfy", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));
        items.add(new ItemModel(R.drawable.summer_campaign, "Herfy wishes", "Herfy", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));
        items.add(new ItemModel(R.drawable.lotto_posh, "Herfy wishes", "Herfy", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));
        items.add(new ItemModel(R.drawable.lotto_new_arival, "Herfy wishes", "Herfy", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));
        items.add(new ItemModel(R.drawable.ap_leggenda, "Herfy wishes", "Herfy", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));
        items.add(new ItemModel(R.drawable.download, "Herfy wishes", "Herfy", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));
        items.add(new ItemModel(R.drawable.ls, "Herfy wishes", "Herfy", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));
        items.add(new ItemModel(R.drawable.sports_shoes, "Herfy wishes", "Herfy", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));
        items.add(new ItemModel(R.drawable.dinamica_300_iii_blue, "DINAMICA 300", "LOTTO", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));
        items.add(new ItemModel(R.drawable.lotto_works_safety_shoe, "WORKS SHOE", "LOTTO", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));
        items.add(new ItemModel(R.drawable.lotto_runner_ii_grey, "RUNNER II", "LOTTO", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));
        items.add(new ItemModel(R.drawable.breeze_free_iii, "BREEZE FREE III", "LOTTO", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));
        items.add(new ItemModel(R.drawable.lotto_performer_sport_sandal, "SPORT SANDAL", "LOTTO", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));
        items.add(new ItemModel(R.drawable.lotto_performer_sport_sandal, "SPORT SANDAL", "LOTTO", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));
        items.add(new ItemModel(R.drawable.lotto_performer_sport_sandal, "SPORT SANDAL", "LOTTO", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));
        items.add(new ItemModel(R.drawable.lotto_performer_sport_sandal, "SPORT SANDAL", "LOTTO", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));
        items.add(new ItemModel(R.drawable.lotto_performer_sport_sandal, "SPORT SANDAL", "LOTTO", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));
        items.add(new ItemModel(R.drawable.tshirt, "Sports T-Shirt", "LOTTO", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));
        items.add(new ItemModel(R.drawable.lotto_soccer_ball_orange, "FOOTBALL", "LOTTO", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));
        items.add(new ItemModel(R.drawable.lotto_soccer_ball_orange, "FOOTBALL", "LOTTO", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));
        items.add(new ItemModel(R.drawable.lotto_soccer_ball_orange, "FOOTBALL", "LOTTO", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));
        items.add(new ItemModel(R.drawable.lotto_soccer_ball_orange, "FOOTBALL", "LOTTO", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));
        items.add(new ItemModel(R.drawable.lotto_soccer_ball_orange, "FOOTBALL", "LOTTO", "Jamuna Future Park", "20%", "200 m", "990.00", "792.00", "29 Mar 2021"));

        return items;
    }

    public void goToWebSite(View view) {
        String url = "https://lotto.expressleather.com.bd";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void goToDeckRatingActivity(View view) {
        startActivity(new Intent(MainActivity.this, DeckRatingActivity.class));
    }

    public void goToDirectionActivity(View view) {
        startActivity(new Intent(MainActivity.this, GeofenceActivity.class));

    }

    public void goToArialDistanceActivity(View view) {
//        startActivity(new Intent(MainActivity.this, ArialDistanceActivity.class));

        //Display track

        DisplayTrack();

    }

    private void DisplayTrack() {
        String source = "DOHS+Baridhara+Mosque,+Lane+-+5,+Dacca";
        String destination = "Lotto+Outlet,+Mawna,+Road+No+-+25,+Gulshan,+Dhaka";
        try {
            //when google map is installed
            //Initialize uri

            Uri uri = Uri.parse("https://www.google.com/maps/dir/"+source+"/"+destination);
            //Initialize intent with action view
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            //Set package
            intent.setPackage("com.google.android.apps.maps");
            //Set flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //Start Activity
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            //when google map is not installed
            //Initialize uri
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            //Initialize intent with action view
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            //Set flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //Start Activity
            startActivity(intent);
        }
    }

    public void hideDisplayIcon(View view) {
        iconBundleCl.setVisibility(View.GONE);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.categoryWise) {
            Toast.makeText(getApplicationContext(), "f", Toast.LENGTH_LONG).show();
            Intent intent =new Intent(MainActivity.this, CategoryActivity.class);
            startActivity(intent);
        }else if (item.getItemId()==R.id.storeAndBrandId){
            Intent intent =new Intent(MainActivity.this, MerchantActivity.class);
            startActivity(intent);
        }

        return false;
    }


    //======================== For data fetching from table ========================================

    class LoadDataTask extends AsyncTask<Void, Void, Void> {

        List<DEALS> dealsList;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            repository = new Repository(getApplicationContext());
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dealsList = repository.getAllData();
            dealsArrayList = new ArrayList<>();

            dealsArrayList.addAll(dealsList);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
//            adapter = new CardStackViewAdapter(MainActivity.this, dealsArrayList);
//            cardStackView.setAdapter(adapter);
        }
    }

    }