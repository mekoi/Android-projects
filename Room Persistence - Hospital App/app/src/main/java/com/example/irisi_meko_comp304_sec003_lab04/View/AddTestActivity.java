package com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Nurse;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Patient;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Test;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.R;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.ViewModel.NurseViewModel;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.ViewModel.PatientViewModel;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.ViewModel.TestViewModel;

public class AddTestActivity extends AppCompatActivity {

    public TestViewModel testViewModel;
    public PatientViewModel patientViewModel;
    public NurseViewModel nurseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_test);

        testViewModel = ViewModelProviders.of(this).get(TestViewModel.class);
        patientViewModel = ViewModelProviders.of(this).get(PatientViewModel.class);
        nurseViewModel = ViewModelProviders.of(this).get(NurseViewModel.class);

        final Button btnAddTest = (Button) findViewById(R.id.buttonAddTest);

        final EditText testType = (EditText) findViewById(R.id.editTextTestType);
        final EditText testPatientID = (EditText) findViewById(R.id.editTextTestPatientID);
        final EditText testNurseID = (EditText) findViewById(R.id.editTextTestNurseID);
        final EditText testBPL = (EditText) findViewById(R.id.editTextTestBPL);
        final EditText testBPH = (EditText) findViewById(R.id.editTextTestBPH);
        final EditText testTemperature = (EditText) findViewById(R.id.editTextTestTemperature);
        final EditText testPrice = (EditText) findViewById(R.id.editTextTestPrice);

        final TextView message = (TextView) findViewById(R.id.textViewMessage);

        btnAddTest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Test newTest = new Test();
                    newTest.setTestType(testType.getText().toString());
                    newTest.setPatientId(Integer.parseInt(testPatientID.getText().toString()));
                    newTest.setNurseId(Integer.parseInt(testNurseID.getText().toString()));
                    newTest.setBPL(Double.parseDouble(testBPL.getText().toString()));
                    newTest.setBPH(Double.parseDouble(testBPH.getText().toString()));
                    newTest.setTemperature(Double.parseDouble(testTemperature.getText().toString()));
                    newTest.setPrice(Double.parseDouble(testPrice.getText().toString()));

                    Patient patient = patientViewModel.findByPatientId(newTest.getPatientId());
                    if (patient==null){
                        message.setText("Patient does not exist in the database.");
                        throw new Exception("Patient does not exist");
                    }

                    Nurse nurse = nurseViewModel.findByNurseId(newTest.getNurseId());
                    if (nurse==null){
                        message.setText("Nurse does not exist in the database.");
                        throw new Exception("Nurse does not exist");
                    }

                    testViewModel.insert(newTest);
                    message.setText("The test was added to the database.");
                    testType.setText("");
                    testPatientID.setText("");
                    testNurseID.setText("");
                    testBPL.setText("");
                    testBPH.setText("");
                    testTemperature.setText("");
                    testPrice.setText("");

                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
