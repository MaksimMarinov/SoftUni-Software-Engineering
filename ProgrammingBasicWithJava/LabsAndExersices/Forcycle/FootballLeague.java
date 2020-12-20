import java.util.Scanner;

public class FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stadium = Integer.parseInt(scanner.nextLine());
        int fansAll = Integer.parseInt(scanner.nextLine());
        int fansA = 0;
        int fansB = 0;
        int fansV = 0;
        int fansG = 0;
        for (int i =1; i <=fansAll; i++){
            String sector = scanner.nextLine();
            switch (sector){
                case ("A"):
                    fansA++;
                    break;
                case ("B"):
                    fansB++;
                    break;
                case ("V"):
                    fansV++;
                    break;
                case ("G"):
                    fansG++;
                    break;
            }


        }  double percentA = fansA*1.0/fansAll*100;
        double percentB = fansB*1.0/fansAll*100;
        double percentV = fansV*1.0/fansAll*100;
        double percentG = fansG*1.0/fansAll*100;
        double percentAll = fansAll*1.0/stadium*100;
        System.out.printf("%.2f%%%n", percentA);
        System.out.printf("%.2f%%%n", percentB);
        System.out.printf("%.2f%%%n", percentV);
        System.out.printf("%.2f%%%n", percentG);
        System.out.printf("%.2f%%", percentAll);

    }
}
