package com.example.demo.util;

import com.example.demo.data.SystemData;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;

@Component
public class FileNameHelper {

    public String getFileName(String userRoute){
        String result = "";
        //用户文件夹是否存在
        File file = new File(SystemData.BASE_ROUTE+"/"+userRoute);
        if(!file.exists()){
            file.mkdirs();
        }

        File[] files = file.listFiles();

        result = "" + files.length;

        return result;
    }

    public ArrayList<String> allPrjects(String userRoute){
        ArrayList<String> res = new ArrayList<String>();
        File file = new File(SystemData.BASE_ROUTE+"/"+userRoute);
        if(!file.exists()){
            file.mkdirs();
        }
        File[] files = file.listFiles();
        for(File f : files){
            res.add(f.getName());
            System.out.println(f.getName());
        }
        return res;
    }
}
