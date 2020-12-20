import java.util.Scanner;

public class SummerOutfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int degrees = Integer.parseInt(scanner.nextLine());
        String daytime = scanner.nextLine();
        String shoes = "";
        String outfit = "";
        switch (daytime){
            case ("Morning"):
                if (degrees >= 10 && degrees <= 18){
                    shoes = "Sneakers";
                    outfit = "Sweatshirt";}
                else if (degrees > 18 && degrees <= 24){
                    shoes = "Moccasins";
                    outfit = "Shirt";}
                else if (degrees >= 25){
                    shoes = "Sandals";
                    outfit = "T-Shirt";}
                break;
            case ("Afternoon"):
                if (degrees >= 10 && degrees <= 18){
                    shoes = "Moccasins";
                    outfit = "Shirt";}
                else if (degrees > 18 && degrees <= 24){
                    shoes = "Sandals";
                    outfit = "T-Shirt";}
                else if (degrees >= 25){
                    shoes = "Barefoot";
                    outfit = "Swim Suit";}
                break;
            case ("Evening"):
                if (degrees >= 10 && degrees <= 18){
                    shoes = "Moccasins";
                    outfit = "Shirt";}
                else if (degrees > 18 && degrees <= 24){
                    shoes = "Moccasins";
                    outfit = "Shirt";}
                else if (degrees >= 25){
                    shoes = "Moccasins";
                    outfit = "Shirt";}
                break;


                }System.out.printf("It's %d degrees, get your %s and %s.", degrees, outfit, shoes);
        }

    }
