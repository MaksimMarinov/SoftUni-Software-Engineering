package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrixInfo = readArray(scanner);
        int rows = matrixInfo[0];
        int cols = matrixInfo[1];
        int[][] matrix = readMatrix(scanner, rows, cols);
       int startingIndexForRows = 0;
       int startingIndexForCols = 0;
       int sum = 0;
       int maxSum = Integer.MIN_VALUE;
       int bestRowStartingIndex =0;
       int bestColStartingIndex =0;
       while (startingIndexForRows+3<=rows){
            while (startingIndexForCols+3<=cols){
                sum = sumInnerMatrix(matrix, startingIndexForCols, startingIndexForRows);
                if(sum>maxSum){
                    maxSum=sum;
                    bestRowStartingIndex=startingIndexForRows;
                    bestColStartingIndex=startingIndexForCols;
                }
                startingIndexForCols++;
            }

           startingIndexForCols=0;
            startingIndexForRows++;
      }
        System.out.println("Sum = "+maxSum);
       printMatrix(matrix, bestColStartingIndex, bestRowStartingIndex);



    }
    private static void printMatrix(int[][] matrix, int colIndex, int rowIndex) {
        for (int row = rowIndex; row <rowIndex+3; row++) {
            for (int col = colIndex; col <colIndex+3; col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
    }

    private static int sumInnerMatrix(int[][] matrix, int startingIndexForCols, int startingIndexForRows) {
        int sum =0;
        for (int row = startingIndexForRows; row <startingIndexForRows+3 ; row++) {
            for (int cols = startingIndexForCols; cols < startingIndexForCols+3; cols++) {
                sum+=matrix[row][cols];
            }
        }
        return sum;
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

