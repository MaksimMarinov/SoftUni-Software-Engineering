import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    static List<String> names=null;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        names = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("Party!")) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]){
                case"Double":
                addOneMore(getPredicate(tokens));
                    break;
                case"Remove":
                removeName(getPredicate(tokens));
                    break;
            }

            command = scanner.nextLine();
        }
        if(names.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else{
            String result=names.stream().sorted(String::compareTo).collect(Collectors.joining(", "));
            System.out.println(result + " are going to the party!");
        }
    }

    private static void removeName(Predicate<String> predicate) {
        names.removeIf(predicate);
    }

    private static void addOneMore(Predicate<String> predicate) {
        List<String> namesToAdd = new ArrayList<>();
        names.stream().filter(predicate).forEach(namesToAdd::add);
        names.addAll(namesToAdd);
    }

    public static Predicate<String> getPredicate(String[] tokens){
        Predicate<String> predicate = null;
        if(tokens[1].equals("StartsWith")){
            predicate = name->name.startsWith(tokens[2]);
        }else if(tokens[1].equals("EndsWith")){
            predicate = name->name.endsWith(tokens[2]);
        }else{
            predicate = name->name.length()== Integer.parseInt(tokens[2]);
        }
        return predicate;
    }

}
