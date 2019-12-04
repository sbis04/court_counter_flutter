package com.souvik_biswas.android.courtcounter;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

import io.flutter.facade.Flutter;

public class MainActivity extends AppCompatActivity {

    // After completion of 4000 ms, the next activity will get started.
    private static final int SPLASH_SCREEN_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // This method is used so that your splash activity
        // can cover the entire screen.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // This will bind your MainActivity.class file with activity_main
        setContentView(R.layout.activity_main);

        // Defining a view to display flutter screen
        View flutterView = Flutter.createView(
                MainActivity.this,
                getLifecycle(),
                "splashRoute"
        );

        // Using FrameLayout for the Flutter screen
        FrameLayout.LayoutParams frameLayout =
                new FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                );

        addContentView(flutterView, frameLayout);


        new Handler().postDelayed(() -> {

            // This intent will be used to switch to the CounterActivity
            Intent i = new Intent(MainActivity.this,
                    CounterActivity.class);

            // Invoke the CounterActivity
            startActivity(i);

            // The current activity will get finished
            finish();

        }, SPLASH_SCREEN_TIME_OUT);
    }
}