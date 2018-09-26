package com.example.demo.service;

import java.util.ArrayList;

public interface DownloadService {
    public ArrayList<ArrayList<Integer>> getPicture(String userRoute, String filename);

    public ArrayList<ArrayList<Integer>> getResult(String userRoute, String filename);

    public String getName(String userRoute, String filename);

}
