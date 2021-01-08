import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class SeizeTheFire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\#+");
        int water = Integer.parseInt(scanner.nextLine());
        int totalWater = 0;
        double efforts =0;
        System.out.println("Cells:");
        for (int i = 0; i < input.length; i++) {
            String[] token = input[i].split(" = ");
            int waterToPut = Integer.parseInt(token[1]);
            if (checkIfInRange(token)) {
                if(waterIsEnough(waterToPut, water))
            { System.out.println(" "+"-" + " " + waterToPut);
            totalWater += waterToPut;
            water -= waterToPut;
            efforts+=0.25*waterToPut;
            }
            }
        } System.out.printf("Effort: %.2f%n", efforts);
        System.out.printf("Total Fire: %d", totalWater);

    }

    private static boolean waterIsEnough(int waterToPut, int water) {
        if(water>=waterToPut){
            return true;
        }return false;
    }

    private static boolean checkIfInRange(String[] token) {
        int range = Integer.parseInt(token[1]);
        switch (token[0]) {
            case "High":
                if (range > 125 || range < 81) {
                    return false;
                }
                break;
            case "Medium":
                if (range > 80 || range < 51) {
                    return false;
                }
                break;
            case "Low":
                if (range > 50 || range < 1) {
                    return false;
                }
                break;
        }
        return true;

        }
    }

