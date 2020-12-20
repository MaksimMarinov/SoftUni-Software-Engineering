import java.util.Scanner;

public class Time15Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hours = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());
        int startTimeMinutes = hours * 60 + minutes;
        int timeAfter15Minutes = startTimeMinutes + 15;
        int finalHours = timeAfter15Minutes/60;
        int finalMinutes = timeAfter15Minutes % 60;
        if (finalHours==24) {
            finalHours=0;
        }
        System.out.printf("%d:%02d", finalHours, finalMinutes);
    }
}
