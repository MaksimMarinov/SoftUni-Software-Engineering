import java.util.Scanner;

public class TheSongOfTheWheels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        int passA = 0;
        int passB = 0;
        int passC = 0;
        int passD = 0;
        int count =0;
        for (int a = 1; a<9; a++){
            for (int b = 1; b<=9; b++){
                for (int c = 1; c<=9;c++){
                    for (int d = 1; d<c; d++){
                        if (a*b+c*d == m && a<b){
                            count++;
                            System.out.printf("%d%d%d%d ", a, b, c, d);

                            if (count==4){
                                passA=a;
                                passB=b;
                                passC=c;
                                passD=d;

                            }}
                    }
                }
            }

        }System.out.println();
        if (count<4){
            System.out.println("No!");
        }else {
            System.out.printf("Password: %d%d%d%d",passA, passB, passC, passD);
        }
    }
}
