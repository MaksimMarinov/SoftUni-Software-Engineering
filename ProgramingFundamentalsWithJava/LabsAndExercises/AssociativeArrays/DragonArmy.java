import java.util.*;
import java.util.stream.Collectors;

public class DragonArmy {
    private static class Dragons{
        String name;
        int damage;
        int health;
        int armor;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }





        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getArmor() {
            return armor;
        }

        public void setArmor(int armor) {
            this.armor = armor;
        }

        public Dragons(String name,  int damage, int health, int armor) {
            this.name = name;;
            this.damage = damage;
            this.health = health;
            this.armor = armor;

        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Dragons> >typeInfo = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String type = tokens[0];
            String name = tokens[1];
            String damageAsString = tokens[2];
            String healthAsString = tokens[3];
            String armorAsString = tokens[4];
            int damage;
            int health;
            int armor;
            if(damageAsString.equals("null")){
                damage = 45;
            }else{
                damage= Integer.parseInt(damageAsString);
            }
            if(healthAsString.equals("null")){
                health = 250;
            }else{
                health= Integer.parseInt(healthAsString);
            }
            if(armorAsString.equals("null")){
                armor = 250;
            }else{
                armor= Integer.parseInt(armorAsString);
            }
            Dragons d = new Dragons(name,  damage, health, armor);
            boolean check=false;
            if(typeInfo.containsKey(type)){
                for (int j = 0; j < typeInfo.get(type).size(); j++) {
                    if(typeInfo.get(type).get(j).getName().equals(name)){
                        check=true;
                        typeInfo.get(type).get(j).setHealth(health);
                        typeInfo.get(type).get(j).setArmor(armor);
                        typeInfo.get(type).get(j).setDamage(damage);
                        break;
                    }
                }
               /* typeInfo.get(type).setArmor(armor);
                typeInfo.get(type).setHealth(health);
                typeInfo.get(type).setArmor(damage);*/
            }
            if (!check || !typeInfo.containsKey(type)) {
                typeInfo.put(type, new ArrayList<>());
            }
            typeInfo.get(type).add(d);
        }


        typeInfo.entrySet().stream().forEach(e->{
            e.getValue().stream().sorted(Comparator.comparing(Dragons::getName)).collect(Collectors.toList());

        });
    }
}
