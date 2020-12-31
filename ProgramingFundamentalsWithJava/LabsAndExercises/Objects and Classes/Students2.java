import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<Student> studentList = new ArrayList<>();
        while(!line.equals("end")){
            String[] studentInfo = line.split("\\s+");
            int age = Integer.parseInt(studentInfo[2]);
            Student student =  new Student(studentInfo[0],studentInfo[1], age,studentInfo[3] );
            Student existingStudent = getStudent(studentList, studentInfo[0],studentInfo[1], age,studentInfo[3]);
            if(existingStudent!=null){
                student =getStudent(studentList, studentInfo[0],studentInfo[1], age,studentInfo[3]);
            }else{
                studentList.add(student);
            }


            line= scanner.nextLine();
        }

        String filterCity = scanner.nextLine();
        studentList.stream()
                .filter(s -> s.getCity().equals(filterCity))
                .forEach(s -> System.out.println(String.format("%s %s is %d years old", s.firstName,
                 s.secondName, s.age)));

    }

    private static Student getStudent(List<Student> students,String firstName, String lastName, int age, String city ){
        Student existingStudent=null;
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.secondName.equals(lastName)) {
                existingStudent = student;
                existingStudent.age = age;
                existingStudent.city = city;
            }
        }
        return existingStudent;
    }
    public static class Student{
        private String firstName;
        private String secondName;
        private int age;
        private String city;

        public Student(String firstName, String secondName, int age, String city) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
            this.city = city;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getSecondName() {
            return secondName;
        }

        public int getAge() {
            return age;
        }

        public String getCity() {
            return city;
        }
    }

}
