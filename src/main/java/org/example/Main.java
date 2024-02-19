package org.example;

import org.example.controller.Sudokulogic;

public class Main {
    public static void main(String[] args) {
        int[][] inputBord = {
                {9,6,2,1,0,7,5,0,8},
                {8,7,0,2,3,0,0,6,0},
                {0,0,0,0,0,5,0,9,0},
                {0,0,0,9,0,0,6,1,0},
                {6,1,4,0,2,0,8,0,9},
                {0,9,0,6,0,8,0,7,0},
                {7,0,0,0,0,0,3,2,1},
                {1,4,6,0,7,2,9,0,0},
                {0,0,0,5,8,0,7,0,0}
        };
        Sudokulogic sudokulogic = new Sudokulogic();

        System.out.println("Sudoku Board - ");
        sudokulogic.printResult(inputBord);

        if(sudokulogic.solveSudokuPuzzle(inputBord)){
            System.out.println("\nSolved successfully\n");
            sudokulogic.printResult(inputBord);
        }
        else{
            System.out.println("Unsolved Sudoku Board");
        }
    }

}