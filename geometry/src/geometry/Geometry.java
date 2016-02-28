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
        RectangularPrism test1 = new RectangularPrism();
        test1.print();
        
        System.out.println();
        
        test1 = new RectangularPrism(3, 4, 5);
        test1.print();
    }
    
}
