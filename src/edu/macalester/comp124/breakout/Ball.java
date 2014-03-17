package edu.macalester.comp124.breakout;

import acm.graphics.GCompound;
import acm.graphics.GOval;

import java.awt.*;

/**
 * Created by Reena on 3/16/14.
 */
public class Ball extends GCompound {
    double theta;
    Ball(){
        GOval ball = new GOval(10,10);
        ball.setFilled(true);
        ball.setFillColor(Color.BLUE);
        theta = 315;
        add(ball);
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public double getTheta() {
        return this.theta;
    }
}
