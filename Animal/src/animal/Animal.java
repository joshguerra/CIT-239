 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

/**
 *
 * @author Instructor
 */
public class Animal {

    /**
     * @param args the command line arguments
     */
 private double weight;
 private int age;
 
 public double getWeight(){ return weight;}
 public int getAge() {return age;}
 public void setWeight(double w) {
     if (w <= 0) w = 1;
     weight = w;
 }
 public void setAge(int age) {
     if (age <= 0) age = 1;
     this.age = age;
 }
 public void eat() {
     if (weight < 10) System.out.println("this animal eats a little");
     else System.out.println("this animal eats a lot");
 }
 public void sleep() {
     System.out.print("This animal is sleeping");
 }
 public void poop() {
     if (weight < 10) System.out.println("this animal poops a little");
     else System.out.println("this animal poops a lot");
 }
 public void makeNoise() {
     if (weight < 10 && age < 2) System.out.println("This animal squeeks");
     else if (weight < 10) System.out.println("This animal makes some noise");
     else System.out.println("This animal makes a ton of noise");
 }
 Animal(double weight , int age) {
     setWeight(weight);
     setAge(age);
 } 
 Animal() {
     this(1, 1);
 }
}
