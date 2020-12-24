import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers1 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> numbers2 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> merged = new ArrayList<>();
        int startIndex = 0;
        int endIndex = 0;
        if (numbers1.size() > numbers2.size()) {
           merged =  returnMergedList1(numbers1, numbers2);
            if (numbers1.get(numbers1.size() - 1) > numbers1.get(numbers1.size() - 2)) {
                startIndex = numbers1.get(numbers1.size() - 2);
                endIndex = numbers1.get(numbers1.size() - 1);
            } else if (numbers1.get(numbers1.size() - 2) > numbers1.get(numbers1.size() - 1))
            {
                startIndex = numbers1.get(numbers1.size() - 1);
                endIndex = numbers1.get(numbers1.size() - 2);

            }

        } else if (numbers2.size() > numbers1.size()) {
         merged =    returnMergedList2(numbers1, numbers2);
            if (numbers2.get(0) > numbers2.get(1)) {
                startIndex = numbers2.get(1);
                endIndex = numbers2.get(0);
            } else if (numbers2.get(0) < numbers2.get(1)) {
                startIndex = numbers2.get(0);
                endIndex = numbers2.get(1);

            }

        }
        Collections.sort(merged);
        if(startIndex>endIndex){

            listPrint(merged, endIndex, startIndex);
        }else if(startIndex<endIndex){
            listPrint(merged, startIndex, endIndex);
        }


    }

    private static List<Integer> returnMergedList1(List<Integer> list1, List<Integer> list2) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < list2.size(); i++) {
            output.add(list1.get(i));
            output.add(list2.get(list2.size() - i - 1));
        }
        return output;


    }

    private static void listPrint(List<Integer> numbers, int index1, int index2) {
        for (int i = 0; i < numbers.size(); i++) {
            int numbersToPrint = numbers.get(i);
            if(numbersToPrint>index1&&numbersToPrint<index2){
                System.out.print(numbersToPrint + " ");
            }

        }
    }
    private static List<Integer> returnMergedList2(List<Integer> list1, List<Integer> list2) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            output.add(list1.get(i));
            output.add(list2.get(list2.size() - i - 1));
        }
        return output;}
}



