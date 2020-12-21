import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
     int n = Integer.parseInt(scanner.nextLine());
     Map<String, List<String>> synonyms = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();
            List<String> currentSynonyms = synonyms.computeIfAbsent(word, k -> new ArrayList<>());
            currentSynonyms.add(synonym);

        }
        for (Map.Entry<String, List<String>> entry : synonyms.entrySet()) {
            System.out.println(entry.getKey() + " - " + String.join(", ", entry.getValue()));
        }

    }  
  
}
