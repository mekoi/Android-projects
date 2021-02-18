package com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

//@Entity(tableName = "patients", foreignKeys = {@ForeignKey(entity = Nurse.class, parentColumns = "nurseId", childColumns = "nurseId")})
@Entity (tableName = "patients")
public class Patient {

    @PrimaryKey (autoGenerate=true)
    private int patientId;
    private String firstname;
    private String lastname;
    private String department;
    private int nurseId;
    private int room;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
}
