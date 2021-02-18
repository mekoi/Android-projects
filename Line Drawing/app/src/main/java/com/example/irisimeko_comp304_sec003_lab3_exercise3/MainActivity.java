package com.example.irisimeko_comp304_sec003_lab3_exercise3;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.graphics.PorterDuff;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener  {

    ImageView imgViewForLine;
    RadioButton btnred, btnyellow, btncyan;
    RadioGroup radioGrColor;
    Button btnClear;

    Integer[] possibleThickness = {100,200,300,400};
    int selectedThickness;

    int startx = 1000;
    int starty = 1000;
    int endx = 0;
    int endy = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgViewForLine = (ImageView) this.findViewById(R.id.imageViewForLine);

        btnred = (RadioButton)findViewById(R.id.radioButtonRed);
        btnyellow = (RadioButton)findViewById(R.id.radioButtonYellow);
        btncyan = (RadioButton)findViewById(R.id.radioButtonCyan);

        radioGrColor = (RadioGroup)findViewById(R.id.radioGroupColor);

        btnClear = (Button)findViewById(R.id.buttonClear);

        Spinner spinnerThickness = (Spinner) findViewById(R.id.spinnerLineThickness);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, possibleThickness);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerThickness.setAdapter(adapter);
        spinnerThickness.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        Bitmap bitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth(), (int) getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmap);
        imgViewForLine.setImageBitmap(bitmap);

        final Paint paint = new Paint();

        radioGrColor.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(btnred.isChecked())
                {
                    paint.setColor(Color.RED);
                }
                else if (btnyellow.isChecked())
                {
                    paint.setColor(Color.YELLOW);
                }
                else  {paint.setColor(Color.CYAN);}
            }
        });

        final Button btnLeft = (Button) findViewById(R.id.buttonLeft);
        btnLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                paint.setStrokeWidth(selectedThickness);
                endx=startx-50;
                endy=starty;
                canvas.drawLine(startx, starty, endx, endy, paint);
                startx=endx;
                starty=endy;
            }
        });

        final Button btnRight = (Button) findViewById(R.id.buttonRight);
        btnRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                paint.setStrokeWidth(selectedThickness);
                endx=startx+50;
                endy=starty;
                canvas.drawLine(startx, starty, endx, endy, paint);
                startx=endx;
                starty=endy;
            }
        });

        final Button btnUp = (Button) findViewById(R.id.buttonUp);
        btnUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                paint.setStrokeWidth(selectedThickness);
                endx=startx;
                endy=starty-50;
                canvas.drawLine(startx, starty, endx, endy, paint);
                startx=endx;
                starty=endy;
            }
        });

        final Button btnDown = (Button) findViewById(R.id.buttonDown);
        btnDown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                paint.setStrokeWidth(selectedThickness);
                endx=startx;
                endy=starty+50;
                canvas.drawLine(startx, starty, endx, endy, paint);
                startx=endx;
                starty=endy;
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //canvas.drawColor(Color.TRANSPARENT);
                canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        selectedThickness = possibleThickness[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO - Custom Code
    }

}

