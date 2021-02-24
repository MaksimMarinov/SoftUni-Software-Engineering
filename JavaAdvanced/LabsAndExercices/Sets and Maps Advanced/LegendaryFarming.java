import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> keyMaterials = new HashMap<>();
        Map<String, Integer> junkMaterials = new HashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        while (true){
            String[] input = scanner.nextLine().split(" ");
            boolean getLegendaryItem = false;

                for (int i = 0; i < input.length; i+=2) {
                    String material = input[i+1].toLowerCase();
                    int quantity = Integer.parseInt(input[i]);
                    if(material.equals("shards")||material.equals("fragments")||material.equals("motes")){
                        int currentQuantity = keyMaterials.get(material);
                        keyMaterials.put(material,currentQuantity+quantity );
                        if(keyMaterials.get(material)>=250){
                            getLegendaryItem=true;
                            break;
                        }
                    }else{
                        if(junkMaterials.containsKey(material)){
                            int currentQuantity = junkMaterials.get(material);
                            junkMaterials.put(material,quantity+currentQuantity);
                        }else{
                            junkMaterials.put(material,quantity);
                        }
                    }
                }
                if(getLegendaryItem){
                    if(keyMaterials.get("shards")>=250){
                        keyMaterials.put("shards", keyMaterials.get("shards")-250);
                        System.out.println("Shadowmourne obtained!");
                    }else if(keyMaterials.get("fragments")>=250){
                        keyMaterials.put("fragments", keyMaterials.get("fragments")-250);
                        System.out.println("Valanyr obtained!");
                    }else{
                        keyMaterials.put("motes", keyMaterials.get("motes")-250);
                        System.out.println("Dragonwrath obtained!");
                    }
                    break;
                }
            }
        keyMaterials.entrySet().stream().sorted((a,b)->{
            if(!a.getValue().equals(b.getValue())){
                return Integer.compare(b.getValue(),a.getValue());
            }else{
                return a.getKey().compareTo(b.getKey());
            }
        }).forEach(material->{
            System.out.println(material.getKey()+": "+material.getValue());
        });

        junkMaterials.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(material->{
            System.out.println(material.getKey()+": "+material.getValue());
        });

        }

    }





