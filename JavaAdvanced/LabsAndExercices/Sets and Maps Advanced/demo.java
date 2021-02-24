import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> studentsInfo = new TreeMap<>();
        String command = scanner.nextLine();
        String regex = "IP=(?<IP>\\d{3}.\\d{2}.\\d{2}.\\d{2}.)message='(?<message>[^']+)' user=(?<user>\\w+)";
        Pattern pattern = Pattern.compile(regex);
        while (!command.equals("end")){
            Matcher matcher = pattern.matcher(command);
while (matcher.find()){
    String user = matcher.group(3);
    String message = matcher.group(2);

    System.out.println(message);
    System.out.println(user);
}


            command= scanner.nextLine();
        }
    }



}
