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
        int comp_move = 0, player_move = 0;
        int[] board_position = new int[2];

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!\nDo you want to be X or O?\n");

        boolean win, play = true, valid_move = false;

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
                computerMoves(comp_move, all_moves, r, board_position, board);
                playerMoves(all_moves, r, board_position, board, valid_move, player_move, sc);
            }
            else {
                playerMoves(all_moves, r, board_position, board, valid_move, player_move, sc);
                computerMoves(comp_move, all_moves, r, board_position, board);
            }
            play = false;
            //printBoard(board);
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

    public static void computerMoves (int comp_move, ArrayList<Integer> all_moves, Random r,
                                  int[] board_position, char[][] board) {

        comp_move = all_moves.get(r.nextInt(all_moves.size()));
        boardPosition(comp_move, board_position);
        all_moves.remove((Integer) comp_move);
        board[board_position[1]][board_position[0]] = 'O';
        printBoard(board);
    }

    public static void playerMoves (ArrayList<Integer> all_moves, Random r, int[] board_position,
                                    char[][] board, boolean valid_move, int player_move, Scanner sc) {
        while (!valid_move) {
            System.out.println("What is your next move? (1-9)");
            player_move = sc.nextInt() - 1;

            if(all_moves.contains(player_move)) {
                valid_move = true;
                boardPosition(player_move, board_position);
                all_moves.remove((Integer) player_move);
                board[board_position[1]][board_position[0]] = 'X';
                printBoard(board);
            }
            else {
                System.out.print("Invalid Move! Try again!");
            }
        }
    }

    public static void checkValidMove () {

    }

    public static boolean checkWinner () {
        return true;
    }
}
