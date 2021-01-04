package com.company;

import java.util.Scanner;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if(line.contains(", ")){
            String[] tickets = line.split("[, ]+");
            for (String ticket : tickets) {
                ticketCheck(ticket);
            }
        }else{
            ticketCheck(line);
        }

    }
    private static void ticketCheck (String ticket){
        if(ticket.length()!=20){
            System.out.println("invalid ticket");
        }else{
        boolean ticketIsWinner = false;
        char winningChar = ' ';
        int counter = 0;
        int maxCounterLeft = 0;
        for (int i = 0; i < ticket.length()/2; i++) {
            if(ticket.charAt(i)=='@'||ticket.charAt(i)=='#'||ticket.charAt(i)=='$'||ticket.charAt(i)=='^'){
                ticketIsWinner=true;
                counter++;
                winningChar=ticket.charAt(i);
                if(counter>1){
                    if(ticket.charAt(i)==ticket.charAt(i-1)){
                       maxCounterLeft=counter;
                    }else{
                        counter=0;
                    }
                }
            }
        }
        if(!ticketIsWinner){
            System.out.printf("ticket \"%s\" - no match", ticket);
        }else{
            counter=0;
            int maxCounterRight=0;

        for (int i = ticket.length()-1; i >=ticket.length()/2 ; i--) {
            if(ticket.charAt(i)=='@'||ticket.charAt(i)=='#'||ticket.charAt(i)=='$'||ticket.charAt(i)=='^'){
                counter++;
                if(counter>1){
                    if(ticket.charAt(i)==ticket.charAt(i+1)){
                        maxCounterRight=counter;
                    }else{
                        counter=0;
                    }
                }

            }
        }
        if(Math.max(maxCounterLeft, maxCounterRight)>=6&&Math.max(maxCounterLeft, maxCounterRight)<10){
            System.out.printf("ticket \"%s\" - %d%c%n",ticket,Math.max(maxCounterLeft, maxCounterRight),winningChar);
        }else if(Math.max(maxCounterLeft, maxCounterRight)==10){
            System.out.printf("ticket \"%s\" - %d%c Jackpot!%n",ticket,Math.max(maxCounterLeft, maxCounterRight),winningChar);
        }
    }}}
}
