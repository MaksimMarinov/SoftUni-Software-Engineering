import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(e -> Integer.parseInt(e)).toArray();
        String command = scanner.nextLine();
        int count=0;
        while (!command.equals("End")){
            int indexHit = Integer.parseInt(command);
            if(indexHit>input.length-1){
                command=scanner.nextLine();
                continue;
            }
            if (isHit(input[indexHit])) {
                command=scanner.nextLine();
                continue;}
            else {
                int power = input[indexHit];
                for (int i = 0; i < input.length; i++) {
                    if(input[i]>power){
                        if (!isHit(input[i])){
                            input[i]-=power;
                            input[indexHit]=-1;}
                    }else{
                        if (!isHit(input[i])){
                            input[i]+=power;
                            input[indexHit]=-1;
                        }

                    }

                }input[indexHit]=-1;
                count++;
            }


            command=scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ",count);// {target1} {target2}… {targetn}\"")//;
        for (int i = 0; i <input.length ; i++)
            {
            System.out.print(input[i]+" ");

        }
    }
    public static boolean isHit(int n){
        boolean isHit = false;
        if(n==-1){
            isHit=true;
        }
        return isHit;
    }
}
