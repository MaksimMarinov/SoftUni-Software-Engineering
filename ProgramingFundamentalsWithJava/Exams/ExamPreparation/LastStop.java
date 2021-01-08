import java.util.*;
import java.util.stream.Collectors;

public class LastStop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String command = scanner.nextLine();
        while(!command.equals("END")){
            String[] tokens = command.split("\\s+");
            switch (tokens[0]){
                case ("Change"):
                    changePlaces(tokens,numbers);
                    break;
                case ("Hide"):
                    hide(tokens,numbers);
                    break;
                case ("Switch"):
                    swapPaintings(numbers,tokens);
                    break;
                case ("Insert"):
                    insert(numbers,tokens);
                    break;
                case ("Reverse"):
                   Collections.reverse(numbers);
                    break;
            }

            command= scanner.nextLine();
        }
        for (String number : numbers) {
            System.out.print(number+" ");

        }

    }

    private static void insert(List<String> numbers, String[] tokens) {
        int index = Integer.parseInt(tokens[1]);
        if(index>=-1&&index<numbers.size()){
            numbers.add(index+1, tokens[2]);
        }

    }

    private static void hide(String[] tokens, List<String> numbers) {
       String number = tokens[1];
        if(numbers.contains(number)){
            numbers.remove(number);
        }
    }

    private static void changePlaces(String[] tokens, List<String> numbers) {
        int index1 = numbers.indexOf(tokens[1]);
        String numberToChange = tokens[2];

        if( index1>=0&&index1<numbers.size()){
            numbers.set(index1,numberToChange);
        }
    }
    private static void swapPaintings(List<String> input, String[]tokens) {
        if(input.contains(tokens[1])&&input.contains(tokens[2])){
            int index1 = input.indexOf(tokens[1]);
            int index2 = input.indexOf(tokens[2]);
            input.set(index1,tokens[2]);
            input.add(index2,tokens[1]);
            input.remove(index2+1);}
    }
}
