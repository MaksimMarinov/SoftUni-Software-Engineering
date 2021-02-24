import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Set<String> vip = new TreeSet<>();
        Set<String> notVip = new TreeSet<>();
        String command = bf.readLine();
        while(!command.equals("PARTY")){
            if(Character.isDigit(command.charAt(0)))
            vip.add(command);
            else{
                notVip.add(command);
            }
            command = bf.readLine();
        }
        command = bf.readLine();
        while (!command.equals("END")){
            if(Character.isDigit(command.charAt(0)))
                vip.remove(command);
            else{
                notVip.remove(command);
            }
            command = bf.readLine();
        }
        System.out.println(vip.size()+notVip.size());
       vip.addAll(notVip);
        vip.forEach(System.out::println);


    }
}
