/*
* Class: CMSC203 CRN 20984
* Instructor: Ahmed Tarek
* Description: This program greets the user, generates a random color, and prompts the user
* to guess that random number
* Due: MM/DD/YYYY
 * Platform/compiler: Linux Mint IntelliJ Idea Community Edition
 * I pledge that I have completed the programming assignment
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
*Print your Name here: Ricardo Hernandez
*/
package org.example;

import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Final Variables
        //These variables are used to hold the information prompted from the user at the beginning of the program
        final String USER_NAME;
        final String USER_DETAILS;
        final String DUE_DATE;
        //These variables are used to hold  the information needed for random number generation
        final int RAND_MIN = 1;
        final int RAND_MAX = 7;
        final int RAND_RANGE = RAND_MAX - RAND_MIN;
        //These variables are used to represent possible random colors
        final String COLOR_RED = "red";
        final String COLOR_ORANGE = "orange";
        final String COLOR_YELLOW = "yellow";
        final String COLOR_GREEN = "green";
        final String COLOR_BLUE = "blue";
        final String COLOR_INDIGO = "indigo";
        final String COLOR_VIOLET = "violet";
        //Prompt for userName
        System.out.print("Enter your name: ");
        USER_NAME = scan.nextLine();
        //Prompt for userDetails
        System.out.print("Describe yourself: ");
        USER_DETAILS = scan.nextLine();
        //Prompt for dueDate
        System.out.print("Due Date: ");
        DUE_DATE = scan.nextLine();
        //Display Application Header
        System.out.println("CMSC203 Assignment 1: Test your ESP Skills!\n");
        int rand;
        String color;
        String userGuess;
        int correctGuesses = 0;
        int roundNumber = 0;
        //Complete Next Steps 11 times
        //HELP, the Assignment description says to repeat this 11 times but i should only have ten total colors? i dont understand
        for (int i = 0; i < 10; i++) {
            //Generate Random Int
            rand = (int)(Math.random()*RAND_RANGE) + RAND_MIN;
            //Pick Color Based on Random Int
            switch(rand){
                case 1:
                    color = COLOR_RED;
                    break;
                case 2:
                    color = COLOR_ORANGE;
                    break;
                case 3:
                    color = COLOR_YELLOW;
                    break;
                case 4:
                    color = COLOR_GREEN;
                    break;
                case 5:
                    color = COLOR_BLUE;
                    break;
                case 6:
                    color = COLOR_INDIGO;
                    break;
                default:
                    color = COLOR_VIOLET;
            }
            //Display round number
            System.out.printf("Round: %d\n", roundNumber + 1);
            //Prompt for userGuess
            System.out.println("I am thinking of a color.\nIs it Red, Orange, Yellow, Green, Blue, Indigo, or Violet?");
            System.out.print("Enter your guess: ");
            userGuess = scan.next();
            //IF guess is correct display answer move to next round
            if (userGuess.equalsIgnoreCase(color)){
                System.out.printf("I was thinking of %s.\n\n", color);
                roundNumber++;
                correctGuesses++;
            }
            //IF guess is incorrect give user another chance to guess
            else{
                System.out.println("Incorrect. Try again.\n");
                System.out.println("I am thinking of a color.\nIs it Red, Orange, Yellow, Green, Blue, Indigo, or Violet?");
                System.out.print("Enter your guess: ");
                userGuess = scan.next();
                System.out.printf("I was thinking of %s.\n\n" , color);
                roundNumber++;
                if(userGuess.equalsIgnoreCase(color)){
                    correctGuesses++;
                }
            }
            //Display correctGuess
        }
        System.out.println("Game Over");
        System.out.printf("You guessed %d out of 10 colors correctly.\n", correctGuesses);
        //Display userName
        System.out.println("User Name: " + USER_NAME);
        //display userDetails
        System.out.println("User Details: " + USER_DETAILS);
        //display dueDate
        System.out.println("Due Date: " + DUE_DATE);
        //Dont forget to system exit
        System.exit(0);
    }
}