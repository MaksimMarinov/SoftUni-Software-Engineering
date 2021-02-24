import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Maksim\\Desktop\\input.txt";
       Scanner scanner = new Scanner(new FileInputStream(path));
       FileWriter writer = new FileWriter("C:\\Users\\Maksim\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\output.txt");

      while (scanner.hasNext()){
          if(scanner.hasNextInt()){
              writer.write(String.valueOf(scanner.nextInt()));
              writer.write(System.lineSeparator());

          }
          scanner.next();
      }


     writer.flush();
      writer.close();
      scanner.close();








    }
}
