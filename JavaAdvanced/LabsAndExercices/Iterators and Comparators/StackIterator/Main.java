package StackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomStack customStack = new CustomStack();
        String[] initialValues = scanner.nextLine().split(",\\s+");

        customStack.push(Integer.parseInt(initialValues[0].split("\\s+")[1]));
        for (int i = 1; i < initialValues.length; i++) {
            customStack.push(Integer.parseInt(initialValues[i].trim()));
        }
        String line = scanner.nextLine();
        while (!line.equals("END")){
            if(line.equals("Pop")){
                try {
                    customStack.pop();
                }catch (IllegalStateException e){
                    System.out.println(e.getMessage());
                }

            }else{
                customStack.push(Integer.parseInt(line.split("\\s+")[1]));
            }

            line= scanner.nextLine();
        }
        customStack.forEach(System.out::println);
        customStack.forEach(System.out::println);

    }
}
