package com.example.gameproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.core.content.ContextCompat;

/*
 * Game takes care of all objects and handles general game state
 */
class Game extends SurfaceView implements SurfaceHolder.Callback {
    private GameLoop gameLoop;
    private Context context;
    public Game(Context context) {
        super(context);

        // Get a surface holder and a callback
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        this.context = context;
        gameLoop = new GameLoop(this, surfaceHolder);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        gameLoop.startLoop();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawUpdates(canvas);
        drawFPS(canvas);
    }

    public void drawUpdates(Canvas canvas) {
        String avgUPS = Double.toString(gameLoop.getAvgUPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.turquoise);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("UPS:" + avgUPS, 10, 40, paint);
    }

    public void drawFPS(Canvas canvas) {
        String avgFPS = Double.toString(gameLoop.getAvgFPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.turquoise);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("FPS:" + avgFPS, 10, 90, paint);
    }

    public void update() {

    }
}
