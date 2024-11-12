package com.jwtPractise.repository;

import com.jwtPractise.Entity.AppDemoUser;
import com.jwtPractise.Entity.Country;
import com.jwtPractise.Entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppDemoUserRepository extends JpaRepository<AppDemoUser, Long> {
    Optional<AppDemoUser> findByUsername(String username);
    Optional<AppDemoUser> findByEmail(String email);


}