/*
    Algebra 2 x 2 Linear Equations
    CH 9 #9.11 Intro to Java Programming
    By Josh Guerra
    Created     02.25.16
    Modified    02.26.16
                Prompted user for a, b, c, d, e, f
                had previously misread directions
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

import java.util.Scanner;

public class Algebra_2x2 {

    public static void main(String[] args) {
        double sys_a, sys_b, sys_c, sys_d, sys_e, sys_f;
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter the value of a: ");
        sys_a = input.nextDouble();
        System.out.print("Please enter the value of b: ");
        sys_b = input.nextDouble();
        System.out.print("Please enter the value of c: ");
        sys_c = input.nextDouble();
        System.out.print("Please enter the value of d: ");
        sys_d = input.nextDouble();
        System.out.print("Please enter the value of e: ");
        sys_e = input.nextDouble();
        System.out.print("Please enter the value of f: ");
        sys_f = input.nextDouble();
        
        LinearEquation system1 = new LinearEquation(sys_a, sys_b, sys_c, 
                sys_d, sys_e, sys_f);

        // test system
        if (system1.isSolvable())
            System.out.println("x is " + system1.getX() + " and y is " + 
                    system1.getY());
        else
            System.out.println("The equations have no solution");
        
    }

}
