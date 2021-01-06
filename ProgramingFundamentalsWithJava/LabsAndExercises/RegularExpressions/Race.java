import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] racers = scanner.nextLine().split("[,\\s]+");
        String command = scanner.nextLine();
        Map<String, Integer> raceInfo =  new LinkedHashMap<>();
        while (!command.equals("end of race")){
        String name = command.replaceAll("[^A-Za-z]", "");
        String[] distanceAsString = command.replaceAll("[^\\d]", "").split("");
          int distance=  Arrays.stream(distanceAsString).mapToInt(Integer::parseInt).sum();
          boolean check = false;

            for (String racer : racers) {
                if(racer.equals(name)){
                    check=true;
                    break;
                }
            }
            if(check){
                if(raceInfo.containsKey(name)){
                    raceInfo.put(name, raceInfo.get(name)+distance);
                }else{
                    raceInfo.put(name, distance);
                }

            }


            command= scanner.nextLine();
        }

        List<String> newList = new ArrayList<>();
      raceInfo.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(3)
                .forEach(e-> newList.add(e.getKey()));



            System.out.printf("1st place: %s%n"+
            "2nd place: %s%n"+
                    "3rd place: %s%n",newList.get(0), newList.get(1), newList.get(2));



    }

}
