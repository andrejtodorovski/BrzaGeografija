package com.example.brzageografija.controller;

import com.example.brzageografija.model.Country;
import com.example.brzageografija.model.ResultDTO;
import com.example.brzageografija.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin("http://localhost:4200")
public class HomeController {
    private final AnimalService animalService;
    private final CityService cityService;
    private final CountryService countryService;
    private final MountainService mountainService;
    private final PlantService plantService;
    private final RiverService riverService;
    private final ThingService thingService;

    public HomeController(AnimalService animalService, CityService cityService, CountryService countryService, MountainService mountainService, PlantService plantService, RiverService riverService, ThingService thingService) {
        this.animalService = animalService;
        this.cityService = cityService;
        this.countryService = countryService;
        this.mountainService = mountainService;
        this.plantService = plantService;
        this.riverService = riverService;
        this.thingService = thingService;
    }
    @GetMapping("/countries")
    public List<Country> getCountries(){
        return countryService.getAllCountries();
    }
    @PostMapping("/add")
    public boolean isValidEntry(@RequestBody ResultDTO resultDTO){
        return countryService.isValidAnswer(resultDTO.getCountry()) &&
                cityService.isValidAnswer(resultDTO.getCity()) &&
                mountainService.isValidAnswer(resultDTO.getMountain()) &&
                riverService.isValidAnswer(resultDTO.getRiver()) &&
                plantService.isValidAnswer(resultDTO.getPlant()) &&
                animalService.isValidAnswer(resultDTO.getAnimal()) &&
                thingService.isValidAnswer(resultDTO.getThing());
    }
}
