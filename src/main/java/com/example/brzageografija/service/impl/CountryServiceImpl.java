package com.example.brzageografija.service.impl;

import com.example.brzageografija.model.Country;
import com.example.brzageografija.repository.CountryRepository;
import com.example.brzageografija.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public boolean isValidAnswer(String input) {
        return countryRepository.findAllByCountryNameEqualsIgnoreCase(input).size()>0;
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
