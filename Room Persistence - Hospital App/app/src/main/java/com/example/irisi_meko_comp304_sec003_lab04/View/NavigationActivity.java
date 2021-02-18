package com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.R;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        Button btnViewPatient = findViewById(R.id.buttonViewPatient);
        btnViewPatient.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PatientActivity.class);
                startActivity(intent);
            }
        });

        Button btnViewTest = findViewById(R.id.buttonViewTest);
        btnViewTest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Intent = new Intent(getApplicationContext(), TestActivity.class);
                startActivity(Intent);
            }
        });

        Button btnAddTest = findViewById(R.id.buttonAddTest);
        btnAddTest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Intent = new Intent(getApplicationContext(), AddTestActivity.class);
                startActivity(Intent);
            }
        });

        Button btnAddEditPatient = findViewById(R.id.buttonAddEditPatient);
        btnAddEditPatient.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddEditPatientActivity.class);
                startActivity(intent);
            }
        });
    }
}