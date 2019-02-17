package com.example.rathana.mvp_demo.entity;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("NAME")
    private String name;
    @SerializedName("ID")
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
