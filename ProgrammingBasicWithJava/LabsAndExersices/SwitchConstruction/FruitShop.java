import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fruit = scanner.nextLine();
        String day = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());
        double price = 0;
        switch (fruit) {
            case ("banana"):
                if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Friday")) {
                    price = 2.5 * quantity;
                    System.out.printf("%.2f", price);
                } else if (day.equals("Saturday") || day.equals("Sunday")) {
                    price = quantity * 2.7;
                    System.out.printf("%.2f", price);

                }else { System.out.println("error");
                }
                break;

            case ("apple"):
                if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Friday")) {
                    price = 1.2 * quantity;
                    System.out.printf("%.2f", price);
                } else if (day.equals("Saturday") || day.equals("Sunday")) {
                    price = quantity * 1.25;
                    System.out.printf("%.2f", price);
                } else {
                    System.out.println("error");
                }
                break;

            case ("orange"):
                if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Friday")) {
                    price = 0.85 * quantity;
                    System.out.printf("%.2f", price);
                } else if (day.equals("Saturday") || day.equals("Sunday")) {
                    price = quantity * 0.9;
                    System.out.printf("%.2f", price);
                } else {
                    System.out.println("error");
                }
                break;

            case ("grapefruit"):
                if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Friday")) {
                    price = 1.45 * quantity;
                    System.out.printf("%.2f", price);
                } else if (day.equals("Saturday") || day.equals("Sunday")) {
                    price = quantity * 1.6;
                    System.out.printf("%.2f", price);}
                else {
                    System.out.println("error");
                }

                    break;

            case ("kiwi"):
                if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Friday")) {
                    price = 2.7 * quantity;
                    System.out.printf("%.2f", price);
                } else if (day.equals("Saturday") || day.equals("Sunday")) {
                    price = quantity * 3;
                    System.out.printf("%.2f", price);
                }
                else {
                    System.out.println("error");
                }

                break;

            case ("pineapple"):
                if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Friday")) {
                    price = 5.5 * quantity;
                    System.out.printf("%.2f", price);
                } else if (day.equals("Saturday") || day.equals("Sunday")) {
                    price = quantity * 5.6;
                    System.out.printf("%.2f", price);
                }else {
                    System.out.println("error");
                }
                    break;

            case ("grapes"):
                if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Friday")) {
                    price = 3.85 * quantity;
                    System.out.printf("%.2f", price);
                } else if (day.equals("Saturday") || day.equals("Sunday")) {
                    price = quantity * 4.2;
                    System.out.printf("%.2f", price);
                }else {
                    System.out.println("error");
                }

                break;


            default:
                System.out.println("error");
                break;

        }

    }
}