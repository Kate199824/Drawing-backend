package com.example.demo.util;

import com.example.demo.data.SystemData;
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
        String res = "";
        try {
            FileReader fr = new FileReader(SystemData.BASE_ROUTE+"/"+url);
            BufferedReader bf = new BufferedReader(fr);
            res = bf.readLine();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return translator.String2Array(res);
    }
}
