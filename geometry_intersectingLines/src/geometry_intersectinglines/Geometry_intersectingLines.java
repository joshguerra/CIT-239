/*
    Geometry Intersecting Line Segments
    CH 9 #9.12 Intro to Java Programming
    By Josh Guerra
    Created     02.25.16
    Modified    02.25.16

    Analysis

    Suppose two line segments intersect. The two endpoints for the first line 
    segment are (x1, y1) and (x2, y2) and for the second line segment are 
    (x3, y3) and (x4, y4). 

    Write a program that prompts the user to enter these four endpoints and 
    displays the intersecting point. 

    Use the LinearEquation class in Programming Exercise 9.11 to solve this
    equation. 

    Design

    declare two parallel arrays of double to hold points
        [x1, x2, x3, x4] and [y1, y2, y3, y4]

    declare an object of LinearEquation
        ax + by = e         x = (ed - bf) / (ad - bc)
        cx + dy = f         y = (af - ec) / (ad - bc)

    declare scanner object
    prompt for 8 doubles to represent the 4 points (2 line segments)

        System of Equations in Standard form from 4 points:
        (y1 - y2)x - (x1 - x2)y = (y1 - y2)x1 - (x1 - x2)y1
        (y3 - y4)x - (x3 - x4)y = (y3 - y4)x3 - (x3 - x4)y3

        a = y1 - y2             b = x1 - x2 
        c = y3 - y4             d = x3 - x4
        
        e = (y1 - y2) * x1 - (x1 - x2) * y1
        f = (y3 - y4) * x3 - (x3 - x4) * y3

    Testing

    x1 = 2, y1 = 2, x2 = 5, y2 = -1.0, x3 = 4.0, y3 = 2.0, x4 = -1.0, y4 = -2.0      
    The intersecting point is at (2.88889, 1.1111)

    x1 = 2, y1 = 2, x2 = 7, y2 = 6.0, x3 = 4.0, y3 = 2.0, x4 = -1.0, y4 = -2.0        
    The two lines are parallel
*/

package geometry_intersectinglines;

import java.util.Scanner;

public class Geometry_intersectingLines {

    public static void main(String[] args) {
        final int NUM_PTS = 4;
        
        double[] xVals = new double[NUM_PTS];
        double[] yVals = new double[NUM_PTS];
        
        // calculate values from points
        // pass values into object constructor
        double a, b, c, d, e, f;
        
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < NUM_PTS; i++) {
            System.out.print("Please enter x value of point " + (i + 1) + ": ");
            xVals[i] = input.nextDouble();
            System.out.print("Please enter y value of point " + (i + 1) + ": ");
            yVals[i] = input.nextDouble();
        }
        
        a = yVals[0] - yVals[1];        // a = y1 - y2 
        b = xVals[0] - xVals[1];        // b = x1 - x2 
        c = yVals[2] - yVals[3];        // c = y3 - y4             
        d = xVals[2] - xVals[3];        // d = x3 - x4
        
        // e = (y1 - y2) * x1 - (x1 - x2) * y1
        // f = (y3 - y4) * x3 - (x3 - x4) * y3
        e = (yVals[0] - yVals[1]) * xVals[0] - (xVals[0] - xVals[1]) * yVals[0];
        f = (yVals[2] - yVals[3]) * xVals[2] - (xVals[2] - xVals[3]) * yVals[2];

        LinearEquation equations = new LinearEquation(a, b, c, d, e, f);
        
        // print results
        if (equations.isSolvable())
            System.out.println("Intersecting point is (" + equations.getX() 
                    + ", " + equations.getY() + ")");
        else
            System.out.println("The two lines are parallel");
    }
    
}
