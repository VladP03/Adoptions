package com.p5.adoptions.service;

import com.p5.adoptions.model.DogDTO;
import com.p5.adoptions.model.ListDTO;
import com.p5.adoptions.model.adapters.DogAdapter;
import com.p5.adoptions.repository.dogs.Dog;
import com.p5.adoptions.repository.dogs.DogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {

    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public void addDog (DogDTO dogDTO) {
        if (dogDTO.getName() == null || dogDTO.getName().equals("")) {
            throw new RuntimeException("Dog must have an name!");
        }

        Dog dogToSave = DogAdapter.fromDTO(dogDTO);

        dogRepository.save(dogToSave);
    }

    public ListDTO<DogDTO> findAll() {
        List<DogDTO> dogDTOS = DogAdapter.toListDTO(dogRepository.findAll());

        long totalCount = dogRepository.count();

        return new ListDTO<>((int) totalCount, dogDTOS);
    }

    public DogDTO findDog(String name) {
        if (name == null || name == "") {
            throw new RuntimeException("Must specify a name");
        }

        return DogAdapter.toDTO(dogRepository.findDogByName(name));
    }
}
