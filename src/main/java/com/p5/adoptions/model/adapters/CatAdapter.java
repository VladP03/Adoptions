package com.p5.adoptions.model.adapters;

import com.p5.adoptions.model.CatDTO;
import com.p5.adoptions.repository.cats.Cat;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter {

    public static Cat fromDTO(CatDTO catDTO) {
        return new Cat()
                .setName(catDTO.getName())
                .setUrl(catDTO.getPhotoUrl());
    }

    public static CatDTO toDTO(Cat cat) {
        return new CatDTO(cat.getName(), cat.getUrl(), cat.getId());
    }

    public static List<CatDTO> toListDTO(List<Cat> catList) {
        List<CatDTO> dtoList = new ArrayList<>();

        for (Cat cat : catList) {
            dtoList.add(toDTO(cat));
        }

        return dtoList;
    }
}
