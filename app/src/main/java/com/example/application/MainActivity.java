package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.logging.ConsoleHandler;

public class MainActivity extends AppCompatActivity {

    private  static  int SPLASH_SCREEN = 3000;

    // declaring the variable for the animations
    Animation topAnim, bottomAnim;

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hide the status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // animations
        topAnim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.bottom_animation);

        // Hooks
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        // assigning the Animations

        imageView.setAnimation(topAnim);
        textView.setAnimation(bottomAnim);

        // Redirecting to the new Activity after set amount of time (3 Sec)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Login.class);

                Pair [] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(imageView,"logo_image");
                pairs[1] = new Pair<View, String>(textView,"logo_text");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                startActivity(intent, options.toBundle());


            }
        },SPLASH_SCREEN);
    }
}
