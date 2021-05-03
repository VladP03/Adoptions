package com.p5.adoptions.controllers;

import com.p5.adoptions.model.Animal;
import com.p5.adoptions.repository.AnimalStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/animals")
public class AnimalController {

    @GetMapping("/hello")
    public ResponseEntity<String> greetOwner(@RequestParam (name = "name", required = false) String ownerName) {
        String name = null;

        if (ownerName != null) {
            name = ownerName;
        } else {
            name = "world";
        }

        return ResponseEntity.ok("Hello " + name + ", from the animal shelter");
    }

    @GetMapping
    public ResponseEntity<List<Animal>> getAvailableAnimals() {
        return ResponseEntity.ok(AnimalStore.available());
    }

    @PostMapping
    public ResponseEntity<Animal> addAnimalForAdoption(@RequestBody Animal animal) {
        if (animal == null || animal.getName() == null || animal.getPhotoUrl() == null) {
            return ResponseEntity.badRequest().body(animal);
        }

        AnimalStore.addAnimal(animal);

        return ResponseEntity.ok(animal);
    }

    @PutMapping("/{name}")
    public void updateAnimal(@PathVariable(name = "name") String name, @RequestBody Animal updatedAnimal) {

        List<Animal> animalList = AnimalStore.available();

        for (Animal animal : animalList) {
            if (animal.getName().equals(updatedAnimal.getName())) {
                animalList.remove(animal);
                animalList.add(updatedAnimal);
                break;
            }
        }
    }

    @DeleteMapping("/{name}")
    public void deleteAnimal (@PathVariable(name = "name") String name) {

        List<Animal> animalList = AnimalStore.available();

        for (Animal animal : animalList) {
            if (animal.getName().equals(name)) {
                animalList.remove(animal);
                break;
            }
        }
    }
}
