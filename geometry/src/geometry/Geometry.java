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


public class Geometry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Triangle tryme = new Triangle();
        tryme.setSide1Length(3);
        tryme.setSide2Length(3);
        tryme.setSide3Length(4);
        
        tryme.printTriangle();
        
        Triangle myTriangle = new Triangle();
        myTriangle.setSide1Length(3);
        myTriangle.setSide2Length(4);
        myTriangle.setSide3Length(5);
        
        tryme.printTriangle();
        
        Square squirrel = new Square();
        
        
    }
    
}
