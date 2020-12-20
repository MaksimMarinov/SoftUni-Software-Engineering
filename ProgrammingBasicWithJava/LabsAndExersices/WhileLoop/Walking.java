import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command =  scanner.nextLine();
        int totalSteps = 0;
        while (!command.equals("Going home")) {
            int steps = Integer.parseInt(command);

            totalSteps += steps;
            if (totalSteps >= 10000) {
                int moreSteps = totalSteps - 10000;
                break;

            }
            command = scanner.nextLine();

        }if (command.equals("Going home")) {
            int stepsToHome = Integer.parseInt(scanner.nextLine());
            totalSteps += stepsToHome;

        }
        if (totalSteps >= 10000) {
            int moreSteps = totalSteps - 10000;
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!", moreSteps);
        } else {
            int diffSteps = 10000 - totalSteps;
            System.out.printf("%d more steps to reach goal.", diffSteps);
        }


    }
}
