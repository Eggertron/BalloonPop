package com.example.edgar.balloonpop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

/**
 * Created by edgar on 8/21/17.
 */

public class Balloon {
    private Bitmap bitmap;
    private int x, y, speed, minY, maxY, minX, maxX;
    private Random random;

    public Balloon(Context context, int screenX, int screenY) {
        random = new Random();
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.balloon_red);
        minY = 0;
        maxY = screenY;
        minX = 0;
        maxX = screenX - bitmap.getWidth();
        speed = random.nextInt(10) + 1;
        init();
    }

    public void update() {
        y -= speed;
        if (y < 0) {
            init();
        }
    }

    private void init() {
        y = maxY;
        x = random.nextInt(maxX);
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
