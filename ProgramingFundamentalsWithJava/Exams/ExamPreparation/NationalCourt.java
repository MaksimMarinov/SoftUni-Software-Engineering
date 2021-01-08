import java.util.Scanner;

public class NationalCourt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int efficiency = scanner.nextInt()+scanner.nextInt()+scanner.nextInt();
        int people =scanner.nextInt();
        int hours = 0;
        while (people>0){
            hours++;
            if(hours%4==0){
                continue;
            }
            people-=efficiency;
        }
        System.out.printf("Time needed: %dh.",hours);

    }
}

