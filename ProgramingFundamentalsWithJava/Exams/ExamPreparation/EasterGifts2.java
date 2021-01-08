import java.util.Scanner;

public class EasterGifts2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        String command = scanner.nextLine();
        while (!command.equals("No Money")){
            String[] tokens = command.split("\\s+");
            switch (tokens[0]){
                case ("OutOfStock"):
                    changeNameIfItIsExist(tokens[1],input);

                    break;
                case ("Required"):
                    int index =Integer.parseInt(tokens[2]);
                    changePlacesToNewIndex(tokens[1],index,input);
                    break;
                case ("JustInCase"):
                    replaceWordToLastPlace(tokens[1],input);

                    break;

            }


            command=scanner.nextLine();
        }
        printResult(input);
        }

    private static void printResult(String[] input) {
        for (int i = 0; i < input.length; i++) {
            if(!input[i].equals("None")){
                System.out.print(input[i] + " ");

            }

        }
    }

    private static void replaceWordToLastPlace(String token, String[] input) {
        input[input.length-1]=token;
    }

    private static void changePlacesToNewIndex(String token, int index, String[] input) {
        if(index<input.length&&index>=0){
            input[index]=token;
        }
    }

    private static void changeNameIfItIsExist(String token, String[] input) {
        for (int i = 0; i <input.length ; i++) {
            if(input[i].equals(token)){
                input[i]="None";
            }

        }
    }
}

