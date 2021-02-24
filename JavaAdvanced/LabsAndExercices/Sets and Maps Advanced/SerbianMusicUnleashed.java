import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianMusicUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Map<String, Integer>> concerts = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")){

            String regex = "(?<singer>[\\w\\s]+)\\s@(?<venue>[a-zA-z\\s]+)\\s(?<price>\\d+)\\s(?<tickets>\\d+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()){
                String singer= matcher.group("singer");
                String venue = matcher.group("venue");
                int price = Integer.parseInt(matcher.group("price"));
                int capacity = Integer.parseInt(matcher.group("tickets"));
                if(!concerts.containsKey(venue)){
                    concerts.put(venue,new LinkedHashMap<>());
                    concerts.get(venue).put(singer, price*capacity);
                }else{
                    if(!concerts.get(venue).containsKey(singer)){
                        concerts.get(venue).put(singer, price*capacity);
                    }else{
                        int currentCapacity = concerts.get(venue).get(singer);
                        concerts.get(venue).put(singer, currentCapacity+price*capacity);
                    }
                }
            }



            input = scanner.nextLine();
        }
        concerts.entrySet().stream().forEach(venue->{
            System.out.println(venue.getKey());
            venue.getValue().entrySet().stream().sorted((a,b)->Integer.compare(b.getValue(),a.getValue()))
                    .forEach(singer->{
                        System.out.printf("#  %s -> %d%n", singer.getKey(), singer.getValue());
                    });
        });
    }
}
