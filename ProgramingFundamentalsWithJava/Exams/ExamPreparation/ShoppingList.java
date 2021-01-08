import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split("\\!+")).collect(Collectors.toList());
       String command = scanner.nextLine();
       while (!command.equals("Go Shopping!")){
           String[] tokens = command.split("\\s+");
           switch (tokens[0]){
               case ("Urgent"):
                   if(!ifContains(input, tokens[1])){
                       input.add(0,tokens[1]);
                   }
                   break;
               case ("Unnecessary"):
                   if(ifContains(input, tokens[1])){
                       input.remove(tokens[1]);
                   }
                   break;
               case ("Correct"):
                   if(ifContains(input, tokens[1])){
                       int index = input.indexOf(tokens[1]);
                       input.set(index, tokens[2]);
                   }
                   break;
               case ("Rearrange"):
                   if(ifContains(input, tokens[1])){
                       input.remove(tokens[1]);
                       input.add(tokens[1]); }
                   break;


           }



           command=scanner.nextLine();

        }
        for (int i = 0; i <input.size()-1 ; i++) {
            System.out.print(input.get(i) + ", ");

        }
        System.out.print(input.get(input.size()-1));

    }
    public static boolean ifContains(List<String> input, String check){
    boolean ifContains=false;
            for (int i = 0; i <input.size() ; i++) {
        if(input.contains(check)){
            return true;
        }

    }return false;
}
}
