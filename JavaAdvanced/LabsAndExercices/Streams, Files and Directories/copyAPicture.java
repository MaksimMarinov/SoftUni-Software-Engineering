import java.awt.*;
import java.io.*;

public class copyAPicture {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\Maksim\\Desktop\\G0048666.JPG");

        FileOutputStream outputStream = new FileOutputStream("output.JPG");
        byte[] buffer = inputStream.readAllBytes();
        inputStream.close();
        outputStream.write(buffer);
        outputStream.flush();
        outputStream.close();

    }
}
