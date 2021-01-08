import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("End")){
            String[] tokens = command.split("\\s+");
            int index = Integer.parseInt(tokens[1]);
            int token2asNumber = Integer.parseInt(tokens[2]);
            switch (tokens[0]){
                case("Shoot"):
                    shoot(numbers, token2asNumber, index);
                    break;
                case("Add"):
                   add(numbers, token2asNumber, index);
                    break;
                case("Strike"):
                    strike(numbers, token2asNumber, index);
                    break;
            }

            command= scanner.nextLine();

        }
        for (int i = 0; i <numbers.size() -1; i++) {
            System.out.print(numbers.get(i)+"|");

        }
        System.out.print(numbers.get(numbers.size()-1));

    }

    private static void strike(List<Integer> numbers, int radius, int index) {

        if(index+radius<=numbers.size()&&index-radius>=0){
            int indexToRemove=index-radius;
            for (int i = indexToRemove; i <=index+radius ; i++) {
                numbers.remove(indexToRemove);
            }
        }else{
            System.out.println("Strike missed!");
        }
    }

    private static void add(List<Integer> numbers, int tokenAsNumber, int index) {
        if(index>=0&&index<numbers.size()){
            numbers.add(index,tokenAsNumber);
        }else{
            System.out.println("Invalid placement!");
        }
    }

    private static void shoot(List<Integer> numbers, int power, int index) {
        if(index>=0&&index<numbers.size()){
            int newValue=numbers.get(index) -power;
            if (newValue > 0) {
                numbers.set(index,newValue);
            }else{
                numbers.remove(index);
            }
        }

    }
}

