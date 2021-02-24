
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeArrayList {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(1.1);
        list.add(2.1);
        list.add(1.2);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Maksim\\Desktop\\output.txt"));
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\Maksim\\Desktop\\output1.txt"));
            List readList = (List) inputStream.readObject();
            readList.forEach(System.out::println);
            inputStream.close();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }



    }
}
