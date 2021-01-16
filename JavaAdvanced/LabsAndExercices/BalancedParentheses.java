import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input= scanner.nextLine();
        ArrayDeque<Character> brackets = new ArrayDeque<>();
        boolean areBalanced =true;
        if(input.length()%2==1){
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);
            if (currentBracket == '{' || currentBracket == '[' || currentBracket == '(') {
                brackets.push((currentBracket));
            } else if (currentBracket == '}' || currentBracket == ')' || currentBracket == ']') {
                char openBracket = brackets.pop();
                if (currentBracket == ')' && openBracket != '(') {
                    areBalanced = false;
                } else if (currentBracket == ']' && openBracket != '[') {
                    areBalanced = false;
                } else if (currentBracket == '}' && openBracket != '{') {
                    areBalanced = false;
                }
            }
        }
        if(areBalanced){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
