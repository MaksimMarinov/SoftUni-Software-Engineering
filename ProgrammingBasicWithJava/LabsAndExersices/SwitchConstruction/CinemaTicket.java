import java.util.Scanner;

public class CinemaTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String day = scanner.nextLine();
        if (day.equals("Monday") || day.equals("Friday") || day.equals("Tuesday")){
            System.out.println(12);
        } else if (day.equals("Thursday") || day.equals("Wednesday")){
            System.out.println(14);}
            else {
                System.out.println(16);
            }
        }
    }

