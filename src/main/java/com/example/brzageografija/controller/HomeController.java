package com.example.brzageografija.controller;

import com.example.brzageografija.model.ResultDTO;
import com.example.brzageografija.service.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

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
    @GetMapping("/generateRandomLetter")
    public String getLetter(HttpServletRequest request) {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        Random rd = new Random();
        String letter = String.valueOf(abc.charAt(rd.nextInt(abc.length())));
        request.getSession().setAttribute("randomLetter", letter);
        return letter;
    }
    @PostMapping("/add")
    public boolean isValidEntry(@RequestBody ResultDTO resultDTO, HttpServletRequest request){
        String randomLetter = (String) request.getSession().getAttribute("randomLetter");
        return countryService.isValidAnswer(resultDTO.getCountry(), randomLetter) &&
                cityService.isValidAnswer(resultDTO.getCity(), randomLetter) &&
                mountainService.isValidAnswer(resultDTO.getMountain(), randomLetter) &&
                riverService.isValidAnswer(resultDTO.getRiver(), randomLetter) &&
                plantService.isValidAnswer(resultDTO.getPlant(), randomLetter) &&
                animalService.isValidAnswer(resultDTO.getAnimal(), randomLetter) &&
                thingService.isValidAnswer(resultDTO.getThing(), randomLetter);
    }
}
