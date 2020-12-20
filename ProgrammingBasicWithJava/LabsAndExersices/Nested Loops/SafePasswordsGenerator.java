import java.util.Scanner;

public class SafePasswordsGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i100 = Integer.parseInt(scanner.nextLine());
        int i10 = Integer.parseInt(scanner.nextLine());
        int i1 = Integer.parseInt(scanner.nextLine());
        for (int k = 2; k<=i100; k++){
            for (int l = 2; l<=i10; l++){
                for (int j = 2; j<=i1; j++){
                    if (k%2==0 && j%2==0){
                        if (l==2 || l==3 || l==5 || l==7){
                            System.out.printf("%d %d %d%n", k, l, j);
                        }
                    }

                }

            }

        }




    }
}
