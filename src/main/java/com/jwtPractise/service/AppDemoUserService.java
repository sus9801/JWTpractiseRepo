package com.jwtPractise.service;

import com.jwtPractise.Entity.AppDemoUser;
import com.jwtPractise.payload.AppDemoUserDto;
import com.jwtPractise.payload.LoginDto;
import com.jwtPractise.repository.AppDemoUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppDemoUserService {
    private AppDemoUserRepository repo;
      private ModelMapper mapper;
      private JwtService jwtservice;
    public AppDemoUserService(AppDemoUserRepository repo, ModelMapper mapper, JwtService jwtservice) {
        this.repo = repo;
        this.mapper = mapper;
        this.jwtservice = jwtservice;
    }
    public AppDemoUserDto mapToDto(AppDemoUser demoUser){
        AppDemoUserDto dto= mapper.map(demoUser,AppDemoUserDto.class);
        return dto;
    }


    public ResponseEntity<?> signupUser(AppDemoUser demo) {
        Optional<AppDemoUser> opappUser=repo.findByUsername(demo.getUsername());
        if(opappUser.isPresent()){
            return new ResponseEntity<>("Username is already in use please enter new one", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Optional<AppDemoUser> opappEmail=repo.findByEmail(demo.getEmail());
        if(opappEmail.isPresent()){
            return new ResponseEntity<>("Email is already in use please enter another Email", HttpStatus.INTERNAL_SERVER_ERROR);
        }
       String encryptPassword= BCrypt.hashpw(demo.getPassword(),BCrypt.gensalt(5));
         demo.setPassword(encryptPassword);
        demo.setRole("ROLE_USER");
        AppDemoUser saveduser= repo.save(demo);
        return new ResponseEntity<>(mapToDto(saveduser),HttpStatus.CREATED);
    }




    public String userLogin(LoginDto dto) {
        Optional<AppDemoUser> opdemo=repo.findByUsername(dto.getUsername());
        if(opdemo.isPresent()){
            AppDemoUser demo=opdemo.get();
            if(BCrypt.checkpw(dto.getPassword(),demo.getPassword())){
             String token= jwtservice.createToken(demo.getUsername());
             return token;
            }
            else{
               return null;
            }}else{
            return null;
        }
    }
    public ResponseEntity<?> signupasOwner(AppDemoUser demo) {

        Optional<AppDemoUser> opappUser=repo.findByUsername(demo.getUsername());
        if(opappUser.isPresent()){

            return new ResponseEntity<>("Username is already in use please enter new one", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Optional<AppDemoUser> opappEmail=repo.findByEmail(demo.getEmail());
        if(opappEmail.isPresent()){
            return new ResponseEntity<>("Email is already in use please enter another Email", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String encryptPassword= BCrypt.hashpw(demo.getPassword(),BCrypt.gensalt(5));
        demo.setPassword(encryptPassword);
        demo.setRole("ROLE_OWNER");
        AppDemoUser saveduser= repo.save(demo);

        return new ResponseEntity<>(mapToDto(saveduser),HttpStatus.CREATED);
    }

}
