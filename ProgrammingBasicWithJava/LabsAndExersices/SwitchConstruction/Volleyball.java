import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String year = scanner.nextLine();
        int holidays = Integer.parseInt(scanner.nextLine());
        int weekendsHometown = Integer.parseInt(scanner.nextLine());
        int holidaySofia = 48-weekendsHometown;
        double playsSofia = holidaySofia * 3.0/4;
        double holidaysPlay = holidays * 2.0/3;
        double total = playsSofia + weekendsHometown + holidaysPlay;
        switch (year){
            case ("leap"):
                total = 1.15*total;
                break;
            case ("normal"):
                    total=total;
                    break;
        }
        System.out.printf("%.2f", Math.floor(total));


    }
}
