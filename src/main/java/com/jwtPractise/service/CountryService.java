package com.jwtPractise.service;

import com.jwtPractise.Entity.City;
import com.jwtPractise.Entity.Country;
import com.jwtPractise.repository.AppDemoUserRepository;
import com.jwtPractise.repository.CountryRepository;
import com.jwtPractise.repository.PropertyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {
 private CountryRepository countryRepo;
 private PropertyRepository propertyRepo;

    public CountryService(CountryRepository countryRepo, PropertyRepository propertyRepo) {
        this.countryRepo = countryRepo;
        this.propertyRepo = propertyRepo;
    }


    public Country addCountryName(Country country) {
        Country savecountry=countryRepo.save(country);
        return savecountry;
    }
@Transactional
    public void deleteCountryByName(String name){
        Optional<Country> opCountry=countryRepo.findByName(name);
        if(opCountry.isPresent()){
            Country country=opCountry.get();
            propertyRepo.deleteByCountry(country);
            countryRepo.delete(country);
        }
       else {
            throw  new RuntimeException("Country with name " + name + " not found.");

        }
    }

    public Country updateCityByName(String name,Country country) {
        Optional<Country> opFindedCountry = countryRepo.findByName(name);
        if (opFindedCountry.isPresent()) {
            Country findedCountry = opFindedCountry.get();
            findedCountry.setName(country.getName());
            Country savedCountry = countryRepo.save(findedCountry);
            return savedCountry;
        } else {
            throw  new RuntimeException("Country with name " + name + " not found.");

        }


    }}