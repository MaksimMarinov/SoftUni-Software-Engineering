import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list1 = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        String command = scanner.nextLine();

        while(!command.equals("end")){
            String[] commandByStrings = command.split(" ");
            switch (commandByStrings[0]) {
                case "Add":

                    list1.add(commandByStrings[1]);
                    break;
                case "Remove":
                    String numberToRemove = commandByStrings[1];
                    list1.remove(numberToRemove);
                    break;
                case "RemoveAt":

                    int intToRemove = Integer.parseInt(commandByStrings[1]);
                    list1.remove(intToRemove);
                    break;
                case "Insert":
                    String intIndexToInsert = commandByStrings[1];
                    int intToInsert = Integer.parseInt(commandByStrings[2]);
                    list1.add(intToInsert, intIndexToInsert);


                    break;
            }
    command=scanner.nextLine();

        }
        System.out.println(String.join(" ", list1));



    }

}
