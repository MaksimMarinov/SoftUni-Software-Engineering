import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args)  {

        try (BufferedReader bf =
                     new BufferedReader(new FileReader("C:\\Users\\Maksim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));){
            long sum =0;
            String line = bf.readLine();
            while (line!=null){
                for(char c :line.toCharArray()){
                    sum+=c;
                }
                line = bf.readLine();
            }
            System.out.println(sum);

        }catch (IOException e){
            e.printStackTrace();
        }



    }
}

