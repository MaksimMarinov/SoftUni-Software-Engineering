import java.util.Scanner;

public class BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder output = new StringBuilder(scanner.nextLine());
        int rowsAndCols = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[rowsAndCols][];
        int playerRow=-1;
        int playerCol=-1;
        for (int row = 0; row < rowsAndCols; row++) {
            String line = scanner.nextLine();
            matrix[row]=line.split("");
            if(line.contains("P")){
                playerRow=row;
                playerCol=line.indexOf("P");
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("end")){
            matrix[playerRow][playerCol]="-";
            String result;
            switch (command){
                case "up":
                    if(playerRow-1>=0){
                        playerRow--;
                    }else{
                        if(output.length()>0){
                            output.deleteCharAt(output.length()-1);
                        }
                    }

                    break;
                case "down":
                    if(playerRow+1<rowsAndCols){
                        playerRow++;
                    }else{
                        if(output.length()>0){
                            output.deleteCharAt(output.length()-1);
                        }
                    }

                    break;
                case "left":
                    if(playerCol-1>=0){
                        playerCol--;
                    }else{
                        if(output.length()>0){
                            output.deleteCharAt(output.length()-1);
                        }
                    }

                    break;
                case "right":
                    if(playerCol+1<rowsAndCols){
                        playerCol++;
                    }else{
                        if(output.length()>0){
                            output.deleteCharAt(output.length()-1);
                        }
                    }

                    break;
            }
            result=matrix[playerRow][playerCol];
            matrix[playerRow][playerCol]="P";
            if(Character.isLetter(result.charAt(0))){
                output.append(result);
            }


            command= scanner.nextLine();
        }
        System.out.println(output);
       printMatrix(matrix);

    }
    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
