package com.p5.adoptions.repository;

import com.p5.adoptions.model.*;

import java.util.ArrayList;
import java.util.List;

public class AnimalStore {

    private static List<Animal> animalList= new ArrayList<>();

    static {
        animalList.add(new DogDTO("Alfi", "https://i.natgeofe.com/n/4f5aaece-3300-41a4-b2a8-ed2708a0a27c/domestic-dog_thumb.jpg", 1));
        animalList.add(new DogDTO("Max", "https://post.medicalnewstoday.com/wp-content/uploads/sites/3/2020/02/322868_1100-800x825.jpg",2));
        animalList.add(new DogDTO("Luchi", "https://i.skyrock.net/5064/69435064/pics/2896107421_small_1.jpg",3));
        animalList.add(new CatDTO("Machi", "https://icatcare.org/app/uploads/2018/07/Thinking-of-getting-a-cat.png", 1));
        animalList.add(new CatDTO("Luna", "https://i.natgeofe.com/n/f0dccaca-174b-48a5-b944-9bcddf913645/01-cat-questions-nationalgeographic_1228126.jpg", 2));
        animalList.add(new CatDTO("Zoe", "https://www.humanesociety.org/sites/default/files/styles/1240x698/public/2018/06/cat-217679.jpg?h=c4ed616d&itok=3qHaqQ56", 3));
    }


    public static List<Animal> available () {
        return animalList;
    }

    public static void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    public static void removeAnimal(Animal animal) {
        animalList.remove(animal);
    }
}
