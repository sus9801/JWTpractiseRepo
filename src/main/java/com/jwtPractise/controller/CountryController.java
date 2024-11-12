package com.jwtPractise.controller;

import com.jwtPractise.Entity.City;
import com.jwtPractise.Entity.Country;
import com.jwtPractise.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/country")
public class CountryController {
    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/addCountry")
    public ResponseEntity<Country> addCountry(@RequestBody Country country) {

        Country saveCountry = countryService.addCountryName(country);
        return new ResponseEntity<>(saveCountry, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCountry")
    public ResponseEntity<String> deleteCountryByName(@RequestParam String name) {
        countryService.deleteCountryByName(name);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @PutMapping("/updateCountry")
    public ResponseEntity<Country> updateCountry(@RequestParam String name, @RequestBody Country country) {
        Country savedCountry = countryService.updateCityByName(name, country);
        return new ResponseEntity<>(savedCountry, HttpStatus.OK);
    }

}

