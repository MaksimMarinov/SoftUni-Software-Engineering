package workingWithAbstraction.greedyTimes;

import java.util.HashMap;
import java.util.Map;

public class Bag {
    private long capacity;
    private long currentTotalQuantity;
    private long gold;
    private Map<String, Long> gems;
    private Map<String, Long> cash;
    private boolean goldIsAdded;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.gems = new HashMap<>();
        this.cash = new HashMap<>();
    }

    public void addCash(String item, long quantity) {
    long totalGems = getTotalGems();
    long totalCash = getTotalCash();
    if(hasFreeCapacity(quantity)&& totalGems>=totalCash+quantity){
        if(!this.cash.containsKey(item)){
            this.cash.put(item, quantity);
        }else {
            this.cash.put(item, this.cash.get(item)+quantity);
        }
        this.currentTotalQuantity+=quantity;
    }
    }
    public long getTotalCash(){
        return this.cash.values().stream().mapToLong(e->e).sum();
    }

    public void addGems(String item, long quantity) {
        long totalGems = getTotalGems();
        if(hasFreeCapacity(quantity)&&totalGems+quantity<=this.gold){
        this.gems.putIfAbsent(item, (long) 0);
        this.gems.put(item, this.gems.get(item)+quantity);
        this.currentTotalQuantity+=quantity;
        }
    }
    private long getTotalGems(){
        return this.gems.values().stream().mapToLong(e->e).sum();
    }

    public void addGold(long quantity) {
    if(hasFreeCapacity(quantity)){
        this.gold+=quantity;
        this.currentTotalQuantity+=quantity;
        this.goldIsAdded=true;
    }
    }

    private boolean hasFreeCapacity(long quantity) {
        return currentTotalQuantity + quantity <= capacity;
    }

    public void printContent() {
        StringBuilder sb = new StringBuilder();
        if(goldIsAdded){
            sb.append(String.format("<Gold> $%d", this.gold)).append(System.lineSeparator());
            sb.append(String.format("##Gold - %d", this.gold)).append(System.lineSeparator());
        }
        convertData(sb, this.gems, "<Gem> $%d", getTotalGems());
        convertData(sb, this.cash, "<Cash> $%d", getTotalCash());

        System.out.println(sb.toString().trim());
    }

    private void convertData(StringBuilder sb, Map<String, Long> gems, String s, long totalGems) {
        if (!gems.isEmpty()) {
            sb.append(String.format(s, totalGems)).append(System.lineSeparator());
            gems.entrySet().stream().sorted((g1, g2) -> {
                int res = g2.getKey().compareTo(g1.getKey());
                if (res == 0) {
                    res = g1.getValue().compareTo(g2.getValue());
                }
                return res;
            })
                    .forEach(e -> sb.append(String.format("##%s - %d", e.getKey(), e.getValue()))
                            .append(System.lineSeparator()));
        }
    }
}
