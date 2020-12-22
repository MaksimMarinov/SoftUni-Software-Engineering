import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input){
            case ("int"):
                int number = Integer.parseInt(scanner.nextLine());
                result(number);
                break;
            case("real"):
                double realNumber = Double.parseDouble(scanner.nextLine());
                result(realNumber);
                break;
            case ("string"):

                String word = scanner.nextLine();
                result(word);

                break;
        }

    }

    private static void result(String word) {
        System.out.println("$" + word + "$");

    }  private static void result(int number) {
        System.out.println(number*2);

    }
    private static void result(double realNumber) {
        System.out.printf("%.2f",realNumber*1.5);

    }
}
