package GenericCountMethodDoubles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Box<Double> box = new Box<>();
        while (n-->0){
            box.getElements().add(Double.parseDouble(bf.readLine()));
        }
        int count = box.countElementsGrater(Double.parseDouble(bf.readLine()), box.getElements());
        System.out.println(count);
    }



}
