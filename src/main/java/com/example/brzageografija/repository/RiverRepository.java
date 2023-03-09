package com.example.brzageografija.repository;

import com.example.brzageografija.model.River;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RiverRepository extends JpaRepository<River,Long> {
    List<River> findAllByRiverNameEqualsIgnoreCaseAndRiverNameStartsWith(String riverName, String s);
}
