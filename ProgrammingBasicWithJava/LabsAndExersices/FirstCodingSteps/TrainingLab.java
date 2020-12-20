import java.util.Scanner;

public class TrainingLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double w = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double rows = Math.floor(((h*100)-100)/70);
        double columns = Math.floor((w*100)/120);
        double desksSum = rows*columns-3;

        System.out.printf("%.0f", desksSum);








    }
}
