package org.example.controller;


public class Sudokulogic {
    private final int gridSize =9;

    public boolean solveSudokuPuzzle(int[][] inputBoard) {
        return solveSudoku(inputBoard);
    }
    public void printResult(int[][] board) {
        for(int i =0; i<gridSize; i++){
            if(i%3 == 0 && i!=0){
                System.out.println("____________");
            }
            for(int j =0; j<gridSize; j++){
                if(j%3 ==0 && j != 0){
                    System.out.print("|");
                }
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private boolean isNumberInRow(int[][] inputBoard, int number, int rowNumber){
        for(int i =0; i< gridSize;i++){
            if(inputBoard[rowNumber][i] == number){
                return true;
            }
        }
        return false;
    }
    private boolean isNumberInColumn(int[][] inputBoard, int number, int columnNumber){
        for(int i =0; i< gridSize;i++){
            if(inputBoard[i][columnNumber] == number){
                return true;
            }
        }
        return false;
    }
    private boolean isNumberInTheBox(int[][] inputBoard, int number,int rowNumber, int columnNumber){
        int individualBoxRow = rowNumber - rowNumber%3;
        int individualBoxColumn = columnNumber - columnNumber%3;

        for(int i = individualBoxRow; i < individualBoxRow+3; i++){
            for(int j = individualBoxColumn; j < individualBoxColumn+3; j++){
                if(inputBoard[i][j] == number){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isValidPlacement(int[][] inputBord, int number, int rowNumber, int columnNumber){
        return !isNumberInRow(inputBord,number,rowNumber) &&
                !isNumberInColumn(inputBord,number,columnNumber) &&
                !isNumberInTheBox(inputBord,number,rowNumber,columnNumber);
    }
    private boolean solveSudoku(int[][] inputBord){
        for(int i = 0; i < gridSize; i++){
            for(int j = 0; j < gridSize; j++){
                if(inputBord[i][j] == 0){
                    for(int numberToTry =1; numberToTry<= gridSize; numberToTry++){
                        if(isValidPlacement(inputBord,numberToTry,i,j)){
                            inputBord[i][j] = numberToTry;

                            //use recursion method
                            if(solveSudoku(inputBord)){
                                return true;
                            }
                            else{
                                inputBord[i][j] =0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
