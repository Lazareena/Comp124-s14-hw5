package edu.macalester.comp124.breakout;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.DataBuffer;
import java.sql.Time;

/**
 * MainProgram runs a program that allows the user to play  brick breaker and uses classes Ball and Paddle
 */
public class MainProgram extends GraphicsProgram {

    public void run() {
        brickRows();

        add(paddle, (getWidth() - paddle.getWidth()) / 2, getHeight() - (paddle.getHeight()) - 5);

        add(ball, (getWidth() / 2), (getHeight() * 3) / 4);

        moveBall();
    }

    private Paddle paddle = new Paddle();
    private Ball ball = new Ball();

    /**
     * Moves the ball and makes it bounce off the edges, bricks and paddle.
     * Removes the bricks
     * Restarts the game when the ball exits the screen
     * Ends the game and stops the ball after three tries
     * Ends the game and stops the ball when all bricks are removed
     */
    public void moveBall() {
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        while (true) {
            println(ball.getTheta());
            ball.movePolar(1, ball.getTheta());
            pause(5);
            GObject a = getElementAt(ball.getX(), ball.getY());
            GObject b = getElementAt((ball.getX() + ball.getWidth()), ball.getY());
            GObject c = getElementAt(ball.getX(), (ball.getY() + ball.getHeight()));
            GObject d = getElementAt((ball.getX() + ball.getWidth()), (ball.getY() + ball.getHeight()));

            if ((a != null) && (a != paddle)) {
                remove(a);
                index1 += 1;
            } else if ((d != null) && (d != paddle)) {
                remove(d);
                index2 += 1;
            } else if (index1 + index2 == 70) {
                GLabel win = new GLabel("YOU WIN! :D");
                add(win, getWidth()/4, (getHeight()-win.getHeight())/ 2);
                win.setColor(Color.BLUE);
                win.setFont("Helvetica-50");
                break;
            }

            if (ball.getY() >= getHeight()) {
                remove(ball);
                add(ball, (getWidth() / 2), (getHeight() * 3) / 4);
                index3 += 1;
            } else if (index3 == 3) {
                GLabel win = new GLabel("YOU LOOSE! :(");
                add(win, getWidth()/4, (getHeight()-win.getHeight())/ 2);
                win.setColor(Color.RED);
                win.setFont("Helvetica-50");
                break;
            }

            if (((c != null) && (d != null)) && ((ball.getTheta() % 360 == 315) || (ball.getTheta() % 360 == -45))) {
                ball.setTheta(ball.getTheta() + 90);
                ball.movePolar(1, ball.getTheta());
                pause(10);
            } else if (((c != null) && (d != null)) && ((ball.getTheta() % 360 == 225) || (ball.getTheta() % 360 == -135))) {
                ball.setTheta(ball.getTheta() - 90);
                ball.movePolar(1, ball.getTheta());
                pause(10);
            } else if (((a != null) && (b != null)) && ((ball.getTheta() % 360 == 45) || (ball.getTheta() % 360 == -315))) {
                ball.setTheta(ball.getTheta() - 90);
                ball.movePolar(1, ball.getTheta());
                pause(10);
            } else if (((a != null) && (b != null)) && ((ball.getTheta() % 360 == 135) || (ball.getTheta() % 360 == -225))) {
                ball.setTheta(ball.getTheta() + 90);
                ball.movePolar(1, ball.getTheta());
                pause(10);
            } else if (((ball.getX() + ball.getWidth()) >= getWidth()) && ((ball.getTheta() % 360 == 315) || (ball.getTheta() % 360 == -45))) {
                ball.setTheta(ball.getTheta() - 90);
                ball.movePolar(1, ball.getTheta());
                pause(10);
            } else if (((ball.getX() + ball.getWidth()) >= getWidth()) && ((ball.getTheta() % 360 == 45) || (ball.getTheta() % 360 == -315))) {
                ball.setTheta(ball.getTheta() + 90);
                ball.movePolar(1, ball.getTheta());
                pause(10);
            } else if ((ball.getX() <= 0) && ((ball.getTheta() % 360 == 225) || (ball.getTheta() % 360 == -135))) {
                ball.setTheta(ball.getTheta() + 90);
                ball.movePolar(1, ball.getTheta());
                pause(10);
            } else if ((ball.getX() <= 0) && ((ball.getTheta() % 360 == 135) || (ball.getTheta() % 360 == -225))) {
                ball.setTheta(ball.getTheta() - 90);
                ball.movePolar(1, ball.getTheta());
                pause(10);
            } else if ((ball.getY() <= 0) && ((ball.getTheta() % 360 == 45) || (ball.getTheta() % 360 == -315))) {
                ball.setTheta(ball.getTheta() - 90);
                ball.movePolar(1, ball.getTheta());
                pause(10);
            } else if ((ball.getY() <= 0) && ((ball.getTheta() % 360 == 135) || (ball.getTheta() % 360 == -225))) {
                ball.setTheta(ball.getTheta() + 90);
                ball.movePolar(1, ball.getTheta());
                pause(10);
            }

        }
    }

