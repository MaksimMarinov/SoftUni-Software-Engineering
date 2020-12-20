import java.util.Scanner;

public class EasterCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cakes = Integer.parseInt(scanner.nextLine());
        int bestScore=0;

        String winner = "";
        for (int i = 1; i <= cakes; i++) {
            String name = scanner.nextLine();
            String command = scanner.nextLine();
            int gradTotal = 0;
            while (!command.equals("Stop")) {
                int grad = Integer.parseInt(command);
                gradTotal += grad;
                command = scanner.nextLine();
            }
            System.out.printf("%s has %d points.%n", name, gradTotal);
            if (gradTotal>bestScore){
                bestScore=gradTotal;
                winner = name;
                System.out.printf("%s is the new number 1!%n", winner);
            }

        }
        System.out.printf("%s won competition with %d points!", winner, bestScore );

    }
}
