import java.lang.invoke.SwitchPoint;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("Craft!")){
            String[] tokens = command.split(" - ");
            switch (tokens[0]){
                case("Collect"):
                    collect(input, tokens[1]);
                    break;
                case("Drop"):
                    drop(input,tokens[1]);
                    break;
                case("Combine Items"):
                    String[] combine = tokens[1].split("\\:+");
                    combineItems(input, combine[0], combine[1]);
                    break;
                case("Renew"):
                    renew(input,tokens[1]);
                    break;
            }

            command= scanner.nextLine();
        }
        for (int i = 0; i < input.size(); i++) {
            System.out.print(input.get(i));
            if(i<input.size()-1){
            System.out.print(", ");}

        }


    }

    private static void renew(List<String> input, String token) {
        if(input.contains(token)){
            input.remove(token);
            input.add(token);
        }
    }

    private static void drop(List<String> input, String token) {
        while (input.contains(token)){
            input.remove(token);
        }
    }

    private static void collect(List<String> input, String token) {
        if(!input.contains(token)){
            input.add(token);
        }
    }
    private static void combineItems(List<String> input, String s, String s1) {
        if(input.contains(s)){
            int index1 = input.indexOf(s);
            input.add(index1+1,s1);
            }
    }
}
