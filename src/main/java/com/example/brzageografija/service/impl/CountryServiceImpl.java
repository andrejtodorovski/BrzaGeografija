package com.example.brzageografija.service.impl;

import com.example.brzageografija.repository.CountryRepository;
import com.example.brzageografija.service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public boolean isValidAnswer(String input, String s) {
        return countryRepository.findAllByCountryNameEqualsIgnoreCaseAndCountryNameStartsWith(input, s).size()>0;
    }

}
