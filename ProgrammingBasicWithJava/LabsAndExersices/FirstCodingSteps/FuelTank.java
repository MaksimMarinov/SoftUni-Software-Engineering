import java.util.Scanner;

public class FuelTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fuel = scanner.nextLine();
        int litres = Integer.parseInt(scanner.nextLine());
        if (fuel.equals("Diesel")) {
            if (litres >= 25) {
                System.out.println("You have enough diesel.");
            } else if (litres < 25) {
                System.out.println("Fill your tank with diesel!");
            }


        }else if (fuel.equals("Gasoline")){
            if (litres >= 25){
                System.out.println("You have enough gasoline.");
            }else if (litres < 25){
                System.out.println("Fill your tank with gasoline!");
            }
        }else if (fuel.equals("Gas")){
            if (litres >= 25){
                System.out.println("You have enough gas.");
            }else if (litres < 25){
                System.out.println("Fill your tank with gas!");
            }
        }else {
            System.out.println("Invalid fuel!");
        }
    }
}



