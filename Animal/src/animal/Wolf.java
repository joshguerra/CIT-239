
package animal;

public class Wolf extends Animal {
   
   public void beWolf() { 
       makeNoise();
       eat();
   } 
   
   public void makeNoise() {
       System.out.println("aaahhwooooooo");
   }
    
   public void eat() {
       System.out.println("this wolf eats rabbits.");
   }
}
