package com.p5.adoptions.model;

import com.p5.adoptions.repository.animals.Animal;

import java.util.List;
import java.util.ArrayList;

public class AnimalShelterDTO {

    private Integer id;
    private String name;
    private String address;
    List<AnimalDTO> animal = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public AnimalShelterDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AnimalShelterDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AnimalShelterDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public List<AnimalDTO> getAnimals() {
        return animal;
    }

    public AnimalShelterDTO setAnimals(List<AnimalDTO> animal) {
        this.animal = animal;
        return this;
    }
}
