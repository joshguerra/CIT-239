package rpgbattle;

public class Hydron {
    private String color;
    private String name;
    private String homePlanet;
    private double height;          // in meters
    private double weight;          // in kg
    private int health;             // max 25
    private int damagePotential;    // (0 - 10)
    private int numVictories;
    private int numLosses;
    
    private void setColor(String clr) { color = clr; }
    private void setName(String n) { name = n; }
    private void setHomePlanet(String planet) { homePlanet = planet; }
    private void setHeight(double h) { height = h; }
    private void setWeight(double w) { weight = w; }
    private void setHealth(int h) { health = h; }
    private void setDamagePotential(int d) { damagePotential = d; }
    private void setNumVictories(int n) { numVictories = n; }
    private void setNumLosses(int n) { numLosses = n; }
    
    String getColor(){ return color; }
    String getName(){ return name; }
    String getHomePlanet(){ return homePlanet; }
    double getHeight(){ return height; }
    double getWeight(){ return weight; }
    int getHealth(){ return health; }
    int getDamagePotential(){ return damagePotential; }
    int getNumVictories(){ return numVictories; }
    int getNumLosses(){ return numLosses; }
    
    Hydron(String newColor, String newName) {
        // set by constructor        
        setColor(newColor);
        setName(newName);
        
        // default settings
        setHomePlanet("Primus");
        setHealth(25);
        setNumVictories(0);
        setNumLosses(0);
                
        // randomized settings
        setHeight(150 + (int)(Math.random() * 50));   // between 150 and 200 cm
        setWeight(72 + (int)(Math.random() * 36));    // between 72 and 108 kg
        setDamagePotential((int)(Math.random() * 11));    // 0 - 10
    }
    
    // ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ // 
    
    int rollDie(DiceRoll die) { return die.roll(); }
    
    void lose(int damage) { 
        if (damage > health)
            health = 0;
        else
            health -= damage;
        
        numLosses++;
    }
    
    // returns amount of damage done to opponent
    int win() {
        numVictories++;
        return (int)((health / 25.0) * damagePotential);
    }
    
    void heal() {
        if (health < 25)
            health++;
    }
    
    void printHydron() {
        System.out.println(name + " the " + color + " Hydron");
        System.out.println("Height: " + height + "\tWeight: " + weight);
        System.out.println("Health: " + health + "\tDamage Potential: " 
                + damagePotential);
        System.out.println();
    }

}