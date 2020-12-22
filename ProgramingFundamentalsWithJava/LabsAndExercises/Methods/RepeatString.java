import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input =  scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());
        String repeated= repeat(input, count);
        System.out.println(repeated);


    }static String repeat(String input, int count){
        String[] repetitions = new String[count];
        for (int i = 0; i <count ; i++) {
            repetitions[i]=input;


        }return String.join("",repetitions);


    }
}
