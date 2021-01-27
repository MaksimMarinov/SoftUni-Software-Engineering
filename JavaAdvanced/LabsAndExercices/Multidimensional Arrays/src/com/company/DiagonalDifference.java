package com.company;

import java.util.Arrays;
import java.util.Scanner;


public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(scanner, n);
        int difference = Math.abs(sumFirstDiagonal(matrix)-sumSecondDiagonal(matrix));
        System.out.println(difference);

    }public static int sumFirstDiagonal(int[][] matrix){
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
    public static int sumSecondDiagonal(int[][] matrix){
        int sum = 0;
        int col = matrix.length-1;
        for (int row = 0; row< matrix.length; row++) {

            sum += matrix[row][col--];
        }
        return sum;
    }

    public static int[][] readMatrix(Scanner scanner, int n){
        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            matrix[row]=readArray(scanner);
        }
        return matrix;
    }
    public static int[] readArray(Scanner scanner){
       return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();
    }
}
