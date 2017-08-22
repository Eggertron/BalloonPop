package com.example.edgar.balloonpop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

import java.util.Random;

/**
 * Created by edgar on 8/21/17.
 */

public class Balloon implements View.OnClickListener {
    private Bitmap bitmap;
    private int x, y, speed, minY, maxY, minX, maxX;
    private Random random;

    public Balloon(Context context, int screenX, int screenY, Bitmap bitmap) {
        random = new Random();
        //bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.balloon_red);
        this.bitmap = bitmap;
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

    public void init() {
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

    @Override
    public void onClick(View view) {

    }
}
