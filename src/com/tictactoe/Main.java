package com.tictactoe;

import java.util.Scanner;

public class  Main {
    private static Scanner in = new Scanner (System.in);

    public static void main(String[] args) {
        boolean keepPlaying = true;
        System.out.println("Welcome to TicTacToe");

        while (keepPlaying){
            GameController ticTacToe = new GameController();
            while (!ticTacToe.hasWon() && !ticTacToe.isBoardFull()) {
                ticTacToe.printBoard();
                System.out.println("It's " + ticTacToe.getCurrentPlayer() + "'s turn, choose your move(1-3 for rows)(1-3 for columns)");
                int row = in.nextInt() - 1;
                int column = in.nextInt() - 1;

                if (!ticTacToe.placeMark(row, column)) {
                    System.out.println("Invalid input");
                    continue;
                }

                if (ticTacToe.hasWon()) {
                    ticTacToe.printBoard();
                    System.out.println(ticTacToe.getCurrentPlayer() + " has won the game!");
                } else if (ticTacToe.isBoardFull()) {
                    ticTacToe.printBoard();
                    System.out.println("The game is tie!");
                }

                // nothing happened, change player
                ticTacToe.changePlayer();
            }
            in.nextLine();
            System.out.println("Want to play again ? (yes or no)");
            String choice = in.nextLine();
            keepPlaying = choice.equalsIgnoreCase("yes");

        }
    }
}
