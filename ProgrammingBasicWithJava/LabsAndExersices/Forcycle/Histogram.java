import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int p1 =0;
        int p2 =0;
        int p3 =0;
        int p4 =0;
        int p5 =0;
        for (int number = 1; number <=n; number++ ) {
            int value = Integer.parseInt(scanner.nextLine());
            if (value < 200) {
                p1 += 1;
            } else if (value >= 200 && value <= 399) {
                p2 += 1;
            } else if (value >= 400 && value <= 599) {
                ;
                p3 += 1;
            } else if (value >= 600 && value <= 799) {
                p4 += 1;
            } else if (value >= 800) {
                p5 += 1;
            }
        }
        double percentP1 = p1*1.0/n*100;
        double percentP2 = p2*1.0/n*100;
        double percentP3 = p3*1.0/n*100;
        double percentP4 = p4*1.0/n*100;
        double percentP5 = p5*1.0/n*100;
        System.out.printf("%.2f%%%n",percentP1);
        System.out.printf("%.2f%%%n",percentP2);
        System.out.printf("%.2f%%%n",percentP3);
        System.out.printf("%.2f%%%n",percentP4);
        System.out.printf("%.2f%%%n",percentP5);

    }
}
