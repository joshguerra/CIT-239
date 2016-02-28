package geometry;

/**
 * @author Josh Guerra
 */
class RectangularPrism {
    private double width; 
    private double length;
    private double height;
    
    // if w is invalid, width set to 1
    void setW(double w) {
        if (w < 0)
            width = 1;
        else
            width = w;
    }
    
    // if l is invalid, width set to 1
    void setL(double l) {
        if (l < 0)
            length = 1;
        else
            length = l;
    }
    
    // if h is invalid, width set to 1
    void setH(double h) {
        if (h < 0)
            height = 1;
        else
            height = h;
    }
    
    RectangularPrism() {
        setW(1);
        setL(1);
        setH(1);
    }
    
    RectangularPrism(double w, double l, double h) {
        setW(w);
        setL(l);
        setH(h);
    }

    double getW() { return width; }
    double getL() { return length; }
    double getH() { return height; }
    double getSurfaceArea() { 
        double a1 = length * width;
        double a2 = length * height;
        double a3 = width * height;
        return 2 * (a1 + a2 + a3); 
    }
    double getVolume() { return length * width * height; }
    
    void print() {
        System.out.println("Prism is " + width + " by " + length + " by " + height);
        System.out.println("Prism has Surface Area of " + getSurfaceArea() + 
                " and Volume of " + getVolume());
    }

}
