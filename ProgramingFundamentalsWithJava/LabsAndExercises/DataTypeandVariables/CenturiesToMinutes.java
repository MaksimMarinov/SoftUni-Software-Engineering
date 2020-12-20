import java.util.Scanner;

public class CenturiesToMinutes {
    public static void main(String[] args) {
        int cent = new Scanner(System.in).nextInt();
        int years = cent*100;
        int days = (int) (years*365.2422);
        int hours = days * 24;
        int minutes = hours*60;
        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes", cent, years, days, hours, minutes);


    }
}
