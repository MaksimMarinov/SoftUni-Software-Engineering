import java.util.Scanner;

public class TruckDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String season = scanner.nextLine();
        double kmPerMonth = Double.parseDouble(scanner.nextLine());
        double salary = 0;
        switch (season) {
            case ("Spring"):
            case ("Autumn"):
                if (kmPerMonth <= 5000){
                    salary = 0.75 * kmPerMonth*4*0.9;
                    System.out.printf("%.2f",salary);
                }else if (kmPerMonth > 5000 && kmPerMonth<=10000 ){
                    salary = 0.95 * kmPerMonth*4*0.9;
                    System.out.printf("%.2f",salary);
                } else if (kmPerMonth > 10000 && kmPerMonth<=20000){
                    salary = 1.45 * kmPerMonth*4*0.9;
                    System.out.printf("%.2f",salary);
                }break;
            case ("Summer"):
                if (kmPerMonth <= 5000){
                    salary = 0.9 * kmPerMonth*4*0.9;
                    System.out.printf("%.2f",salary);
                }else if (kmPerMonth > 5000 && kmPerMonth<=10000 ){
                    salary = 1.1 * kmPerMonth*4*0.9;
                    System.out.printf("%.2f",salary);
                } else if (kmPerMonth > 10000 && kmPerMonth<=20000) {
                    salary = 1.45 * kmPerMonth * 4 * 0.9;
                    System.out.printf("%.2f", salary);
                }break;
            case ("Winter"):
                if (kmPerMonth <= 5000){
                    salary = 1.05 * kmPerMonth*4*0.9;
                    System.out.printf("%.2f",salary);
                }else if (kmPerMonth > 5000 && kmPerMonth<=10000 ){
                    salary = 1.25 * kmPerMonth*4*0.9;
                    System.out.printf("%.2f",salary);
                } else if (kmPerMonth > 10000 && kmPerMonth<=20000) {
                    salary = 1.45 * kmPerMonth * 4 * 0.9;
                    System.out.printf("%.2f", salary);
                }break;



                }

    }
}
