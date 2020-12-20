import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double dogfood = Double.parseDouble (input.nextLine());
        double otherFood = Double.parseDouble (input.nextLine());
        double sumForDogs = dogfood*2.5;
        double sumForOthers = otherFood*4;
        System.out.println(sumForDogs + sumForOthers + " lv.");

    }

}


