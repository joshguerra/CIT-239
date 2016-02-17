package sandbox;

/**
 * @author Josh Guerra
 */
public class Sandbox {
    
    public static void main(String[] args) {
        final int NUM_DOGS = 3;
        Dog doggies[] = new Dog[NUM_DOGS];
        
        Dog chucho = new Dog();
        chucho.setName("Chucho");
        chucho.setBreed("Bichon Frise");
        chucho.setColorHair("White");
        chucho.setAge(3.75);
        
        doggies[0] = chucho;
        doggies[1] = new Dog();
        doggies[2] = new Dog();

        doggies[1].setName("Duga");
        doggies[1].setBreed("Beagle");
        doggies[1].setColorHair("White and Black with Brown spots");
        doggies[1].setAge(7.5);

        doggies[2].setName("Roscoe");
        doggies[2].setBreed("Golden Retriever");
        doggies[2].setColorHair("Golden");
        doggies[2].setAge(0.33);
        
        for (int i = 0; i < NUM_DOGS; i++) {
            doggies[i].printInfo();
            doggies[i].speak();
            System.out.println();
            
        }
        
    }
    
}
