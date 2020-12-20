import java.util.Scanner;

public class BasketballTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int totalGames = 0;
        int wins = 0;
        int loses = 0;
        while (!command.equals("End of tournaments")){
            int numGames = Integer.parseInt(scanner.nextLine());

            for(int i = 1; i<=numGames; i++){
                int pointsDesiTeam = Integer.parseInt(scanner.nextLine());
                int pointsEnemyTeam = Integer.parseInt(scanner.nextLine());
                int diff = Math.abs(pointsDesiTeam-pointsEnemyTeam);
                if (pointsDesiTeam>pointsEnemyTeam){
                    wins++;
                    System.out.printf("Game %d of tournament %s: win with %d points.%n", i, command, diff);
                }else {
                    loses++;
                    System.out.printf("Game %d of tournament %s: lost with %d points.%n", i, command, diff);

                }
            }command=scanner.nextLine();
            totalGames += numGames;



        }
        double percentWins = wins*1.0/totalGames*100;
        double percentLoses = loses*1.0/totalGames*100;
        System.out.printf("%.2f%% matches win%n", percentWins);
        System.out.printf("%.2f%% matches lost",percentLoses);

    }
}
