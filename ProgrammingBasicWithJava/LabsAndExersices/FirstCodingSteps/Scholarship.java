import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double income = Double.parseDouble(scanner.nextLine());
        double averageGrate = Double.parseDouble(scanner.nextLine());
        double minimalSalary = Double.parseDouble(scanner.nextLine());
        double socialScholarship = Math.floor(0.35 * minimalSalary);
        double excelentScolarship = Math.floor(averageGrate * 25);
        if (income >= minimalSalary && averageGrate < 5.5) {
                System.out.println("You cannot get a scholarship!");
        } else if (income >= minimalSalary && averageGrate >= 5.5) {
                System.out.printf("You get a scholarship for excellent results %.0f BGN", excelentScolarship);

        }else if (income < minimalSalary && averageGrate <= 4.5 ) {
                    System.out.println("You cannot get a scholarship!");
        } else if (income < minimalSalary && averageGrate > 4.5 && averageGrate < 5.5) {
                    System.out.printf("You get a Social scholarship %.0f BGN", socialScholarship);
        }else if (income < minimalSalary) {
                if (averageGrate > 5.5 && excelentScolarship >= socialScholarship) {
                    System.out.printf("You get a scholarship for excellent results %.0f BGN", excelentScolarship);
                } else if (averageGrate > 5.5 && excelentScolarship < socialScholarship) {
                    System.out.printf("You get a Social scholarship %.0f BGN", socialScholarship);
                }
            }

    }



}
