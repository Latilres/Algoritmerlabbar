// Author(s): Fressia Merino & Therese Tengdahl
// Date: 11 May 2017
package fraktaler;

public class Sierpinski extends Flake{
    public void draw(Turtle turtle,int n,double size) {
        this.turtle = turtle;
        turtle.turnTo(0.0);
        drawSide(n, size);

    }

    private void drawSide(int n,double size) {
        if ( n <= 0 ) {
            turtle.turn(-60.0);
            turtle.walk(size);
            turtle.turn(120.0);
            turtle.walk(size);
            turtle.turn(120.0);
            turtle.walk(size);
        }
        else {
            double l = size/2.0;
            //first triangle
            drawSide(n-1, l);
            turtle.turn(120);
            turtle.jump(l);
            turtle.turn(60);
            //second triangle
            drawSide(n-1, l);
            turtle.turn(-120);
            turtle.jump(l);
            turtle.turn(-60);
            //third triangle
            drawSide(n-1, l);
            turtle.jump(l);
        }
    }
}
