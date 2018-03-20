package com.mygdx.game;

public class SandSpot {
    private double[] position = new double[2]; //x and y values
    private final int radius = 2;

    public SandSpot(double aX,double aY){
        this.position[0] = aX;
        this.position[1] = aY;
    }

    public double[] getPosition() {
        return position;
    }

    public int getRadius() {
        return radius;
    }
}
