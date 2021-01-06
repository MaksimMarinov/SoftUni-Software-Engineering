import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String reg = "\\+359([- ])2\\1[\\d]{3}\\1[\\d]{4}\\b";
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(reg);
        Matcher matchPhoneNumber = pattern.matcher(input);
        List<String> phoneNumbers = new ArrayList<>();
        while (matchPhoneNumber.find()){
            phoneNumbers.add(matchPhoneNumber.group());
        }
        System.out.print(String.join(", ",phoneNumbers));

    }
}
