package com.example.brzageografija.repository;

import com.example.brzageografija.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Long> {
    List<City> findAllByCityNameEqualsIgnoreCase(String cityName);
}
