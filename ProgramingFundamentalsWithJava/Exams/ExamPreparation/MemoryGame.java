import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        int count = 0;
        while(!command.equals("end")){
            String[] indexes = command.split("\\s+");
            int index1= Integer.parseInt(indexes[0]);
            int index2= Integer.parseInt(indexes[1]);
        count++;
            checkIsCorect(index1,index2,input);
            if (!checkIsCorect(index1,index2,input)) {
                System.out.println("Invalid input! Adding additional elements to the board");
                addTwoElementsInTheMiddle(input,count);

            }else{
                checkIsMatch(index1,index2,input);
            }
            if(input.isEmpty()){
                System.out.printf("You have won in %d turns!",count);
                return;
            }
            command= scanner.nextLine();
        }
        System.out.println("Sorry you lose :(");
        for (String s : input) {
            System.out.print(s+" ");
        }

    }

    private static void checkIsMatch(int index1, int index2, List<String> input) {
        if(input.get(index1).equals(input.get(index2))){
            System.out.printf("Congrats! You have found matching elements - %s!%n", input.get(index1));
            if(index1>index2){
                input.remove(index2);
                input.remove(index1-1);
            }else{
                input.remove(index1);
                input.remove(index2-1);

            }

        }else{
            System.out.println("Try again!");
        }
    }

    private static void addTwoElementsInTheMiddle(List<String> input, int count) {
        int indexToSet=input.size()/2;
        String toSet = "-"+count+"a";
        input.add(indexToSet,toSet);
        input.add(indexToSet,toSet);
    }

    private static boolean checkIsCorect(int index1, int index2, List<String> input) {
        if(index1<0||index1>=input.size()||index2<0||index2>=input.size()||index1==index2){
    return false;
        }
        return true;
    }
}
