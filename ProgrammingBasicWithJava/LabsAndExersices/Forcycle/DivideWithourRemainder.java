import java.util.Scanner;

public class DivideWithourRemainder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int p1 =0;
        int p2 =0;
        int p3 =0;
        for (int number = 1; number <=n; number++ ) {
                    int value = Integer.parseInt(scanner.nextLine());
                    if (value % 2 == 0) {
                        p1 += 1;
                    } if (value % 3 == 0) {
                        p2 += 1;
                    } if (value % 4 == 0) {
                        p3 += 1; }
                }
                double percentP1 = p1*1.0/n*100;
                double percentP2 = p2*1.0/n*100;
                double percentP3 = p3*1.0/n*100;
                System.out.printf("%.2f%%%n",percentP1);
                System.out.printf("%.2f%%%n",percentP2);
                System.out.printf("%.2f%%%n",percentP3);

            }
        }



