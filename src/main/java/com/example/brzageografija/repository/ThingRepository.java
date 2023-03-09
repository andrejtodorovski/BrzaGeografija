package com.example.brzageografija.repository;

import com.example.brzageografija.model.Thing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThingRepository extends JpaRepository<Thing,Long> {
    List<Thing> findAllByThingNameEqualsIgnoreCase(String thingName);
}
