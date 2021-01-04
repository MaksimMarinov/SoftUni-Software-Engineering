import java.util.Scanner;

public class DigitLettersandOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        StringBuilder number = new StringBuilder();
        StringBuilder letter = new StringBuilder();
        StringBuilder other = new StringBuilder();
        for (int i = 0; i <line.length() ; i++) {
            Character ch = line.charAt(i);
            if(Character.isDigit(ch)){
                number.append(ch);
            }else if(Character.isLetter(ch)){
                letter.append(ch);
            }else{
                other.append(ch);
            }
        }
        System.out.println(number);
        System.out.println(letter);
        System.out.println(other);

    }
}
