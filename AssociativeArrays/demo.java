import java.util.*;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, List<String>> webSide = new TreeMap<>();


       webSide.put("a", new ArrayList<>());
       webSide.put("b", new ArrayList<>());

       webSide.get("b").add("c");
       webSide.get("b").add("d");
        webSide.get("a").add("a");
        webSide.get("a").add("b");
        webSide.get("a").add("d");
        webSide.entrySet().stream().filter(e->e.getValue().size()>0)
                .sorted(Map.Entry.<String, List<String>>comparingByValue(Comparator.comparing(List::size)).reversed()).forEach(e->{
            System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
            e.getValue().stream().sorted(String::compareTo).forEach(s->
                    System.out.println("" +
                            "! "+s));
        });
        /*webSide.entrySet().stream().filter(e->e.getValue().size()>0)
                .sorted(Map.Entry.<String, List<String>>comparingByValue(Comparator.comparing(List::size)).reversed())
                .forEach(e->{
                    System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
                    e.getValue().stream().sorted(String::compareTo).forEach(s->
                            System.out.println("! "+s));
                });*/

    }
}