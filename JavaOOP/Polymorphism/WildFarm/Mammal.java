package WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{
    private String livingRegion;
    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion=livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }


    @Override
    public void eat(Food food) {
        if(food instanceof Vegetable){
            this.setFoodEaten(this.getFoodEaten()+food.getQuantity());
        }else{
            String type = "Zebras";
            if(this.getAnimalType().equals("Mouse")){
                type = "Mice";
            }
            throw new IllegalStateException(type+" are not eating that type of food!");
        }

    }
    @Override
    public String toString() {
        DecimalFormat dm = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s]",
                this.getAnimalType(), this.getAnimalName(), dm.format(this.getAnimalWeight()),
                this.getLivingRegion(), this.getFoodEaten());
    }
}
