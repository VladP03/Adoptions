package com.p5.adoptions.service;

import com.p5.adoptions.repository.dogs.Dog;
import com.p5.adoptions.repository.dogs.DogRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/dogs")
public class DogService {

    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public void addDog (Dog dog) {
        if (dog.getName() == null || dog.getName() == "") {
            throw new RuntimeException("Dog must have an name!");
        }

        Dog dogToSave = new Dog()
                .setName(dog.getName())
                .setUrl(dog.getUrl());

        dogRepository.save(dogToSave);
    }

    public List<Dog> findAll() {
        return dogRepository.findAll();
    }

    public Dog findDog(String name) {
        if (name == null || name == "") {
            throw new RuntimeException("Must specify a name");
        }

        return dogRepository.findDogByName(name);
    }
}
