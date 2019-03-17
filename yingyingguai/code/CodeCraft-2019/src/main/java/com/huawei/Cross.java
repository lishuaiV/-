package com.huawei;

public class Cross {
    private int id;
    private int northRoad;
    private int eastRoad;
    private int southRoad;
    private int westRoad;
    private Car[] waitingCars;
    private Car[] turnInCars;
    Cross(String s){
        String[] info = s.substring(1, s.length() - 1).split(",");
        id = Integer.parseInt(info[0]);
        northRoad = Integer.parseInt(info[1]);
        eastRoad = Integer.parseInt(info[2]);
        southRoad = Integer.parseInt(info[3]);
        westRoad=Integer.parseInt(info[4]);
    }
    public int getId(){return id;}
    public int getNorthRoad(){return northRoad;}
    public int getEastRoad(){return eastRoad;}
    public int getSouthRoad(){return southRoad;}
    public int getWestRoad(){return westRoad;}

    public void turn(){}
}
