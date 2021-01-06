import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        double sum =0;
        while (!command.equals("end of shift")){
            Pattern pattern = Pattern.compile(("^%(?<name>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$$"));


            Matcher matcherForName = pattern.matcher(command);
            while(matcherForName.find()){
                String name = matcherForName.group("name");
                String product = matcherForName.group("product");
                int count = Integer.parseInt(matcherForName.group("count"));
                double price = Double.parseDouble(matcherForName.group("price"));
                System.out.printf("%s: %s - %.2f%n", name, product, price*count);
                sum+=(count*price);
            }




            command= scanner.nextLine();
        }
        System.out.printf("Total income: %.2f",sum);

    }
}
