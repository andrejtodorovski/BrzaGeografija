package com.example.brzageografija.repository;

import com.example.brzageografija.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantRepository extends JpaRepository<Plant,Long> {
    List<Plant> findAllByPlantNameEqualsIgnoreCaseAndPlantNameStartsWith(String plantName, String s);
}
