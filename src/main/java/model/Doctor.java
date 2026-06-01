package model;

import java.io.Serializable;

public class Doctor implements Serializable {
    private int id;
    private String name;
    private String specialty;
    private String phone;

    public Doctor(int id, String name, String specialty, String phone) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.phone = phone;
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}