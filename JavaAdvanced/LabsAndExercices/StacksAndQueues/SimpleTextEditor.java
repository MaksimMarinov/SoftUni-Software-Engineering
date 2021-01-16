import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String toPrint = "";
        int numberOfOperations = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> lastStrings = new ArrayDeque<>();
        for (int i = 0; i < numberOfOperations; i++) {
            String[] command = scanner.nextLine().split(" ");
            switch (command[0]){
                case"1":
                 toPrint +=   command[1];
                  lastStrings.push(toPrint);
                    break;
                case"2":
                    int countOfLettersToErase = Integer.parseInt(command[1]);
                    int startingIndex = toPrint.length()-countOfLettersToErase;
                    toPrint=toPrint.substring(0, startingIndex);
                    lastStrings.push(toPrint);
                    break;
                case"3":
                    int index = Integer.parseInt(command[1]);
                    System.out.println(toPrint.charAt(index-1));
                    break;
                case"4":
                    lastStrings.pop();
                    if (lastStrings.size() > 0)
                    {
                        toPrint=lastStrings.peek();
                    }
                    else
                    {
                        toPrint="";
                    }

                    break;
            }

        }
    }

}
