package com.lls.springboot.pojo;

public class Category {

    private int id;

    private String name_cn;
    private int collection;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name_cn;
    }
    public void setName(String name) {
        this.name_cn = name;
    }
    public int getCollection() {
        return collection;
    }
    public void setCollection(int collection) {
        this.collection = collection;
    }

}