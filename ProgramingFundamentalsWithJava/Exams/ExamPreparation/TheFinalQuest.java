import java.util.*;
import java.util.stream.Collectors;

public class TheFinalQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("Stop")){
            String[] tokens = command.split(" ");
            switch (tokens[0]){
                case ("Delete"):
                    int index= Integer.parseInt(tokens[1]);
                    deleteIndex(input,index);
                    break;
                case ("Swap"):
                    swap(tokens[1],tokens[2], input);
                    break;
                case ("Put"):
                    put(tokens[1],Integer.parseInt(tokens[2]), input);
                    break;
                case ("Sort"):
                    input.sort(Collections.reverseOrder());
                    break;
                case ("Replace"):
                    replaceWords(tokens[1],tokens[2], input);
                    break;



            }


            command= scanner.nextLine();
        }
        for (String s : input) {
            System.out.print(s+" ");
        }


    }

    private static void replaceWords(String word1, String word2, List<String> input) {
        if(input.contains(word2)){
            int index = input.indexOf(word2);
            input.set(index,word1);
        }

    }

    private static void put(String token, int index, List<String> input) {
        if(index>0&&index<=input.size()+1){
            input.add(index-1,token);
        }

    }

    private static void swap(String s, String s1, List<String> input) {
            if(input.contains(s)&&input.contains(s1)){
                int index1 = input.indexOf(s);
                int index2 = input.indexOf(s1);
                input.set(index1,s1);
                input.add(index2,s);
                input.remove(index2+1);}
    }

    private static void deleteIndex(List<String> input, int index) {
        if(index>=-1&&index<input.size()-1){
            input.remove(index+1);
        }
    }
}
