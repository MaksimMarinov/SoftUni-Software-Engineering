package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<Person> people = new ArrayList<>();
        while (!line.equals("END")){
            String[] personInfo = line.split("\\s+");
            Person person = new Person(personInfo[0], Integer.parseInt(personInfo[1]), personInfo[2] );
            people.add(person);
            line= scanner.nextLine();
        }
        int index = Integer.parseInt(scanner.nextLine());
        Person searchedPerson = people.get(index-1);
        int counter = 0;
        for (Person person : people) {
            if(person.compareTo(searchedPerson)==0){
                counter++;
            }
            
        }
        if(counter==1){
            System.out.println("No matches");
        }else{
            System.out.println(counter+" "+(people.size()-counter)+" "+people.size());
        }
    }
}
