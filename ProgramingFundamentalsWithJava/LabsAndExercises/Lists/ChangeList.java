import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("end")){
            String[] commandLine = command.split("\\s+");
            int element1 = Integer.parseInt(commandLine[1]);
            switch (commandLine[0]){
                case ("Delete"):
                    while (numbers.contains(element1)){
                    numbers.remove(Integer.valueOf(element1));
                    }
                    break;
                case ("Insert"):
                    int element2 = Integer.parseInt(commandLine[2]);
                    if(element2<numbers.size()){
                    numbers.add(element2,element1);}
                    break;
            }
            command = scanner.nextLine();
        }listPrint(numbers);

    } private static void listPrint(List<Integer> evenNumbers) {
        for (int i = 0; i < evenNumbers.size(); i++) {
            int evenNumbersToPrint = evenNumbers.get(i);
            System.out.print(evenNumbersToPrint + " ");

        }
        System.out.println();
    }
}
