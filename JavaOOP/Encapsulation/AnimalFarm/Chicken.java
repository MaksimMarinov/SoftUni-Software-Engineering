package AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setAge(int age) {
        if(age>=0&&age<=15){
            this.age=age;
        }else{
            throw new IllegalStateException("Age should be between 0 and 15.");
        }

    }

    private void setName(String name) {
        if (name.length() < 1) {
            throw new IllegalStateException("Name cannot be empty.");
        } else {
            this.name = name;
        }
    }
   private double calculateProductPerDay(){
       if(this.age<6){
           return 2;
       }else if(this.age<12){
           return 1;
       }
       return 0.75;
    }

    public double productPerDay(){
       return this.calculateProductPerDay();

  }

    @Override
    public String toString() {
        return String.format("Chicken %s %d can produce %.0f eggs per day.",this.name, this.age, this.productPerDay() );
    }
}
