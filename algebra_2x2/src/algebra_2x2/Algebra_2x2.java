/*
    Algebra 2 x 2 Linear Equations
    CH 9 #9.11 Intro to Java Programming
    By Josh Guerra
    Created     02.25.16
    Modified    02.25.16

    Analysis

    Design a class named LinearEquation for a 
    2 by 2 system of linear equations:

        ax + by = e
        cx + dy = f
        
        x = (ed - bf) / (ad - bc)
        y = (af - ec) / (ad - bc)
    
    class contains
        private variables a, b, c, d, e, and f.
        constructor with the arguments for a, b, c, d, e, and f.
        getter methods for a, b, c, d, e, and f.
        method isSolvable() {returns true if (ad - bc) != 0}
        methods getX() and getY() that return the solution for the equation.

    Draw the UML diagram for the class and then implement the class. 
    Write a test program that prompts the user to enter a, b, c, d, e, and f 
    and displays the result. If ad - bc is 0, report that 
    “The equation has no solution.” 

    Testing

    a = 9.0, b = 4.0, c = 3.0, d = -5.0, e = -6.0, f = -21.0 
    x is -2.0 and y is 3.0

    a = 1.0, b = 2.0, c = 2.0, d = 4.0, e = 4.0, f = 5.0 
    The equation has no solution

 */

package algebra_2x2;

public class Algebra_2x2 {

    public static void main(String[] args) {
        
    }
    
}
