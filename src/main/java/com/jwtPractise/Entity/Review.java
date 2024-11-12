package com.jwtPractise.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "description", length = 1000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "app_demo_user_id")
    private AppDemoUser appDemoUser;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

}