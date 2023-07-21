package com.example.gameproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

/*
 * The Main Activity handles how users interact with game and the main update loop
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Makes Full Screen
        Window mainWindow = getWindow();
        mainWindow.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        // Changes context to new Game
        setContentView(new Game(this));
    }
}