/*
 testDisctinctNumbers
 by Josh Guerra
 created 03.11.16
 modified  03.11.16

 11.4 (Maximum element in ArrayList) 
 Write the following method that returns the maximum value in an ArrayList 
 of integers. The method returns null if the list is null or the list 
 size is 0. 


    
 public static Integer max(ArrayList<Integer> list) 

 Write a test program that prompts the user to enter a sequence of numbers ending 
 with 0, and invokes this method to return the largest number in the input. 


 */
package testdistinctnumbers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Collections;

public class TestDistinctNumbers {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter integers (input ends with 0): ");
        int value;

        do {
            value = input.nextInt(); // Read a value from the input

            if (!list.contains(value) && value != 0) {
                list.add(value); // Add the value if it is not in the list
            }
        } while (value != 0);

        printList(list);
        System.out.println();
        Collections.sort(list);
        printList(list);
        System.out.println("\n" + max(list));
        shuffleList(list);
        printList(list);
    }
    
    public static void printList(ArrayList<Integer> list) {
        for (Integer list1 : list) 
            System.out.print(list1 + " ");
    }

    public static Integer max(ArrayList<Integer> list) {
        if (list.isEmpty()) 
            return null;
        else {
            Collections.sort(list);
            return list.get(list.size() - 1);
        }
    }
    
    public static void shuffleList(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            // Generate an index j randomly with 0 <= j <= i
            int j = (int)(Math.random()
            * (i + 1));

            // Swap list.get(i) with list.get(j)
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

}
