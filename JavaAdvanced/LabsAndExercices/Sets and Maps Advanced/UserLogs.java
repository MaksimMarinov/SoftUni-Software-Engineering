import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserLogs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, LinkedHashMap<String, Integer>> users = new LinkedHashMap<>();

        String line;

        while (!(line = reader.readLine()).equals("end")) {
            String[] tokens = line.split("[=\\s+]");

            String user = tokens[5];
            String ip = tokens[1];

            if (!users.containsKey(user)) {
                users.put(user, new LinkedHashMap<>());
            }
            if (!users.get(user).containsKey(ip)) {
                users.get(user).put(ip, 1);
            } else {
                users.get(user).put(ip, users.get(user).get(ip) + 1);
            }
        }
        users.entrySet()
                .stream()
                .sorted((u1, u2) -> u1.getKey().compareTo(u2.getKey()))
                .forEach(u -> {
                    System.out.printf("%s:%n", u.getKey());

                    String[] ips = getIps(u.getValue());
                    System.out.printf("%s.%n", String.join(", ", ips));
                });
    }

    private static String[] getIps(LinkedHashMap<String, Integer> map) {
        String[] result = new String[map.size()];

        int index = 0;
        for (Map.Entry<String, Integer> ipAndCount : map.entrySet()) {
            result[index] = String.format("%s => %d", ipAndCount.getKey(), ipAndCount.getValue());
            index++;
        }

        return result;
    }
}