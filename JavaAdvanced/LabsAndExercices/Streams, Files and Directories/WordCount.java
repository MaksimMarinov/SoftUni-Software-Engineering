
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\Maksim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt"));
        String[] wordsToCheck= scanner.nextLine().split(" ");
        scanner.close();
        Scanner text = new Scanner(new FileInputStream("C:\\Users\\Maksim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt"));
        String[] textToCheck = text.nextLine().split(" ");
        scanner.close();
        PrintWriter writer = new PrintWriter("C:\\Users\\Maksim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");
        for (String word : wordsToCheck) {
            int count = 0;
            for (String wordFromText : textToCheck) {
                if(word.equals(wordFromText)){
                    count++;
                }
            }
            writer.println(word + " - "+count);

        }
        writer.flush();
        writer.close();






    }
}
