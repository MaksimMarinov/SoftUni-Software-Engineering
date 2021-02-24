import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, List<String>>> continentsInfo = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-->0){
            String[] tokens = scanner.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];
            continentsInfo.putIfAbsent(continent, new LinkedHashMap<>() );
            continentsInfo.get(continent).putIfAbsent(country, new ArrayList<>());
            continentsInfo.get(continent).get(country).add(city);
        }
        continentsInfo.entrySet().stream().forEach(continent->{
            System.out.println(continent.getKey()+":");
            continent.getValue().entrySet().stream().forEach(country->{
                System.out.printf("  %s -> ", country.getKey());
                for (int i = 0; i < country.getValue().size(); i++) {
                    String separator = ", ";
                    if(i==country.getValue().size()-1){
                        separator="";
                    }
                    System.out.printf("%s%s", country.getValue().get(i), separator);
                }
                System.out.println();
            });
        });
    }
}
