package com.souvik_biswas.android.courtcounter;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import io.flutter.embedding.android.FlutterActivity;

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

        // Defining the FlutterActivity to display
        // the Flutter UI within this host app.
        startActivity(
                FlutterActivity
                        .withNewEngine()
                        .initialRoute("splashRoute")
                        .build(this)
        );

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