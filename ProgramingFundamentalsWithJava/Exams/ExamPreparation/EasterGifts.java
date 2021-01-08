import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasterGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+") ).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("No Money")){
            String[] tokens = command.split("\\s+");
            switch (tokens[0]){
                case ("OutOfStock"):
                    changeNameIfItIsExist(tokens[1],input);

                    break;
                case ("Required"):
                    int index =Integer.parseInt(tokens[2]);
                    changePlacesToNewIndex(tokens[1],index,input);
                    break;
                case ("JustInCase"):
                    replaceWordToLastPlace(tokens[1],input);

                    break;

            }


            command=scanner.nextLine();
        }
        removeUnusedLetters(input,"None");

        printList(input);

    }

    private static void removeUnusedLetters(List<String> input, String none) {
        if(input.contains("None")){
            while ((input.contains("None"))){

                input.remove("None");
            }
        }

    }

    private static void replaceWordToLastPlace(String token, List<String> input) {
        input.set(input.size()-1,token);
    }

    private static void changePlacesToNewIndex(String name, int index, List<String> input) {
        if(index>0&&index<input.size()){
            input.set(index,name);
        }
    }

    private static void changeNameIfItIsExist(String token, List<String> input) {
        if(input.contains(token)){
            while ((input.contains(token))){
                int index = input.indexOf(token);
                input.set(index,"None");
            }
        }
    }

    private static void printList(List<String> input) {
        for (int i = 0; i <input.size(); i++) {
            System.out.print(input.get(i) +" ");

        }
    }
}

