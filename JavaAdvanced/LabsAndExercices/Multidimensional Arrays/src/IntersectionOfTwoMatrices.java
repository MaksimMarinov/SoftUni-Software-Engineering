import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        char[][] first = new char[rows][cols];
        char[][] second = new char[rows][cols];
       first = readArray(scanner, rows, cols);
       second = readArray(scanner, rows, cols);
       char[][] output = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(first[row][col] == second[row][col]){
                    output[row][col]=first[row][col];
                }else{
                    output[row][col]='*';
                }
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(output[row][col]+" ");
            }
            System.out.println();
        }


    }
    public static char[][] readArray(Scanner scanner, int rows, int cols){
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] symbols = scanner.nextLine().split("\\s+");
            for (int col =0; col<cols; col++){
                matrix[row][col]=symbols[col].charAt(0);
            }
        }return matrix;
    }


}

