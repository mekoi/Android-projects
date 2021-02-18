package com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.ViewModel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model.Patient;
import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.R;
import java.util.ArrayList;
import java.util.List;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.PatientHolder> {
    private List<Patient> patients = new ArrayList<>();
    @NonNull
    @Override
    public PatientHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.patient_item,parent, false);
        return new PatientHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientHolder holder, int position) {
        Patient currentPatient = patients.get(position);
        holder.textViewPatientID.setText("Patient ID: " + String.valueOf(currentPatient.getPatientId()));
        holder.textViewFirstName.setText("First Name: " + currentPatient.getFirstname());
        holder.textViewLastName.setText("Last Name: " + currentPatient.getLastname());
        holder.textViewDepartment.setText("Department: "+ currentPatient.getDepartment());
        holder.textViewNurseID.setText("Nurse ID: "+ currentPatient.getNurseId());
        holder.textViewRoom.setText("Room: " +String.valueOf(currentPatient.getRoom()));
    }

    @Override
    public int getItemCount() {
        return patients.size();
    }

    public void setPatients(List<Patient> patients){
        this.patients = patients;
        notifyDataSetChanged();
    }

    class PatientHolder extends RecyclerView.ViewHolder{
        private TextView textViewPatientID;
        private TextView textViewFirstName;
        private TextView textViewLastName;
        private TextView textViewDepartment;
        private TextView textViewNurseID;
        private TextView textViewRoom;

        public PatientHolder(View itemView){
            super(itemView);
            textViewPatientID = itemView.findViewById(R.id.textViewPatientID);
            textViewFirstName = itemView.findViewById(R.id.textViewFirstName);
            textViewLastName = itemView.findViewById(R.id.textViewLastName);
            textViewDepartment = itemView.findViewById(R.id.textViewDepartment);
            textViewNurseID = itemView.findViewById(R.id.textViewNurseId);
            textViewRoom = itemView.findViewById(R.id.textViewRoom);

        }
    }
}