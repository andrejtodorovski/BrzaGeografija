package com.example.brzageografija.service.impl;

import com.example.brzageografija.repository.PlantRepository;
import com.example.brzageografija.service.PlantService;
import org.springframework.stereotype.Service;

@Service
public class PlantServiceImpl implements PlantService {
    private final PlantRepository plantRepository;

    public PlantServiceImpl(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @Override
    public boolean isValidAnswer(String input, String s) {
        return plantRepository.findAllByPlantNameEqualsIgnoreCaseAndPlantNameStartsWith(input, s).size()>0;
    }
}
