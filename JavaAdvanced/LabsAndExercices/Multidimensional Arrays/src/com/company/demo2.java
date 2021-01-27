package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndCols = readArray(scanner);
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        int[][] matrix = readMatrix(scanner, rows, cols);
        int row =rows;
        int col;
        while(row>=0){
            col = cols-1;
            int rowTemp = row;
            while(rowTemp< matrix.length){
                System.out.print(matrix[rowTemp][col] + " ");
                rowTemp++;
                col--;
            }
            System.out.println();
            row--;
        }
        col= matrix.length-1;
        while(col>=0){
            int colTemp = col;
            row = 0;
            while(colTemp>=0){
                System.out.print(matrix[row][colTemp] + " ");
                row++;
                colTemp--;
            }
            System.out.println();
            col--;
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

    private static int[][] readMatrix(Scanner scanner, int rows, int cols){

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner);
        }
        return matrix;

    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
    }
}
