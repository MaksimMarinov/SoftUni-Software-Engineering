import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] robotsInput = scanner.nextLine().split(";");
       Map<String, Integer> robotsInfo= getLinkedHashMap(robotsInput);
        int[] workingTime= new int[robotsInfo.size()];
        String time = scanner.nextLine();
        int hours = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        int seconds = Integer.parseInt(time.split(":")[2]);
        long totalTimeInSeconds = hours*3600+minutes*60+seconds;

        String product = scanner.nextLine();
        ArrayDeque<String> products = new ArrayDeque<>();
        while (!product.equals("End")){
            products.offer(product);
            product= scanner.nextLine();
        }
       while(!products.isEmpty()){
           totalTimeInSeconds++;
           String currentProduct=products.poll();
           boolean isAssigned = false;
           for (int robot = 0; robot < workingTime.length; robot++) {
               if(workingTime[robot]>0){
                   --workingTime[robot];
               }
           }
           for (int i = 0; i < workingTime.length; i++) {
               if(workingTime[i]==0){
                   int count = 0;
                   for (Map.Entry<String, Integer> robot: robotsInfo.entrySet()) {
                       if(count==i){
                           workingTime[i]=robot.getValue();
                           long takenHours =totalTimeInSeconds/3600%24;
                           long takenMinutes = totalTimeInSeconds%3600/60;
                           long takenSeconds = totalTimeInSeconds%60;
                           System.out.printf("%s - %s [%02d:%02d:%02d]%n", robot.getKey(),
                                   currentProduct, takenHours, takenMinutes, takenSeconds );
                           isAssigned=true;
                           break;
                       }
                       count++;
                   }
                   break;
               }
           }
           if(!isAssigned){
            products.offer(currentProduct);
           }
       }


    }

    private static Map<String, Integer> getLinkedHashMap(String[] robotsInput) {
        Map<String, Integer> robotsInfo = new LinkedHashMap<>();
        for (String s : robotsInput) {
            String[] tokens = s.split("-");
            robotsInfo.put(tokens[0], Integer.parseInt(tokens[1]));
        }
        return robotsInfo;
    }
}
