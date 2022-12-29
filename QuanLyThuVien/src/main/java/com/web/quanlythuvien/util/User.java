package com.web.quanlythuvien.util;

public class User {

    private int id;
    private String name;
    private int age;
    private int sex;

    private int numberPhone;

    public User() {
    }

    public User(int id, String name, int age, int sex, int numberPhone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.numberPhone = numberPhone;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }
}
