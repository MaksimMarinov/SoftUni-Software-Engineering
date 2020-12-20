import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());

        int area =  width*length*height;
        while (true){
            String command = scanner.nextLine();
            if (command.equals("Done")){

                System.out.printf("%d Cubic meters left.", area);
                break;
            }
            int num = Integer.parseInt(command);
           area = area - num;
            if (area<0){

                System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(area));
                break;

            }




        }
    }
}
