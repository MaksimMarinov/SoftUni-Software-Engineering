import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Snake {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int rowAndCols = Integer.parseInt(bf.readLine());
        String[][] matrix = new String[rowAndCols][rowAndCols];
        int snakeRow = -1;
        int snakeCol = -1;
        for (int i = 0; i < rowAndCols; i++) {
            String line=bf.readLine();
            matrix[i]=line.split("");
            if(line.contains("S")){
                snakeRow=i;
                snakeCol=line.indexOf("S");
            }
        }
        int foodEaten = 0;
       while (foodEaten<10){
        String command = bf.readLine();
        String result="";
        matrix[snakeRow][snakeCol]=".";
        switch (command){
            case "up":
                snakeRow--;
                break;
            case"down":
                snakeRow++;
                break;
            case "left":
                snakeCol--;
                break;
            case"right":
                snakeCol++;
                break;
        }
        if(!isIn(matrix, snakeRow, snakeCol)){
            System.out.println("Game over!");
            break;
        }
        result=matrix[snakeRow][snakeCol];
           if(result.equals("B")){
            matrix[snakeRow][snakeCol]=".";
            int[] coo = findCoo(matrix);
            snakeRow=coo[0];
            snakeCol=coo[1];
            result=matrix[snakeRow][snakeCol];
           }

        if(result.equals("*")){
            foodEaten++;
        }
        matrix[snakeRow][snakeCol]="S";
       }
       if(foodEaten>=10){
           System.out.println("You won! You fed the snake.");
       }
        System.out.println("Food eaten: "+foodEaten);
        for (int row = 0; row < rowAndCols; row++) {
            for (int col = 0; col < rowAndCols; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }


    }

    private static int[] findCoo(String[][] matrix) {
        int[] coo = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col].equals("B")){
                    coo[0]=row;
                    coo[1]=col;
                    return coo;
                }
            }
        }
        return coo;
    }

    private static boolean isIn(String[][] matrix, int snakeRow, int snakeCol) {
        return snakeRow>=0&&snakeRow< matrix.length&&snakeCol>=0&&snakeCol<matrix[snakeRow].length;
    }
}
