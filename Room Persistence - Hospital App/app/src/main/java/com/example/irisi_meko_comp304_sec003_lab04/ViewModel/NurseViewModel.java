package com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.ViewModel;
import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Nurse;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Persistence.NurseRepository;
import java.util.List;

public class NurseViewModel extends AndroidViewModel {

    private NurseRepository nurseRepository;
    private LiveData<List<Nurse>> allNurses;

    public NurseViewModel(Application application) {
        super(application);
        nurseRepository=new NurseRepository(application);
        allNurses=nurseRepository.getAllNurses();
    }

    public LiveData<List<Nurse>> getAllNurses(){
        return allNurses;
    }

    public Nurse findByNurseId(int nurseId){
        return nurseRepository.findByNurseId(nurseId);
    }

    public void insert(Nurse... nurse){
        nurseRepository.insert(nurse);
    }

    public void update(Nurse... nurse){
        nurseRepository.update(nurse);
    }

    public void delete(Nurse... nurse){
        nurseRepository.delete(nurse);
    }
}
