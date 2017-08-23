package com.example.edgar.balloonpop;

import android.graphics.Bitmap;
import android.view.View;

import java.util.Random;

/**
 * Created by edgar on 8/21/17.
 */

public class Balloon implements View.OnClickListener {
    private Bitmap bitmap;
    private int x, y, speed, minY, maxY, minX, maxX;
    private Random random;

    public Balloon(int screenX, int screenY) {
        random = new Random();
        maxY = screenY;
        minX = 0;
        maxX = screenX;
        init();
    }

    public void update() {
        y -= speed;
        if (y < minY) {
            init();
        }
    }

    public void init() {
        switch (random.nextInt(4)) {
            case 0: bitmap = Assets.balloon_red;
                break;
            case 1: bitmap = Assets.balloon_blue;
                break;
            case 2: bitmap = Assets.balloon_green;
                break;
            case 3: bitmap = Assets.balloon_orange;
        }
        minY = 0 - bitmap.getHeight();
        speed = random.nextInt(5) + 5;
        y = maxY;
        x = random.nextInt(maxX - bitmap.getWidth());
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
