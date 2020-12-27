import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int countMaxSequence=1;
        int currentSequence=1;
        String currentSymbol = input[0];
        String toPrint = currentSymbol;
        for (int i = 1; i < input.length; i++) {

            if(input[i].equals(currentSymbol)){
                currentSequence++;
            }else{
                currentSymbol=input[i];
                currentSequence=1;
            }
            if(countMaxSequence<currentSequence){
                countMaxSequence=currentSequence;
                toPrint=currentSymbol;
            }

        }
        for (int i = 0; i<countMaxSequence; i++){
            System.out.print(toPrint+" ");
        }

    }
}
