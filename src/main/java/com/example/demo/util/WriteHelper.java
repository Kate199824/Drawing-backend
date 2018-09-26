package com.example.demo.util;

import com.example.demo.data.Result;
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
        String dir = SystemData.BASE_ROUTE+"/"+url+"/origin";
        String pointsString = translator.Array2String(points);
        saveFile(dir,pointsString);
    }

    public void saveResult(String url, Result result){
        String dir = SystemData.BASE_ROUTE+"/"+url+"/result";
        String pointsString = translator.Array2String(result.getParsedPoints());
        saveFile(dir,pointsString);

        String nameDir = SystemData.BASE_ROUTE+"/"+url+"/name";
        String nameString = result.getName();
        saveFile(nameDir, nameString);
    }

    private void saveFile(String url, String content){
        File file = new File(url);
        try{
            if(!file.exists()){
                File dir = new File(url.substring(0,url.lastIndexOf('/')));
                dir.mkdirs();
                file.createNewFile();
                FileWriter fw = new FileWriter(file);
                fw.write(content);
                fw.flush();
                fw.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
