package com.example.demo.serviceImpl;

import com.example.demo.service.UserService;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Override
    public String getUserRoute(String username) {
        return username;
    }
}
