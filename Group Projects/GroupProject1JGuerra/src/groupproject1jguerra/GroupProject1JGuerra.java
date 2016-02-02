/*  Letter to Phone Number Converter
    Project Name: Group Project 1 JGuerra
    Author: Josh Guerra
    Created: 1.29.16
    Modified: 2.02.16
 */

package groupproject1jguerra;

import java.util.Scanner;

public class GroupProject1JGuerra {

    public static void main(String[] args) {
        final int LENGTH = 7;
        int phoneNumber;
        String word;
        
        System.out.println(
                "Letter to Phone Number Converter\n" + 
                "Group Project 1\n" + "by JGuerra\n");
        
        System.out.print("Please enter " + LENGTH + " letters that you would like to convert to a phone number: ");
        word = getStringOfLettersWithLength(LENGTH);
        
        System.out.println(word);
        
    }
    
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
    
    public static String getStringOfLength(int n) {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        userInput = userInput.trim();
        
        while(userInput.length() != n) {
            System.out.println("Please enter exactly " + n + " letters: ");
            userInput = input.nextLine();
            userInput = userInput.trim();
        }
        
        return userInput.toLowerCase();
    }
    
}
