package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random r = new Random();
        boolean play = true;
        int guess = -1, count = 0;
        int rand_int = r.nextInt(20) + 1;

        System.out.println("Hello! What is your name?");
        String name = scan.nextLine();
        String playAgain = "";

        System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.");

        while (play) {
            System.out.println("Take a guess.");
            guess = scan.nextInt();
            count++;

            if (guess > rand_int)
                System.out.println("Your guess is too high.");
            else if (guess < rand_int)
                System.out.println("Your guess is too low.");
            else {
                System.out.println("Good job, " + name + "! You guessed my number in " + count +" guesses!");
                System.out.println("Would you like to play again? (y or n)");
                playAgain = scan.next();

                if (playAgain.equals("y")){
                    count = 0;
                    rand_int = r.nextInt(20) + 1;
                }
                else
                    play = false;
            }
        }
    }
}
