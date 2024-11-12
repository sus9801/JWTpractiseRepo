package com.jwtPractise.service;

import com.jwtPractise.Entity.City;
import com.jwtPractise.Entity.Country;
import com.jwtPractise.Entity.Property;
import com.jwtPractise.repository.CityRepository;
import com.jwtPractise.repository.CountryRepository;
import com.jwtPractise.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    private PropertyRepository propertyRepository;
    private CityRepository cityRepository;
    private CountryRepository countryRepository;

    public PropertyService(PropertyRepository propertyRepository, CityRepository cityRepository, CountryRepository countryRepository) {
        this.propertyRepository = propertyRepository;
        this.cityRepository = cityRepository;

        this.countryRepository = countryRepository;
    }

    public Property addProperty(String cityName,String countryName,Property property) {
        City city=cityRepository.findByName (cityName).get();
        Country country=countryRepository.findByName(countryName).get();
          property.setCity(city);
          property.setCountry(country);
        Property saveProperty= propertyRepository.save(property);
        return saveProperty;
    }


    public List<Property> searchHotel(String name) {
       List<Property> property= propertyRepository.searchHotel(name);
       return property;
    }
}
