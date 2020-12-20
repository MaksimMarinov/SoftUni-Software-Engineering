import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int freeSeats = 0;
        int stdTickets = 0;
        int studTickets =0;
        int kidsTickets = 0;
        int ticketsPerMovie = 0;
        int totalTickets = 0;
        while (!command.equals("Finish")){
            freeSeats=Integer.parseInt(scanner.nextLine());
            while (true){
                String type = scanner.nextLine();
                if (type.equals("End")){
                    break;
                }
                switch (type) {
                    case "standard":
                        stdTickets++;
                        ticketsPerMovie++;
                        break;
                    case "student":
                        studTickets++;
                        ticketsPerMovie++;

                        break;
                    case "kid":
                        kidsTickets++;
                        ticketsPerMovie++;

                        break;
                }if (ticketsPerMovie==freeSeats){
                    break;
                }
            }
            double percentSold = ticketsPerMovie*1.0/freeSeats*100;
            System.out.printf("%s - %.2f%% full.%n", command, percentSold);
            command=scanner.nextLine();
            totalTickets +=ticketsPerMovie;
            ticketsPerMovie=0;

        }
        System.out.printf("Total tickets: %d%n", totalTickets);
        double percentKidsTickets = kidsTickets*1.0/totalTickets*100;
        double percentStdTickets = stdTickets*1.0/totalTickets*100;
        double percentStudTickets = studTickets*1.0/totalTickets*100;
        System.out.printf("%.2f%% student tickets.%n", percentStudTickets);
        System.out.printf("%.2f%% standard tickets.%n", percentStdTickets);
        System.out.printf("%.2f%% kids tickets.", percentKidsTickets);

    }
}
