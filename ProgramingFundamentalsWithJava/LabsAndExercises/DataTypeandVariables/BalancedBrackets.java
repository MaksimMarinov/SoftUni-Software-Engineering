import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String currentBracket = "";


        for (int i = 1; i <=n ; i++) {
            String input = scanner.nextLine();
            if ((currentBracket.equals("")&& input.equals(")"))||(currentBracket.equals("(")&& input.equals("(")) || (currentBracket.equals(")")&& input.equals(")"))) {
                System.out.println(("UNBALANCED"));
                return;
            }
            if (input.equals("(") || input.equals(")")){
                currentBracket = input;
            }



        }if (currentBracket.equals("(")){
            System.out.println(("UNBALANCED"));

        }else{
            System.out.println("BALANCED");}



    }
}
