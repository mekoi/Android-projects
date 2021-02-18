package com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Test;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.R;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.ViewModel.PatientViewModel;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.ViewModel.TestAdapter;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.ViewModel.TestViewModel;

import java.util.List;

public class TestActivity extends AppCompatActivity {
    private TestViewModel testViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewTest);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final TestAdapter adapter = new TestAdapter();
        recyclerView.setAdapter(adapter);

        testViewModel = ViewModelProviders.of(this).get(TestViewModel.class);
        testViewModel.getAllTests().observe(this, new Observer<List<Test>>() {
            @Override
            public void onChanged(@Nullable List<Test> tests) {
                adapter.setTests(tests);
            }
        });
    }
}