package WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime{
    private String breed;
    public Cat( String animalType, String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName,  animalWeight, livingRegion);
        this.breed=breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        DecimalFormat dm = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %s]",
                this.getAnimalType(), this.getAnimalName(),this.getBreed(), dm.format(this.getAnimalWeight()),
                this.getLivingRegion(), this.getFoodEaten());
    }
}
