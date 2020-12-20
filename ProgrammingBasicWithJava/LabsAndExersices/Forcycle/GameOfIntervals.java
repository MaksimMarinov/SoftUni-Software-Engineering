import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tours = Integer.parseInt(scanner.nextLine());
        double score = 0;
        double score1 = 0;
        double score2 = 0;
        double score3 = 0;
        double score4 = 0;
        double score5 = 0;
        double score6 = 0;
        double totalScore = 0;
        for (int i = 1; i<=tours; i++){
            double numbers = Double.parseDouble(scanner.nextLine());
            if (numbers>=0 && numbers<=9) {
               score = 0.2*numbers;
                score1 += 1;}
            else if (numbers>=10 && numbers<=19){
               score = 0.3*numbers;
            score2 += 1;}
            else if (numbers>=20 && numbers<=29){
                score = 0.4*numbers;
                score3 += 1;}
            else if (numbers>=30 && numbers<=39){
                score = 50;
                score4 += 1;}
            else if (numbers>=40 && numbers<=50){
               score = 100;
                score5 += 1;}
            else {
                score = totalScore/2 - totalScore;
                score6 += 1;}

                totalScore += score;
            }double scorePer1 = score1/tours*100;
        double scorePer2 = score2/tours*100;
        double scorePer3 = score3/tours*100;
        double scorePer4 = score4/tours*100;
        double scorePer5 = score5/tours*100;
        double scorePer6 = score6/tours*100;

        System.out.printf("%.2f%n", totalScore);
        System.out.printf("From 0 to 9: %.2f%%%n", scorePer1);
        System.out.printf("From 10 to 19: %.2f%%%n", scorePer2);
        System.out.printf("From 20 to 29: %.2f%%%n", scorePer3);
        System.out.printf("From 30 to 39: %.2f%%%n", scorePer4);
        System.out.printf("From 40 to 50: %.2f%%%n", scorePer5);
        System.out.printf("Invalid numbers: %.2f%%", scorePer6);



        }
    }

