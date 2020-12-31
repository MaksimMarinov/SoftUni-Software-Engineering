import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CompanyRoster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Employee employee = new Employee();
            String[] input = scanner.nextLine().split("\\s+");
            employee.setName(input[0]);
            employee.setSalary(Double.parseDouble(input[1]));
            employee.setPosition(input[2]);
            employee.setDepartment(input[3]);
            if(input.length==6){
                employee.setEmail(input[4]);
                employee.setAge(Integer.parseInt(input[5]));

            }else if(input.length==5){
                if(input[4].contains("@")){
                    employee.setEmail(input[4]);
                }else{
                    employee.setAge(Integer.parseInt(input[4]));
                }
            }
            employeeList.add(employee);

        }
        List<String> departmentsList = employeeList.stream().map(Employee::getDepartment).distinct()
                .collect(Collectors.toList());
        List<Department> departments= new ArrayList<>();
        for (String department : departmentsList) {
            departments.add(new Department(department, employeeList.stream().filter(employee ->
                    employee.getDepartment().equals(department)).collect(Collectors.toList())));
        }
        departments.sort(Comparator.comparing(Department::getAvgSalary).reversed());
        Department department = departments.get(0);
        department.getEmployees().sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        System.out.printf("Highest Average Salary: %s%n", department.getName());
        for (CompanyRoster.Employee employee : department.getEmployees()) {
            System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());
        }


    }
  public  static class Employee{
        String name;
        double salary;
        String position;
        String department;
        String email;
        int age;

        public Employee() {

            this.email = "n/a";
            this.age = -1;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

      public String getDepartment() {
          return department;
      }

      public void setDepartment(String department) {
          this.department = department;
      }
  }
  public static class Department {
        String name;
        List<Employee> employees;
       double avgSalary;

      public Department(String name, List<Employee> employees) {
          this.name = name;
          this.employees = employees;
          this.avgSalary = employees.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
      }

      public String getName() {
          return name;
      }

      public List<Employee> getEmployees() {
          return employees;
      }

      public double getAvgSalary() {
          return avgSalary;
      }
  }
}

