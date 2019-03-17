package com.huawei;

public class Road {
    private int id;
    private int length;
    private int maxSpeed;
    private int lanes;
    private int origin;
    private int end;
    private boolean dual;
    private Car[][] carsInLanse1;
    private Car[][] carsInLanse2;

    Road(String s){
        String[] info = s.substring(1, s.length() - 1).split(",");
        id = Integer.parseInt(info[0]);
        length = Integer.parseInt(info[1]);
        maxSpeed = Integer.parseInt(info[2]);
        lanes = Integer.parseInt(info[3]);
        origin = Integer.parseInt(info[4]);
        end = Integer.parseInt(info[5]);
        carsInLanse1=new Car[lanes][length];
        if (info[6].equals("0")){
            dual = false;
            carsInLanse2 = null;
        }
        else {
            dual = true;
            carsInLanse2=new Car[lanes][length];
        }
    }

    public int getId() { return id; }
    public int getLength(){ return length; }
    public int getMaxSpeed(){ return maxSpeed; }
    public int getLanes(){ return lanes; }
    public int getOrigin(){return origin;}
    public int getEnd(){return end;}
    public boolean isDual(){return dual;}

    public void addCar(Car car){ }//cross通过调用此方法使车进入road;
    public void moveCar(){}//移动路上的车一个单位时间;
}
