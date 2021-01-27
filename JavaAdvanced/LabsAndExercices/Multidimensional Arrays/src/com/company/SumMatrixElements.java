package com.company;

import java.util.Arrays;
import java.util.Scanner;


public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
      int sum= Arrays.stream(matrix).mapToInt(arr-> Arrays.stream(arr).sum()).sum();
        System.out.println(sum);

    }
    private static int[][] readMatrix(Scanner scanner){
        int[] rowsAndCols = readArray(scanner);
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner);
        }
        return matrix;

    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt)
                .toArray();
    }

}
