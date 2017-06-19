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
public class Cat extends Animal {

   public Cat() {
       setAge(2);
   //    System.out.println("The age is " + getAge());
   }
   public void beCat() {
       super.sleep(); // Animal's sleep
       System.out.println();
       sleep("on keyboard"); // cat's sleep
       makeNoise();
   } 
   /** sleep(string) @param where does the cat sleep */
   public void sleep(String where) {
       super.sleep(); // Animal's sleep
       if (where == "on keyboard") // cat sleep with argument
        System.out.println(" " + where + " djkalfjldkajfdaoi");
       else 
           System.out.println(" " + where);
       sleep(); // Cat's sleep
    }
   /** makeNoise() make cat-type noises */
   public void makeNoise() {
       System.out.println("Meow meow");
   }
   public void sleep() {
       System.out.println("leave me alone. i'm sleeping.");
   }
}
