package com.azhar.deckdeals.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.azhar.deckdeals.Database.Entity.DEALS;
import com.azhar.deckdeals.Database.Repository;
import com.azhar.deckdeals.R;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        Repository repository = new Repository(getApplicationContext());

        DEALS shoe1 = new DEALS("BREEZE FREE III", "Lotto", "Jamuna Future Park","20%","200 m", "990.00", "792.00", "29 March 2021");
        DEALS shoe2 = new DEALS("DINAMICA 300 III BLUE", "Lotto", "Jamuna Future Park","20%","200 m", "990.00", "792.00", "29 March 2021");
        DEALS shoe3 = new DEALS("LOTTO WORKS SAFETY SHOE", "Lotto", "Jamuna Future Park","20%","200 m", "990.00", "792.00", "29 March 2021");
        DEALS shoe4 = new DEALS("LOTTO RUNNER II GREY", "Lotto", "Jamuna Future Park","20%","200 m", "990.00", "792.00", "29 March 2021");
        DEALS shoe5 = new DEALS("BREEZE FREE III", "Lotto", "Jamuna Future Park","20%","200 m", "990.00", "792.00", "29 March 2021");
        DEALS sandels1 = new DEALS("LOTTO PERFORMER SPORT SANDAL", "Lotto", "Jamuna Future Park","20%","200 m", "990.00", "792.00", "29 March 2021");
        DEALS sandels2 = new DEALS("LOTTO PERFORMER SPORT SANDAL","Lotto", "Jamuna Future Park","20%","200 m", "990.00", "792.00", "29 March 2021");
        DEALS sandels3 = new DEALS("LOTTO PERFORMER SPORT SANDAL", "Lotto", "Jamuna Future Park","20%","200 m", "990.00", "792.00", "29 March 2021");
        DEALS sandels4 = new DEALS("LOTTO PERFORMER SPORT SANDAL", "Lotto", "Jamuna Future Park","20%","200 m", "990.00", "792.00", "29 March 2021");
        DEALS sandels5 = new DEALS("LOTTO PERFORMER SPORT SANDAL", "Lotto", "Jamuna Future Park","20%","200 m", "990.00", "792.00", "29 March 2021");
        DEALS tshirt = new DEALS("LOTTO Sports T-Shirt", "Lotto", "Jamuna Future Park","20%","200 m", "990.00", "792.00", "29 March 2021");
        DEALS football1 = new DEALS("LOTTO PROFESSIONAL FOOTBALL – ORANGE", "Lotto", "Jamuna Future Park","20%","200 m", "990.00", "792.00", "29 March 2021");
        DEALS football2 = new DEALS("LOTTO PROFESSIONAL FOOTBALL – ORANGE", "Lotto", "Jamuna Future Park","20%","200 m", "990.00", "792.00", "29 March 2021");
        DEALS football3 = new DEALS("LOTTO PROFESSIONAL FOOTBALL – ORANGE", "Lotto", "Jamuna Future Park","20%","200 m", "990.00", "792.00", "29 March 2021");
        DEALS football4 = new DEALS("LOTTO PROFESSIONAL FOOTBALL – ORANGE", "Lotto", "Jamuna Future Park","20%","200 m", "990.00", "792.00", "29 March 2021");
        DEALS football5 = new DEALS("LOTTO PROFESSIONAL FOOTBALL – ORANGE", "Lotto", "Jamuna Future Park","20%","200 m", "990.00", "792.00", "29 March 2021");

        repository.InsertTask(shoe1);
        repository.InsertTask(shoe2);
        repository.InsertTask(shoe3);
        repository.InsertTask(shoe4);
        repository.InsertTask(shoe5);
        repository.InsertTask(sandels1);
        repository.InsertTask(sandels2);
        repository.InsertTask(sandels3);
        repository.InsertTask(sandels4);
        repository.InsertTask(sandels5);
        repository.InsertTask(tshirt);
        repository.InsertTask(football1);
        repository.InsertTask(football2);
        repository.InsertTask(football3);
        repository.InsertTask(football4);
        repository.InsertTask(football5);

    }

    public void goToNext(View view) {
        Intent intent = new Intent(DataActivity.this, MainActivity.class);
        startActivity(intent);
    }
}