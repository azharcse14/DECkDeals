package com.azhar.deckdeals.ImageProcessing;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class ImageDecoder {

    public Bitmap convert(String base64) {

        final byte[] decodedBytes = Base64.decode(base64, Base64.DEFAULT);

        Bitmap decodedBitmap = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);

        return decodedBitmap;
    }
}
