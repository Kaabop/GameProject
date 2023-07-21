package com.example.gameproject;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameLoop extends Thread{
    private boolean isRunning = false;
    private SurfaceHolder surfaceHolder;
    private Game game;
    public GameLoop(Game game, SurfaceHolder surfaceHolder) {
        this.game = game;
        this.surfaceHolder = surfaceHolder;
    }

    public double getAvgUPS() {
        return 0;
    }

    public double getAvgFPS() {
        return 0;
    }

    public void startLoop() {
        isRunning = true;
        start();
    }

    /*
     * The game loop will lock and unlock the canvas since we are overriding a threading method
     */
    @Override
    public void run() {
        super.run();

        Canvas myCanvas;
        //Main game while loop
        while (isRunning) {
            // Try to update and render all needed objects from the gameLoop
            try {
                myCanvas = surfaceHolder.lockCanvas();
                game.update();
                game.draw(myCanvas);
                surfaceHolder.unlockCanvasAndPost(myCanvas);
            } catch (IllegalArgumentException error) {
                error.printStackTrace();
            }
            // Pauses game to slow down and skips frames to keep up
        }
    }
}
