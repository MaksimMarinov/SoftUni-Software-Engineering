import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        long fibo1 = 0;
        long fibo2 = 0;
        long fiboN = 0;

        for (int i = 0; i <n ; i++) {

            if(i<1) {
                fibo1=1;
                fiboN=1;
            }else if(i==1){
                fibo2=1;
            }else{
                fiboN = fibo1+fibo2;
                fibo1 = fibo2;
                fibo2 = fiboN;
            }


        }
        System.out.println(fiboN);


    }
}
