package vetClinic;


public class Main {
    public static void main(String[] args) {
        // Initialize the repository
        vetClinic.Clinic clinic = new vetClinic.Clinic(20);

// Initialize entity
        vetClinic.Pet dog = new vetClinic.Pet("Ellias", 5, "Tim");

// Print Pet
        System.out.println(dog); // Ellias 5 (Tim)

// Add Pet
        clinic.add(dog);

// Remove Pet
        System.out.println(clinic.remove("Ellias")); // true
        System.out.println(clinic.remove("Pufa")); // false

        vetClinic.Pet cat = new vetClinic.Pet("Bella", 2, "Mia");
        vetClinic.Pet bunny = new vetClinic.Pet("Zak", 4, "Jon");

        clinic.add(cat);
        clinic.add(bunny);

// Get Oldest Pet
        vetClinic.Pet oldestPet = clinic.getOldestPet();
        System.out.println(oldestPet); // Zak 4 (Jon)

// Get Pet
        vetClinic.Pet pet = clinic.getPet("Bella", "Mia");
        System.out.println(pet); // Bella 2 (Mia)

// Count
        System.out.println(clinic.getCount()); // 2

// Get Statistics
        clinic.getPet("Bella", "Mia");
        System.out.println(clinic.getStatistics());

//The clinic has the following patients:
//Bella Mia
//Zak Jon

    }
}

