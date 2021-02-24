import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;


public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Maksim\\Desktop\\input.txt";
        FileInputStream is = new FileInputStream(path);
        FileOutputStream os = new FileOutputStream("output.txt");
        PrintWriter printWriter = new PrintWriter(os);
        int singleByte = is.read();
        while (singleByte>=0){
        if(singleByte==10||singleByte==32){
            printWriter.print((char) singleByte);
        }else{
            printWriter.print(singleByte);
        }
        singleByte= is.read();
        }
        printWriter.close();
        is.close();







    }
}
