package com.web.quanlythuvien.util;

public class Book {
    private int id;
    private String name;
    private String tacGia;
    private int date;
    private String country;

    public Book() {
    }

    public Book(int id, String name, String tacGia, int date, String country) {
        this.id = id;
        this.name = name;
        this.tacGia = tacGia;
        this.date = date;
        this.country = country;
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

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
