package edu.macalester.comp124.breakout;

import acm.graphics.GCompound;
import acm.graphics.GOval;

import java.awt.*;

/**
 * Ball constructs a default GOval
 */
public class Ball extends GCompound {
    private double theta;

    Ball() {
        GOval ball = new GOval(10, 10);
        ball.setFilled(true);
        ball.setFillColor(Color.BLUE);
        theta = 315;
        add(ball);
    }

    /**
     * Sets the angle in which the ball moves
     *
     * @param theta
     */

    public void setTheta(double theta) {
        this.theta = theta;
    }

    /**
     * Returns the angle in which the ball moves
     *
     * @return
     */

    public double getTheta() {
        return this.theta;
    }
}
