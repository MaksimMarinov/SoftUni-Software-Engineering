import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class writeToFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Maksim\\Desktop\\input.txt";
        FileInputStream is = new FileInputStream(path);
       FileOutputStream os = new FileOutputStream("C:\\Users\\Maksim\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\output.txt");
        PrintWriter printWriter = new PrintWriter(os);
        int singleByte = is.read();
        Set<Character> punctuations = new HashSet<>();
        punctuations.add(',');
        punctuations.add('?');
        punctuations.add('.');
        punctuations.add('!');
        while (singleByte>=0){
            char symbol = (char) singleByte;
            if(!punctuations.contains(symbol)){
               printWriter.print(symbol);
            }

            singleByte= is.read();
        }
      printWriter.close();
    }
}

