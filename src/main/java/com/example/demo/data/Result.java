package com.example.demo.data;

import java.util.ArrayList;

public abstract  class Result {
    protected double likability = 0.0;
    protected ArrayList<ArrayList<Integer>> originPoints;
    protected ArrayList<ArrayList<Integer>> parsedPoints;
    protected String name = "";

    abstract void compute();

    protected void setLikability(double likability){
        this.likability = likability;
    }

    public Result(String name){
        this.name = name;
    }

    public double getLikability() {
        return likability;
    }

    public ArrayList<ArrayList<Integer>> getOriginPoints() {
        return this.originPoints;
    }

    public void setOriginPoints(ArrayList<ArrayList<Integer>> originPoints) {
        this.originPoints = originPoints;
    }

    public ArrayList<ArrayList<Integer>> getParsedPoints() {
        return this.parsedPoints;
    }

    public void setParsedPoints(ArrayList<ArrayList<Integer>> parsedPoints) {
        this.parsedPoints = parsedPoints;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
