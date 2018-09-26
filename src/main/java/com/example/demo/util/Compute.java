package com.example.demo.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Compute {
    //获得两点之间的角度
    public static double getK(ArrayList<Integer> p1, ArrayList<Integer> p2){
//        System.out.println("P1: ("+p1.get(0)+","+p1.get(1)+")  P2: ("+p2.get(0)+","+p2.get(1)+")");
        if(p2.get(0) - p1.get(0) == 0){
            if(p2.get(1)>p1.get(1)){
                return Math.PI*0.5;
            }
            else{
                return -Math.PI*0.5;
            }
        }
        else {
            return Math.atan((p2.get(1)-p1.get(1)) / ((double)p2.get(0)-(double)p1.get(0)));
        }
    }
}
