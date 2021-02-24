package GenericSwapMethodIntegers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Box<Integer> box = new Box();
        int n = Integer.parseInt(bf.readLine());
        while (n-->0){
            box.getElements().add(Integer.parseInt(bf.readLine()));
        }
        int[] indexes = Arrays.stream(bf.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        bf.close();
        box.swapElements(indexes[0], indexes[1]);
        System.out.println(box.toString());;
    }
}
