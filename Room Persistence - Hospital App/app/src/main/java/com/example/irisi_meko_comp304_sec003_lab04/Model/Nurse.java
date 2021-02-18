package com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "nurses")
public class Nurse {

    @PrimaryKey (autoGenerate=true)
    private int nurseId;
    private String firstname;
    private String lastname;
    private String department;
    private String password;

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
