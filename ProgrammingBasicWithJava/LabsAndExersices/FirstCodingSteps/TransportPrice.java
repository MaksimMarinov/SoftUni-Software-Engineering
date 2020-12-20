import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String dayOrNight = scanner.nextLine();
        double taxiDay = n * 0.79 + 0.7;
        double taxiNight = n * 0.9 + 0.7;
        double bus = n * 0.09;
        double train = n * 0.06;
        if ( n < 20 && dayOrNight.equals("day")){
            System.out.printf("%.2f", taxiDay);}
        else if ( n < 20 && dayOrNight.equals("night")) {
            System.out.printf("%.2f", taxiNight);}
        else if (n >= 20 && n < 100){
        System.out.printf("%.2f", bus);}
        else if (n >= 100){
            System.out.printf("%.2f", train);}
        }

        }




