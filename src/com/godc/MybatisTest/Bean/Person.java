package com.godc.MybatisTest.Bean;

public class Person {
    private int id;
    private String name;
    private String Gender;

    public Person() {
    }

    public Person(int id, String name, String gender) {
        this.id = id;
        this.name = name;
        Gender = gender;
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

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Gender='" + Gender + '\'' +
                '}';
    }
}
