import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String movie = scanner.nextLine();
        int studentsTickets = 0;
        int standardTickets = 0;
        int kidsTickets = 0;
        int totalTicket =0;
        while(!movie.equals("Finish")){
            int freeSeats = Integer.parseInt(scanner.nextLine());
            int takenSeats = 0;


            while (true){
                String ticketType = scanner.nextLine();

                takenSeats ++;
                if (ticketType.equals("End")){
                    break;

                }if (freeSeats <= takenSeats){
                    break;
                }totalTicket++;
                if (ticketType.equals("Student")){
                studentsTickets++;}
                else if(ticketType.equals("Kid")){
                    kidsTickets++;}
                else if(ticketType.equals("Standard")){
                    standardTickets++;}
                double percentTakenSeats = takenSeats*1.0/freeSeats*100;
                System.out.printf("%s - %.2f full.", percentTakenSeats);
                movie = scanner.nextLine();

            }if (movie.equals("Finish")){
                System.out.printf("Total tickets: %d%n", totalTicket);
                double perSt = studentsTickets*1.0/totalTicket*100;
                System.out.printf("%.2f%% student tickets.", perSt);
                double perStan = standardTickets*1.0/totalTicket*100;
                System.out.printf("%.2f%% student tickets.", perStan);
                double perK = kidsTickets*1.0/totalTicket*100;
                System.out.printf("%.2f%% student tickets.", perSt);


            }


        }
    }
}
