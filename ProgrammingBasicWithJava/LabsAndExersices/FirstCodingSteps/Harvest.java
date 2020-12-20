import java.util.Scanner;

public class Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        int z = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());
        double totalGrapes = x * y;
        double harvest = totalGrapes*0.4;
        double wine = harvest / 2.5;
        double litersLeft = Math.abs(wine - z);
        double wineWorkers =litersLeft / workers;
        if (wine >= z) {
            System.out.printf("Good harvest this year! Total wine: %.0f liters.", Math.floor(wine));
            System.out.println();
            System.out.printf("%s liters left -> %s liters per person.", (int)Math.ceil(litersLeft), (int)Math.ceil(wineWorkers));
        } else if (wine < z) {
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(litersLeft));


        }
    }
}
