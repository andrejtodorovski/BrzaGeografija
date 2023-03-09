package com.example.brzageografija.controller;

import com.example.brzageografija.model.ResultDTO;
import com.example.brzageografija.model.ResultPointsDTO;
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
        request.getServletContext().setAttribute("randomLetter", letter.toUpperCase());
        return letter;
    }
    @PostMapping("/submitAnswer")
    public ResultPointsDTO isValidEntry(@RequestBody ResultDTO resultDTO, HttpServletRequest request){
        String randomLetter = (String) request.getServletContext().getAttribute("randomLetter");
        ResultPointsDTO resultPointsDTO = new ResultPointsDTO();
        int defPoints = 5;
        resultPointsDTO.setCountry(
                countryService.isValidAnswer(resultDTO.getCountry(), randomLetter) ? defPoints : 0
        );
        resultPointsDTO.setCity(
                cityService.isValidAnswer(resultDTO.getCity(), randomLetter) ? defPoints : 0
        );
        resultPointsDTO.setRiver(
                riverService.isValidAnswer(resultDTO.getRiver(), randomLetter) ? defPoints: 0
        );
        resultPointsDTO.setAnimal(
                animalService.isValidAnswer(resultDTO.getAnimal(), randomLetter) ? defPoints : 0
        );
        resultPointsDTO.setMountain(
                mountainService.isValidAnswer(resultDTO.getMountain(), randomLetter) ? defPoints : 0
        );
        resultPointsDTO.setThing(
                thingService.isValidAnswer(resultDTO.getThing(), randomLetter) ? defPoints : 0
        );
        resultPointsDTO.setPlant(
                plantService.isValidAnswer(resultDTO.getPlant(), randomLetter) ? defPoints : 0
        );
        resultPointsDTO.setTotalPoints(
                resultPointsDTO.getCity()+ resultPointsDTO.getAnimal()+ resultPointsDTO.getCountry()+
                        resultPointsDTO.getMountain()+ resultPointsDTO.getPlant()+ resultPointsDTO.getThing()+
                        resultPointsDTO.getRiver()
        );
        return resultPointsDTO;
    }
}
