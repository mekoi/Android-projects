package com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Nurse;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Patient;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.R;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.ViewModel.NurseViewModel;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.ViewModel.PatientViewModel;
import android.view.View;

public class AddEditPatientActivity extends AppCompatActivity {

    public PatientViewModel patientViewModel;
    public NurseViewModel nurseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_patient);

        patientViewModel = ViewModelProviders.of(this).get(PatientViewModel.class);
        nurseViewModel = ViewModelProviders.of(this).get(NurseViewModel.class);

        final Button btnAdd = (Button) findViewById(R.id.buttonAdd);
        final Button btnUpdate = (Button) findViewById(R.id.buttonUpdate);
        final EditText patientID = (EditText) findViewById(R.id.editTextPatientID);
        final EditText firstName = (EditText) findViewById(R.id.editTextFirstName);
        final EditText lastName = (EditText) findViewById(R.id.editTextLastName);
        final EditText department = (EditText) findViewById(R.id.editTextDepartment);
        final EditText nurseID = (EditText) findViewById(R.id.editTextNurseID);
        final EditText room = (EditText) findViewById(R.id.editTextRoom);

        final TextView message = (TextView) findViewById(R.id.textViewMessage);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Patient newPatient = new Patient();
                    newPatient.setFirstname(firstName.getText().toString());
                    newPatient.setLastname(lastName.getText().toString());
                    newPatient.setDepartment(department.getText().toString());
                    newPatient.setNurseId(Integer.parseInt(nurseID.getText().toString()));
                    newPatient.setRoom(Integer.parseInt(room.getText().toString()));

                    Nurse nurse = nurseViewModel.findByNurseId(newPatient.getNurseId());
                    if (nurse==null){
                        message.setText("Nurse does not exist in the database.");
                        throw new Exception("Nurse does not exist");
                    }

                    patientViewModel.insert(newPatient);
                    message.setText("The patient was added to the database.");
                    firstName.setText("");
                    lastName.setText("");
                    department.setText("");
                    nurseID.setText("");
                    room.setText("");
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Patient foundPatient = patientViewModel.findByPatientId(Integer.parseInt(patientID.getText().toString()));
                    if (foundPatient==null){
                        message.setText("This patient does not exist in the database, add it.");
                        throw new Exception("This patient does not exist in the database, add it.");
                    }

                    Patient changedPatient = new Patient();
                    changedPatient.setPatientId(Integer.parseInt(patientID.getText().toString()));
                    changedPatient.setFirstname(firstName.getText().toString());
                    changedPatient.setLastname(lastName.getText().toString());
                    changedPatient.setDepartment(department.getText().toString());
                    changedPatient.setNurseId(Integer.parseInt(nurseID.getText().toString()));
                    changedPatient.setRoom(Integer.parseInt(room.getText().toString()));

                    Nurse nurse = nurseViewModel.findByNurseId(changedPatient.getNurseId());
                    if (nurse==null){
                        message.setText("Nurse does not exist in the database.");
                        throw new Exception("Nurse does not exist");
                    }

                    patientViewModel.update(changedPatient);
                    message.setText("The patient was updated to the database.");
                    firstName.setText("");
                    lastName.setText("");
                    department.setText("");
                    nurseID.setText("");
                    room.setText("");
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}