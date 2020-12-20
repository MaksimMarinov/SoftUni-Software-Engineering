import java.util.Scanner;

public class TennisRanklist {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        double pointsStart = Integer.parseInt(scanner.nextLine());
        double points = 0;
        double wins = 0;
        for (int i= 1; i<=num; i++){
            String result = scanner.nextLine();
            if (result.equals("W")){
                points = points+2000;
                wins++;
            }else if (result.equals("F")){
                points= points +1200;
            }else if (result.equals("SF")){
                points = points +720;
            }
        } pointsStart = points + pointsStart;
        double pointsAvarage = Math.floor(points/num);
        double percent = wins/num*100;
        System.out.printf("Final points: %.0f%n", pointsStart);
        System.out.printf("Average points: %.0f%n", pointsAvarage);
        System.out.printf("%.2f%%", percent);




    }
}
