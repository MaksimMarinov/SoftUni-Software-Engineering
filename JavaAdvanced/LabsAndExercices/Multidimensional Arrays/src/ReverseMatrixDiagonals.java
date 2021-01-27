import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndCols = readArray(scanner);
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        int[][] matrix = readMatrix(scanner, rows, cols);
        int row= rows-1, col = cols-1;
        while (row>=0){
            int innerRow =row;
            int innerCol = col;
            while (innerCol<cols&&innerRow>=0){
                System.out.print(matrix[innerRow--][innerCol++]+" ");
            }
            System.out.println();
            col--;
            if(col<0){
                col=0;
                row--;
            }
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
