package com.example.demo.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Translator {

    public String Array2String (ArrayList<ArrayList<Integer>> list){
        String result = "";
        for(int i=0;i<list.size();i++){
            ArrayList<Integer> point = list.get(i);
            result = result + point.get(0)+","+point.get(1);
            if(i != list.size()-1){
                result = result + ";";
            }
        }
        System.out.println("Translated: "+result);
        return result;
    }

    public ArrayList<ArrayList<Integer>> String2Array (String str){
        System.out.println("Translating: "+str);
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        String[] points = str.split(";");
        for(int i=0;i<points.length;i++){
            String[] point = points[i].split(",");
            ArrayList<Integer> p = new ArrayList<Integer>();
            p.add(Integer.parseInt(point[0]));
            p.add(Integer.parseInt(point[1]));
            list.add(p);
        }
        return list;
    }
}
