package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class compareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrixOne = readMatrix(scanner);
        int[][] matrixTwo = readMatrix(scanner);
        boolean areNotEqual = false;
        if(matrixOne.length==matrixTwo.length){
            for (int row = 0; row<matrixOne.length;row++ ){
                if(matrixOne[row].length==matrixTwo[row].length){
                    for (int col = 0; col < matrixOne[row].length; col++) {
                        if(matrixOne[row][col]!=matrixTwo[row][col]){
                            areNotEqual=true;
                            break;

                        }
                    }
                }else{
                    areNotEqual=true;
                }
                if(areNotEqual){
                    break;
                }


            }
        }else{
            areNotEqual=true;
        }

       String output = areNotEqual?"not equal":"equal" ;
        /*if(areNotEqual){
            System.out.println("not equal");

        }else{
            System.out.println("equal");
        }*/
        System.out.println(output);

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
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();
    }
}
