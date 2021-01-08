import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).
                mapToInt(e -> Integer.parseInt(e)).toArray();
        String command = scanner.nextLine();
        while(!command.equals("end")){
            String[] tokens = command.split("\\s+");
            switch (tokens[0]){
                case ("swap"):
                    int oldElement =input[Integer.parseInt(tokens[1])];
                    input[Integer.parseInt(tokens[1])]=input[Integer.parseInt(tokens[2])];
                    input[Integer.parseInt(tokens[2])]=oldElement;
                    break;
                case ("multiply"):
                    input[Integer.parseInt(tokens[1])]=
                            input[Integer.parseInt(tokens[1])]*input[Integer.parseInt(tokens[2])];
                    break;
                case ("decrease"):
                    for (int i = 0; i < input.length; i++) {
                        input[i]--;
                    }
                    break;
            }
            command=scanner.nextLine();
        }
        /*for (int i = 0; i <input.length-1 ; i++) {
            System.out.print(input[i]+", ");
        } System.out.print(input[input.length-1]);*/
        for (int i = 0; i <input.length; i++) {
            System.out.print(input[i]);
            if(i<input.length-1){
                System.out.print(", ");
            }
        }
    }
}
