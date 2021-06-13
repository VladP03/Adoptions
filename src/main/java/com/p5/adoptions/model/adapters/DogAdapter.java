package com.p5.adoptions.model.adapters;

import com.p5.adoptions.model.DogDTO;
import com.p5.adoptions.repository.dogs.Dog;

import java.util.ArrayList;
import java.util.List;

public class DogAdapter {

    public static Dog fromDTO(DogDTO dogDTO) {
        if (dogDTO.getName().equals("")) {
            dogDTO.setName("Generic dog");
        }

        return (Dog) new Dog()
                .setName(dogDTO.getName())
                .setUrl(dogDTO.getPhotoUrl());
    }

    public static DogDTO toDTO (Dog dog) {
        return new DogDTO(dog.getName(), dog.getUrl(), dog.getId());
    }

    public static List<DogDTO> toListDTO (List<Dog> dogList) {
        List<DogDTO> dtoList = new ArrayList<>();

        for (Dog dog : dogList) {
            dtoList.add(toDTO(dog));
        }

        return dtoList;
    }
}
