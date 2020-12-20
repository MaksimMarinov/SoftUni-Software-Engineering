import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int count = 0;
        for (int rows = 1; rows<=n; rows++){
            for (int cols =1; cols<=rows; cols++ ){
                if (count==n){
                    break;

                }count++;
                System.out.print(count + " ");
            }if (count==n){
                break;

            }
            System.out.println();
        }
    }
}
