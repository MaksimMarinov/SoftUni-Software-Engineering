import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());
        printCenterPoint(x1, y1, x2, y2);

    }

    private static void printCenterPoint(int x1, int y1, int x2, int y2) {

       int result = x1+y1;
       int result2 = x2+y2;
       if(result>=result2){
           System.out.printf("(%d, %d)", x2, y2);
       }else{
           System.out.printf("(%d, %d)", x1, y1);
       }
    }
}
