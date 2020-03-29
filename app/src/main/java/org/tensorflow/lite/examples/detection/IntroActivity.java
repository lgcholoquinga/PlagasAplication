package org.tensorflow.lite.examples.detection;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private SliderAdapter slideradapter;
    private Button btnsaltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        mSlideViewPager = (ViewPager) findViewById(R.id.introActivityViewPager);
        slideradapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(slideradapter);

        btnsaltar = (Button) findViewById(R.id.btnsaltarslider);

        btnsaltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(IntroActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}
