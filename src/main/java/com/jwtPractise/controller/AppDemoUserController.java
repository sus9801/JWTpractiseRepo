package com.jwtPractise.controller;

import com.jwtPractise.Entity.AppDemoUser;
import com.jwtPractise.payload.AppDemoUserDto;
import com.jwtPractise.payload.LoginDto;
import com.jwtPractise.payload.TokenDto;
import com.jwtPractise.service.AppDemoUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/RegUsers")
public class AppDemoUserController {
    private AppDemoUserService service;

    public AppDemoUserController(AppDemoUserService service) {
        this.service = service;
    }

    @PostMapping("/signup-user")
    public ResponseEntity<?>SignUpUser(@RequestBody AppDemoUser demo){
        return service.signupUser(demo);
    }
    @PostMapping("/login")
    public ResponseEntity<?> userSignin(@RequestBody LoginDto dto){
       String token= service.userLogin(dto);
       if(token!=null){
           TokenDto tokenDto=new TokenDto();
           tokenDto.setToken(token);
           tokenDto.setType("JWT");
              return new ResponseEntity<>(tokenDto, HttpStatus.OK);
       }
       else{
           return new ResponseEntity<>("Username/password is incorrect",HttpStatus.FORBIDDEN);
       }
    }
    @PostMapping("/signup-owner")
    public ResponseEntity<?>SignUpOwner(@RequestBody AppDemoUser demo){

        return service.signupasOwner(demo);

    }
}
