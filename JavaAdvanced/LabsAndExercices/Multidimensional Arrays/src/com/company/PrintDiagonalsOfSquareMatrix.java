package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
    int[][]  matrix = readMatrix(scanner,n);
      int startIndexRows = 0;
      int startIndexCols=0;
      while (startIndexRows< n&&startIndexCols<n){
          System.out.print(matrix[startIndexRows++][startIndexCols++]+" ");
      }
        System.out.println();
      startIndexCols=0;
      startIndexRows= n-1;
      while (startIndexCols<n&&startIndexRows>=0){
          System.out.print(matrix[startIndexRows--][startIndexCols++]+" ");
      }

    }
    private static int[][] readMatrix(Scanner scanner,int n){

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = readArray(scanner);
        }
        return matrix;

    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();
    }
}
