package geometry;

/**
 * @author Josh Guerra
 */
class Rectangle {
    private double width; 
    private double length;
    
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
    
    Rectangle() {
        setW(1);
        setL(1);
    }
    
    Rectangle(double w, double l) {
        setW(w);
        setL(l);
    }

    double getW() { return width; }
    double getL() { return length; }
    double getArea() { return length * width; }
    double getPerimeter() { return 2 * (length + width); }
    
    void print() {
        System.out.println("Rectangle is " + width + " by " + length);
        System.out.println("Rectangle has Area of " + getArea() + 
                " and Perimeter of " + getPerimeter());
    }

}
