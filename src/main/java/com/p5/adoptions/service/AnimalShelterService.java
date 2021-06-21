package com.p5.adoptions.service;

import com.p5.adoptions.model.AnimalDTO;
import com.p5.adoptions.model.AnimalShelterDTO;
import com.p5.adoptions.model.adapters.AnimalShelterAdapter;
import com.p5.adoptions.model.validations.OnCreate;
import com.p5.adoptions.model.validations.OnUpdate;
import com.p5.adoptions.repository.shelter.AnimalShelterRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Service
@Validated
public class AnimalShelterService {

    private final AnimalShelterRepository animalShelterRepository;

    public AnimalShelterService(AnimalShelterRepository animalShelterRepository) {
        this.animalShelterRepository = animalShelterRepository;
    }

    public AnimalShelterDTO getShelter(Integer id) {
        return AnimalShelterAdapter.toDto(animalShelterRepository.getOne(id));
    }

    @Validated(OnCreate.class)
    public AnimalShelterDTO createShelter(@Valid AnimalShelterDTO shelterDTO) {
        return AnimalShelterAdapter.toDto(animalShelterRepository.save(AnimalShelterAdapter.fromDto(shelterDTO)));
    }

    @Validated(OnUpdate.class)
    public AnimalShelterDTO updateShelter(@Valid AnimalShelterDTO shelterDTO) {

        validateShelter(shelterDTO);

        return AnimalShelterAdapter.toDto(animalShelterRepository.save(AnimalShelterAdapter.fromDto(shelterDTO)));
    }

    public List<AnimalShelterDTO> getAll() {
        return AnimalShelterAdapter.toListDTO(animalShelterRepository.findAll());
    }

    private void validateShelter(AnimalShelterDTO shelterDTO) {

        animalShelterRepository.findById(shelterDTO.getId()).orElseThrow(() -> new RuntimeException("Shelter not found"));

        if (!shelterDTO.getAddress().toLowerCase(Locale.ROOT).contains("iasi")) {
            throw new RuntimeException("Shelter is not from Iasi");
        }

        for (AnimalDTO animal : shelterDTO.getAnimals()) {
            if (!animal.getPhotoUrl().toLowerCase(Locale.ROOT).contains("https")) {
                throw new RuntimeException("Animal does not have a valid url");
            }
        }
    }
}
