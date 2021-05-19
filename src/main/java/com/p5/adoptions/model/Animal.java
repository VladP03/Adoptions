package com.p5.adoptions.model;

public class Animal {

    protected Integer id;
    protected String name;
    protected String photoUrl;

    public Animal() {

    }

    public Animal(String name, String photoUrl, Integer id) {
        this.name = name;
        this.photoUrl = photoUrl;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public Animal setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Animal setId(Integer id) {
        this.id = id;
        return this;
    }
}
