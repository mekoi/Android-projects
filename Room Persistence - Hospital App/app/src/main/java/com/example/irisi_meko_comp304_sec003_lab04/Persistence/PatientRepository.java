package com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Persistence;
import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Patient;
import java.util.List;

public class PatientRepository {

    private PatientDAO patientDAO;
    private LiveData<List<Patient>> allPatients;

    public PatientRepository(Application application) {
        ClinicDatabase clinicDatabase = ClinicDatabase.getInstance(application);
        patientDAO = clinicDatabase.patientDao();
        allPatients=patientDAO.getAllPatients();
    }

    public LiveData<List<Patient>> getAllPatients(){
        return allPatients;
    }

    public Patient findByPatientId(int patientId){
        return patientDAO.findByPatientId(patientId);
    }

    public void insert(Patient... patient){
        new InsertPatientAsyncTask(patientDAO).execute(patient);
    }

    private static class InsertPatientAsyncTask extends AsyncTask<Patient,Void,Void> {
        private PatientDAO patientDAO;
        private InsertPatientAsyncTask(PatientDAO patientDAO){
            this.patientDAO=patientDAO;
        }
        @Override
        protected Void doInBackground(Patient... patient) {
            patientDAO.insert(patient);
            return null;
        }
    }

    public void update(Patient... patients){
        new UpdatePatientAsyncTask(patientDAO).execute(patients);
    }

    private static class UpdatePatientAsyncTask extends AsyncTask<Patient,Void,Void> {
        private PatientDAO patientDAO;

        private UpdatePatientAsyncTask(PatientDAO patientDAO){
            this.patientDAO =patientDAO;
        }
        @Override
        protected Void doInBackground(Patient... patients) {
            patientDAO.update(patients);
            return null;
        }
    }

    public void delete(Patient... patient){
        new UpdatePatientAsyncTask(patientDAO).execute(patient);
    }

    private static class DeletePatientAsyncTask extends AsyncTask<Patient,Void,Void> {
        private PatientDAO patientDAO;

        private DeletePatientAsyncTask(PatientDAO patientDAO){
            this.patientDAO =patientDAO;
        }
        @Override
        protected Void doInBackground(Patient... patient) {
            patientDAO.delete(patient);
            return null;
        }
    }
}
