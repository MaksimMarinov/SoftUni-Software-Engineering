import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char char1 = scanner.nextLine().charAt(0);
        char char2 = scanner.nextLine().charAt(0);
        String line = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < line.length(); i++) {

            if((int)line.charAt(i)>(int) char1 && (int)line.charAt(i)<(int) char2){
                sum += (int)line.charAt(i);
            }
        }
        System.out.println(sum);

    }
}
