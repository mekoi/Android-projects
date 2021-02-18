package com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Persistence;
import java.util.List;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.lifecycle.LiveData;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Patient;

@Dao
public interface PatientDAO {
    @Insert
    void insert(Patient... patient);

    @Update
    void update(Patient... patient);

    @Delete
    void delete(Patient... patient);

    @Query("SELECT * FROM patients WHERE patientId = :patientId")
    Patient findByPatientId(int patientId);

    @Query("SELECT * FROM patients ORDER BY patientId")
    LiveData<List<Patient>> getAllPatients();
}

