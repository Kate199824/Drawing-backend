package com.example.demo.util;

import com.example.demo.data.SystemData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

@Component
public class WriteHelper {
    @Autowired
    Translator translator;

    public void saveOrigin(String url, ArrayList<ArrayList<Integer>> points){
        String s = SystemData.BASE_ROUTE+"/"+url+"/origin";
        System.out.println(s);
        File file = new File(SystemData.BASE_ROUTE+"/"+url+"/origin");
        String pointsString = translator.Array2String(points);
        try{
            if(!file.exists()){
                File dir = new File(SystemData.BASE_ROUTE+"/"+url);
                dir.mkdirs();
                file.createNewFile();
                FileWriter fw = new FileWriter(file);
                fw.write(pointsString);
                fw.flush();
                fw.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void saveResult(String url, ArrayList<ArrayList<Integer>> points){
        String s = SystemData.BASE_ROUTE+"/"+url+"/origin";
        System.out.println(s);
        File file = new File(SystemData.BASE_ROUTE+"/"+url+"/result");
        String pointsString = translator.Array2String(points);
        try{
            if(!file.exists()){
                File dir = new File(SystemData.BASE_ROUTE+"/"+url);
                dir.mkdirs();
                file.createNewFile();
                FileWriter fw = new FileWriter(file);
                fw.write(pointsString);
                fw.flush();
                fw.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
