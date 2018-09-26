package com.example.demo.service;

import java.util.ArrayList;

public interface ProjectService {

    public void deleteProject(String userRoute, String filename);

    public ArrayList<String> getUserProjects(String userRoute);
}
