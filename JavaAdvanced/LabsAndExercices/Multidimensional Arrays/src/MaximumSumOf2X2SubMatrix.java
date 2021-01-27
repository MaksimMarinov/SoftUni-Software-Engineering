import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int maxSum = Integer.MIN_VALUE;
        int[] coordinates = new int[4];
        for (int row = 0; row < matrix.length-1; row++) {
            for (int col = 0; col < matrix[row].length-1; col++) {
                int sum = matrix[row][col]+matrix[row+1][col]+matrix[row+1][col+1]+matrix[row][col+1];
                if(sum>maxSum){
                    maxSum=sum;
                    coordinates[0]=matrix[row][col];
                    coordinates[1]=matrix[row][col+1];
                    coordinates[2]=matrix[row+1][col];
                    coordinates[3]=matrix[row+1][col+1];
                }
            }
        }
        System.out.println(coordinates[0]+" "+coordinates[1]);
        System.out.println(coordinates[2]+" "+coordinates[3]);
        System.out.println(maxSum);
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
