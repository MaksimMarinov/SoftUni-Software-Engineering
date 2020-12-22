import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 =Integer.parseInt(scanner.nextLine());
        int n3 =Integer.parseInt(scanner.nextLine());
        printMultiplicationSign(n1,n2,n3);

    }

    private static void printMultiplicationSign(int n1, int n2, int n3) {
        if(n1==0||n2==0||n3==0){
            System.out.println("zero");

        }else if((n1<0&& n2>0&&n3>0)||(n2<0&& n1>0&&n3>0)||(n3<0&& n1>0&&n2>0)
        ||(n1<0&&n2<0&&n3<0)||(n1<0&&n3<0&&n2<0)||(n2<0&&n3<0&&n1<0)){
            System.out.println("negative");
        }else{
            System.out.println("positive");
        }

    }
}
