package com.company;

import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rowsAndCols = readArray(scanner);
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols =Integer.parseInt(rowsAndCols[1]);
        String[][] matrix = readMatrix(scanner, rows, cols);
        String command = scanner.nextLine();
        while (!command.equals("END")){
            String[] tokens = command.split(" ");
            if(tokens.length != 5 || !tokens[0].equals("swap") || checkCoo(tokens, rows, cols)){
                System.out.println("Invalid input!");
            }else{
                int rowFirstPoint = Integer.parseInt(tokens[1]);
                int colFirstPoint = Integer.parseInt(tokens[2]);
                int rowSecond= Integer.parseInt(tokens[3]);
                int colSecond = Integer.parseInt(tokens[4]);
                String valueOne = matrix[rowFirstPoint][colFirstPoint];
                String valueTwo = matrix[rowSecond][colSecond];
                matrix[rowFirstPoint][colFirstPoint]= valueTwo;
                matrix[rowSecond][colSecond]=valueOne;
                printMatrix(matrix);
            }
            command = scanner.nextLine();

        }
    }

    private static boolean checkCoo(String[] tokens, int rows, int cols) {
        int rowFirstPoint = Integer.parseInt(tokens[1]);
        int colFirstPoint = Integer.parseInt(tokens[2]);
        int rowSecond= Integer.parseInt(tokens[3]);
        int colSecond = Integer.parseInt(tokens[4]);
        if(rowFirstPoint<0||rowFirstPoint>rows-1||rowSecond<0||rowSecond>rows-1
                ||colFirstPoint<0||colFirstPoint>cols-1||colSecond<0||colSecond>cols-1){
            return true;
        }
        return false;
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static String[][] readMatrix(Scanner scanner, int rows, int cols){

        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner);
        }
        return matrix;

    }

    private static String[] readArray(Scanner scanner) {
        return scanner.nextLine().split(" ");
    }
}

