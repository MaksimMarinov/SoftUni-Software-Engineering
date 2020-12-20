import java.util.Scanner;

public class Fishtank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());
        int volume = length * width * height;
        double litresSum = volume * 0.001;
        double percentAfter = percent/100;
        double litresNeed = litresSum * (1-percentAfter);
        System.out.printf("%.2f", litresNeed);






    }
}
