import java.util.Scanner;

public class Profit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int coin1 = Integer.parseInt(scanner.nextLine());
        int coin2 = Integer.parseInt(scanner.nextLine());
        int lev5 = Integer.parseInt(scanner.nextLine());
        int sum = Integer.parseInt(scanner.nextLine());
        for (int i =0; i<=coin1; i++){
            for (int k =0; k<=coin2; k++){
                for (int l =0; l<=lev5; l++){
                    if (i*1+k*2+l*5==sum){
                        System.out.printf("%d * 1 lv. + %d * 2 lv. + %d * 5 lv. = %d lv.%n", i, k, l, sum);
                    }

                }


                }

            }

    }
}
