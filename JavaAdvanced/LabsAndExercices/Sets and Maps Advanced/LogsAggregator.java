import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> usersOccurrences = new TreeMap<>();
        Map<String, List<String>> userIpInfo = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-->0){
            String[] tokens = scanner.nextLine().split("\\s+");
            String ip = tokens[0];
            String user = tokens[1];
            int occurrences = Integer.parseInt(tokens[2]);
            if(usersOccurrences.containsKey(user)){
                usersOccurrences.put(user,usersOccurrences.get(user)+occurrences);
                if(!userIpInfo.get(user).contains(ip)){
                    userIpInfo.get(user).add(ip);
                }
            }else{
                usersOccurrences.put(user, occurrences);
                userIpInfo.put(user, new ArrayList<>());
                userIpInfo.get(user).add(ip);
            }

        }
        userIpInfo.entrySet().forEach(user->{
            user.getValue().sort(String::compareTo);
            print(user, usersOccurrences);
        });
    }

    private static void print(Map.Entry<String, List<String>> user, Map<String, Integer> usersOccurrences) {
        System.out.print(user.getKey()+": "+usersOccurrences.get(user.getKey())+" [");
        for (int i = 0; i < user.getValue().size(); i++) {
            String separator = ", ";
            if(i==user.getValue().size()-1){
                separator="]";
            }
            System.out.print(user.getValue().get(i)+separator);
        }
        System.out.println();
    }

}
