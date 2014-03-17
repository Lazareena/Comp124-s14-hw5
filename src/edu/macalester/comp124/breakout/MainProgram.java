package edu.macalester.comp124.breakout;

import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 */
public class MainProgram extends GraphicsProgram {
public void run(){

    brickRows();

    add(paddle, (getWidth()-paddle.getWidth())/2, getHeight()- (paddle.getHeight()));

    add(ball, (getWidth()/2), (getHeight()*3)/4);

    moveBall();

}
    Paddle paddle = new Paddle();
    Ball ball = new Ball();

    public void moveBall(){

        while(true){
               println(ball.getTheta());
               ball.movePolar(1, ball.getTheta());
               pause(5);
            GObject a=getElementAt(ball.getX(), ball.getY());
            GObject b=getElementAt((ball.getX() + ball.getWidth()), ball.getY());
            GObject c= getElementAt(ball.getX(), (ball.getY()+ ball.getHeight()));
            GObject d= getElementAt((ball.getX()+ ball.getWidth()), (ball.getY()+ ball.getHeight()));
       if ((a!= null) && (a!= paddle)) {
           remove(a);
       }  else if ((c!= null) && (c!= paddle)) {
           remove(c);
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
           ball.setTheta(ball.getTheta() -90);
           ball.movePolar(1, ball.getTheta());
           pause(10);
       } else if (((a != null) && (b != null)) && ((ball.getTheta() % 360 == 135) || (ball.getTheta() % 360 == -225))) {
           ball.setTheta(ball.getTheta() + 90);
           ball.movePolar(1, ball.getTheta());
           pause(10);
       } else if (((ball.getX() + ball.getWidth()) >= getWidth()) && ((ball.getTheta() % 360 == 315) || (ball.getTheta() % 360 == -45))) {
           ball.setTheta(ball.getTheta()-90);
           ball.movePolar(1, ball.getTheta());
           pause(10);
       } else if (((ball.getX() + ball.getWidth()) >= getWidth()) && ((ball.getTheta() % 360 == 45) || (ball.getTheta() % 360 == -315))) {
           ball.setTheta(ball.getTheta()+90);
           ball.movePolar(1, ball.getTheta());
           pause(10);
       } else if ((ball.getX() <= 0) && ((ball.getTheta() % 360 == 225) || (ball.getTheta() % 360 == -135))) {
           ball.setTheta(ball.getTheta()+90);
           ball.movePolar(1, ball.getTheta());
           pause(10);
       } else if ((ball.getX() <= 0) && ((ball.getTheta() % 360 == 135) || (ball.getTheta() % 360 == -225))) {
           ball.setTheta(ball.getTheta()-90);
           ball.movePolar(1, ball.getTheta());
           pause(10);
       } else if ((ball.getY() <= 0) && ((ball.getTheta() % 360 == 45) || (ball.getTheta() % 360 == -315))) {
                ball.setTheta(ball.getTheta() -90);
                ball.movePolar(1, ball.getTheta());
                pause(10);
       } else if ((ball.getY() <= 0) && ((ball.getTheta() % 360 == 135) || (ball.getTheta() % 360 == -225))) {
           ball.setTheta(ball.getTheta() + 90);
           ball.movePolar(1, ball.getTheta());
           pause(10);
       }
    }
    }

    public void brickRows(){
        int num = (getWidth())/100;

        GRect row1[] = new GRect[num];
        int x1 = 10;
        int y1 = 0;

        for(int i= 0; i < num; i++) {
            row1[i] =  new GRect(100,20);
            row1[i].setFilled(true);
            row1[i].setFillColor(Color.RED);
            add(row1[i], x1, y1);
            x1 += 105;
        }

        GRect row2[] = new GRect[num];
        int x2 = 10;
        int y2 = 25;

        for(int i =0; i<num; i++) {
            row2[i] = new GRect(100,20);
            row2[i].setFilled(true);
            row2[i].setFillColor(Color.RED);
            add(row2[i], x2, y2);
            x2 += 105;
        }

        GRect row3[] = new GRect[num];
        int x3 = 10;
        int y3 = 50;

        for(int i =0; i<num; i++) {
            row3[i] = new GRect(100,20);
            row3[i].setFilled(true);
            row3[i].setFillColor(Color.ORANGE);
            add(row3[i], x3, y3);
            x3 += 105;
        }

        GRect row4[] = new GRect[num];
        int x4 = 10;
        int y4 = 75;

        for(int i =0; i<num; i++) {
            row4[i] = new GRect(100,20);
            row4[i].setFilled(true);
            row4[i].setFillColor(Color.ORANGE);
            add(row4[i], x4, y4);
            x4 += 105;
        }

        GRect row5[] = new GRect[num];
        int x5 = 10;
        int y5 = 100;

        for(int i =0; i<num; i++) {
            row5[i] = new GRect(100,20);
            row5[i].setFilled(true);
            row5[i].setFillColor(Color.YELLOW);
            add(row5[i], x5, y5);
            x5 += 105;
        }

        GRect row6[] = new GRect[num];
        int x6 = 10;
        int y6 = 125;

        for(int i =0; i<num; i++) {
            row6[i] = new GRect(100,20);
            row6[i].setFilled(true);
            row6[i].setFillColor(Color.YELLOW);
            add(row6[i], x6, y6);
            x6 += 105;
        }

        GRect row7[] = new GRect[num];
        int x7 = 10;
        int y7 = 150;

        for(int i =0; i<num; i++) {
            row7[i] = new GRect(100,20);
            row7[i].setFilled(true);
            row7[i].setFillColor(Color.GREEN);
            add(row7[i], x7, y7);
            x7 += 105;
        }

        GRect row8[] = new GRect[num];
        int x8 = 10;
        int y8 = 175;

        for(int i =0; i<num; i++) {
            row8[i] = new GRect(100,20);
            row8[i].setFilled(true);
            row8[i].setFillColor(Color.GREEN);
            add(row8[i], x8, y8);
            x8 += 105;
        }

        GRect row9[] = new GRect[num];
        int x9 = 10;
        int y9 = 200;

        for(int i =0; i<num; i++) {
            row9[i] = new GRect(100,20);
            row9[i].setFilled(true);
            row9[i].setFillColor(Color.CYAN);
            add(row9[i], x9, y9);
            x9 += 105;
        }

        GRect row10[] = new GRect[num];
        int x10 = 10;
        int y10 = 225;

        for(int i =0; i<num; i++) {
            row10[i] = new GRect(100,20);
            row10[i].setFilled(true);
            row10[i].setFillColor(Color.CYAN);
            add(row10[i], x10, y10);
            x10 += 105;
        }
 addMouseListeners();
    }


    GObject obj;
    double lastX, lastY;
    @Override
    public void mouseEntered(MouseEvent e) {
        lastX =e.getX();
        lastY =e.getY();
        obj = getElementAt(lastX,lastY);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if ( obj != null) {
            obj.move(e.getX() - lastX, 0);
            lastX = e.getX();
            lastY = e.getY();
        }
}

}


