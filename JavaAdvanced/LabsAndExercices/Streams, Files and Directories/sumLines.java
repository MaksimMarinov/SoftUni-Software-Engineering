import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class sumLines {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = Files.newBufferedReader(Path.of("C:\\Users\\Maksim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        String line = bf.readLine();
        while (line!=null){
            long sum=0;
            for (char c : line.toCharArray()) {
                sum+=c;
            }
            System.out.println(sum);
            line=bf.readLine();
        }
        bf.close();
    }
}
