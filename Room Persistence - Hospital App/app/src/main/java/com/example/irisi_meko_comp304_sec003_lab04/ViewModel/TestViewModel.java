package com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.ViewModel;
import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Test;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Persistence.TestRepository;
import java.util.List;

public class TestViewModel extends AndroidViewModel {

    private TestRepository testRepository;
    private LiveData<List<Test>> allTests;

    public TestViewModel(Application application) {
        super(application);
        testRepository=new TestRepository(application);
        allTests=testRepository.getAllTests();
    }

    public LiveData<List<Test>> getAllTests(){
        return allTests;
    }

    public Test findTestByPatientId(int patientId){
        return testRepository.findTestByPatientId(patientId);
    }

    public void insert(Test... test){
        testRepository.insert(test);
    }

    public void update(Test... test){
        testRepository.update(test);
    }

    public void delete(Test... test){
        testRepository.delete(test);
    }

}
