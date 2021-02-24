package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster=new ArrayList<>();
    }
    public void addPlayer(Player player){
        if(this.roster.size()<capacity){
            this.roster.add(player);
        }
    }
    public boolean removePlayer(String name){
       return this.roster.removeIf(player -> player.getName().equals(name));
    }
    public void promotePlayer(String name){
        Player player = this.roster.stream().filter(player1 -> player1.getName().equals(name)).findFirst().get();
        if(player.getRank().equals("Trial")){
            player.setRank("Member");
        }
    }
    public void demotePlayer(String name){
        Player player = this.roster.stream().filter(player1 -> player1.getName().equals(name)).findFirst().get();
        if(player.getRank().equals("Member")){
            player.setRank("Trial");
        }

    }
    public Player[] kickPlayersByClass(String clazz){
        List<Player> removed = this.roster.stream().filter(player -> player.getClazz().equals(clazz)).collect(Collectors.toList());
        this.roster.removeAll(removed);
        return removed.toArray(removed.toArray(new Player[0]));
    }
    public int count(){
        return this.roster.size();
    }
    public String report(){
        StringBuilder out = new StringBuilder("Players in the guild: ").append(this.name).append(":");
        this.roster.forEach(player -> out.append(System.lineSeparator()).append(player));
        return out.toString();
    }
}

