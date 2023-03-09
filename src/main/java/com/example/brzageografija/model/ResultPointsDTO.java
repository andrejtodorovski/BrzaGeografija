package com.example.brzageografija.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ResultPointsDTO {
    Integer country;
    Integer city;
    Integer mountain;
    Integer river;
    Integer plant;
    Integer animal;
    Integer thing;
    Integer totalPoints;
}
