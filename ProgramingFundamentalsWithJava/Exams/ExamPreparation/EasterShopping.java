import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasterShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> shops = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <n ; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            switch (command[0]){
                case ("Include"):
                    addToTheEnd(command[1], shops);
                    break;
                case ("Visit"):
                    if(Integer.parseInt(command[2])<=shops.size()){
                        switch (command[1]) {
                            case ("first"):
                                for (int j = 0; j < Integer.parseInt(command[2]); j++) {
                                    shops.remove(0);
                                }
                                break;
                            case ("last"):
                                for (int j = 0; j < Integer.parseInt(command[2]); j++) {
                                    shops.remove(shops.size()-1);
                                }
                                break;

                        }
                    }

                    break;
                case ("Prefer"):
                    changePlacesByIndex(shops, Integer.parseInt(command[1]),Integer.parseInt(command[2]));
                    break;
                case ("Place"):
                    insertAfterIndex(Integer.parseInt(command[2]), shops, command[1]);

                    break;
            }


        }
        System.out.println("Shops left:");
        for (String shop : shops) {
            System.out.print(shop + " ");

        }


    }

    private static void insertAfterIndex(int index, List<String> shops, String s) {
        if(index>=0&&index<shops.size()){
            shops.add(index+1,s);
        }
    }

    private static void changePlacesByIndex(List<String> shops, int index1,int index2) {
        if(index1>=0&&index1<shops.size()&&index2>=0&&index2<shops.size()){
            String word1 = shops.get(index1);
            String word2 = shops.get(index2);
            shops.set(index1,word2);
            shops.set(index2,word1);
        }
    }

    private static void addToTheEnd(String s, List<String> shops) {
        shops.add(s);
    }
}
