package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] word_bank = {"apple", "book", "car", "dog", "elephant", "friend", "goose", "hello", "igloo",
                "kite", "larva", "monster", "newt", "octopus"};

        ArrayList<String> guessed_word = new ArrayList<>();

        Random r = new Random();
        char letter;
        int int_rand, counter;
        boolean play = true;

        while (play) {
            ArrayList<Character> wrong_guess = new ArrayList<>();
            int_rand = r.nextInt(14);
            counter = 0;

            for (int i = 0; i < word_bank[int_rand].length(); i++)
                guessed_word.add("_");
            //change this to add the number of char of the word and not just random chars

            while (counter < 6) {
                System.out.println(guessed_word + "  Wrong Letters: " + wrong_guess);

                System.out.println("Guess a letter: ");
                letter = sc.next().charAt(0);

                if (guessed_word.contains(String.valueOf(letter)) || wrong_guess.contains(letter)) {
                    System.out.println("Letter already entered!");
                }
                else if (word_bank[int_rand].indexOf(letter) >= 0) {
                    for (int j = 0; j < word_bank[int_rand].length(); j++) {
                        if (word_bank[int_rand].charAt(j) == letter)
                            guessed_word.set(j, String.valueOf(letter));
                    }
                }
                else {
                    counter++;
                    wrong_guess.add(letter);
                }

                System.out.println();

                if (!guessed_word.contains("_")) {
                    counter = 6;
                    System.out.println("Congrats! You guessed the word correctly! The word was: " + word_bank[int_rand]);
                    System.out.println();
                }
                else if (counter == 6){
                    System.out.println("Sorry, you guessed incorrectly. The word was: " + word_bank[int_rand]);
                    System.out.println();
                }

            }
            System.out.println("Do you want to play again? y/n");
            letter = sc.next().charAt(0);
            System.out.println();

            if (letter == 'y') {
                guessed_word.clear();
            }
            else play = false;
        }
    }
}
