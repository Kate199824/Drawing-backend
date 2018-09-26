package com.example.demo.Helper;

import com.example.demo.data.SystemData;
import com.example.demo.util.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

@Component
public class ReadHelper {
    @Autowired
    Translator translator;

    public ArrayList<ArrayList<Integer>> read(String url){
        String res = readString(url);
        return translator.String2Array(res);
    }

    public String readName (String url){
        return readString(url);
    }

    private String readString(String url){
        String res = "";
        try {
            FileReader fr = new FileReader(SystemData.BASE_ROUTE+"/"+url);
            BufferedReader bf = new BufferedReader(fr);
            res = bf.readLine();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  res;
    }
}
