
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double savings = Double.parseDouble(scanner.nextLine());;
        List<Integer> drumsStrengthOriginal = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> drumsStrengthCurrent = new ArrayList<>();
        for (int i = 0; i < drumsStrengthOriginal.size(); i++) {
            drumsStrengthCurrent.add(drumsStrengthOriginal.get(i));
        }
        String command = scanner.nextLine();

        while (!command.equals("Hit it again, Gabsy!")) {
            int power = Integer.parseInt(command);
            for (int i = 0; i < drumsStrengthOriginal.size(); i++) {
                drumsStrengthCurrent.set(i, drumsStrengthCurrent.get(i) - power);}
            for (int i = 0; i <drumsStrengthOriginal.size() ; i++) {



                if (drumsStrengthCurrent.get(i)<=0) {

                    if (savings > drumsStrengthOriginal.get(i) * 3) {
                        drumsStrengthCurrent.set(i, drumsStrengthOriginal.get(i));
                        savings = savings - drumsStrengthOriginal.get(i) * 3;
                    } else {
                        drumsStrengthCurrent.remove(i);
                        drumsStrengthOriginal.remove(i);
                        i=i-1;
                    } }
            }


            command = scanner.nextLine();
        }
        listPrint(drumsStrengthCurrent);
        System.out.printf("%nGabsy has %.2flv.", savings);


    }
    private static void listPrint(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int numbersToPrint = numbers.get(i);
            System.out.print(numbersToPrint + " ");
        }
    }


}
