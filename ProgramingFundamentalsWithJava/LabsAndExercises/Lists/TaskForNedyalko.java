public class TaskForNedyalko {
    public static void main(String[] args) {
                int[] input = {1,2,3,4,5,6,7,8,9,10};
                int maxNumber1=input[0];
                int maxNumber2=input[1];
                for (int i = 2; i < input.length; i++) {
                    if (input[i]>maxNumber1) {
                        maxNumber1=input[i];
                        if (input[i-1]>maxNumber2){
                            maxNumber2=input[i-1]; }

                    }if(input[i]>maxNumber2&&input[i]!=maxNumber1){
                        maxNumber2=input[i]; }
                }
                System.out.printf("%d, %d",maxNumber1, maxNumber2);

            }
        }
