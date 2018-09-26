package com.example.demo.serviceImpl;

import com.example.demo.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Override
    public String getUserRoute(String username) {
        return username;
    }

    @Override
    public void login() {

    }
}
