/*  Letter to Phone Number Converter
    Project Name: Group Project 1 JGuerra
    Author: Josh Guerra
    Created: 1.29.16
    Modified: 2.02.16

    Think about allowing numbers to be inputted as well. 
    numbers would obviously not need to be converted.
 */

/* 
    Test cases:
    gooddog => 4663364
    jguerra => 5483772
    JGUERRA => 5483772
    *** not case sensitive ***

    asf     => not enough letters
    qwe1234 => only letters allowed
*/

package groupproject1jguerra;

import java.util.Scanner;

public class GroupProject1JGuerra {

    public static void main(String[] args) {
        boolean isFinished = false;
        final int LENGTH = 7;       // valid length of phone number in US w/o area code
        int phoneNumber;
        String word;
        char again;
        
        // title block displays program info to user
        System.out.println(
                "Letter to Phone Number Converter\n" + 
                "Group Project 1\n" + "by JGuerra\n");
        
        // keep going until user is finished
        while(!isFinished) {
            // prompt and validate word for conversion
            System.out.print("Please enter " + LENGTH + 
                    " letters that you would like to convert to a phone number: ");
            word = getStringOfLettersWithLength(LENGTH);
            
            // convert and display number
            phoneNumber = convertStringToPhoneNumber(word);
            System.out.println("\nYour number is: " + phoneNumber);
            
            // keep going?
            System.out.print("\nWould you like to try different letters? ");
            again = getYorN();
            if (again == 'n')
                isFinished = true;
            
            // just for spacing output
            System.out.println();
        }
        
        // exit message
        System.out.println("Thanks for using our program.");
    }
    
    /**
     * Gets a string of only alphabetic letters of length n from System.in
     *
     * @param  n target length of string, not including whitespace
     * 
     * @return String
     */
    public static String getStringOfLettersWithLength(int n) {
        /*String userInput = getStringOfLength(n);
        boolean isValid = true;
        
        for (int i = 0; i < n && isValid; i++) {
            if (userInput.charAt(i) < 'a' || userInput.charAt(i) > 'z') {
                System.out.println("Please use only alphabetic letters: ");
                isValid = false;
            }
        }
        
        if (!isValid)
            // rescan for new imput and start validation over
            userInput = getStringOfLettersWithLength(n);
        */
        
        String userInput;
        boolean isValid;
        
        do {
            userInput = getStringOfLength(n);
            isValid = true;
        
            for (int i = 0; i < n && isValid; i++) {
                if (!Character.isAlphabetic(userInput.charAt(i))) {
                    System.out.println("Please use only alphabetic letters: ");
                    isValid = false;
                }
            }
        } while (!isValid);
        
        return userInput;
    }
        
    /**
     * Gets a string of length n from System.in
     *
     * @param  n target length of string, not including whitespace
     * 
     * @return String
     */
    public static String getStringOfLength(int n) {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        userInput = userInput.trim();
        
        while(userInput.length() != n) {
            System.out.println("Please enter exactly " + n + " letters: ");
            userInput = input.nextLine();
            userInput = userInput.trim();
        }
        
        return userInput;
    }
        
    /**
     * Converts a string of letters to a number based on the 
     * international phone keypad
     *
     * @param  word string to convert
     * 
     * @return integer result of conversion
     */
    public static int convertStringToPhoneNumber(String word) {
        
        int number = 0;
        
        for (int i = 0; i < word.length(); i++) {
            /*  originally appended digit after converting the character 
                and adding to result. Moving it here removes the need to 
                remove the extra digit at the end of the process. 
                Also, this step does not affect the first letter converted 
                because the number is initialed to 0. */
            number *= 10;   // appends a digit to the running total
            
            switch (word.charAt(i)) {
                case 'a':
                case 'b':
                case 'c':
                    number += 2; break;
                    
                case 'd':
                case 'e':
                case 'f':
                    number += 3; break;
                    
                case 'g':
                case 'h':
                case 'i':
                    number += 4; break;
                    
                case 'j':
                case 'k':
                case 'l':
                    number += 5; break;
                    
                case 'm':
                case 'n':
                case 'o':
                    number += 6; break;
                    
                case 'p':
                case 'q':
                case 'r':
                case 's':
                    number += 7; break;
                    
                case 't':
                case 'u':
                case 'v':
                    number += 8; break;
                    
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    number += 9; break;
                    
                default:
                    System.out.println("something broke :(");
            }
        }
        
        return number;
    }
    
    /**
     * Gets a char from System.in
     * 
     * @return char, either 'y' or 'n'
     */
    public static char getYorN() {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        userInput = userInput.trim();
        userInput = userInput.toLowerCase();
        
        while (true) {
            switch(userInput.charAt(0)) {
                case 'y':
                    return 'y';
                
                case 'n':
                    return 'n';
                
                default:
                    System.out.println("Please enter (y)es or (n)o: ");
                    userInput = input.nextLine();
                    userInput = userInput.trim();
                    userInput = userInput.toLowerCase();
            }
        }
    }
}