package bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees=new ArrayList<>();
    }
    public void add(Employee employee){
        if(this.employees.size()<this.capacity){
            this.employees.add(employee);
        }
    }
    public boolean remove(String name){
        return this.employees.removeIf(employee -> employee.getName().equals(name));
    }
    public Employee getOldestEmployee(){
        return this.employees.stream().max(Comparator.comparingInt(Employee::getAge)).get();
    }
    public Employee getEmployee(String name){
        return this.employees.stream().filter(employee -> employee.getName().equals(name)).findFirst().orElse(null);
    }
    public int getCount(){
        return this.employees.size();
    }
    public String report(){
        StringBuilder out = new StringBuilder("Employees working at Bakery ").append(this.name).append(":");
        this.employees.forEach(employee -> out.append(System.lineSeparator()).append(employee));
        return out.toString();
    }
}
