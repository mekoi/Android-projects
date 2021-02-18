package com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Persistence;
import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Nurse;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Patient;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Test;
import java.util.List;

public class TestRepository {

    private TestDAO testDAO;
    private LiveData<List<Test>> allTests;

    public TestRepository(Application application) {
        ClinicDatabase clinicDatabase = ClinicDatabase.getInstance(application);
        testDAO = clinicDatabase.testDao();
        allTests=testDAO.getAllTests();
    }

    public LiveData<List<Test>> getAllTests(){
        return allTests;
    }

    public Test findTestByPatientId(int patientId){
        return testDAO.findTestByPatientId(patientId);
    }

    public void insert(Test... test){
        new InsertTestAsyncTask(testDAO).execute(test);
    }

    private static class InsertTestAsyncTask extends AsyncTask<Test,Void,Void> {
        private TestDAO testDAO;

        private InsertTestAsyncTask(TestDAO testDAO){
            this.testDAO =testDAO;
        }
        @Override
        protected Void doInBackground(Test... test) {
            testDAO.insert(test);
            return null;
        }
    }

    public void update(Test... test){
        new UpdateTestAsyncTask(testDAO).execute(test);
    }

    private static class UpdateTestAsyncTask extends AsyncTask<Test,Void,Void> {
        private TestDAO testDAO;

        private UpdateTestAsyncTask(TestDAO testDAO){
            this.testDAO =testDAO;
        }
        @Override
        protected Void doInBackground(Test... test) {
            testDAO.update(test);
            return null;
        }
    }

    public void delete(Test... test){
        new UpdateTestAsyncTask(testDAO).execute(test);
    }

    private static class DeleteTestAsyncTask extends AsyncTask<Test,Void,Void> {
        private TestDAO testDAO;

        private DeleteTestAsyncTask(TestDAO testDAO){
            this.testDAO=testDAO;
        }
        @Override
        protected Void doInBackground(Test... test) {
            testDAO.delete(test);
            return null;
        }
    }

}
