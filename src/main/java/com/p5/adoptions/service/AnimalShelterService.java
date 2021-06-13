package com.p5.adoptions.service;

import com.p5.adoptions.model.AnimalShelterDTO;
import com.p5.adoptions.model.adapters.AnimalShelterAdapter;
import com.p5.adoptions.repository.animals.Animal;
import com.p5.adoptions.repository.shelter.AnimalShelter;
import com.p5.adoptions.repository.shelter.AnimalShelterRepository;
import org.springframework.stereotype.Service;

@Service
public class AnimalShelterService {

    private final AnimalShelterRepository animalShelterRepository;

    public AnimalShelterService(AnimalShelterRepository animalShelterRepository) {
        this.animalShelterRepository = animalShelterRepository;
    }

    public AnimalShelterDTO getShelter(Integer id) {
        return AnimalShelterAdapter.toDto(animalShelterRepository.getOne(id));
    }

    public AnimalShelterDTO createShelter(AnimalShelterDTO shelterDTO) {
        AnimalShelter animalShelter = AnimalShelterAdapter.fromDto(shelterDTO);

        animalShelter.setId(null);
        for (Animal animal : animalShelter.getAnimals()) {
            animal.setId(null);
        }

        return AnimalShelterAdapter.toDto(animalShelterRepository.save(animalShelter));
    }
}
