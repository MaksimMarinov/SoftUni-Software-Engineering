import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> pokemonDistance = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;

        while (!pokemonDistance.isEmpty()){
            int index = Integer.parseInt(scanner.nextLine());
            int numberToRemove = 0;

            if(index>pokemonDistance.size()-1){
                numberToRemove = pokemonDistance.remove(pokemonDistance.size()-1);
                pokemonDistance.add(pokemonDistance.get(0));
                sum+=numberToRemove;
            }else if (index<0) {
                numberToRemove=pokemonDistance.remove(0);

                sum += numberToRemove;
                pokemonDistance.add(0, pokemonDistance.get(pokemonDistance.size() - 1));}

            else {
                numberToRemove = pokemonDistance.remove(index);
                sum += numberToRemove;

            }
            for (int i = 0; i < pokemonDistance.size(); i++) {
                if (numberToRemove >= pokemonDistance.get(i)) {
                    pokemonDistance.set(i, pokemonDistance.get(i) + numberToRemove);

                } else {
                    pokemonDistance.set(i, pokemonDistance.get(i) - numberToRemove);
                }
            }



        }
        System.out.println(sum);


    }


}
