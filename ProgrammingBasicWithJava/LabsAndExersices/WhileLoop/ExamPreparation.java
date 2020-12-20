import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int failedTreshold = Integer.parseInt(scanner.nextLine());
        int failedTimes = 0;
        int solvedProblems = 0;
        double gradeSum = 0;
        String lastProblem = "";
        boolean isFailed = true;
        while (failedTimes < failedTreshold){
            String name = scanner.nextLine();
            if ("Enough".equals(name)){
                isFailed = false;
                break;
            }
            int grade = Integer.parseInt(scanner.nextLine());
            if (grade<=4){
                failedTimes++;
            }
            gradeSum += grade;
            solvedProblems++;
            lastProblem=name;


        }if (isFailed){
            System.out.printf("You need a break, %d poor grades.", failedTreshold);
        }else {
            System.out.printf("Average score: %.2f%n", gradeSum/solvedProblems);
            System.out.printf("Number of problems: %d%n", solvedProblems);
            System.out.printf("Last problem: %s", lastProblem );

        }




    }
}
