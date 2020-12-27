import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String[] input2 = scanner.nextLine().split(" ");
        for (int i = 0; i < input2.length; i++) {
            for (int j = 0; j < input.length; j++) {
               if(input2[i].equals(input[j])) {
                   System.out.print(input[j]+' ');
               }
            }
        }
    }
}
