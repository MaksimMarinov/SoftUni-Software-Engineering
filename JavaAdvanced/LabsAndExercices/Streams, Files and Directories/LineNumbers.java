import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
     BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\Maksim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt"));
    String line =  bf.readLine();
    int counter = 1;
        PrintWriter printWriter = new PrintWriter("C:\\Users\\Maksim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");
    while (line!=null){

        printWriter.println(counter + ". " + line);
        line = bf.readLine();
        counter++;
    }
    bf.close();
    printWriter.close();


    }
}