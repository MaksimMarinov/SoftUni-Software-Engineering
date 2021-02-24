import java.io.*;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        BufferedReader bf1 = new BufferedReader(new FileReader("C:\\Users\\Maksim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt"));
        PrintWriter writer = new PrintWriter("C:\\Users\\Maksim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");
        String line = bf1.readLine();
        printFile(line, bf1, writer);
        bf1.close();
        BufferedReader bf2 = new BufferedReader(new FileReader("C:\\Users\\Maksim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt"));
        line = bf2.readLine();
        printFile(line, bf2, writer);
        bf2.close();
        writer.close();
    }

    private static void printFile(String line, BufferedReader bf, PrintWriter writer) throws IOException {
        while (line!=null){
            writer.println(line);
            line= bf.readLine();
        }
    }
}
