import java.util.Arrays;
import java.util.Scanner;

public class printMatrixFromTopLeft {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int row =0;
        int col;
        while(row<matrix.length){
            col =0;
            int rowTemp = row;
            while(rowTemp>=0){
                System.out.print(matrix[rowTemp][col] + " ");
                rowTemp--;
                col++;
            }
            System.out.println();
            row++;
        }
        col=1;
        while(col<matrix.length){
            int colTemp = col;
            row = matrix.length-1;
            while(colTemp<=matrix.length-1){
                System.out.print(matrix[row][colTemp] + " ");
                row--;
                colTemp++;
            }
            System.out.println();
            col++;
        }

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
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
    }
}
