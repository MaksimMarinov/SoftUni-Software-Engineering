import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        System.out.println(VowelsCount(input));



    }public static int VowelsCount(String input){
        String[] letters = input.split("");
        int counter=0;
        for (int i = 0; i <letters.length ; i++) {
            if(letters[i].equals("a")||letters[i].equals("A")){
                counter++;
            }else if(letters[i].equals("e")||letters[i].equals("E")){
                counter++;
            }else if(letters[i].equals("i")||letters[i].equals("I")){
                counter++;
            }else if(letters[i].equals("o")||letters[i].equals("O")){
                counter++;
            }else if(letters[i].equals("u")||letters[i].equals("U")){
                counter++;
            }else if(letters[i].equals("y")||letters[i].equals("Y")){
                counter++;
            }

        }return counter;

    }

}
