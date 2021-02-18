package com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.R;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Patient;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.ViewModel.PatientViewModel;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.ViewModel.PatientAdapter;
import java.util.List;

public class PatientActivity extends AppCompatActivity {

    private PatientViewModel patientViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewPatient);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final PatientAdapter adapter = new PatientAdapter();
        recyclerView.setAdapter(adapter);

        patientViewModel = ViewModelProviders.of(this).get(PatientViewModel.class);
        patientViewModel.getAllPatients().observe(this, new Observer<List<Patient>>() {
            @Override
            public void onChanged(@Nullable List<Patient> patients) {
                adapter.setPatients(patients);
            }
        });
    }
}




