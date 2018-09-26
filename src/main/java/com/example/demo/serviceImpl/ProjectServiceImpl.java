package com.example.demo.serviceImpl;

import com.example.demo.service.ProjectService;
import com.example.demo.Helper.FileNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    FileNameHelper fileNameHelper;

    @Override
    public void deleteProject(String userRoute, String filename) {
        fileNameHelper.deleteProject(userRoute, filename);
    }

    @Override
    public ArrayList<String> getUserProjects(String userRoute) {
        return fileNameHelper.allProjects(userRoute);
    }
}
