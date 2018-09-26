package com.example.demo.service;

import java.util.ArrayList;

public interface UserService {

    public String getUserRoute(String username);

    public ArrayList<String> getUserProjects(String userRoute);

}
