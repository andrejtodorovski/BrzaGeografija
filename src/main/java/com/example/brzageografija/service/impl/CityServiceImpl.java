package com.example.brzageografija.service.impl;

import com.example.brzageografija.repository.CityRepository;
import com.example.brzageografija.service.CityService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public boolean isValidAnswer(String input) {
        return cityRepository.findAllByCityNameEqualsIgnoreCase(input).size()>0;
    }
}
