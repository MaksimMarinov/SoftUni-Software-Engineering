import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();
        String countRegex = "(?i)[star]";
        Pattern countPattern = Pattern.compile(countRegex);
        String validMessageRegex = "@(?<name>[A-Za-z]*)[^@\\-!:>]*:(?<population>\\d+)[^@\\-!:>]*!(?<type>[A|D])![^@\\-!:>]*->*(?<soliders>\\d+)";
        Pattern validMsgPattern = Pattern.compile(validMessageRegex);
        for (int i = 0; i < n; i++) {


            String input = scanner.nextLine();
            Matcher matcher = countPattern.matcher(input);
            int count=0;
           while (matcher.find()){
               count++;
           }
           StringBuilder decryptedMessage = new StringBuilder();
            for (int j = 0; j < input.length(); j++) {
                decryptedMessage.append((char)(input.charAt(j)-count));
            }
            matcher= validMsgPattern.matcher(decryptedMessage.toString());
            if(matcher.find()){
                String planet = matcher.group("name");
               String type = matcher.group("type");
                if(type.equals("A")){
                attacked.add(planet);
                }else{
                    destroyed.add(planet);
                }
            }


        }
        System.out.println("Attacked planets: "+ attacked.size());
        attacked.stream().sorted((a,b)->a.compareTo(b)).forEach(e-> System.out.println("-> "+e));
        System.out.println("Destroyed planets: "+destroyed.size());
        destroyed.stream().sorted((a,b)->a.compareTo(b)).forEach(e-> System.out.println("-> "+e));

    }
}
