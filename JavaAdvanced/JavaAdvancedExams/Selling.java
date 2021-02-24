import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Selling {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int rowAndCols = Integer.parseInt(bf.readLine());
        int bakerRow = -1;
        int bakerCol = -1;
        int pillar1Row = -1;
        int pillar1Col = -1;
        int pillar2Row = -1;
        int pillar2Col = -1;
        boolean hasPillars = false;
        char[][] matrix = new char[rowAndCols][rowAndCols];
        for (int row = 0; row < rowAndCols; row++) {
            String line = bf.readLine();
            matrix[row] = line.toCharArray();
            if (line.contains("O")) {
                hasPillars = true;
            }
            if (line.contains("S")) {
                bakerRow = row;
                bakerCol = line.indexOf("S");
            }

        }
        if (hasPillars) {
            for (int row = 0; row < rowAndCols; row++) {
                for (int col = 0; col < rowAndCols; col++) {
                    if (matrix[row][col] == 'O') {
                        if (pillar1Col == -1) {
                            pillar1Row = row;
                            pillar1Col = col;
                        } else if (pillar2Row == -1) {
                            pillar2Col = col;
                            pillar2Row = row;
                        }


                    }

                }
                if (pillar1Row != -1 && pillar2Row != -1) {
                    break;
                }
            }

        }
        String command = bf.readLine();
        int countMoney = 0;
        while (true) {
            matrix[bakerRow][bakerCol]='-';
            char result = 0;
            switch (command) {
                case "up":
                    bakerRow--;
                    break;
                case"down":
                    bakerRow++;
                    break;
                case "left":
                    bakerCol--;
                    break;
                case"right":
                    bakerCol++;
                    break;
            }
            if(isOut(matrix, bakerRow, bakerCol)){
                System.out.println("Bad news, you are out of the bakery.");
                break;
            }
            result=matrix[bakerRow][bakerCol];
            if(result=='O'){
                matrix[bakerRow][bakerCol]='-';
                if(bakerRow==pillar1Row&&bakerCol==pillar1Col){
                    bakerRow=pillar2Row;
                    bakerCol=pillar2Col;
                }else{
                    bakerRow=pillar1Row;
                    bakerCol=pillar1Col;
                }
                result=matrix[bakerRow][bakerCol];
            }

            if(Character.isDigit(result)){
                countMoney+=Integer.parseInt(String.valueOf(result));
            }
            matrix[bakerRow][bakerCol]='S';
            if(countMoney>=50){
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }
            command = bf.readLine();

        }
        System.out.println("Money: "+countMoney);
        printMatrix(matrix);



    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static boolean isOut(char[][] matrix, int row, int col) {
        return row < 0 || col < 0 || row >= matrix.length || col >= matrix.length;
    }
}
