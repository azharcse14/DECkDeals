package com.azhar.deckdeals.data;

import com.azhar.deckdeals.Database.Entity.MERCHANT;

import java.util.ArrayList;

public class DataPackager {

    ArrayList<MERCHANT> merchantArrayList;



    public ArrayList<MERCHANT> getMerchantArrayList() {
        return merchantArrayList;
    }

    public void setMerchantArrayList(ArrayList<MERCHANT> merchantArrayList) {
        this.merchantArrayList = merchantArrayList;
    }
}
