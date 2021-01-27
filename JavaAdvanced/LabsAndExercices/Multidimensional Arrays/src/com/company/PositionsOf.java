package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions=readArray(scanner);
        int rowsCount = dimensions[0];
        int colsCount = dimensions[1];

        int[][] matrix = readMatrix(scanner, rowsCount, colsCount);
        int searchedNumber = Integer.parseInt(scanner.nextLine());
        boolean isFound=false;
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                if(matrix[rows][cols]==searchedNumber){
                    isFound=true;
                    System.out.println(rows+" "+cols);
                }
            }
        }
        if(!isFound){
            System.out.println("not found");
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
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();
    }
}

