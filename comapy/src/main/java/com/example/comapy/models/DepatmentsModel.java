package com.example.comapy.models;

public class DepatmentsModel {
    Integer id,idEmployee;
    String title;

    public DepatmentsModel(Integer id, Integer idEmployee, String title) {
        this.id = id;
        this.idEmployee = idEmployee;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
