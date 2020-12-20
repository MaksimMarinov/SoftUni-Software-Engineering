import java.util.Scanner;

public class Grades {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int students = Integer.parseInt(scanner.nextLine());
        double g1 = 0;
        double g2 = 0;
        double g3 = 0;
        double g4 = 0;
        double g5 = 0;
        double sumGrades = 0;
        for (int i=1; i<=students; i++){
           double grades = Double.parseDouble(scanner.nextLine());
           if (grades>=5.00){
               g1 += 1;
           }else if (grades <= 4.99 && grades >= 4.00){
               g2 += 1;
           }else if (grades <= 3.99 && grades >= 3.00){
               g3 += 1;
           } else if (grades <= 3.00 ){
               g4 += 1;}
            sumGrades += grades;

        }
        double g1Persent = g1/students*100;
        double g2Persent = g2/students*100;
        double g3Persent = g3/students*100;
        double g4Persent = g4/students*100;
        double middleGrade = sumGrades/students;
        System.out.printf("Top students: %.2f%%%n", g1Persent);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", g2Persent);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", g3Persent);
        System.out.printf("Fail: %.2f%%%n", g4Persent);
        System.out.printf("Average: %.2f", middleGrade );

    }
}
