package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';

        //Scanner sc = new Scanner(System.in);



        printBoard(board);
    }

    public static void printBoard (char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 2)
                    System.out.print(board[i][j]);
                else
                    System.out.print(board[i][j] + " | ");
            }
            if (i == 2)
                System.out.println();
            else {
                System.out.println();
                System.out.println("---------");
            }
        }
    }
}