    /**
     * Constructs multicolored rows of bricks
     */

    public void brickRows() {
        int num = (getWidth()) / 100;

        Brick row1[] = new Brick[num];
        int x1 = 10;
        int y1 = 0;

        for (int i = 0; i < num; i++) {
            Brick brick = new Brick(Color.RED);
            row1[i] = brick;
            add(row1[i], x1, y1);
            x1 += 105;
        }

        Brick row2[] = new Brick[num];
        int x2 = 10;
        int y2 = 25;

        for (int i = 0; i < num; i++) {
            row2[i] = new Brick(Color.RED);
            add(row2[i], x2, y2);
            x2 += 105;
        }

        Brick row3[] = new Brick[num];
        int x3 = 10;
        int y3 = 50;

        for (int i = 0; i < num; i++) {
            row3[i] = new Brick(Color.ORANGE);
            add(row3[i], x3, y3);
            x3 += 105;
        }

        Brick row4[] = new Brick[num];
        int x4 = 10;
        int y4 = 75;

        for (int i = 0; i < num; i++) {
            row4[i] = new Brick(Color.ORANGE);
            add(row4[i], x4, y4);
            x4 += 105;
        }

        Brick row5[] = new Brick[num];
        int x5 = 10;
        int y5 = 100;

        for (int i = 0; i < num; i++) {
            row5[i] = new Brick(Color.YELLOW);
            add(row5[i], x5, y5);
            x5 += 105;
        }

        Brick row6[] = new Brick[num];
        int x6 = 10;
        int y6 = 125;

        for (int i = 0; i < num; i++) {
            row6[i] = new Brick(Color.YELLOW);
            add(row6[i], x6, y6);
            x6 += 105;
        }

        Brick row7[] = new Brick[num];
        int x7 = 10;
        int y7 = 150;

        for (int i = 0; i < num; i++) {
            row7[i] = new Brick(Color.GREEN);
            add(row7[i], x7, y7);
            x7 += 105;
        }

        Brick row8[] = new Brick[num];
        int x8 = 10;
        int y8 = 175;

        for (int i = 0; i < num; i++) {
            row8[i] = new Brick(Color.GREEN);
            add(row8[i], x8, y8);
            x8 += 105;
        }

        Brick row9[] = new Brick[num];
        int x9 = 10;
        int y9 = 200;

        for (int i = 0; i < num; i++) {
            row9[i] = new Brick(Color.CYAN);
            add(row9[i], x9, y9);
            x9 += 105;
        }

        Brick row10[] = new Brick[num];
        int x10 = 10;
        int y10 = 225;

        for (int i = 0; i < num; i++) {
            row10[i] = new Brick(Color.CYAN);
            add(row10[i], x10, y10);
            x10 += 105;
        }
        addMouseListeners();
    }

    GObject obj;
    double lastX, lastY;

    /**
     * Sets the initial value of the mouse listener to all the x-values along the height of the paddle
     *
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        lastX = e.getX();
        lastY = getHeight() - paddle.getHeight() - 5;
        obj = getElementAt(lastX, lastY);
    }

    /**
     * Moves the paddle to the left and right according to the motion of the mouse
     *
     * @param e
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        if (obj != null) {
            obj.move(e.getX() - lastX, 0);
            lastX = e.getX();
            lastY = getHeight() - paddle.getHeight() - 5;
        }
    }

}


