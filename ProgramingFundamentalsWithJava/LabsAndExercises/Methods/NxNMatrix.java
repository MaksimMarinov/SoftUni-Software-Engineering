import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        int input = new Scanner(System.in).nextInt();
        printMatrx(input);





    }

    private static void printMatrx(int input) {
        for (int i = 0; i < input; i++) {
            for (int j = 0; j <input ; j++) {
                System.out.print(input + " ");

            }
            System.out.println();

        }
    }
}
