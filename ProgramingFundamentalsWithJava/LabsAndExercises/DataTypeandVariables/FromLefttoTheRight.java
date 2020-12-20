import java.util.Scanner;

public class FromLefttoTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum =0;
        for (int i = 1; i <=n ; i++) {
            long left = scanner.nextLong();
            long right = scanner.nextLong();
            sum = 0;
            if (left>right){
                while (left!=0){
                    sum += left%10;
                    left /=10;

                }System.out.println(Math.abs(sum));


            }else{
                while (right!=0){
                    sum += right%10;
                    right /=10;}
                System.out.println(Math.abs(sum));



            }


        }

    }
}
