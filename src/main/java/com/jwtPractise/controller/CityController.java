package com.jwtPractise.controller;

import com.jwtPractise.Entity.City;
import com.jwtPractise.service.CityService;
import com.jwtPractise.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cityController")
public class CityController {
    private CityService cityService;

    public CityController( CityService cityService) {
        this.cityService = cityService;

    }

    @PostMapping("/addCity")
    public ResponseEntity<City> addCity(@RequestBody City city){

        City saveCity=cityService.addCityName(city);
        return new ResponseEntity<>(saveCity, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCity")
    public ResponseEntity<String>deleteCity(@RequestParam String name){
        cityService.deleteCity(name);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @PutMapping("/updateCity")
    public ResponseEntity<City>updateCity(@RequestParam String name, @RequestBody City city){
       City savedcity= cityService.updateCityByName(name,city);
       return new ResponseEntity<>(savedcity,HttpStatus.OK);
    }
}
