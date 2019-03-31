package com.tictactoe;

public class GameController {

    private char[][] cells;
    private char currentPlayer;

    //setting the board
    public GameController(){
        cells = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    public char getCurrentPlayer(){
        return currentPlayer;
    }

    public void printBoard(){
        System.out.println("-------------------------");

        for (int i =0; i <3; i++){
            System.out.print("| ");
            for (int j =0; j <3; j++){
                System.out.print(cells[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }

    public boolean isBoardFull(){

        for (int i =0; i <3; i++){
            for (int j =0; j<3; j++){
                if (cells[i][j] == '-')
                    return false; // found one empty cell, board isn't full
            }
        }

        return true;
    }

    public boolean hasWon(){
        for (int i =0; i <3; i++) {
            // checks rows for win
            if (cells[i][0] != '-' && cells[i][0] == cells[i][1] && cells[i][0] == cells[i][2]) {
                return true;
            }
            // checks columns for win
            if (cells[0][i] != '-' && cells[0][i] == cells[1][i] && cells[0][i] == cells[2][i]){
                return true;
            }
        }
        //checks diagonals win
        if (cells[2][0] != '-' && cells[2][0] == cells[1][1] && cells[2][0] == cells[2][2]){
            return true;
        }
        if (cells[0][0] != '-' && cells[0][0] == cells[1][1] && cells[0][0] == cells[2][2]){
            return true;
        }

        return false;
    }

    public void changePlayer(){
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean placeMark(int row, int col){
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            if (cells[row][col] == '-') {
                cells[row][col] = currentPlayer;
                return true;
            }
        }
        return false;
    }

    public void initializeBoard(){
        for (int i =0; i <3; i++) {
            for (int j =0; j <3; j++){
                cells[i][j] = '-';
            }
        }
    }
}
