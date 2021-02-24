import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReVolt {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int rowsAndCols = Integer.parseInt(bf.readLine());
        int countOfCommands = Integer.parseInt(bf.readLine());
        String[][] matrix = new String[rowsAndCols][rowsAndCols];
        int playerRow = -1;
        int playerCol = -1;
        for (int i = 0; i < rowsAndCols; i++) {
            String line = bf.readLine();
            matrix[i] = line.split("");
            if(line.contains("f")){
                playerRow=i;
                playerCol=line.indexOf("f");
            }
        }
        boolean isWon = false;

        for (int i = 0; i < countOfCommands; i++) {
            String command = bf.readLine();
            String result;
            matrix[playerRow][playerCol]="-";
            switch (command) {
                case "up":
                    playerRow--;
                    if(isOut(matrix, playerRow, playerCol)){
                        playerRow=matrix.length-1;
                    }
                    result=matrix[playerRow][playerCol];
                    if(result.equals("T")){
                        playerRow++;
                        if(isOut(matrix, playerRow, playerCol)){
                            playerRow=0;
                        }
                    }else if(result.equals("B")){
                        playerRow--;
                        if(isOut(matrix, playerRow, playerCol)){
                            playerRow=matrix.length-1;
                        }
                    }
                    break;
                case "down":
                    playerRow++;
                    if(isOut(matrix,playerRow, playerCol)){
                        playerRow=0;
                    }
                    result=matrix[playerRow][playerCol];
                    if(result.equals("T")){
                        playerRow--;
                        if(isOut(matrix, playerRow, playerCol)){
                            playerRow=matrix.length-1;
                        }
                    }else if(result.equals("B")){
                        playerRow++;
                        if(isOut(matrix, playerRow, playerCol)){
                            playerRow=0;
                        }
                    }
                    break;
                case "left":
                    playerCol--;
                    if(isOut(matrix, playerRow, playerCol)){
                        playerCol=matrix.length-1;
                    }
                    result=matrix[playerRow][playerCol];
                    if(result.equals("T")){
                        playerCol++;
                        if(isOut(matrix, playerRow, playerCol)){
                            playerCol=0;
                        }
                    }else if(result.equals("B")){
                        playerCol--;
                        if(isOut(matrix, playerRow, playerCol)){
                            playerCol=matrix.length-1;
                        }
                    }
                    break;
                case "right":
                    playerCol++;
                    if(isOut(matrix,playerRow, playerCol)){
                        playerCol=0;
                    }
                    result=matrix[playerRow][playerCol];
                    if(result.equals("T")){
                        playerCol--;
                        if(isOut(matrix, playerRow, playerCol)){
                            playerCol=matrix.length-1;
                        }
                    }else if(result.equals("B")){
                        playerCol++;
                        if(isOut(matrix, playerRow, playerCol)){
                            playerCol=0;
                        }
                    }
                    break;


            }
            result=matrix[playerRow][playerCol];
            matrix[playerRow][playerCol]="f";
            if(result.equals("F")){
                isWon=true;
                break;
            }


        }
        if(isWon){
            System.out.println("Player won!");
        }else{
            System.out.println(("Player lost!"));
        }
        for (int row = 0; row < rowsAndCols; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }

    }
    private static boolean isOut(String[][] matrix, int row, int col){
        return row<0||row>=matrix.length||col<0||col>=matrix[row].length;
    }
}
