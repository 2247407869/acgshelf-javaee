package com.lls.springboot.model;

public class AnimePo {

    private int id;
    private int rank;
    private String name_cn;
    private String collection;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public String getName() {
        return name_cn;
    }
    public void setName(String name) {
        this.name_cn = name;
    }
    public String getCollection() {
        return collection;
    }
    public void setCollection(String collection) {
        this.collection = collection;
    }

}