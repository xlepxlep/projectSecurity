package com.example.projectSecurity.controller;


import com.example.projectSecurity.Repository.UserRepository;
import com.example.projectSecurity.model.User;
import com.example.projectSecurity.model.dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class mainController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public mainController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    @RequestMapping("api/getAllUsers")
    public List<User> getAllCitizens() {
        return userRepository.findAll();
    }

    @GetMapping
    @RequestMapping("api/delAll")
    public String deleteAllUsers() {

        userRepository.deleteAll();

        return "All deleted";
    }

    @PostMapping
    @RequestMapping("api/registration")
    public String addUser(@RequestBody dto newUser) {

        User newUser1 = new User(
                newUser.getName(),
                passwordEncoder.encode(newUser.getPassword()),
                newUser.getRole(),
                newUser.getResidence()
        );

        userRepository.save(newUser1);

//        User xlep = new User(
//        "xlep",
//        passwordEncoder.encode("xlep123"),
//        "EMPLOYEE",
//        "Nea Smyrni");
//
//        userRepository.save(xlep);
//
//        User atha = new User(
//                "atha",
//                passwordEncoder.encode("atha123"),
//                "CITIZEN",
//                "Nea Smyrni");
//
//        userRepository.save(atha);

        return "All good aea aea!";
    }



    @GetMapping
    @RequestMapping("api/citizen")
    public String onlyCitizens(){
        return "Hello my Citizen";
    }

    @GetMapping
    @RequestMapping("api/employee")
    public String onlyEmployees(){
        return "Hello my Employee";
    }

    @GetMapping
    @RequestMapping("api/admin")
    public String onlyAdmin(){
        return "Hello my Admin";
    }
}
