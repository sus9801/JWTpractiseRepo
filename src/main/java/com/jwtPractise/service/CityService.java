package com.jwtPractise.service;

import com.jwtPractise.Entity.City;
import com.jwtPractise.repository.CityRepository;
import com.jwtPractise.repository.PropertyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {
    private CityRepository cityRepo;
    private PropertyRepository propertyRepo;

    public CityService(CityRepository cityRepo, PropertyRepository propertyRepo) {
        this.cityRepo = cityRepo;
        this.propertyRepo = propertyRepo;
    }

    public City addCityName(City city) {
       City saveCity= cityRepo.save(city);
        return saveCity;
    }

    @Transactional
    public void deleteCity(String name){
        Optional<City> opCity=cityRepo.findByName(name);
        if(opCity.isPresent()){
           City city= opCity.get();
            propertyRepo.deleteByCity(city);
            cityRepo.delete(city);
        }
        else{
            throw new RuntimeException("City with name " + name + " not found.");
        }

    }

    public City updateCityByName(String name,City city) {
        Optional<City> opFindedCity=cityRepo.findByName(name);
        if(opFindedCity.isPresent()){
           City findedCity= opFindedCity.get();
            findedCity.setName(city.getName());
           City savedCity=cityRepo.save(findedCity);
          return savedCity;
        }
        else{
            throw new RuntimeException("City with name " + name + " not found.");

        }


    }
}
