/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometry;

/**
 *
 * @author Josh
 */
public class Square {
    double sideLength; // squares have all 4 sides equal
    double angle = 90; // squares have all angles equal to 90 degrees
    
    double getArea() {
        return sideLength * sideLength;
    }
    
    double getPerimeter() {
        return 4 * sideLength;
    }
}
