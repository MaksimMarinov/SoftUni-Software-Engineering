package google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Person> people = new LinkedHashMap<>();
        while (!input.equals("End")){
        String[] tokens = input.split("\\s+");
        String name =  tokens[0];
        Person person = new Person(name);
        people.putIfAbsent(name, person);
        switch (tokens[1]){
            case"company":
                String companyName = tokens[2];
                String department = tokens[3];
                double salary = Double.parseDouble(tokens[4]);
                Company company = new Company(companyName, department, salary);
                people.get(name).setCompany(company);
                break;
            case"pokemon":
                String pokemonName = tokens[2];
                String pokemonType = tokens[3];
                Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                people.get(name).add(pokemon);
                break;
            case"parents":
                String parentName = tokens[2];
                String parentBirthday = tokens[3];
                Parent parent = new Parent(parentName, parentBirthday);
                people.get(name).add(parent);
                break;
            case"children":
                String childName = tokens[2];
                String childBirthday = tokens[3];
                Children children = new Children(childName, childBirthday);
                people.get(name).add(children);
                break;
            case"car":
                String model = tokens[2];
                String speed = tokens[3];
                Car car = new Car(model, speed);
                people.get(name).setCar(car);
                break;

        }
            input= scanner.nextLine();
        }
        String name = scanner.nextLine();
        if (people.containsKey(name)) {
            System.out.println(people.get(name));
        }
    }
}
