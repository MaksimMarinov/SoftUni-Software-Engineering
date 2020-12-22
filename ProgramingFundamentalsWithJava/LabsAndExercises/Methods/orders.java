import java.util.Scanner;

public class orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int number = Integer.parseInt(scanner.nextLine());
         orders(product, number);

    }
    public static void orders(String product, double number){
       double sum =0;
        switch (product){
            case ("coffee"):
                sum = number*1.5;
                break;
            case ("water"):
                sum = number*1.0;
                break;
            case ("coke"):
                sum = number*1.4;
                break;
            case ("snacks"):
                sum = number*2;
                break;

        }
        System.out.printf("%.2f",sum  );

    }
}
