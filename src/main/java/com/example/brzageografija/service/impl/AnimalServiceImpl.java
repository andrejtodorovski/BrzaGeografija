package com.example.brzageografija.service.impl;

import com.example.brzageografija.repository.AnimalRepository;
import com.example.brzageografija.service.AnimalService;
import org.springframework.stereotype.Service;

@Service
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public boolean isValidAnswer(String input) {
        return animalRepository.findAllByAnimalNameEqualsIgnoreCase(input).size()>0;
    }
}
