import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bee {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int rowAndCols = Integer.parseInt(bf.readLine());
      String[][] matrix = new String[rowAndCols][rowAndCols];
      int beeRow = -1;
      int beeCol = -1;
        for (int row = 0; row < rowAndCols; row++) {
            String line = bf.readLine();
            matrix[row]=line.split("");
            if(line.contains("B")){
                beeRow=row;
                beeCol=line.indexOf("B");
            }
        }
        int countFlowers=0;
        String command = bf.readLine();
        while (!command.equals("End")&&!isOutOfTheMatrix(beeRow, beeCol, matrix)){
            String result ="";
            matrix[beeRow][beeCol]=".";
            switch (command){
                case"up":
                    beeRow--;
                    if (ifIsOut(matrix, beeRow, beeCol)) continue;
                    result=matrix[beeRow][beeCol];
                    if (bonusMove(matrix, beeRow, beeCol, result)) continue;
                    break;
                case"down":
                    beeRow++;
                    if (ifIsOut(matrix, beeRow, beeCol)) continue;
                    result=matrix[beeRow][beeCol];
                    if (bonusMove(matrix, beeRow, beeCol, result)) continue;
                    break;
                case "right":
                    beeCol++;
                    if (ifIsOut(matrix, beeRow, beeCol)) continue;
                    result=matrix[beeRow][beeCol];
                    if (bonusMove(matrix, beeRow, beeCol, result)) continue;
                    break;
                case "left":
                    beeCol--;
                    if (ifIsOut(matrix, beeRow, beeCol)) continue;
                    result=matrix[beeRow][beeCol];
                    if (bonusMove(matrix, beeRow, beeCol, result)) continue;
                    break;

            }
            if(result.equals("f")){
                countFlowers++;
            }
            matrix[beeRow][beeCol]="B";

            command=bf.readLine();
        }
        if(countFlowers>=5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", countFlowers);
        }else{
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5-countFlowers);
        }
        for (int row = 0; row < rowAndCols; row++) {
            for (int col = 0; col <rowAndCols ; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }


    }

    private static boolean bonusMove(String[][] matrix, int beeRow, int beeCol, String result) {
        if (result.equals("O")) {
            matrix[beeRow][beeCol] = "B";
            return true;
        }
        return false;
    }

    private static boolean ifIsOut(String[][] matrix, int beeRow, int beeCol) {
        if (isOutOfTheMatrix(beeRow, beeCol, matrix)) {
            System.out.println("The bee got lost!");
            return true;
        }
        return false;
    }

    private static boolean isOutOfTheMatrix(int row, int col, String[][] matrix){
        return row<0||col<0||row>= matrix.length||col>= matrix.length;
    }

}
