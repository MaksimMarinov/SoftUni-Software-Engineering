import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());
        String command = scanner.nextLine();
        while(!command.equals("Decode")){
            String[] tokens=command.split("\\|+");
            switch (tokens[0]){
                case("Move"):
                    int n = Integer.parseInt(tokens[1]);
                    for (int i = 0; i <n ; i++) {
                        String letterToRemove=input.get(0);

                        input.add(input.size(),letterToRemove);
                        input.remove(letterToRemove);
                    }
                    break;
                case("Insert"):
                    int n1 = Integer.parseInt(tokens[1]);
                    String[] secondIndex = tokens[2].split("");
                    if(secondIndex.length==1){
                        input.add(n1, tokens[2] );

                    }else{
                        for (int i = 0; i <secondIndex.length ; i++) {
                            input.add(n1,secondIndex[i]);
                            n1=n1+1;

                        }
                    }





                    break;
                case ("ChangeAll"):
                    String letterToChange = tokens[1];
                    while (input.contains(letterToChange)){
                        int index = input.indexOf(letterToChange);
                        input.set(index,tokens[2]);
                    }
                    break;
            }


            command=scanner.nextLine();
        }
        System.out.print("The decrypted message is: ");
        for (String s : input) {
            System.out.print(s);

        }

    }
}
