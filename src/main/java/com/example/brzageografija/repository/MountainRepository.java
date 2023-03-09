package com.example.brzageografija.repository;

import com.example.brzageografija.model.Mountain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MountainRepository extends JpaRepository<Mountain,Long> {
    List<Mountain> findAllByMountainNameEqualsIgnoreCaseAndMountainNameStartsWith(String mountainName, String s);
}
