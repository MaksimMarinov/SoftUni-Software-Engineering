import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> contestInfo = new LinkedHashMap<>();
        Map<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("end of contests")) {
            String[] tokens = input.split(":");
            String name = tokens[0];
            String pass = tokens[1];
            contestInfo.put(name,pass);

            input = scanner.nextLine();
        }
        input= scanner.nextLine();
        while (!input.equals("end of submissions")){
            String[] tokens = input.split("=>");
            String course = tokens[0];
            String pass = tokens[1];
            String name = tokens[2];
            int result = Integer.parseInt(tokens[3]);
            if(contestInfo.containsKey(course)){
                if(contestInfo.get(course).equals(pass)){
                    LinkedHashMap<String, Integer> courseInfo=new LinkedHashMap<>();
                    courseInfo.put(course,result);
                    if(!users.containsKey(name)){
                        users.put(name,courseInfo);
                    }else{
                        if(!users.get(name).containsKey(course)){
                            users.get(name).put(course,result);
                        }else{
                            users.get(name).put(course, Math.max(result,users.get(name).get(course)));
                        }
                    }


                }
            }


            input= scanner.nextLine();
        }
        int totalSum = 0;
        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : users.entrySet()) {
            int sum = user.getValue().values().stream().mapToInt(i -> i).sum();
            if (sum > totalSum) {
                totalSum = sum;
            }
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : users.entrySet()) {
            if(user.getValue().values().stream().mapToInt(e->e).sum()==totalSum){
                System.out.printf("Best candidate is %s with total %d points.%n", user.getKey(), totalSum);
            }

        }
        System.out.println("Ranking:");
        users.forEach((k,v)->{
            System.out.printf("%s%n", k);
            v.entrySet().stream().sorted((f,s)->s.getValue().compareTo(f.getValue())).forEach(e->
                    System.out.printf("#  %s -> %d%n", e.getKey(), e.getValue()));
        });
    }

}
