import java.util.Scanner;

public class CarToGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String carClass = "";
        String carType = "";
        double priceCar = 0;
        switch (season){
            case ("Summer"):
                if (budget <=100){
                    priceCar = 0.35*budget;
                    carClass = "Economy class";
                    carType  = "Cabrio";
                }else if (budget>100 && budget<=500){
                    priceCar = 0.45*budget;
                    carClass = "Compact class";
                    carType  = "Cabrio";}
                else {
                    priceCar = 0.9*budget;
                    carClass = "Luxury class";
                    carType  = "Jeep";}
                break;
            case ("Winter"):
                carType  = "Jeep";
                if (budget <=100){
                    priceCar = 0.65*budget;
                    carClass = "Economy class";
                }else if (budget>100 && budget<=500){
                    priceCar = 0.8*budget;
                    carClass = "Compact class";
                   }
                else {
                    priceCar = 0.9*budget;
                    carClass = "Luxury class";
                    }
                break;



        }
        System.out.println(carClass);
        System.out.printf("%s - %.2f", carType, priceCar);


    }
}
