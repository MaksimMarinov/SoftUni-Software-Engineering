package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(", ");
        int rowsAndCols = Integer.parseInt(tokens[0]);
        int[][] matrix = new int[rowsAndCols][rowsAndCols];
        switch (tokens[1]){
            case"A":
                fillMethodA(rowsAndCols, matrix);
                break;
            case"B":
                fillMethodB(rowsAndCols, matrix);
                break;
        }
        printMatrix(matrix);

    }

    private static void fillMethodB(int rowsAndCols, int[][] matrix) {
        int index=1;
        for (int col = 0; col < rowsAndCols; col++) {
            if(col%2==0){

                for (int row = 0; row < rowsAndCols; row++) {
                    matrix[row][col]=index++;
                }
            }else{
                for (int row = rowsAndCols-1;row>=0 ; row--) {
                    matrix[row][col]=index++;
                }
            }
        }
    }

    private static void fillMethodA(int rowsAndCols, int[][] matrix) {
        int index=1;
        for (int col = 0; col < rowsAndCols; col++) {
            for (int row = 0; row < rowsAndCols; row++) {
                matrix[row][col]=index++;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

}
