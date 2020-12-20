import java.util.Scanner;

public class SleepyTomCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int holidays = Integer.parseInt(scanner.nextLine());
        int workDays = 365 -  holidays;
        int time = (holidays * 127) + (workDays * 63);
        if (time < 30000) {
            int difference = 30000 - time;
            double hours = Math.floor(difference / 60);
            double minutes = Math.floor(difference % 60);
            System.out.printf("Tom sleeps well");
            System.out.println();
            System.out.printf("%.0f hours and %.0f minutes less for play", hours, minutes);

        }else if (time>30000) {
            int difference = time - 30000;
            double hours = Math.floor(difference / 60);
            double minutes = Math.floor(difference % 60);
            System.out.printf("Tom will run away");
            System.out.println();
            System.out.printf("%.0f hours and %.0f minutes more for play", hours, minutes);
        }

    }
}
