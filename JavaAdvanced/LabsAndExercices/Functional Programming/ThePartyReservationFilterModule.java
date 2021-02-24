import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        Map<String, Predicate<String>> predicates = new HashMap<>();
        while (!command.equals("Print")) {
            String[] tokens = command.split(";");
            String predicateName = tokens[1]+tokens[2];
               if(tokens[0].contains("Add")){
                Predicate<String> predicate = getPredicate(tokens);
                predicates.put(predicateName, predicate );
               }else{
                predicates.remove(predicateName);
               }

            command = scanner.nextLine();
        }
       names.stream().filter(guest->{
           boolean isValid = true;
           for (Predicate<String> predicate : predicates.values()) {
               if(predicate.test(guest)){
                   isValid=false;
                   break;
               }
           }
           return isValid;
       }).forEach(e-> System.out.print(e+" "));
    }

    public static Predicate<String> getPredicate(String[] tokens) {
        Predicate<String> predicate = null;
        switch (tokens[1]) {
            case "StartsWith":
                predicate = name -> name.startsWith(tokens[2]);
                break;
            case "EndsWith":
                predicate = name -> name.endsWith(tokens[2]);
                break;
            case "Length":
                predicate = name -> name.length() == Integer.parseInt(tokens[2]);
                break;
            default:
                predicate = name -> name.contains(tokens[2]);
                break;
        }
        return predicate;
    }
}
