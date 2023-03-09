package com.example.brzageografija.service;

import com.example.brzageografija.model.Country;

import java.util.List;

public interface CountryService {
    boolean isValidAnswer(String input);
    List<Country> getAllCountries();
}
