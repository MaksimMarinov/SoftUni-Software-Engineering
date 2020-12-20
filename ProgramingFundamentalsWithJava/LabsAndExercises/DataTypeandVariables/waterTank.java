import java.util.Scanner;

public class waterTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int littersLeft = 255;
        int littersIn = 0;
        for (int i = 1; i <=n ; i++) {
            int quantitiesOfWater = Integer.parseInt(scanner.nextLine());
            if (quantitiesOfWater>littersLeft){
                System.out.println("Insufficient capacity!");
            }else {
                littersLeft -= quantitiesOfWater;
                littersIn += quantitiesOfWater;
            }

        }
        System.out.println(littersIn);
    }
}
