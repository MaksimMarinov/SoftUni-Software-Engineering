import java.util.Scanner;

public class PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =  Integer.parseInt(scanner.nextLine());
        int n1 = Integer.parseInt(scanner.nextLine());
        for (int i = n; i <= n1 ; i++) {
          char c = (char)i;
            System.out.print(c + " ");


        }



    }

}
