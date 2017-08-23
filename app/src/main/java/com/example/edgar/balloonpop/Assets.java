package com.example.edgar.balloonpop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by edgar on 8/22/17.
 */

public class Assets {
    public static Bitmap balloon_red;
    public static Bitmap balloon_orange;
    public static Bitmap balloon_blue;
    public static Bitmap balloon_green;


    public static void load(Context context) {
        balloon_red = BitmapFactory.decodeResource(context.getResources(), R.drawable.balloon_red);
        balloon_orange = BitmapFactory.decodeResource(context.getResources(), R.drawable.balloon_orange);
        balloon_blue = BitmapFactory.decodeResource(context.getResources(), R.drawable.balloon_blue);
        balloon_green = BitmapFactory.decodeResource(context.getResources(), R.drawable.balloon_green);
    }
}
