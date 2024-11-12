package com.jwtPractise.repository;

import com.jwtPractise.Entity.City;
import com.jwtPractise.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {

    Optional<Country> findByName(String name);
}