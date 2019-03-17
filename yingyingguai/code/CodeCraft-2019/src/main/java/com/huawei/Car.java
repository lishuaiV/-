package com.huawei;

public class Car {
    private int id;
    private int startCross;
    private int destinationCross;
    private int maxSpeed;
    private int startTime;
    private int nowSpeed;
    private int[] place;
    private int[] bestRoute;
    private int[] nowRoute;
    private int[] finalRoute;
    private int state;
    Car(String s){
        String[] info = s.substring(1, s.length() - 1).split(",");
        id = Integer.parseInt(info[0]);
        startCross = Integer.parseInt(info[1]);
        destinationCross = Integer.parseInt(info[2]);
        maxSpeed = Integer.parseInt(info[3]);
        startTime = Integer.parseInt(info[4]);
        nowSpeed=0;
        state=0;
    }
    public int getMaxSpeed(){ return maxSpeed;}
    public void setBestRoute(int[] route){bestRoute=route;}
    public void setRoute(int[] route){nowRoute=route;}
    public int[] getPlace(){return place;}
    public int getState(){return state;}

}
