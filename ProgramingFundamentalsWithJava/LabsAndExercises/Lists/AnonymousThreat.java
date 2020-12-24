import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
      String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("3:1")) {

            int startIndex = Integer.parseInt(command[1]);
            int endIndex = Integer.parseInt(command[2]);
            String concatWord = "";
            if (endIndex > input.size() - 1 || endIndex < 0)
            {
                endIndex = input.size() - 1;
            }
            if (startIndex < 0 || startIndex > input.size())
            {
                startIndex = 0;
            }

            switch (command[0]) {
                case ("merge"):
                    for (int i = startIndex; i <endIndex ; i++) {
                        concatWord += input.get(i);
                    }





                    break;

                case ("divide"):
                    break;
            }


            command = scanner.nextLine().split(" ");
        }

    }

    private static String addLetters(int index, List<String> letters){
        String output ="";
        for (int i = 0; i < index ; i++) {
            output+=letters.get(i);
        }return output;
    }
    private static List<Integer> removeLetters(int index, List<Integer> letters){
        for (int i = 0; i < index ; i++) {
            letters.remove(0);

        }return letters;
    }
}

