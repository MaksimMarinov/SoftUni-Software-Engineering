import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = Double.parseDouble(scanner.nextLine());
        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();
        double number1 = 0;
        if (word1.equals("mm") && word2.equals("cm")) {
            number1 = number / 10;
        } else if (word1.equals("mm") && word2.equals("m")) {
            number1 = number / 1000;}
        else if (word1.equals("cm") && word2.equals("m")) {
            number1 = number / 100;
           }
        else if (word1.equals("cm") && word2.equals("mm")) {
            number1 = number * 10;
            }
        else if (word1.equals("m") && word2.equals("mm")) {
            number1 = number * 1000; }
        else if (word1.equals("m") && word2.equals("cm")) {
            number1 = number * 100;
            }
        System.out.printf("%.3f",number1);


        }
    }
