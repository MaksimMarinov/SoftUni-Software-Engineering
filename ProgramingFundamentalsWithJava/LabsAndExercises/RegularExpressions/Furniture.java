import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double sum = 0;
        System.out.println("Bought furniture:");
        while (!input.equals("Purchase")) {
            String regex = ">>(?<name>[A-Za-z]+)<<(?<price>\\d+\\.?\\d*)!(?<quantity>\\d+)";
            //String regex="^>+([?<name>A-Z{0,}a-z]+)+<<(?<price>\\d+\\.?\\d+)+!([?<quantity>\\d+]+)\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
               String name = matcher.group(1);
                double price = Double.parseDouble(matcher.group("price"));
                double quantity = Double.parseDouble(matcher.group(3));
                sum += (price * quantity);
                System.out.println(name);
            }

        input= scanner.nextLine();
        }

        System.out.printf("Total money spend: %.2f",sum);
    }
}
