package com.example.demo.serviceImpl;

import com.example.demo.data.Result;
import com.example.demo.service.UploadService;
import com.example.demo.util.FileNameHelper;
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
    @Autowired
    FileNameHelper fileNameHelper;

    @Override
    public String upload(String userRoute, ArrayList<ArrayList<Integer>> points) {
        String filename = fileNameHelper.getFileName(userRoute);//get

        writeHelper.saveOrigin(userRoute+"/"+filename,points);
        Result result = recognizeHelper.recognize(points);
        writeHelper.saveResult(userRoute+"/"+filename, result);

        return filename;
    }
}
