
package model;

import java.io.Serializable;

public class Patient implements Serializable {
    private int id;
    private String name;
    private String phone;
    private String medicalHistory;

    public Patient(int id, String name, String phone, String medicalHistory) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.medicalHistory = medicalHistory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}