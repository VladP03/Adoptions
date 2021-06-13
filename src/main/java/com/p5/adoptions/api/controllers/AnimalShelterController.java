package com.p5.adoptions.api.controllers;

import com.p5.adoptions.model.AnimalShelterDTO;
import com.p5.adoptions.service.AnimalShelterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/shelters")
public class AnimalShelterController {

    private final AnimalShelterService shelterService;

    public AnimalShelterController(AnimalShelterService shelterService) {
        this.shelterService = shelterService;
    }

    @GetMapping("/{id}")
    private ResponseEntity<AnimalShelterDTO> getShelter(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(shelterService.getShelter(id));
    }

    @PostMapping
    private ResponseEntity<AnimalShelterDTO> createShelter(@RequestBody AnimalShelterDTO shelterDTO) {
        return ResponseEntity.ok(shelterService.createShelter(shelterDTO));
    }
}
