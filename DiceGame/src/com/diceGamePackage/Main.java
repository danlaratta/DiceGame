package com.diceGamePackage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game();

    }

    public static void Game(){
        Scanner scan = new Scanner(System.in);

        // stores number of points and lives
        int points = 0;
        int lives = 5;

        //game loop
        while (true){
            // plays the game if the player still has lives left and they did not already win
            if(lives > 0 && points != 3){
                // prompts user to enter guess
                System.out.print("Enter your guess or (quit) to stop playing: ");
                // takes users guess then converts it to lowercase (if they enter the word stop)
                String userGuess = scan.nextLine().toLowerCase();
                // selects a random number between 1-6 to represent dice and is casted as an integer
                int randDice = (int) (Math.random() * 6 + 1);
                // sets the result of random number to a string to compare with users guess
                String diceResult = Integer.toString(randDice);

                // enter quit to stop game
                if (userGuess.equals("quit")){
                    break;
                }
                // if guess is incorrect and user still has lives or hasn't won yet (lose a life)
                else if ( !userGuess.equals(diceResult) && (points != 3 || lives > 0)) {
                    lives--;
                    System.out.println("\nIncorrect guess, try again.");
                    System.out.println("Lives remaining: " + lives + " Total Points: " + points);
                    System.out.println("Your Guess: " + userGuess);
                    System.out.println("Dice rolled: " + diceResult);
                    System.out.print("\nEnter your guess: ");
                }
                // if guess is correct and user still has lives or hasn't won yet (gain a point)
                else if (userGuess.equals(diceResult) && (points != 3 || lives > 0)) {
                    points++;
                    System.out.println("\nCorrect! Guess again.");
                    System.out.println("Lives remaining: " + lives + " Total Points: " + points);
                    System.out.println("Your Guess: " + userGuess);
                    System.out.println("Dice rolled: " + diceResult);
                }
            }
            // if the user is out lives they lose
            else if (lives == 0){
                System.out.println("Sorry you lose :(");
                System.out.println("You had " + points + " points");
                break;
            }
            // if the user has 3 points they win
            else if (points == 3){
                System.out.println("Congrats you Win! :)");
                System.out.println("You had " + lives + " lives remaining");
                break;
            }

        } // end while loop
    }



}
