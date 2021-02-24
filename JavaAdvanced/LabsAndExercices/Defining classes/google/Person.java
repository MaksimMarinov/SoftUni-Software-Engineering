package google;


import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Car car;
    private Company company;
    private List<Parent> parentList;
    private List<Pokemon> pokemonList;
    private List<Children> childrenList;

    public Person(String name) {
        this.name = name;
        this.parentList = new ArrayList<>();
        this.pokemonList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    public void add(Parent parent){
        this.parentList.add(parent);
    }
    public void add(Children children){
        this.childrenList.add(children);
    }
    public void add(Pokemon pokemon){
        this.pokemonList.add(pokemon);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.name);
        sb.append(System.lineSeparator());
        sb.append("Company: ").append(System.lineSeparator());
        if (this.company!=null){
            sb.append(this.company).append(System.lineSeparator());
        }
        sb.append("Car: ").append(System.lineSeparator());
        if(this.car!=null){
            sb.append(this.car).append(System.lineSeparator());
        }
        sb.append("Pokemon: ").append(System.lineSeparator());
        this.pokemonList.forEach(pokemon -> sb.append(pokemon).append(System.lineSeparator()));
        sb.append("Parents: ").append(System.lineSeparator());
        this.parentList.forEach(parent -> sb.append(parent).append(System.lineSeparator()));
        sb.append("Children:").append(System.lineSeparator());
        this.childrenList.forEach(child -> sb.append(child).append(System.lineSeparator()));
        return sb.toString();
    }
}
