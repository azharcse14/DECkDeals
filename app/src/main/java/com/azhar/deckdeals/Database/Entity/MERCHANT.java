package com.azhar.deckdeals.Database.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MERCHANT {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "brandName")
    public String brandName;

    @ColumnInfo(name = "address")
    public String address;

    @ColumnInfo(name = "latitude")
    public double latitude;

    @ColumnInfo(name = "longitude")
    public double longitude;

    @ColumnInfo(name = "logo")
    public String logo;

    public MERCHANT(String brandName, String address, double latitude, double longitude, String logo) {
        this.brandName = brandName;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.logo = logo;
    }
}
