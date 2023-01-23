package com.example.comapy.models;

public class DB {
    Integer id, age,idEmployee;
    String title, name;
    double wages;

    public DB(Integer id, Integer age, String title, String name, double wages, Integer idEmployee) {
        this.id = id;
        this.idEmployee = idEmployee;
        this.age = age;
        this.title = title;
        this.name = name;
        this.wages = wages;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
