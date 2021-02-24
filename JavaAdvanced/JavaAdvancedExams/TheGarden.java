import java.util.Scanner;

public class TheGarden {
    final static String lettuce = "L";
    final static String potatoes = "P";
    final static String carrots = "C";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        String[][] garden = new String[rows][];
        for (int row = 0; row < rows; row++) {
            garden[row]= scanner.nextLine().split(" ");
        }
        int countOfCarrots =0;
        int countOfPotatoes =0;
        int countOfLettuce =0;
        int countOfHarmedVegetables =0;
        String line = scanner.nextLine();
        while (!line.equals("End of Harvest")){
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);
            String result;
            switch (command){
                case "Harvest":
                    if(isValid(row, col, garden)){
                        result = garden[row][col];
                        if(result.equals(lettuce)){
                            countOfLettuce++;
                        }else if(result.equals(potatoes)){
                            countOfPotatoes++;
                        }else if(result.equals(carrots)){
                            countOfCarrots++;
                        }
                        garden[row][col]=" ";
                    }
                    break;
                case"Mole":
                    if(isValid(row, col, garden)){
                        String direction = tokens[3];
                        if(direction.equals("up")){
                            for (int currentRow = row; currentRow >=0 ; currentRow-=2) {
                                countOfHarmedVegetables = getCountOfHarmedVegetables(garden,
                                        countOfHarmedVegetables, currentRow, col);

                            }
                        }else if(direction.equals("down")){
                            for (int currentRow = row; currentRow < garden.length; currentRow+=2) {
                                countOfHarmedVegetables = getCountOfHarmedVegetables(garden,
                                        countOfHarmedVegetables, currentRow, col);
                            }
                        }else if(direction.equals("left")){
                            for (int currentCol = col; currentCol >=0; currentCol-=2) {
                                countOfHarmedVegetables = getCountOfHarmedVegetables(garden,
                                        countOfHarmedVegetables, row, currentCol);
                            }
                        }else if(direction.equals("right")){
                            for (int currentCol = col; currentCol <garden[row].length ; currentCol+=2) {
                                countOfHarmedVegetables = getCountOfHarmedVegetables(garden,
                                        countOfHarmedVegetables, row, currentCol);
                            }
                        }

                    }
                    break;
            }
            line= scanner.nextLine();

        }
        for (int currentRow = 0; currentRow < rows; currentRow++) {
            for (int currentCol = 0; currentCol < garden[currentRow].length; currentCol++) {
                System.out.print(garden[currentRow][currentCol]+" ");
            }
            System.out.println();
        }
        System.out.println("Carrots: "+countOfCarrots);
        System.out.println("Potatoes: "+countOfPotatoes);
        System.out.println("Lettuce: "+countOfLettuce);
        System.out.println("Harmed vegetables: "+countOfHarmedVegetables);


    }


    private static int getCountOfHarmedVegetables(String[][] garden, int countOfHarmedVegetables, int row, int col) {
        String result;
        result = garden[row][col];
        if(result.equals(potatoes)||result.equals(lettuce)||result.equals(carrots)){
            countOfHarmedVegetables++;
            garden[row][col]=" ";
        }
        return countOfHarmedVegetables;
    }


    private static boolean isValid(int row, int col, String[][] matrix){
        return row>=0&&row<matrix.length&&col>=0&&col<matrix[row].length;
    }
}
