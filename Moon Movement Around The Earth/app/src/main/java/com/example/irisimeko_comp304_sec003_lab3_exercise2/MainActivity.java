package com.example.irisimeko_comp304_sec003_lab3_exercise2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Earth imageview
        final ImageView imgViewEarth = (ImageView)findViewById(R.id.imageViewEarth);
        imgViewEarth.setImageResource(R.drawable.earth);
        imgViewEarth.setVisibility(View.VISIBLE);

        // We will animate the imageview
        final ImageView imgViewMoon = (ImageView)findViewById(R.id.imageViewMoon);
        imgViewMoon.setImageResource(R.drawable.moon);
        imgViewMoon.setVisibility(View.VISIBLE);

        // Load the appropriate animation
        final Animation an =  AnimationUtils.loadAnimation(this, R.anim.rotate);

        // Handle Start Button
        final Button buttonStart = (Button) findViewById(R.id.btnStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imgViewMoon.startAnimation(an);
            }
        });

        // Handle End Button
        final Button buttonEnd = (Button) findViewById(R.id.btnEnd);
        buttonEnd.setClickable(true);
        buttonEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgViewMoon.clearAnimation();
                imgViewMoon.setVisibility(View.INVISIBLE);
            }
        });
    }

    class MyAnimationListener implements Animation.AnimationListener {

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }
}