package edu.macalester.comp124.breakout;

import acm.graphics.GCompound;
import acm.graphics.GRect;

import java.awt.*;

/**
 * Brick constructs a colored brick
 */
public class Brick extends GCompound {
    /**
     * Constructs a GRect with a specific color
     *
     * @param color
     */
    public Brick(Color color) {
        GRect bricks = new GRect(100, 20);
        add(bricks);
        bricks.setFilled(true);
        bricks.setFillColor(color);
    }


}
