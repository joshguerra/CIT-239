/*
    Project 2: Simple RPG battle game
    RPGBattle
    by JGuerra
    Created: 03.03.16
    Modified: 03.03.16

Analysis
    
    Create a simple rpg battle game: Hydrons vs Zexors
    
    Game Entities:
    Hydrons: 
        have color, height, weight, health (starts at 25), 
        damage potential (0-10, scaled by health), attack type, 
        number of battles won, number of battles lost, name, and home planet.

    Zexors: 
        have color, height, weight, health (starts at 25), 
        damage potential (0-10, scaled by health), attack type, 
        number of battles won, number of battles lost, name, and species.

    DiceRoll: 
        number of sides

    Game starts with 3 Hydrons and 3 Zexors. 

    Each round one of each team are randomly slected for battle. Each 
    participant rolls a die and the higher roll wins. Loser takes damage. 
    damage = percent health * damage potential. Any creatures not participating 
    in battle gain 1 health, max 25 total. At the end of each round, print the
    status of all creatures. 

    NOTE: health is an int, thus damage is rounded down to nearest int

    Game ends when one creature reaches 0 health.

Design - part of design in UML.txt

    to make my life easier, all Hydron and Zexor setters will be private.
    all the attributes will have default values or randomized ones except
    color and name, which come from user input. 
    my constructor will call the setters.

    Hydron teamH[3]
    Zexor teamZ[3]
    DiceRoll dice

    ints for current fighters (represent indexes of team arrays)
    and for the rolls that they make

    going to need a while loop for game to keep going

    while (neither fighter has 0 health)
        pick new fighters
        roll dice
        re-roll ties
        damamge is dealt to loser
        non-combatants heal
        print everyone's status

    if the current fighter reaches 0, the while loop 
    terminates and the game is done. Potential to add a post game report. It 
    could list each creatures ending health and win ratio. Thats a future 
    feature though :P

Testing
    since this is a game with randomness, I will test it by playing the game
    many times. it's either that switch off randomness to test, but I would 
    rather just play until im confident.

 */
package rpgbattle;

import java.util.Scanner;

public class RPGBattle {

    public static void main(String[] args) {
        String line = "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ";
        final int TEAM_SIZE = 3;
        
        Scanner input = new Scanner(System.in);
        DiceRoll die;
        
        String color;
        String name;
        
        int numSides;
        int hydron = 0;
        int zexor = 0;
        int hRoll;
        int zRoll;
        
        // ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ //
        
        Hydron[] teamH = new Hydron[TEAM_SIZE];
        Zexor[] teamZ = new Zexor[TEAM_SIZE];
        
        for (int i = 0; i < TEAM_SIZE; i++) {
            System.out.print("Please provide a name for Hydron " + (i + 1) + ": ");
            name = input.nextLine();
            System.out.print("What color is Hydron " + (i + 1) + ": ");
            color = input.nextLine();
            teamH[i] = new Hydron(color, name);
            
            System.out.print("Please provide a name for Zexor " + (i + 1) + ": ");
            name = input.nextLine();
            System.out.print("What color is Zexor " + (i + 1) + ": ");
            color = input.nextLine();
            teamZ[i] = new Zexor(color, name);
        }
        
        System.out.println();
        System.out.print("How many sides are on the dice? ");
        die = new DiceRoll(input.nextInt());
        System.out.println("\n" + line + "\n");
        
        while (teamH[hydron].getHealth() > 0 && 
                teamZ[zexor].getHealth() > 0) {
            // select new fighters
            hydron = (int)(Math.random() * TEAM_SIZE);
            zexor = (int)(Math.random() * TEAM_SIZE);
            
            // print the fighters
            teamH[hydron].printHydron();
            System.out.println("\t\tVS\n");
            teamZ[zexor].printZexor();
            System.out.println(line + "\n");
            
            // roll dice
            hRoll = teamH[hydron].rollDie(die);
            zRoll = teamZ[zexor].rollDie(die);
            
            while (hRoll == zRoll) {
                System.out.println(teamH[hydron].getName() + " and " 
                        + teamZ[zexor].getName() + " both rolled " 
                        + hRoll + ". Lets re-roll.");
                
                // re-roll the tie
                hRoll = teamH[hydron].rollDie(die);
                zRoll = teamZ[zexor].rollDie(die);
            }
            
            System.out.println(teamH[hydron].getName() + " rolled a " + hRoll);
            System.out.println(teamZ[zexor].getName() + " rolled a " + zRoll);
            
            // damage is dealt
            if (hRoll > zRoll) {
                teamZ[zexor].lose(teamH[hydron].win());
                System.out.println("\n" + teamH[hydron].getName() + " deals " 
                        + teamH[hydron].win() + " damage to " 
                        + teamZ[zexor].getName());
            }
            else {
                teamH[hydron].lose(teamZ[zexor].win());
                System.out.println("\n" + teamZ[zexor].getName() + " deals " 
                        + teamZ[zexor].win() + " damage to " 
                        + teamH[hydron].getName());
            }
            
            System.out.println("\n" + line + "\n");
            
            // non-combatants heal
            for (int i = 0; i < TEAM_SIZE; i++) {
                if (i != hydron)
                    teamH[i].heal();
                if (i != zexor)
                    teamZ[i].heal();
            }
            
            // print status of teams
            for (int i = 0; i < TEAM_SIZE; i++) {
                teamH[i].printHydron();
                teamZ[i].printZexor();
            }
            
            System.out.println("\n" + line + "\n");
                
        }
        
    }
    
}
