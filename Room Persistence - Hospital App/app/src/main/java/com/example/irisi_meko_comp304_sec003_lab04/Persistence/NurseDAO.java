package com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Nurse;
import java.util.List;

@Dao
public interface NurseDAO {
    @Insert
    void insert(Nurse... nurse);

    @Update
    void update(Nurse... nurse);

    @Delete
    void delete(Nurse... nurse);

    @Query("SELECT * FROM nurses WHERE nurseId = :nurseId")
    Nurse findByNurseId(int nurseId);

    @Query("SELECT * FROM nurses")
    LiveData<List<Nurse>> getAllNurses();
}