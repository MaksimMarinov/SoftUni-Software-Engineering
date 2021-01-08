import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SchoolLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split("&+"))
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("Done")){
            String[] token = command.split(" \\|+ ");
            switch (token[0]){
                case("Add Book"):
                    addBook(input, token[1]);
                    break;
                case("Take Book"):
                    takeBook(input, token[1]);
                    break;
                case ("Swap Books"):
                    swapBooks(input, token[1], token[2]);
                    break;
                case("Insert Book"):
                    insertBook(input, token[1]);
                    break;
                case ("Check Book"):
                    int index = Integer.parseInt(token[1]);
                    checkBook(input, index);
                    break;

            }
            command=scanner.nextLine();
        }
        for (int i = 0; i <input.size()-1 ; i++) {
            System.out.print(input.get(i) + ","+" ");

        }
        System.out.print(input.get(input.size()-1));
    }

    private static void checkBook(List<String> input, int s) {
        if(s>=0&&s<input.size()){
            System.out.println(input.get(s));
        }
    }

    private static void insertBook(List<String> input, String s) {
        input.add(s);
    }

    private static void swapBooks(List<String> input, String s, String s1) {
        if(input.contains(s)&&input.contains(s1)){
        int index1 = input.indexOf(s);
        int index2 = input.indexOf(s1);
        input.set(index1,s1);
        input.add(index2,s);
        input.remove(index2+1);}
    }

    private static void takeBook(List<String> input, String s) {
        for (int i = 0; i < input.size(); i++) {
            if(input.contains(s)){
                input.remove(s);
            }
        }

    }

    private static void addBook(List<String> input, String s) {
        for (int i = 0; i < input.size(); i++) {
            if(!input.contains(s)){
                input.add(0,s);
            }
        }

    }




}
