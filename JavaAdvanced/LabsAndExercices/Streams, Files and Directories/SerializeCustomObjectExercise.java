import java.io.*;

public class SerializeCustomObjectExercise {
    public static class Course implements Serializable{
        String name;
        int numberOfStudents;
        @Override
        public String toString() {
            return String.format("%s->%d", this.name, this.numberOfStudents);
        }


    }


    public static void main(String[] args) {
    try {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Maksim\\Desktop\\output.txt"));
        Course course = new Course();
        course.name = "Java";
        course.numberOfStudents=20;
        outputStream.writeObject(course);
        outputStream.close();
        System.out.println(course);
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\Maksim\\Desktop\\output.txt"));
        Course newCourse = (Course)inputStream.readObject();
                System.out.println(newCourse);
                inputStream.close();
    }catch (IOException | ClassNotFoundException e){
        e.printStackTrace();
    }
    }
}
