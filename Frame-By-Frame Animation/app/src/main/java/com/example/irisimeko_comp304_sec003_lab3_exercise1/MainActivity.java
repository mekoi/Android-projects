package com.example.irisimeko_comp304_sec003_lab3_exercise1;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable mframeAnimation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Handle Start Button
        final Button onButton = (Button) findViewById(R.id.buttonStart);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startAnimation();
            }
        });

        // Handle Stop Button
        final Button offButton = (Button) findViewById(R.id.buttonStop);
        offButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopAnimation();
            }
        });
    }

    private void startAnimation()
    {
        ImageView img = (ImageView)findViewById(R.id.imageViewSeaHorse);

        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.pic1);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.pic2);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.pic3);

        // Get the background, which has been compiled to an AnimationDrawable object.
        int reasonableDuration = 250;
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);	// loop continuously
        mframeAnimation.addFrame(frame1, reasonableDuration);
        mframeAnimation.addFrame(frame2, reasonableDuration);
        mframeAnimation.addFrame(frame3, reasonableDuration);

        img.setBackground(mframeAnimation);

        mframeAnimation.setVisible(true,true);
        mframeAnimation.start();
    }

    private void stopAnimation()
    {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false,false);

    }

}
