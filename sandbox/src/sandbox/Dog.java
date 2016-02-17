/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

/**
 *
 * @author Josh
 */
public class Dog {
    private String name;
    private String colorHair;
    private String breed;
    private double age;    // in years
    
    void setName(String s) { name = s; }
    void setColorHair(String s) { colorHair = s; }
    void setBreed(String s) { breed = s; }
    
    void setAge(double a) {
        if (a >= 0)
            age = a;
        else
            age = 0;
    }
    
    String getName() { return name; }
    String getColorHair() { return colorHair; }
    String getBreed() { return breed; }
    double getAge() { return age; }
    
    void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Color: " + colorHair);
        System.out.println("Breed: " + breed);
        System.out.println("Age: " + age + " years old");
    }
    
    void eat() { System.out.println("Nom nom nom"); }
    void sleep() { System.out.println("zzZZZzz..."); }
    void poop() { System.out.println("-__-\""); }
    void speak() { System.out.println("Woof!"); }
}
