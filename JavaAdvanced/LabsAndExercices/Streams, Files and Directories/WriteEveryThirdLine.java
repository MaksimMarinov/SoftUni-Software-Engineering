import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Maksim\\Desktop\\input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));

        BufferedWriter writer = new BufferedWriter(new FileWriter("" +
                "C:\\Users\\Maksim\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "\\Files-and-Streams\\output.txt"));
        String line = reader.readLine();
        int lineNumber = 0;
        while (line!=null){
            lineNumber++;
            if(lineNumber%3==0){
                writer.write(line);
                writer.write(System.lineSeparator());
            }

            line = reader.readLine();
        }
        writer.close();

    }
}
