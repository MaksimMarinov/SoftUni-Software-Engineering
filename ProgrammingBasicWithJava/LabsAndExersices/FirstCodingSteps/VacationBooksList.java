import java.util.Scanner;

public class VacationBooksList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int pagesBook = Integer.parseInt(scanner.nextLine());
        int pagesPerHour = Integer.parseInt(scanner.nextLine());
        int daysToRead = Integer.parseInt(scanner.nextLine());
        int hoursToRead = pagesBook/pagesPerHour;
        int hoursPerDay = hoursToRead/daysToRead;
        System.out.println(hoursPerDay);

    }
}
