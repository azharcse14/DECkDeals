package com.azhar.deckdeals.Database;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.room.Room;

import com.azhar.deckdeals.Database.Entity.BRAND;
import com.azhar.deckdeals.Database.Entity.DEALS;
import com.azhar.deckdeals.Database.Entity.MERCHANT;

import java.util.List;

public class Repository {
    private final DATABASE database;
    Context context;
    String DB_NAME;

    public Repository(Context context){
        this.context = context;
        DB_NAME = "deckdeals.db";
        database = Room.databaseBuilder(context, DATABASE.class, DB_NAME).build();

        Toast.makeText(context, "Database created", Toast.LENGTH_LONG).show();

    }

    //============= Fetch Task ==========
    public List<DEALS> getAllData(){
        List<DEALS> dealsList = database.dao().getAllDeals();
        return dealsList;
    }

    //========== Insert Task =================
    public void InsertTask(final DEALS deals){
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().insertDealsTask(deals);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(context, deals.id+" is inserted", Toast.LENGTH_LONG).show();
            }
        }.execute();
    }


    //==============================================================================================
    //==============================================================================================
    //==============================================================================================


    //============= Fetch Task ==========
    public List<BRAND> getAllBrandName(){
        List<BRAND> brandList = database.dao().getAllBrand();
        return brandList;
    }

    //========== Insert Task =================
    public void InsertBrandTask(final BRAND brand){
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().insertBrandTask(brand);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(context, brand.id+" is inserted", Toast.LENGTH_LONG).show();
            }
        }.execute();
    }

    //==============================================================================================
    //==============================================================================================
    //==============================================================================================


    //=================== Delete All Task ===========================
    public void DeleteAllMerchantTask(){
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().deleteAllMerchant();
                return null;
            }
        }.execute();
    }

    //===============Delete Task Start=================

    public void DeleteTaskMerchant(final MERCHANT merchant){
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().deleteMerchantTask(merchant);
                return null;
            }
        }.execute();
    }

    //============= Fetch Task ==========
    public List<MERCHANT> getAllMerchant(){
        List<MERCHANT> merchantList = database.dao().getAllMerchant();
        return merchantList;
    }

    //========== Insert Task =================
    public void InsertMerchantTask(final MERCHANT merchant){
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.dao().insertMerchantTask(merchant);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(context, merchant.id+" is inserted", Toast.LENGTH_LONG).show();
            }
        }.execute();
    }

}
