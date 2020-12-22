import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);;
        String input = scanner.nextLine();
        printMiddle(input);

    }

    private static void printMiddle(String input) {
        String[] output = input.split("");

        if (output.length%2==0){
            for (int i = input.length()/2-1; i <=input.length()/2 ; i++) {
                System.out.print(output[i]);



            }
        }else{
            System.out.println(output[input.length()/2]);

        }
    }
}
