import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    int m = Integer.parseInt(scanner.nextLine());
    int y = Integer.parseInt(scanner.nextLine());
    int nLeft = n;
    int count=0;
    while (nLeft>=m){
        nLeft=nLeft-m;
        count++;
        if (n/2==nLeft&& y!=0){
            nLeft=(int)nLeft/y;
        }

    }
        System.out.printf("%d%n%d", nLeft, count);







    }
}
