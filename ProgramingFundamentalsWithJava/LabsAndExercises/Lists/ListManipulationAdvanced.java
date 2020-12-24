import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            int numberToPrint = numbers.get(i);
            if (numberToPrint % 2 == 0) {

                evenNumbers.add(numberToPrint);

            } else if (numberToPrint % 2 == 1) {
                oddNumbers.add(numberToPrint);
            }

        }

        while (!command.equals("end")) {
            String[] commandStrings = command.split(" ");


            switch (commandStrings[0]) {


                case ("Contains"):
                    int commandNumber = Integer.parseInt(commandStrings[1]);
                    boolean equalNumber = false;
                    for (int i = 0; i < numbers.size(); i++) {
                        int number = numbers.get(i);

                        if (number == commandNumber) {
                            equalNumber = true;
                        }
                    }
                    if (equalNumber) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");

                    }


                    break;
                case ("Print"):


                    if (commandStrings[1].equals("even")) {
                        listPrint(evenNumbers);


                    }
                    if (commandStrings[1].equals("odd")) {
                        listPrint(oddNumbers);


                    }
                    break;
                case ("Get"):
                    int sum = 0;
                    for (int i = 0; i < numbers.size(); i++) {

                        sum += numbers.get(i);
                    }
                    System.out.print(sum);
                    System.out.println();
                    break;

                case ("Filter"):
                    int commandNumberForCaseFilter = Integer.parseInt(commandStrings[2]);
                    List<Integer> biggerNumbers = new ArrayList<>();
                    List<Integer> biggerOrEqualNumbers = new ArrayList<>();
                    List<Integer> smallerNumbers = new ArrayList<>();
                    List<Integer> smallerrOrEqualNumbers = new ArrayList<>();


                    for (int i = 0; i < numbers.size(); i++) {
                        int numberToPrintFilter = numbers.get(i);
                        if (numberToPrintFilter >= commandNumberForCaseFilter) {

                            biggerOrEqualNumbers.add(numberToPrintFilter);

                        } else if (numberToPrintFilter < commandNumberForCaseFilter) {
                            smallerNumbers.add(numberToPrintFilter);
                        }
                        if (numberToPrintFilter <= commandNumberForCaseFilter) {

                            smallerrOrEqualNumbers.add(numberToPrintFilter);

                        } else if (numberToPrintFilter > commandNumberForCaseFilter) {
                            biggerNumbers.add(numberToPrintFilter);
                        }

                    }

                    if (commandStrings[1].equals(">=")) {
                        listPrint(biggerOrEqualNumbers);


                    } else if (commandStrings[1].equals(">")) {
                        listPrint(biggerNumbers);
                    } else if (commandStrings[1].equals("<=")) {
                        listPrint(smallerrOrEqualNumbers);
                    } else if (commandStrings[1].equals("<")) {
                        listPrint(smallerNumbers);
                    }

                    break;
            }

            command = scanner.nextLine();
        }
    }


    private static void listPrint(List<Integer> evenNumbers) {
        for (int i = 0; i < evenNumbers.size(); i++) {
            int evenNumbersToPrint = evenNumbers.get(i);
            System.out.print(evenNumbersToPrint + " ");

        }
        System.out.println();
    }
}

