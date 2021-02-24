import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Garden {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String command =  bf.readLine();
        int[] rowsAndCols = readArray(command);
        int gardenRows = rowsAndCols[0];
        int gardenCols = rowsAndCols[1];
        int[][] garden =new int[gardenRows][gardenCols];
        for (int row = 0; row < gardenRows; row++) {
            for (int col = 0; col < gardenCols; col++) {
                garden[row][col]=0;
            }
        }
       command = bf.readLine();
        while (!command.equals("Bloom Bloom Plow")){
            int[] flowerCoordinates = readArray(command);
            int flowerRow = flowerCoordinates[0];
            int flowerCol = flowerCoordinates[1];
            if(isValid(flowerRow, flowerCol, garden)){
                bloomLeft(flowerRow, flowerCol, garden);
                bloomRight(flowerRow, flowerCol, garden);
                bloomUp(flowerRow, flowerCol, garden);
                bloomDown(flowerRow, flowerCol, garden);

            }else{
                System.out.println("Invalid coordinates.");
            }



            command=bf.readLine();
        }
        for (int row = 0; row < gardenRows; row++) {
            for (int col = 0; col < gardenCols; col++) {
                System.out.print(garden[row][col]+" ");
            }
            System.out.println();
        }

    }

    private static void bloomUp(int flowerRow, int flowerCol, int[][] garden) {
        for (int i = flowerRow-1; i >=0 ; i--) {
            garden[i][flowerCol]++;
        }
    }
    private static void bloomDown(int flowerRow, int flowerCol, int[][] garden){
        for (int i = flowerRow+1; i < garden.length; i++) {
            garden[i][flowerCol]++;
        }
    }

    private static void bloomRight(int flowerRow, int flowerCol, int[][] garden) {
        for (int i = flowerCol+1; i < garden.length; i++) {
            garden[flowerRow][i]++;
        }
    }

    private static void bloomLeft(int flowerRow, int flowerCol, int[][] garden) {
        for (int i = flowerCol; i >=0 ; i--) {
            garden[flowerRow][i]++;
        }
    }

    private static boolean isValid(int flowerRow, int flowerCol, int[][] garden) {
        return flowerRow>=0&&flowerCol>=0&&flowerCol< garden.length&&flowerRow< garden.length;
    }

    private static int[] readArray(String command) throws IOException {
        return Arrays.stream(command.split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
