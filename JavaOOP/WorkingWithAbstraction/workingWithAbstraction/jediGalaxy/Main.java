package workingWithAbstraction.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

            int[] dimensions = readArray(line);

           Galaxy galaxy = new Galaxy(dimensions[0], dimensions[1]);
           StarsManipulator starsManipulator = new StarsManipulator(galaxy);

            String command = scanner.nextLine();
            long sum = 0;
            while (!command.equals("Let the Force be with you"))
            {
                int[] playerPositions =readArray(command);
                line = scanner.nextLine();
                int[] evilPositions = readArray(line);

               starsManipulator.destroyStars(evilPositions);
               sum+=starsManipulator.sumOfStars(playerPositions);


                command = scanner.nextLine();
            }

        System.out.println(sum);


    }
    private static int[] readArray(String line){
        return Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
