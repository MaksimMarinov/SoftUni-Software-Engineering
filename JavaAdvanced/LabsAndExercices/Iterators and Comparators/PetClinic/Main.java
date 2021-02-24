package PetClinic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic> clinics = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            switch (command[0]){
                case "Create":
                    if(command[1].equals("Pet")){
                        String petName = command[2];
                        Pet pet = new Pet(petName, Integer.parseInt(command[3]), command[4] );
                        pets.putIfAbsent(petName, pet);

                    }else{
                    try{
                    String clinicName = command[2];
                    Clinic clinic = new Clinic(clinicName, Integer.parseInt(command[3]));
                    clinics.putIfAbsent(clinicName, clinic);
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    }
                    break;
                case "Add":
                    String petName =command[1];
                    String clinicName = command[2];
                    Pet pet = pets.get(petName);
                    Clinic clinic = clinics.get(clinicName);
                    System.out.println(clinic.addPet(pet));
                    break;
                case "Release":
                    Clinic clinic1 = clinics.get(command[1]);
                    System.out.println(clinic1.release());
                    break;
                case "HasEmptyRooms":
                    System.out.println(clinics.get(command[1]).hasEmptyRooms());
                    break;
                case "Print":
                    String klinikName = command[1];
                    Clinic clinic2 = clinics.get(klinikName);
                    if(command.length==2){
                        for (Pet p : clinic2.getPets()) {
                           if(p==null){
                               System.out.println("Room empty");
                           }else{
                               System.out.println(p.toString());
                           }
                        }
                    }else{
                        int room = Integer.parseInt(command[2]);
                        clinic2.printClinicRoomInfo(room);
                    }
                    break;
            }
        }



    }


}
