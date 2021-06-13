package com.p5.adoptions.repository.animals;

import com.p5.adoptions.repository.shelter.AnimalShelter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

// Optiunea 1:
//@MappedSuperclass   // ne permite ca clasa Animal sa fie clasa de baza pentru alte entitati (OBS: Animal nu va fi tabela in DB)

// Optiunea 2:
//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)            // clasa de baza intr-o ierarhie de entitati
//// if not specified, DEFAULT: name of the class
//@DiscriminatorColumn(name = "name", discriminatorType = DiscriminatorType.STRING)       // specifica entitatii salvate

// Optiunea 3
// One table for each entity
// Will join tables to compose an entity
// Drawback: complexity because of Join
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)

// Optiunea 4
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String url;

//    @OneToOne(mappedBy = "animal")
//    private AnimalShelter shelter;

    // Bidirectionala
//    @ManyToOne
//    @JoinColumn(name = "shelter_id")
//    AnimalShelter shelter;

    // Bidirectional ManyToMany
//    @ManyToMany(mappedBy = "animals")
//    List<AnimalShelter> shelter = new ArrayList<>();

    public Animal() {
    }

    public Integer getId() {
        return id;
    }

    public Animal setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Animal setUrl(String url) {
        this.url = url;
        return this;
    }
}
