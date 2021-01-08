import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int totalEff = scanner.nextInt() + scanner.nextInt() + scanner.nextInt();
        int students = scanner.nextInt();
        int countHours=0;
        while (students>0) {
            countHours++;
            if(countHours%4!=0){
                students-=totalEff;
            }

        }
        System.out.printf("Time needed: %dh.",countHours);

    }
}
