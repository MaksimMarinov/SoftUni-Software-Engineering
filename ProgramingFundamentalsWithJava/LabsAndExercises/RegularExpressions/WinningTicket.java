import java.util.Scanner;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("[\\s,]+");
        String separator="";
        for (String s : input) {
            if(s.length()!=20){
                System.out.println("invalid ticket");
            }else{
                String leftSide = s.substring(0,10);
                String rightSide = s.substring(10);
                if(!s.contains("$")&&!s.contains("@")&&!s.contains("#")&&!s.contains("^")){
                    System.out.printf("ticket \"%s\" - no match%n",s);

                }else{
                    separator =  checkSeparator(s);
                    int countLeft = countLeftSide(separator, leftSide);
                    int countRight = countLeftSide(separator, rightSide);
                    int winnerLine = Math.min(countLeft,countRight);
                    if(winnerLine>=6&&winnerLine<10){
                        System.out.printf("ticket \"%s\" - %d%s%n", s,winnerLine,separator);
                    }else if(winnerLine==10){
                        System.out.printf("ticket \"%s\" - %d%s Jackpot!%n", s,winnerLine,separator);
                    }else{
                        System.out.printf("ticket \"%s\" - no match%n",s);
                    }

                }

            }

        }



    }

    private static int countLeftSide(String separator, String leftSide) {
        int totalCount=0;
        int count=0;
        char newSep=separator.charAt(0);
        for (int i = 0; i < leftSide.length(); i++) {
            char check = leftSide.charAt(i);
            if(i==0&&check==newSep){
                count=1;
            }
            else if(check==newSep&&newSep==leftSide.charAt(i-1)){
                count+=1;
                totalCount=count;
            }else if(check==newSep&&newSep!=leftSide.charAt(i-1)){
                count=1;
            }else{
                count=0;
            }
        }return totalCount;
    }

    public static String checkSeparator(String ticket){
       if(ticket.contains("$")){
           return "$";
       }else if(ticket.contains("#")){
           return "#";
       }else if(ticket.contains("@")){
           return "@";

       }
       return "^";
    }


}
