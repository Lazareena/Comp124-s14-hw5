package edu.macalester.comp124.breakout;

import acm.graphics.GCompound;
import acm.graphics.GRect;

import java.awt.*;

/**
 * Paddle constructs a default GRect
 */
public class Paddle extends GCompound {
    public Paddle() {
        GRect paddle = new GRect(150, 15);
        paddle.setFilled(true);
        paddle.setFillColor(Color.BLACK);
        add(paddle);
    }
}
