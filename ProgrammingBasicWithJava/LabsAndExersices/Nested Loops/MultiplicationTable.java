import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
for (int number1 = 1; number1<=10; number1++){
    for (int number2 = 1; number2<=10; number2++){
        System.out.println(number1 + " * " + number2 + " = " + number1*number2);
    }
}
    }
}
