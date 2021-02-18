package com.example.studentloancalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import java.text.DecimalFormat;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText loanAmount;
    EditText loanInterestRate;
    Button btnCalculate;
    TextView totalAmount;
    RadioButton interestMinusTwo, interestTwo, interestThree;

    Integer[] possibleDuration = {1,2,3,4,5};
    public int selectedDuration;

    public void loanAmount_Clicked(View v) {
        loanAmount.setText("");
    }

    public void loanInterestRate_Clicked(View v) {
        loanInterestRate.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loanAmount = (EditText) findViewById(R.id.editTextLoanAmount);
        interestMinusTwo = (RadioButton)findViewById(R.id.radioButtonInterestMinusTwo);
        interestTwo = (RadioButton)findViewById(R.id.radioButtonInterestTwo);
        interestThree = (RadioButton)findViewById(R.id.radioButtonInterestThree);

        Spinner spinnerLoanDur = (Spinner) findViewById(R.id.spinnerLoanDuration);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, possibleDuration);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLoanDur.setAdapter(adapter);
        spinnerLoanDur.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        btnCalculate = (Button) findViewById(R.id.buttonCalculate);
        totalAmount = (TextView) findViewById(R.id.textViewTotalAmount);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double amount = Double.parseDouble(loanAmount.getText().toString());
                int duration = selectedDuration;
                double interestRate = 0;

                if (interestMinusTwo.isChecked()) {interestRate=-2;}
                else if (interestTwo.isChecked()) {interestRate=2;}
                else  {interestRate=3;}

                double tot_amount = amount * (1 + duration * interestRate/100);
                DecimalFormat df=new DecimalFormat("###,###.00");
                totalAmount.setText(String.valueOf( df.format(tot_amount)));

                final String toastAmount = String.valueOf( df.format(tot_amount));

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Information about total amount")
                        .setMessage("Are you sure you want to see the total amount in a Toast?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"Total loan amount is " + toastAmount,Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"",Toast.LENGTH_SHORT).show();
                            }
                        });
                //Creating dialog box
                AlertDialog dialog  = builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        selectedDuration = possibleDuration[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO - Custom Code
    }


}
