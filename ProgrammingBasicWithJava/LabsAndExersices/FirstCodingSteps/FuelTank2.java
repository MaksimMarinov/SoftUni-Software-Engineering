import java.util.Scanner;

public class FuelTank2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fuelKind = scanner.nextLine();
        double fuelQuantity = Double.parseDouble(scanner.nextLine());
        String discountCard = scanner.nextLine();
        double discount = 0;
        if (fuelKind.equals("Gas")) {
            if (fuelQuantity < 20) {
                if (discountCard.equals("Yes")) {
                    discount = 0.08;
                    double finalPriceGas = fuelQuantity * (0.93 - discount);
                    System.out.printf("%.2f lv.", finalPriceGas);
                } else if (discountCard.equals("No")) {
                    double finalPriceGas = fuelQuantity * (0.93 - discount);
                    System.out.printf("%.2f lv.", finalPriceGas);
                }
            } else if (fuelQuantity >= 20 && fuelQuantity <= 25) {
                if (discountCard.equals("Yes")) {
                    discount = 0.08;
                    double finalPriceGas = fuelQuantity * (0.93 - discount);
                    System.out.printf("%.2f lv.", 0.92 * finalPriceGas);
                } else if (discountCard.equals("No")) {
                    double finalPriceGas = fuelQuantity * (0.93 - discount);
                    System.out.printf("%.2f lv.", 0.92 * finalPriceGas);
                }
            } else if (fuelQuantity > 25) {
                if (discountCard.equals("Yes")) {
                    discount = 0.08;
                    double finalPriceGas = fuelQuantity * (0.93 - discount);
                    System.out.printf("%.2f lv.", 0.9 * finalPriceGas);
                } else if (discountCard.equals("No")) {
                    double finalPriceGas = fuelQuantity * (0.93 - discount);
                    System.out.printf("%.2f lv.", 0.9 * finalPriceGas);
                }
            }


        } else if (fuelKind.equals("Gasoline")) {
            if (fuelQuantity < 20) {
                if (discountCard.equals("Yes")) {
                    discount = 0.18;
                    double finalPriceGasoline = fuelQuantity * (2.22 - discount);
                    System.out.printf("%.2f lv.", finalPriceGasoline);
                } else if (discountCard.equals("No")) {
                    double finalPriceGasoline = fuelQuantity * (2.22 - discount);
                    System.out.printf("%.2f lv.", finalPriceGasoline);
                }
            } else if (fuelQuantity >= 20 && fuelQuantity <= 25) {
                if (discountCard.equals("Yes")) {
                    discount = 0.18;
                    double finalPriceGasoline = fuelQuantity * (2.22 - discount);
                    System.out.printf("%.2f lv.", 0.92 * finalPriceGasoline);
                } else if (discountCard.equals("No")) {
                    double finalPriceGasoline = fuelQuantity * (2.22 - discount);
                    System.out.printf("%.2f lv.", 0.92 * finalPriceGasoline);
                }
            } else if (fuelQuantity > 25) {
                if (discountCard.equals("Yes")) {
                    discount = 0.18;
                    double finalPriceGasoline = fuelQuantity * (2.22 - discount);
                    System.out.printf("%.2f lv.", 0.9 * finalPriceGasoline);
                } else if (discountCard.equals("No")) {
                    double finalPriceGasoline = fuelQuantity * (2.22 - discount);
                    System.out.printf("%.2f lv.", 0.9 * finalPriceGasoline);
                }
            }


        } else if (fuelKind.equals("Diesel")) {
            if (fuelQuantity < 20) {
                if (discountCard.equals("Yes")) {
                    discount = 0.12;
                    double finalPriceDiesel = fuelQuantity * (2.33 - discount);
                    System.out.printf("%.2f lv.", finalPriceDiesel);
                } else if (discountCard.equals("No")) {
                    double finalPriceDiesel = fuelQuantity * (2.33 - discount);
                    System.out.printf("%.2f lv.", finalPriceDiesel);
                }
            } else if (fuelQuantity >= 20 && fuelQuantity <= 25) {
                if (discountCard.equals("Yes")) {
                    discount = 0.12;
                    double finalPriceDiesel = fuelQuantity * (2.33 - discount);
                    System.out.printf("%.2f lv.", 0.92 * finalPriceDiesel);
                } else if (discountCard.equals("No")) {
                    double finalPriceDiesel = fuelQuantity * (2.33 - discount);
                    System.out.printf("%.2f lv.", 0.92 * finalPriceDiesel);
                }
            } else if (fuelQuantity > 25) {
                if (discountCard.equals("Yes")) {
                    discount = 0.12;
                    double finalPriceDiesel = fuelQuantity * (2.33 - discount);
                    System.out.printf("%.2f lv.", 0.9 * finalPriceDiesel);
                } else if (discountCard.equals("No")) {
                    double finalPriceDiesel = fuelQuantity * (2.33 - discount);
                    System.out.printf("%.2f lv.", 0.9 * finalPriceDiesel);
                }
            }
        }
    }
}




