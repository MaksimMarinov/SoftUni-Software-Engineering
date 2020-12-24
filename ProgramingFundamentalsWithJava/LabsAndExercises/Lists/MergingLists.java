import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list1 = parseLineOfNumbers(scanner);
        List<Integer> list2 = parseLineOfNumbers(scanner);
        List<Integer> mergedList = new ArrayList<>();
        int indexFirst = 0;
        int indexSecond =0;
        while (indexFirst<list1.size()||indexSecond<list2.size() ){
            if (indexFirst<list1.size()){
                mergedList.add(list1.get(indexFirst++));

            }
            if (indexSecond<list2.size()){
                mergedList.add(list2.get(indexSecond++));

            }



        }

        for(int number : mergedList ){
            System.out.print(number + " ");
        }
        
    }

    private static List<Integer> parseLineOfNumbers(Scanner scanner) {
        String line = scanner.nextLine();
        String[] array = line.split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String s : array) {
           int number = Integer.parseInt(s);
           numbers.add(number);


        }return numbers;
    }
}
