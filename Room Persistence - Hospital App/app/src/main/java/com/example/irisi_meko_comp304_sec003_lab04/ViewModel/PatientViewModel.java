package com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.ViewModel;
import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Patient;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Persistence.PatientRepository;
import java.util.List;

public class PatientViewModel extends AndroidViewModel {

    private PatientRepository patientRepository;
    private LiveData<List<Patient>> allPatients;

    public PatientViewModel(Application application) {
        super(application);
        patientRepository=new PatientRepository(application);
        allPatients=patientRepository.getAllPatients();
    }

    public LiveData<List<Patient>> getAllPatients(){
        return allPatients;
    }

    public Patient findByPatientId(int patientId){
        return patientRepository.findByPatientId(patientId);
    }

    public void insert(Patient... patient){
        patientRepository.insert(patient);
    }

    public void update(Patient... patient){
        patientRepository.update(patient);
    }

    public void delete(Patient... patient){
        patientRepository.delete(patient);
    }

}
