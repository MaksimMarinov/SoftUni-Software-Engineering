import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String destination = scanner.nextLine();

        while (!destination.equals("End")){
            double budget = Double.parseDouble(scanner.nextLine());
            double sum =0;
            while (true){
                double amountSaved = Double.parseDouble(scanner.nextLine());
                sum += amountSaved;
                if (sum>=budget){
                    System.out.printf("Going to %s!%n",destination);
                    break;
                }


            } destination = scanner.nextLine();
        }
    }
}
