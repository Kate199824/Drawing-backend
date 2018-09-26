package com.example.demo.serviceImpl;

import com.example.demo.service.DownloadService;
import com.example.demo.util.ReadHelper;
import com.sun.java.accessibility.util.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DownloadServiceImpl implements DownloadService {

    @Autowired
    ReadHelper readHelper;

    @Override
    public ArrayList<ArrayList<Integer>> getPicture(String userRoute, String filename){
        ArrayList<ArrayList<Integer>> points = readHelper.read(userRoute+"/"+filename+"/origin");
        return points;
    }

    @Override
    public ArrayList<ArrayList<Integer>> getResult(String userRoute, String filename){
        ArrayList<ArrayList<Integer>> points = readHelper.read(userRoute+"/"+filename+"/result");
        return points;
    }

    @Override
    public String getName(String userRoute, String filename) {
        String name = readHelper.readName(userRoute+"/"+filename+"/name");
        return name;
    }
}
