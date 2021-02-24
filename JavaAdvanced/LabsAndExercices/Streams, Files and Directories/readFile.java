import java.io.FileInputStream;
import java.io.IOException;


public class readFile {
    public static void main(String[] args) throws IOException {
    String path = "C:\\Users\\Maksim\\Desktop\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        int oneByte = inputStream.read();
        while (oneByte!=-1){
            System.out.printf("%s ", Integer.toBinaryString(oneByte));
            oneByte=inputStream.read();
        }
    }
}







