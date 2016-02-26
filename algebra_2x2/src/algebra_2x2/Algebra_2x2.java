/*
    Algebra 2 x 2 Linear Equations
    CH 9 #9.11 Intro to Java Programming
    By Josh Guerra
    Created     02.25.16
    Modified    02.25.16

    Analysis

    Design a class named LinearEquation for a 
    2 by 2 system of linear equations:
        ax + by = e         x = (ed - bf) / (ad - bc)
        cx + dy = f         y = (af - ec) / (ad - bc)

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
    The equations have no solution
 */
package algebra_2x2;

public class Algebra_2x2 {

    public static void main(String[] args) {
        double  sys1_a = 9.0,
                sys1_b = 4.0,
                sys1_c = 3.0,
                sys1_d = -5.0,
                sys1_e = -6.0,
                sys1_f = -21.0;
        
        double  sys2_a = 1.0,
                sys2_b = 2.0,
                sys2_c = 2.0,
                sys2_d = 4.0,
                sys2_e = 4.0,
                sys2_f = 5.0;

        LinearEquation system1 = new LinearEquation(sys1_a, sys1_b, sys1_c, 
                sys1_d, sys1_e, sys1_f);
        LinearEquation system2 = new LinearEquation(sys2_a, sys2_b, sys2_c, 
                sys2_d, sys2_e, sys2_f);

        // first test system
        System.out.print("System 1: ");
        if (system1.isSolvable())
            System.out.println("x is " + system1.getX() + " and y is " + 
                    system1.getY());
        else
            System.out.println("The equations have no solution");
        
        // second test system
        System.out.print("System 2: ");
        if (system2.isSolvable())
            System.out.println("x is " + system2.getX() + " and y is " + 
                    system2.getY());
        else
            System.out.println("The equations have no solution");

    }

}
