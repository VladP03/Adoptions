package com.p5.adoptions.repository.dogs;

import com.p5.adoptions.repository.animals.Animal;
import javax.persistence.Entity;

@Entity
public class Dog extends Animal {

    private String height;

    public Dog() {
    }

    public String getHeight() {
        return height;
    }

    public Dog setHeight(String height) {
        this.height = height;
        return this;
    }
}
