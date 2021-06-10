package com.azhar.deckdeals.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.azhar.deckdeals.Database.Entity.BRAND;
import com.azhar.deckdeals.Database.Entity.DEALS;
import com.azhar.deckdeals.Database.Entity.LIKE;
import com.azhar.deckdeals.Database.Entity.MERCHANT;

@Database(entities = {DEALS.class, BRAND.class, LIKE.class, MERCHANT.class}, version = 1, exportSchema = false)
public abstract class DATABASE extends RoomDatabase {

    public abstract DAO dao();
}
