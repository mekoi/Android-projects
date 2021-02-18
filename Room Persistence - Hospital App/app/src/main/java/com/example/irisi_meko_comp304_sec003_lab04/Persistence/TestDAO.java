package com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Persistence;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Query;
import androidx.lifecycle.LiveData;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Test;
import java.util.List;

@Dao
public interface TestDAO {
    @Insert
    void insert(Test... test);

    @Update
    void update(Test... test);

    @Delete
    void delete(Test... test);

    @Query("SELECT * FROM tests WHERE patientId = :patientId")
    Test findTestByPatientId(int patientId);

    @Query("SELECT * FROM tests order by patientId")
    LiveData<List<Test>> getAllTests();
}

