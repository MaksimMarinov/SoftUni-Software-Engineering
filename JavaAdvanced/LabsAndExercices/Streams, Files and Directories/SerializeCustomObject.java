import java.io.*;

public class SerializeCustomObject {
    public static class  Cube implements Serializable{
        String color;
        double width;
        double height;
        double depth;

        public Cube(String color, double width, double height, double depth) {
            this.color = color;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
   Cube cube = new Cube("green",15.3, 12.4, 3.0);
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("object.txt"));
        outputStream.writeObject(cube);
        outputStream.close();
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("object.txt"));
        Cube readCube = (Cube)inputStream.readObject();
        System.out.println(readCube.color);
    }
}
