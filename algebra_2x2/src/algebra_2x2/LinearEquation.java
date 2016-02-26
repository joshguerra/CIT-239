
package algebra_2x2;

/*
    2 by 2 system of linear equations

     ax + by = e
     cx + dy = f

     x = (ed - bf) / (ad - bc)
     y = (af - ec) / (ad - bc)
*/

public class LinearEquation {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    
    public LinearEquation(double initA, double initB, double initC, 
            double initD, double initE, double initF) {
        a = initA;
        b = initB;
        c = initC;
        d = initD;
        e = initE;
        f = initF;
    }
    
    public double getA() { return a; }
    public double getB() { return b; }
    public double getC() { return c; }
    public double getD() { return d; }
    public double getE() { return e; }
    public double getF() { return f; }
    
    public boolean isSolvable() {
        // if (ad -bc) is 0, the system is unsolvable
        return (a * d - b * c) != 0;
    }
    
    public double getX() {
        return (e * d - b * f) / (a * d - b * c);
    }
    
    public double getY() {
        return (a * f - e * c) / (a * d - b * c);
    }
}
