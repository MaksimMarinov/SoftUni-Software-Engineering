import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalPrice=0;
        String command = scanner.nextLine();
        while ((!command.equals("special"))){
            if(command.equals("regular")){
                break;
            }
           double price = Double.parseDouble(command);
            if(price<0){
                System.out.println("Invalid price!" );
                command=scanner.nextLine();
                continue;
            }
            totalPrice+=price;
            command=scanner.nextLine();
        }
        double tax = totalPrice*0.2;
        double totalPriceWithTaxes=totalPrice+tax;
       if(command.equals("special")){
           totalPriceWithTaxes=totalPriceWithTaxes*0.9;
       }
       if(totalPrice<=0){
           System.out.println("Invalid order!");
       }else{
        System.out.printf("Congratulations you've just bought a new computer!%n" +
                "Price without taxes: %.2f$%n" +
                "Taxes: %.2f$%n" + "-----------%n"+
                "Total price: %.2f$"
                ,totalPrice, tax,totalPriceWithTaxes);}

    }
}
//(!command.equals("regular"))