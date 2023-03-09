package com.example.brzageografija.repository;

import com.example.brzageografija.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal,Long> {
    List<Animal> findAllByAnimalNameEqualsIgnoreCaseAndAnimalNameStartsWith(String animalName, String s);
}
