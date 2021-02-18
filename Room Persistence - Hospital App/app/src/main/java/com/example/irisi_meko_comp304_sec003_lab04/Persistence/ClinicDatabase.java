package com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Persistence;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Patient;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Test;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Nurse;
import android.content.Context;
import android.os.AsyncTask;

@Database(entities = {Test.class,Patient.class,Nurse.class},version = 1,exportSchema = false)
public abstract class ClinicDatabase extends RoomDatabase {

    private static String DATABASE_NAME="clinic.db";
    private static ClinicDatabase instance;
    public abstract PatientDAO patientDao();
    public abstract TestDAO testDao();
    public abstract NurseDAO nurseDao();

    public static synchronized ClinicDatabase getInstance(final Context context){
        if (instance==null){
            instance=Room.databaseBuilder(context.getApplicationContext(),ClinicDatabase.class,DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private PatientDAO patientDAO;
        private TestDAO testDAO;
        private NurseDAO nurseDAO;

        private PopulateDbAsyncTask (ClinicDatabase db){
            patientDAO=db.patientDao();
            testDAO=db.testDao();
            nurseDAO=db.nurseDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            Nurse nurse = new Nurse();
            nurse.setNurseId(123);
            nurse.setPassword("password123");
            nurse.setFirstname("Ana");
            nurse.setLastname("Green");
            nurse.setDepartment("Radiography");
            nurseDAO.insert(nurse);

            Patient patient1 = new Patient();
            patient1.setFirstname("John");
            patient1.setLastname("Smith");
            patient1.setDepartment("Radiography");
            patient1.setNurseId(123);
            patient1.setRoom(301);
            patientDAO.insert(patient1);

            Patient patient2 = new Patient();
            patient2.setFirstname("Anita");
            patient2.setLastname("Smith");
            patient2.setDepartment("Cardiology");
            patient2.setNurseId(123);
            patient2.setRoom(305);
            patientDAO.insert(patient2);

            Test test1 = new Test();
            test1.setTestType("Blood test");
            test1.setPatientId(1);
            test1.setNurseId(123);
            test1.setBPL(1.35);
            test1.setBPH(5.56);
            test1.setTemperature(37.5);
            test1.setPrice(69.99);
            testDAO.insert(test1);

            Test test2 = new Test();
            test2.setTestType("Sideremia");
            test2.setPatientId(2);
            test2.setNurseId(123);
            test2.setBPL(3.25);
            test2.setBPH(5.15);
            test2.setTemperature(36.3);
            test2.setPrice(29.99);
            testDAO.insert(test2);

            return null;
        }
    }
}
