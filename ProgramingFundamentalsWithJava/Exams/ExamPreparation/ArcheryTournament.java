import java.util.Arrays;
import java.util.Scanner;

public class ArcheryTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\|")).
                mapToInt(e -> Integer.parseInt(e)).toArray();
        String command = scanner.nextLine();
        int totalPoints =0;
        while (!command.equals("Game over")){
            String[] tokens = command.split("\\s+");
            String[] indexes = new String[3];
            if(tokens.length>1){
                indexes=tokens[1].split("@");
            }
            switch (tokens[0]){
                case("Shoot"):
                    int startIndex = Integer.parseInt(indexes[1]);
                    int length = Integer.parseInt(indexes[2]);
                    int shootingIndex = 0;
                    if(startIndex>=input.length||startIndex<0){
                        command=scanner.nextLine();
                        continue;
                    }
                    if(indexes[0].equals("Left")){
                        shootingIndex=FindShootingIndexLeft(input, length, startIndex);
                        if(input[shootingIndex]>=5){
                            input[shootingIndex]-=5;
                            totalPoints= points(totalPoints,5);

                        }else if(input[shootingIndex]<5&&input[shootingIndex]>0){
                            totalPoints = points(totalPoints,input[shootingIndex]);
                            input[shootingIndex]=0;
                        }

                    }else if(indexes[0].equals("Right")){
                        shootingIndex=FindShootingIndexRight(input,length,startIndex);
                        if(input[shootingIndex]>=5){
                            input[shootingIndex]-=5;
                            totalPoints= points(totalPoints,5);

                        }else if(input[shootingIndex]<5&&input[shootingIndex]>0){
                            totalPoints = points(totalPoints,input[shootingIndex]);
                            input[shootingIndex]=0;
                        }

                    }

                    break;
                case("Reverse"):
                    input=reverseArray(input);
                    break;

            }


            command=scanner.nextLine();
        }
        printResult(input,totalPoints);
    }

    private static int FindShootingIndexLeft(int[] input, int length, int startIndex) {
        int index=startIndex-length;

        if(index<0){
            while (index<0){
                index=input.length+index;


            }
        }return index;
    }
    private static int FindShootingIndexRight(int[] input, int length, int startIndex) {
        int index=startIndex+length;

        if (index > input.length) {
            while (index > input.length) {
                index = startIndex+length;
                length=length-input.length-1;
                if(length<input.length){
                    length++;
                }

            }

        }return index;
    }

    private static int points(int points, int pointsToAdd){
        points+=pointsToAdd;
        return points;

    }
    private static void printResult(int array[], int points){
        for (int i = 0; i <array.length-1 ; i++) {
            System.out.print(array[i]+ " " + "-"+" ");
        }System.out.print(array[array.length-1]);
        System.out.printf("%nIskren finished the archery tournament with %d points!", points);

    }


    public static int[] reverseArray(int array[]){
        int[] b = new int[array.length];
        int j = array.length;

        for (int i = 0; i < array.length; i++) {
            b[j - 1] = array[i];
            j = j - 1;
        }
        return b;

    }
}
