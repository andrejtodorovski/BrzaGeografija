package com.example.brzageografija.repository;

import com.example.brzageografija.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country,Long> {
    List<Country> findAllByCountryNameEqualsIgnoreCase(String countryName);
}
