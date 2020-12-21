import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> students = new TreeMap<>();
        Map<String, Integer> languages = new TreeMap<>();
        String command = scanner.nextLine();
        while (!command.equals("exam finished")){
            String[] tokens = command.split("-");
            String name = tokens[0];
            if(tokens.length==2){
                students.remove(name);
            }else {
                String language = tokens[1];
               int grade = Integer.parseInt(tokens[2]);
                if (students.containsKey(name)&&students.get(name)<grade) {
                        students.put(name,grade);
                }else if(!students.containsKey(name)){
                    students.put(name, grade);
                }
                if(languages.containsKey(language)){
                    languages.put(language, languages.get(language)+1);
                }else{
                    languages.put(language,1);
                }
            }
            command= scanner.nextLine();
        }
        System.out.println("Results:");
        students.entrySet().stream().sorted((k,v)->
                v.getValue().compareTo(k.getValue()))
                .forEach(e->
                        System.out.println(e.getKey()+" | "+e.getValue()));
        System.out.println("Submissions:");
        languages.entrySet().stream().sorted((k,v)->
        v.getValue().compareTo(k.getValue()))
                .forEach(e->
                System.out.println(e.getKey()+" - "+e.getValue()));

    }
}
