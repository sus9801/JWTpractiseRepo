package com.jwtPractise.controller;

import com.jwtPractise.Entity.Country;
import com.jwtPractise.Entity.Property;
import com.jwtPractise.repository.PropertyRepository;
import com.jwtPractise.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/add-property")
public class PropertyController {
    private PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    public ResponseEntity<Property> addCountry(@RequestParam String cityName
            ,@RequestParam String countryName,@RequestBody Property property){

        Property saveProperty=propertyService.addProperty(cityName,countryName,property);
        return new ResponseEntity<>(saveProperty, HttpStatus.CREATED);
    }

      @GetMapping("/search-hotel")
     public ResponseEntity<List<Property>> searchHotels(@RequestParam String name){
        List<Property> property=propertyService.searchHotel(name);
        return new ResponseEntity<>(property,HttpStatus.OK);
      }
}
