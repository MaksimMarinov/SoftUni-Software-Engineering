import java.util.Scanner;

public class TournamentOfChristmas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        String command = "";

        int winsTotal = 0;

        int loseTotal = 0;

        double moneyEarnedTotal = 0;
        int winner = 0;
        int looser = 0;
        for (int i = 1; i<=days; i++){
            command = scanner.nextLine();
            int winsPerDay = 0;
            int losePerDay =0;
            double moneyEarnedPerDay = 0;
            while (!command.equals("Finish")){
                String result = scanner.nextLine();
                if (result.equals("win")){
                    winsPerDay++;
                    moneyEarnedPerDay += 20;

                }else{
                    losePerDay++;
                }
                command =scanner.nextLine();
            }if (winsPerDay>losePerDay){
                moneyEarnedPerDay = moneyEarnedPerDay*1.1;
                winner++;


            }else{
                looser++;
            }winsTotal += winsPerDay;
            loseTotal += losePerDay;
            moneyEarnedTotal += moneyEarnedPerDay;

        }
        if (winsTotal > loseTotal){
            moneyEarnedTotal=moneyEarnedTotal*1.2;

        }if(winner>looser){
            System.out.printf("You won the tournament! Total raised money: %.2f", moneyEarnedTotal);

        }else{
            System.out.printf("You lost the tournament! Total raised money: %.2f", moneyEarnedTotal);
        }

    }

}
