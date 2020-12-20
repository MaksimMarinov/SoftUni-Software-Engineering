import java.util.Scanner;

public class Balls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =Integer.parseInt(scanner.nextLine());
        int totalPoints = 0;
        int countRed =0;
        int countOrange = 0;
        int countYellow =0;
        int countBlack = 0;
        int countWhite = 0;
        int countOthers = 0;
        for (int i =1; i<=n; i++) {
            String colour = scanner.nextLine();
            switch (colour){
                case ("red"):
                    totalPoints += 5;
                    countRed++;
                    break;
                case ("orange"):
                    totalPoints += 10;
                    countOrange++;
                    break;
                case ("yellow"):
                    totalPoints += 15;
                    countYellow++;
                    break;
                case ("white"):
                    totalPoints += 20;
                    countWhite++;
                    break;
                case ("black"):
                        totalPoints /= 2;
                        countBlack++;
                        break;
                default:
                    countOthers++;
                    break;


            }

        }
        System.out.printf("Total points: %d%n", totalPoints);
        System.out.printf("Points from red balls: %d%n", countRed);
        System.out.printf("Points from orange balls: %d%n", countOrange);
        System.out.printf("Points from yellow balls: %d%n", countYellow);
        System.out.printf("Points from white balls: %d%n", countWhite);
        System.out.printf("Other colors picked: %d%n", countOthers);
        System.out.printf("Divides from black balls: %d", countBlack);

    }
}
