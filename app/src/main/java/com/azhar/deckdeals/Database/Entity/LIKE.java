package com.azhar.deckdeals.Database.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LIKE {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "percentage")
    public String percentage;

    @ColumnInfo(name = "brandName")
    public String brandName;

    @ColumnInfo(name = "branchName")
    public String branchName;

    @ColumnInfo(name = "distance")
    public String distance;

    @ColumnInfo(name = "price")
    public String price;

    @ColumnInfo(name = "discountPrice")
    public String discountPrice;

    @ColumnInfo(name = "date")
    public String date;

    public LIKE(String name, String percentage, String brandName, String branchName, String distance, String price, String discountPrice, String date) {
        this.name = name;
        this.percentage = percentage;
        this.brandName = brandName;
        this.branchName = branchName;
        this.distance = distance;
        this.price = price;
        this.discountPrice = discountPrice;
        this.date = date;
    }
}

