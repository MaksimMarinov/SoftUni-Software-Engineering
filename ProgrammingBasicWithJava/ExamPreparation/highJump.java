import java.util.Scanner;

public class highJump {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int desireHigh = Integer.parseInt(scanner.nextLine());
        int startHigh =  desireHigh-30;
        int jumpsTotal = 0;
        int jumpsUnsuccess = 0;
        while (true){
            int highJump = Integer.parseInt(scanner.nextLine());
            jumpsTotal++;

            if (highJump>startHigh) {
                startHigh = startHigh + 5;
                jumpsUnsuccess = 0;
            }else {
                jumpsUnsuccess++;
                if (jumpsUnsuccess==3){
                    System.out.printf("Tihomir failed at %dcm after %d jumps.", startHigh, jumpsTotal);
                    break;
                }
            }if (startHigh>desireHigh){
                System.out.printf("Tihomir succeeded, he jumped over %dcm after %d jumps.", desireHigh, jumpsTotal);
                break;
            }
        }

    }
}
