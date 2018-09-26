package com.example.demo.data;

import com.example.demo.util.Compute;

import java.util.ArrayList;

public class Circle extends Result {
   public Circle(ArrayList<ArrayList<Integer>> points){
       super("圆形");
       super.setOriginPoints(points);
       compute();
   }

    @Override
    void compute() {
        ArrayList<ArrayList<Integer>> keyPoints = new  ArrayList<ArrayList<Integer>>();
        keyPoints.add(originPoints.get(0));
        double lastK = Compute.getK(originPoints.get(0), originPoints.get(1));
        double currentK = 0.0;
        for(int i=1;i<originPoints.size()-1;i++){
            currentK = Compute.getK(originPoints.get(i), originPoints.get(i+1));
            //System.out.println("CURRENT K: "+currentK);
            double differK = Math.abs(currentK-lastK);
//            System.out.println("DIFFER K: "+differK);
            if(differK > 0.005*Math.PI){
                keyPoints.add(originPoints.get(i));
//                System.out.println("ADD KEY POINT: ("+originPoints.get(i).get(0)+","+originPoints.get(i).get(1)+")");
            }
            lastK = currentK;
        }

        keyPoints.add(originPoints.get(0));
        System.out.println("CIRCLE NUMBER OF KEY: "+keyPoints.size());

        setParsedPoints(keyPoints);
        setLikability( keyPoints.size()/160.0 );
    }
}
