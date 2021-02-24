import java.io.*;
public class allCapitals {
    public static void main(String[] args) throws IOException {
        BufferedReader bf =
                new BufferedReader(new FileReader("C:\\Users\\Maksim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
      String line =bf.readLine();
        PrintWriter writer = new PrintWriter(new FileOutputStream("C:\\Users\\Maksim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));
      while (line!=null){
          writer.println(line.toUpperCase());
          line = bf.readLine();
      }
      bf.close();
      writer.close();

    }
}
