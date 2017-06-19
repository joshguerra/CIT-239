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
public class Dog extends Animal {
   
   public void beDog() {
       play(); // Animal's sleep
       System.out.println();
       sleep("on bed"); // dog's sleep
       makeNoise();
   } 
   
   /** sleep(string) @param where does the dog sleep */
   public void sleep(String where) {
       super.sleep(); // Animal's sleep
       System.out.println(" " + where);
   }
   
   /** makeNoise() make dog-type noises */
   public void makeNoise() {
       System.out.println("Ruff Ruff");
   }
   
   /** play() */
   public void play() {
       System.out.println("this dog is jumping around. so cute");
   }
   
   public void eat() {
       System.out.println("this dog eats kibble.");
   }
}
