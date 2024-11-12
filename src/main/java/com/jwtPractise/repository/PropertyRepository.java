package com.jwtPractise.repository;

import com.jwtPractise.Entity.*;
import com.jwtPractise.Entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    void deleteByCity(City city);
    void deleteByCountry(Country country);

    @Query("select p from Property p JOIN p.city c JOIN p.country co where c.name=:name or co.name=:name")
    List<Property>searchHotel(@Param("name") String name);
}
