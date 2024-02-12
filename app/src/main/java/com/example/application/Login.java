package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    Button signup, login_btn;
    ImageView imageView;
    TextView textView, sloganview;
    TextInputLayout username, password;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        signup = findViewById(R.id.registration_button);
        imageView = findViewById(R.id.logo);
        textView = findViewById(R.id.logo_name);
        sloganview = findViewById(R.id.slogan_name);
        username= findViewById(R.id.username);
        password= findViewById(R.id.password);
        login_btn = findViewById(R.id.login);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, signUp.class);

                Pair [] pairs = new Pair[7];

                pairs[0] = new Pair<View, String>(imageView,"logo_image");
                pairs[1] = new Pair<View, String>(textView,"logo_text");
                pairs[2] = new Pair<View, String>(sloganview,"logo_desc");
                pairs[3] = new Pair<View, String>(username,"username");
                pairs[4] = new Pair<View, String>(password,"password");
                pairs[5] = new Pair<View, String>(signup,"signup_button");
                pairs[6] = new Pair<View, String>(login_btn,"bottom_desc");


                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);
                startActivity(intent, options.toBundle());
            }
        });

    }
}