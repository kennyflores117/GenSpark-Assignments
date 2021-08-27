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
        int[] board_position = new int[2];

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!\nDo you want to be X or O?\n");

        boolean play = true, valid_move = false;

        char computer, player = sc.next().toUpperCase().charAt(0);
        if (player == 'X') {
            System.out.println("\nThe computer will go first.");
            computer = 'O';
        }
        else {
            System.out.println("\nYou will go first.");
            computer = 'X';
        }
        //decide whether player or computer goes first.
        while (play) {
            if (player == 'X') {
                computerMoves(all_moves, r, board_position, board, computer);
                play = beforeNextMove(board, all_moves, player);

                if (play) {
                    playerMoves(all_moves, board_position, board, valid_move, sc, player);
                    play = beforeNextMove(board, all_moves, player);

                    if (play)
                    System.out.println("\nComputer's Next Move");
                }
            }
            else {
                playerMoves(all_moves, board_position, board, valid_move, sc, player);
                play = beforeNextMove(board, all_moves, player);

                if (play) {
                    System.out.println("\nComputer's Next Move");
                    computerMoves(all_moves, r, board_position, board, computer);
                    play = beforeNextMove(board, all_moves, player);
                }
            }


            /*
            if (play == false) {
                System.out.println("\nWould you like to play again? (Y/N) ");
                if (sc.next().toUpperCase().charAt(0) == 'Y') {
                    play = true;

                }
                else {

                }
            }

             */
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

    public static void computerMoves(ArrayList<Integer> all_moves, Random r,
                                     int[] board_position, char[][] board, char computer) {

        int comp_move = all_moves.get(r.nextInt(all_moves.size()));
        boardPosition(comp_move, board_position);
        all_moves.remove((Integer) comp_move);
        board[board_position[1]][board_position[0]] = computer;
        printBoard(board);
    }

    public static void playerMoves(ArrayList<Integer> all_moves, int[] board_position,
                                   char[][] board, boolean valid_move, Scanner sc, char player) {
        while (!valid_move) {
            System.out.println("\nWhat is your next move? (1-9)");
            int player_move = sc.nextInt() - 1;

            if(all_moves.contains(player_move)) {
                valid_move = true;
                boardPosition(player_move, board_position);
                all_moves.remove((Integer) player_move);
                board[board_position[1]][board_position[0]] = player;
                printBoard(board);
            }
            else {
                System.out.println("Invalid Move! Try again!");
            }
        }
    }

    public static boolean beforeNextMove (char[][] board, ArrayList<Integer> all_moves, char player) {
        if (checkWinner(board) == player && checkWinner(board) != ' ') {
            System.out.println("\nCongratulations! You won!");
            return false;
        }
        else if (checkWinner(board) != player && checkWinner(board) != ' ') {
            System.out.println("\nThe computer has won!");
            return false;
        }
        else if (all_moves.size() < 1) {
            System.out.println("\nIt's a tie!");
            return false;
        }
        else return true;
    }

    public static char checkWinner (char[][] board) {
        //rows
        for(int i = 0; i < 3; i++) {
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-')
                return board[i][0];
        }

        //columns
        for(int j = 0; j < 3; j++) {
            if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-')
                return board[0][j];
        }

        //diagonals
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-')
            return board[0][0];

        if(board[2][0] == board[1][1] && board[1][1] ==  board[0][2] && board[2][0] != '-')
            return board[2][0];

        //no winner
        return ' ';
    }
}
