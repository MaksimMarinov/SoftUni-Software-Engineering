import java.util.Scanner;

public class Snowball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int bestSnowballSnow = 0;
        int bestSnowBallTime = 0;
        double bestSnowBallValue = 0;
        int bestSnowBallQuality = 0;
        for (int i = 1; i <=n ; i++) {
            int snowBallSnow = Integer.parseInt(scanner.nextLine());
            int snowBallTime = Integer.parseInt(scanner.nextLine());
            int snowBallQuality= Integer.parseInt(scanner.nextLine());
            double snowBallVolume = Math.pow((snowBallSnow/snowBallTime),snowBallQuality);
            if (snowBallVolume>bestSnowBallValue){
                bestSnowballSnow = snowBallSnow;
                bestSnowBallTime = snowBallTime;
                bestSnowBallValue = snowBallVolume;
                bestSnowBallQuality = snowBallQuality ;

            }

        }
        System.out.printf("%d : %d = %.0f (%d)", bestSnowballSnow, bestSnowBallTime, bestSnowBallValue, bestSnowBallQuality);
    }
}
