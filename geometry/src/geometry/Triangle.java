/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometry;

/** @author Josh */
public class Triangle {
    private double side1Length;
    private double side2Length;
    private double side3Length;
    private double angle1;
    private double angle2;
    private double angle3; 
    
    void setSide1Length(double s) {
        if (validateLength(s))
            side1Length = s;
        else 
            side1Length = 1;
    }
    
    void setSide2Length(double s) {
        if (validateLength(s))
            side2Length = s;
        else 
            side2Length = 1;
    }
    void setSide3Length(double s) {
        if (validateLength(s))
            side3Length = s;
        else 
            side3Length = 1;
    }
    
    void setAngle1(double a) {
        if (validateAngle(a))
            angle1 = a;
        else 
            angle1 = 1;
    }
    
    void setAngle2(double a) {
        if (validateAngle(a))
            angle2 = a;
        else 
            angle2 = 1;
    }
    
    void setAngle3(double a) {
        if (validateAngle(a))
            angle3 = a;
        else 
            angle3 = 1;
    }
    
    boolean validateLength(double s) {
        return s > 0;
    }
    
    boolean validateAngle(double a) {
        return a > 0 && a < 180;
    }
    
    double getSide1Length() { return side1Length; }
    double getSide2Length() { return side2Length; }
    double getSide3Length() { return side3Length; }
    
    double getAngle1() { return angle1; }
    double getAngle2() { return angle2; }
    double getAngle3() { return angle3; }
    
    double getArea() {
        double semiPerimeter = getPerimeter() / 2.;
        return Math.sqrt(semiPerimeter * 
                (semiPerimeter - side1Length) * 
                (semiPerimeter - side2Length) * 
                (semiPerimeter - side3Length));
    }
    
    double getPerimeter() {
        return side1Length + side2Length + side3Length;
    }
    
    void printTriangle() {
        System.out.println("Triangle has sides: " + side1Length + 
                ", " + side2Length + ", " + side3Length);
        System.out.println("Triangle has area: " + getArea() + 
                ", perimeter: " + getPerimeter());
        
    }
}
