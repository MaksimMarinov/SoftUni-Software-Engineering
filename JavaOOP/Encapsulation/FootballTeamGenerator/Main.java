package FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Team> teams = new HashMap<>();
        String input = bf.readLine();
        while (!input.equals("END")) {
            String[] tokens = input.split(";");
            String command = tokens[0];
            String teamName = tokens[1];
            try {
                if (command.equals("Team")) {
                    teams.putIfAbsent(teamName, new Team(teamName));
                } else if (command.equals("Add")) {
                    if (!teams.containsKey(teamName)) {
                        throw new IllegalArgumentException("Team " + teamName + " does not exist.");

                    }
                    String playerName = tokens[2];
                    int endurance = Integer.parseInt(tokens[3]);
                    int sprint = Integer.parseInt(tokens[4]);
                    int dribble = Integer.parseInt(tokens[5]);
                    int passing = Integer.parseInt(tokens[6]);
                    int shooting = Integer.parseInt(tokens[7]);
                    Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                    teams.get(teamName).addPlayer(player);
                    teams.put(teamName, teams.get(teamName));
                } else if (command.equals("Remove")) {

                    if (!teams.containsKey(teamName)) {
                        throw new IllegalArgumentException("Team " + teamName + " does not exist.");
                    }
                    String playerName = tokens[2];
                    teams.get(teamName).removePlayer(playerName);
                } else if (command.equals("Rating")) {
                    if (!teams.containsKey(teamName)) {
                        throw new IllegalArgumentException("Team " + teamName + " does not exist.");
                    }
                    System.out.println(teamName + " - " + (int)teams.get(teamName).getRating());
                }
            }catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            input = bf.readLine();
        }
    }
}
