package com.example.demo.serviceImpl;

import com.example.demo.data.Result;
import com.example.demo.service.UploadService;
import com.example.demo.Helper.FileNameHelper;
import com.example.demo.Helper.RecognizeHelper;
import com.example.demo.Helper.WriteHelper;
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
    public String upload(String userRoute, String userFilename, ArrayList<ArrayList<Integer>> points) {
        String filename = fileNameHelper.getFileName(userRoute, userFilename);//get

        writeHelper.saveOrigin(userRoute+"/"+filename,points);
        Result result = recognizeHelper.recognize(points);
        writeHelper.saveResult(userRoute+"/"+filename, result);

        return filename;
    }
}
