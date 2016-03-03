/*
UML
    DiceRoll
    -----------------
    - int sides
    -----------------
    + void setSides(int)
    + int getSides()
    + int roll()
 */
package rpgbattle;

public class DiceRoll {
    private int sides;
    
    private void setSides (int s) { sides = s; }
    int getSides() { return sides; }
    
    DiceRoll(int s) {
        setSides(s);
    }
    
    // returns an int from 1 to the number of sides, inclusively
    int roll() { return 1 + (int)(Math.random() * sides); }
}
