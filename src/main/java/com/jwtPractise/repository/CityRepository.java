package com.jwtPractise.repository;

import com.jwtPractise.Entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {


    Optional<City> findByName(String name);
}