package com.example.demo.serviceImpl;

import com.example.demo.service.UserService;
import com.example.demo.util.FileNameHelper;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    FileNameHelper fileNameHelper;

    @Override
    public String getUserRoute(String username) {
        return username;
    }

    @Override
    public ArrayList<String> getUserProjects(String userRoute) {
        return fileNameHelper.allPrjects(userRoute);
    }
}
