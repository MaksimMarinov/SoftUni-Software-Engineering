import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int yield = Integer.parseInt(scanner.nextLine());
        int days = 0;
        int yieldLeft = 0;
        for (int i = 1; yield >= 100 ; i++) {
            if (yield >= 100) {
                days++;
                yieldLeft = yieldLeft + (yield - 26);
                yield -= 10;
            }

        }if (yieldLeft>=26){
            yieldLeft -=26;
        }else{
            yieldLeft=0;
        }
        System.out.printf("%d%n%d", days, yieldLeft);


    }
}
