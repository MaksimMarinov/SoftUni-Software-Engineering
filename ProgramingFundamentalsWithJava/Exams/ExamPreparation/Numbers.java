import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int sum=0;
        for (int i = 0; i <numbers.size() ; i++) {

            sum+=numbers.get(i);
        }
        int averageSum = sum/numbers.size();
       List<Integer> newList = new ArrayList<>();
        for (int  i= 0;  i< numbers.size(); i++) {
            if(numbers.get(i)>averageSum){
                newList.add(numbers.get(i));
            }

        }
        newList = newList.stream().sorted(Comparator.reverseOrder()).limit(5).collect(Collectors.toList());
        if(newList.isEmpty()){
            System.out.println("No");
        }else{
            for (Integer integer : newList) {
                System.out.print(integer+" ");

        }


        }



    }
}
