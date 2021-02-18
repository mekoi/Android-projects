package com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.ViewModel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Test;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.R;
import java.util.ArrayList;
import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestHolder> {
    private List<Test> tests = new ArrayList<>();
    @NonNull
    @Override
    public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.test_item,parent, false);
        return new TestHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TestHolder holder, int position) {
        Test currentTest = tests.get(position);
        holder.textViewTestId.setText("Test ID: " + String.valueOf(currentTest.getTestId()));
        holder.textViewTestType.setText("Test Type: " + currentTest.getTestType());
        holder.textViewPatientId.setText("Patient ID: " + String.valueOf(currentTest.getPatientId()));
        holder.textViewNurseId.setText("Nurse ID: " + String.valueOf(currentTest.getNurseId()));
        holder.textViewTestBPL.setText("BPL: " + String.valueOf(currentTest.getBPL()));
        holder.textViewTestBPH.setText("BPH: " + String.valueOf(currentTest.getBPH()));
        holder.textViewTemperature.setText("Temperature: " + String.valueOf(currentTest.getTemperature()));
        holder.textViewPrice.setText("Price: " +String.valueOf(currentTest.getPrice()));
    }

    @Override
    public int getItemCount() {
        return tests.size();
    }

    public void setTests(List<Test> tests){
        this.tests = tests;
        notifyDataSetChanged();
    }

    class TestHolder extends RecyclerView.ViewHolder{

        private TextView textViewTestId;
        private TextView textViewTestType;
        private TextView textViewPatientId;
        private TextView textViewNurseId;
        private TextView textViewTestBPL;
        private TextView textViewTestBPH;
        private TextView textViewTemperature;
        private TextView textViewPrice;

        public TestHolder(View itemView){
            super(itemView);
            textViewTestId = itemView.findViewById(R.id.textViewTestId);
            textViewTestType = itemView.findViewById(R.id.textViewTestType);
            textViewPatientId = itemView.findViewById(R.id.textViewPatientId);
            textViewNurseId = itemView.findViewById(R.id.textViewNurseId);
            textViewTestBPL = itemView.findViewById(R.id.textViewTestBPL);
            textViewTestBPH = itemView.findViewById(R.id.textViewTestBPH);
            textViewTemperature = itemView.findViewById(R.id.textViewTemperature);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
        }
    }
}