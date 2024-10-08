package com.Distributed_E_commerce_Microservice.user_management_service.controller;


import com.Distributed_E_commerce_Microservice.user_management_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Distributed_E_commerce_Microservice.user_management_service.Repository.User;
import org.springframework.security.core.Authentication;
import com.Distributed_E_commerce_Microservice.user_management_service.dto.LoginRequest;
import com.Distributed_E_commerce_Microservice.user_management_service.dto.JwtResponse;
import com.Distributed_E_commerce_Microservice.user_management_service.security.JwtUtils;

@RestController
@RequestMapping("/v1/User")
public class UserController {

    @Autowired
    private UserService userService;
    //register
    @PostMapping("/register")
    public ResponseEntity<?>  registerUser (@RequestBody User user){

        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully");
    }
    // login
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = userService.authenticate(loginRequest);
        String jwt = JwtUtils.generateToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

}
