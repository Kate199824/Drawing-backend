package com.example.demo.Helper;

import com.example.demo.data.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RecognizeHelper {

    public Result recognize(ArrayList<ArrayList<Integer>> points){
        Result[] results = new Result[3];
        results[0] = new Circle(points);
        results[1] = new Triangle(points);
        results[2] = new Rectangle(points);
        Result finalResult = getHighestResult(results);
        for(int i=0;i<results.length;i++){
            System.out.println(results[i].getName()+" : "+results[i].getLikability());
        }

        return finalResult;
    }

    private Result getHighestResult (Result[] results){
        Result res = results[0];
        for(int i=0;i< results.length;i++){
            if(results[i].getLikability()>res.getLikability()){
                res = results[i];
            }
        }
        return res;
    }

}
