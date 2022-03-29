package com.godc.MybatisTest.Bean;

public class MyBoy {
    private int id;
    private String name;

    public MyBoy(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public MyBoy() {
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

    @Override
    public String toString() {
        return "MyBoy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
