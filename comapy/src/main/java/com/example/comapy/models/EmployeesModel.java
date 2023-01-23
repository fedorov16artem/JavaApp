package com.example.comapy.models;

import com.example.comapy.services.DataBaseService;

public class EmployeesModel extends DataBaseService {
    Integer id,age;
    String name;
    double wages;

    public EmployeesModel(Integer id, Integer age, Double wages, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.wages = wages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getWages() {
        return wages;
    }

    public void setWages(double wages) {
        this.wages = wages;
    }
}
