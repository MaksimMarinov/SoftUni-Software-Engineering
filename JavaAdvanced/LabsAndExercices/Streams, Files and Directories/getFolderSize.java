import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class getFolderSize {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Maksim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources");
        File[] files = file.listFiles();
        try(PrintWriter writer = new PrintWriter("output.txt")) {
            int size = 0;
        if(files!=null){

            for (File f : files) {
                size += f.length();
            }
        }writer.println(size);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
