package com.example.demo.serviceImpl;

import com.example.demo.service.UploadService;
import com.example.demo.util.RecognizeHelper;
import com.example.demo.util.WriteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UploadServiceImpl implements UploadService {
    @Autowired
    WriteHelper writeHelper;
    @Autowired
    RecognizeHelper recognizeHelper;

    @Override
    public String upload(String userRoute, ArrayList<ArrayList<Integer>> points) {
        String filename = "filename";//get

        writeHelper.saveOrigin(userRoute+"/"+filename,points);
        ArrayList<ArrayList<Integer>> result = recognizeHelper.recognize(points);
        writeHelper.saveResult(userRoute+"/"+filename, result);

        return filename;
    }
}
