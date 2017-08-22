package com.example.edgar.balloonpop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by edgar on 8/21/17.
 */

public class GameView extends SurfaceView implements Runnable {

    volatile boolean playing;
    private Thread gameThread = null;
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;
    private ArrayList<Balloon> balloons;
    private final int ballonsCount = 60;
    protected Bitmap balloonBitmap;

    public GameView(Context context, int screenX, int screenY) {
        super(context);

        surfaceHolder = getHolder();
        paint = new Paint();
        balloonBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.balloon_red);

        balloons = new ArrayList<Balloon>();
        for (int i = 0; i < ballonsCount; i++) {
            balloons.add(new Balloon(context, screenX, screenY, balloonBitmap));
        }
        playing = true;
    }

    @Override
    public void run() {
        while (playing) {
            update();
            draw();
            control();
        }
    }

    private void update() {
        for (Balloon balloon : balloons) {
            balloon.update();
        }
    }

    private void draw() {
        if (surfaceHolder.getSurface().isValid()) {
            canvas = surfaceHolder.lockCanvas();
            canvas.drawColor(Color.BLACK);

            paint.setColor(Color.WHITE);

            for (Balloon balloon : balloons) {
                canvas.drawBitmap(balloon.getBitmap(),
                        balloon.getX(),
                        balloon.getY(),
                        paint );
            }

            surfaceHolder.unlockCanvasAndPost(canvas);

        }
    }

    private void control() {
        try {
            gameThread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        playing = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
        }
    }

    public void resume() {
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();

        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_UP:
                //player.stopBoosting();
                break;
            case MotionEvent.ACTION_DOWN:
                System.out.println("touched: "+x+", "+y);
                for (Balloon balloon : balloons) {
                    if (x > balloon.getX() && x < balloon.getX() + balloon.getBitmap().getWidth() &&
                            y > balloon.getY() && y < balloon.getY() + balloon.getBitmap().getHeight()) {
                        balloon.init();
                    }
                }
                break;
        }
        return true;
    }
}
