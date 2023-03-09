package com.example.brzageografija.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ResultDTO {
    String country;
    String city;
    String mountain;
    String river;
    String plant;
    String animal;
    String thing;
}
