package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfRows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(scanner, numberOfRows);
        int[] dimension = readArray(scanner);
        int wrongNumber = matrix[dimension[0]][dimension[1]];
        List<int[]> positionsOfWrongNumber = new ArrayList<>();
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col]==wrongNumber){
                    int[] arrayOFCoo = new int []{row,col};
                    positionsOfWrongNumber.add(arrayOFCoo);
                }
            }
        }
        int[] replacements = new int[positionsOfWrongNumber.size()];
        for (int i = 0; i < positionsOfWrongNumber.size(); i++) {
            int row = positionsOfWrongNumber.get(i)[0];
            int col = positionsOfWrongNumber.get(i)[1];
           replacements[i]= findReplacement(row, col, matrix, wrongNumber);

        }
        /*for (int row = 0; row < numberOfRows; row++) {
            for (int cols = 0; cols < matrix[row].length; cols++) {

            }
        }*/
        for (int i = 0; i < positionsOfWrongNumber.size(); i++) {
            int row = positionsOfWrongNumber.get(i)[0];
            int col = positionsOfWrongNumber.get(i)[1];
            matrix[row][col]=replacements[i];
        }
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }



    }

    private static int findReplacement(int row, int col, int[][] matrix, int wrongNumber) {
        int sum=0;
        if(row-1>=0&&matrix[row-1][col]!=wrongNumber){
            sum+=matrix[row-1][col];
        }if(row+1<matrix.length&&matrix[row+1][col]!=wrongNumber){
            sum+=matrix[row+1][col];
        } if(col-1>=0&&matrix[row][col-1]!=wrongNumber){
            sum+=matrix[row][col-1];
        }if(col+1<matrix[row].length&&matrix[row][col+1]!=wrongNumber){
            sum+=matrix[row][col+1];
        }
        
        return sum;
        
    }


    public static int[][] readMatrix(Scanner scanner, int rows){
        int [][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner);
        }
        return matrix;

    }
    public static int[] readArray(Scanner scanner){
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
