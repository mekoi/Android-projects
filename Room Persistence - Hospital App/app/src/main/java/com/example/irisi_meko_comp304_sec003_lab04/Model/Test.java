package com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.Model;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

//@Entity(tableName = "tests", foreignKeys = {@ForeignKey(entity = Patient.class, parentColumns = "patientId", childColumns = "patientId")})
@Entity (tableName = "tests")
public class Test {

    @PrimaryKey (autoGenerate=true)
    private int testId;
    private String testType;
    private int patientId;
    private int nurseId;
    private double BPL;
    private double BPH;
    private double temperature;
    private double price;

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public double getBPL() {
        return BPL;
    }

    public void setBPL(double BPL) {
        this.BPL = BPL;
    }

    public double getBPH() {
        return BPH;
    }

    public void setBPH(double BPH) {
        this.BPH = BPH;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
