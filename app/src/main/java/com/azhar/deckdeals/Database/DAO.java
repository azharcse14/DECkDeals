package com.azhar.deckdeals.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.azhar.deckdeals.Database.Entity.BRAND;
import com.azhar.deckdeals.Database.Entity.DEALS;
import com.azhar.deckdeals.Database.Entity.MERCHANT;

import java.util.List;

@Dao
public interface DAO {

    @Insert
    Long insertDealsTask(DEALS deals);

    @Query("select*from deals order by id asc")
    List<DEALS> getAllDeals();

    //=======================================================

    @Insert
    Long insertBrandTask(BRAND brand);

    @Query("select*from brand order by id asc")
    List<BRAND> getAllBrand();

    //=======================================================

    @Insert
    Long insertMerchantTask(MERCHANT merchant);

    @Query("select*from merchant order by id asc")
    List<MERCHANT> getAllMerchant();

    @Delete
    void deleteMerchantTask(MERCHANT merchant);


    @Query("DELETE FROM MERCHANT")
    public void deleteAllMerchant();
}
