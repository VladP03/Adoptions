package com.p5.adoptions.service;

import com.p5.adoptions.model.CatDTO;
import com.p5.adoptions.model.ListDTO;
import com.p5.adoptions.model.adapters.CatAdapter;
import com.p5.adoptions.repository.cats.Cat;
import com.p5.adoptions.repository.cats.CatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    // putem pune constructor in loc de @AutoWired

    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;

    }

    public void addCat(CatDTO catDTO) {
        if (catDTO.getName() == null || catDTO.getPhotoUrl() == null || catDTO.getName().equals("")) {
            throw new RuntimeException("Cat must have a name and a photo url!");
        }

        Cat catToSave = CatAdapter.fromDTO(catDTO);

        catRepository.save(catToSave);
    }

    public ListDTO<CatDTO> findAll() {
        List<CatDTO> catDTOS = CatAdapter.toListDTO(catRepository.findAll());

        long totalCount = catRepository.count();

        return new ListDTO<>(Math.toIntExact(totalCount), catDTOS);
    }

    public CatDTO findCat(String name) {
        if (name == null || name.equals("")) {
            throw new RuntimeException("Must specify a name");
        }

        return CatAdapter.toDTO(catRepository.findCatByName(name));
    }
}
