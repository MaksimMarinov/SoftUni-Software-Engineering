package ShoppingSpree;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    private void setCost(double cost) {
        if(cost<0){
            throw new IllegalStateException("Money cannot be negative");
        }else{
            this.cost=cost;
        }
    }

    private void setName(String name) {
        if(name.replaceAll("\\s+","").length()<1){
            throw new IllegalStateException("Name cannot be empty");
        }else{
            this.name=name;
        }
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }
}
