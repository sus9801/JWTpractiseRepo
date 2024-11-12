package com.jwtPractise.payload;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class AppDemoUserDto {

    private String name;
    private String username;
    private String email;
    private String role;
}
