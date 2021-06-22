package com.p5.adoptions.model;

import com.p5.adoptions.model.validations.OnCreate;
import com.p5.adoptions.model.validations.OnUpdate;

import javax.validation.constraints.*;
import java.util.List;
import java.util.ArrayList;

public class AnimalShelterDTO {

    @Null(message = "Id must be null for creation", groups = OnCreate.class)
    @NotNull(message = "Id must not be null for update", groups = OnUpdate.class)
    @Min(value = 1, groups = OnUpdate.class)
    private Integer id;

    @NotNull(message = "Name must not be null")
    private String name;

    @NotNull(message = "Adrees must not be null")
    private String address;

    @NotNull(message = "List of animals must not be null")
    private List<AnimalDTO> animal = new ArrayList<>();

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
