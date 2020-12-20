import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char c = scanner.next().charAt(0);
        boolean b1 = Character.isUpperCase(c);
        boolean b2 = Character.isLowerCase(c);



if (b1){
    System.out.println("upper-case");
}else if (b2){
    System.out.println("lower-case");

}

    }
}
