package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        ArrayList<Integer> all_moves = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';

        Random r = new Random();
        int comp_move;
        int[] board_position = new int[2];

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!\nDo you want to be X or O?\n");

        boolean win, play = true;
        char computer, player = sc.next().toUpperCase().charAt(0);
        if (player == 'X') {
            computer = 'O';
            System.out.println("\nThe computer will go first.");
        }
        else {
            computer = 'X';
            System.out.println("\nYou will go first.");
        }
        //decide whether player or computer goes first.
        while (play) {
            if (player == 'X') {
                comp_move = all_moves.get(r.nextInt(all_moves.size()));
                boardPosition(comp_move, board_position);
                all_moves.remove((Integer) comp_move);
                board[board_position[0]][board_position[1]] = 'O';

                System.out.print("What is your next move? (1-9)");
            }
            play = false;
            printBoard(board);
        }
    }

    public static void printBoard (char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 2)
                    System.out.print(board[i][j]);
                else
                    System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            if (i < 2)
                System.out.println("---------");
        }
    }

    public static void boardPosition (int choice, int[] board_position) {
        if (choice < 3)
            board_position[1] = 0;
        else if (choice < 6)
            board_position[1] = 1;
        else
            board_position[1] = 2;

        board_position[0] = choice % 3;
    }

    public static void checkValidMove () {

    }

    public static boolean checkWinner () {
        return true;
    }
}
