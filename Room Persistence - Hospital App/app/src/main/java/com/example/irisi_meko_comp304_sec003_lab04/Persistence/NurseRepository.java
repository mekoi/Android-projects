package com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Persistence;
import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Nurse;
import java.util.List;

public class NurseRepository {

    private NurseDAO nurseDAO;
    private LiveData<List<Nurse>> allNurses;

    public NurseRepository(Application application) {

        ClinicDatabase clinicDatabase = ClinicDatabase.getInstance(application);
        nurseDAO = clinicDatabase.nurseDao();
        allNurses=nurseDAO.getAllNurses();
    }

    public LiveData<List<Nurse>> getAllNurses(){
        return allNurses;
    }

    public Nurse findByNurseId(int nurseId){
        return nurseDAO.findByNurseId(nurseId);
    }

    public void insert(Nurse... nurse){
        new InsertNurseAsyncTask(nurseDAO).execute(nurse);
    }

    private static class InsertNurseAsyncTask extends AsyncTask<Nurse,Void,Void> {
        private NurseDAO nurseDAO;

        private InsertNurseAsyncTask(NurseDAO nurseDAO){
            this.nurseDAO =nurseDAO;
        }
        @Override
        protected Void doInBackground(Nurse... nurse) {
            nurseDAO.insert(nurse);
            return null;
        }
    }

    public void update(Nurse... nurse){
        new UpdateNurseAsyncTask(nurseDAO).execute(nurse);
    }

    private static class UpdateNurseAsyncTask extends AsyncTask<Nurse,Void,Void> {
        private NurseDAO nurseDAO;

        private UpdateNurseAsyncTask(NurseDAO nurseDAO){
            this.nurseDAO =nurseDAO;
        }
        @Override
        protected Void doInBackground(Nurse... nurse) {
            nurseDAO.update(nurse);
            return null;
        }
    }
    public void delete(Nurse... nurse){
        new UpdateNurseAsyncTask(nurseDAO).execute(nurse);
    }

    private static class DeleteNurseAsyncTask extends AsyncTask<Nurse,Void,Void> {
        private NurseDAO nurseDAO;

        private DeleteNurseAsyncTask(NurseDAO nurseDAO){
            this.nurseDAO=nurseDAO;
        }
        @Override
        protected Void doInBackground(Nurse... nurse) {
            nurseDAO.delete(nurse);
            return null;
        }
    }
}
