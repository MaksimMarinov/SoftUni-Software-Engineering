import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String command = bf.readLine();
        Set<String> parkingInfo = new LinkedHashSet<>();
       while (command.charAt(0)!='E'){
           int index = command.indexOf(',');
           String number = command.substring(index+2);
        if(command.charAt(0)=='I'){
           parkingInfo.add(number);
        }else{
            parkingInfo.remove(number);
        }

           command= bf.readLine();
       }
       if(parkingInfo.isEmpty()){
           System.out.println("Parking Lot is Empty");
       }else{
           parkingInfo.forEach(System.out::println);
       }

    }
}
