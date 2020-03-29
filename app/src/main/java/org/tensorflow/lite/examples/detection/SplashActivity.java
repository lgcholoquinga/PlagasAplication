package org.tensorflow.lite.examples.detection;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView = (ImageView) findViewById(R.id.imvinicio);
        textView = (TextView) findViewById(R.id.tvspinicio);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.animation_screen);
        imageView.startAnimation(animation);
        textView.startAnimation(animation);

        Handler handler = new Handler();
        handler.postDelayed(()-> {
            Intent intent = new Intent(SplashActivity.this,IntroActivity.class);
            startActivity(intent);
        },3000);

    }
}
