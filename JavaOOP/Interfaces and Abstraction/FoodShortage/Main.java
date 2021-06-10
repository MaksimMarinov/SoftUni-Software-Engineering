package FoodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Citizen> citizens = new ArrayDeque<>();
        ArrayDeque<Rebel> rebels = new ArrayDeque<>();
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = bf.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            if(tokens.length==3){
                String group = tokens[2];
                Rebel rebel = new Rebel(name, age, group);
                rebels.push(rebel);
            }else{
                String id = tokens[2];
                String dateOfBirth = tokens[3];
                Citizen citizen = new Citizen(name, age, id, dateOfBirth);
                citizens.push(citizen);
            }
        }
        int totalFoodBought =0;
        String name = bf.readLine();
        while (!name.equals("End")){
            if(checkIfTheNameIsInTheRebelsList(name, rebels )){
                totalFoodBought+=5;
            }else if(checkIfTheNameIsInCitizenList(name, citizens )){
                totalFoodBought+=10;
            }

            name=bf.readLine();
        }
        System.out.println(totalFoodBought);

    }

    private static boolean checkIfTheNameIsInCitizenList(String name, ArrayDeque<Citizen> citizens) {
        for (Citizen citizen : citizens) {
            if(citizen.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    private static boolean checkIfTheNameIsInTheRebelsList(String name, ArrayDeque<Rebel> rebels) {
        for (Rebel rebel : rebels) {
          if(rebel.getName().equals(name)){
              return true;
          }
        }
        return false;
    }
}
