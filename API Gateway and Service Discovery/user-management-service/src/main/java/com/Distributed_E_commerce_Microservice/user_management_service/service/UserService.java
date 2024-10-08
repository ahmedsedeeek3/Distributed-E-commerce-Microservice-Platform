package com.Distributed_E_commerce_Microservice.user_management_service.service;


import com.Distributed_E_commerce_Microservice.user_management_service.Repository.User;
import com.Distributed_E_commerce_Microservice.user_management_service.dto.LoginRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void saveUser(User user) {


    }


    public Authentication authenticate(LoginRequest loginRequest) {
        return null;
    }
}
