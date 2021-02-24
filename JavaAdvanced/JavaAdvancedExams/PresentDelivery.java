import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PresentDelivery {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int countOfPresents = Integer.parseInt(bf.readLine());
        int rowsAndCols = Integer.parseInt(bf.readLine());
        String[][] matrix = new String[rowsAndCols][rowsAndCols];
        int santaRow = -1;
        int santaCol = -1;

        for (int row = 0; row < rowsAndCols; row++) {
            String line = bf.readLine();
            matrix[row] = line.split(" ");

        }
        for (int row = 0; row < rowsAndCols; row++) {
            for (int col = 0; col < rowsAndCols; col++) {
                if (matrix[row][col].equals("S")) {
                    santaRow = row;
                    santaCol = col;
                    break;
                }
            }
            if (santaRow != -1) {
                break;
            }
        }
        String command = bf.readLine();
        int countGivenPresents = 0;
        while (!command.equals("Christmas morning") && countOfPresents > 0) {
            matrix[santaRow][santaCol] = "-";
            String result = "";
            switch (command) {
                case "up":
                    santaRow--;
                    break;
                case "down":
                    santaRow++;
                    break;
                case "left":
                    santaCol--;
                    break;
                case "right":
                    santaCol++;
                    break;

            }
            result = matrix[santaRow][santaCol];
            matrix[santaRow][santaCol] = "S";
            if (result.equals("V")) {
                countGivenPresents++;
                countOfPresents--;
            } else if (result.equals("C")) {
                if (matrix[santaRow][santaCol - 1].equals("V")) {
                    matrix[santaRow][santaCol - 1] = "-";
                    countGivenPresents++;
                    countOfPresents--;
                    if (countOfPresents == 0) {
                        System.out.println("Santa ran out of presents.");
                        break;
                    }
                } else if (matrix[santaRow][santaCol - 1].equals("X")) {
                    matrix[santaRow][santaCol - 1] = "-";
                    countOfPresents--;
                    if (countOfPresents == 0) {
                        break;
                    }
                }

                if (matrix[santaRow][santaCol + 1].equals("V")) {
                    matrix[santaRow][santaCol + 1] = "-";
                    countGivenPresents++;
                    countOfPresents--;

                } else if (matrix[santaRow][santaCol + 1].equals("X")) {
                    matrix[santaRow][santaCol + 1] = "-";
                    countOfPresents--;

                }
                if (countOfPresents == 0) {
                    System.out.println("Santa ran out of presents!");
                    break;
                }

                if (matrix[santaRow - 1][santaCol].equals("V")) {
                    matrix[santaRow - 1][santaCol] = "-";
                    countGivenPresents++;
                    countOfPresents--;

                } else if (matrix[santaRow - 1][santaCol].equals("X")) {
                    matrix[santaRow - 1][santaCol] = "-";
                    countOfPresents--;

                }
                if (countOfPresents == 0) {
                    System.out.println("Santa ran out of presents!");
                    break;
                }

                if (matrix[santaRow + 1][santaCol].equals("V")) {
                    matrix[santaRow + 1][santaCol] = "-";
                    countGivenPresents++;
                    countOfPresents--;

                } else if (matrix[santaRow + 1][santaCol].equals("X")) {
                    matrix[santaRow + 1][santaCol] = "-";
                    countOfPresents--;

                }
                if (countOfPresents == 0) {
                    System.out.println("Santa ran out of presents!");
                    break;
                }


            }

            command = bf.readLine();
        }
        StringBuilder out = new StringBuilder();
        int niceKidsLeft = 0;
        for (int row = 0; row < rowsAndCols; row++) {
            for (int col = 0; col < rowsAndCols; col++) {
                if (matrix[row][col].equals("V")) {
                    niceKidsLeft++;
                }
                out.append(matrix[row][col]).append(" ");
            }
            out.append(System.lineSeparator());
        }
        System.out.println(out.toString().trim());
        if (niceKidsLeft > 0) {
            System.out.printf("No presents for %d nice kid/s.%n", niceKidsLeft);
        } else {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", countGivenPresents);
        }


    }

}
