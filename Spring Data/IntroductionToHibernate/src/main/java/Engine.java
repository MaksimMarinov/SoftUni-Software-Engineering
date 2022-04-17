import HomeWorkTasks.*;


import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {
    private final EntityManager em;
    private static final BufferedReader bf =
            new BufferedReader(new InputStreamReader(System.in));
    private HomeWork homeWork;

    public Engine(EntityManager em) {
        this.em = em;
    }

    @Override
    public void run() {
        while (true) {
            System.out.print("Please, enter task number to solve: ");
            String taskNumber="";
            try {
                taskNumber = bf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (taskNumber) {
                case "1":
                    System.out.println("First task is just to setup :)");
                    break;
                case "2":
                    homeWork = new ChangeCasing(em);
                    break;
                case "3":
                    homeWork= new ContainsEmployee(em);
                    break;
                case "4":
                    homeWork = new EmployeesWithSalaryOver50000(em);
                    break;
                case "5":
                    homeWork = new EmployeesFromDepartment(em);
                    break;
                case "6":
                    homeWork = new AddingANewAddress(em) ;
                    break;
                case "7":
                    homeWork = new AddressesWithEmployeeCount(em);
                    break;
                case "8":
                    homeWork = new GetEmployeeWithProject(em);
                    break;
                case "9":
                    homeWork = new FindLatest10Projects(em);
                    break;
                case "10":
                    homeWork = new IncreaseSalaries(em);
                    break;
                case "11":
                    homeWork = new FindEmployeesByFirstName(em);
                    break;
                case "12":
                    homeWork = new EmployeesMaximumSalaries(em);
                    break;
                case "13":
                    homeWork = new RemoveTowns(em);
                    break;
                default:
                    System.out.printf("Entered task number is not valid!%nPlease try again, you must enter single number from  2 to 13%n");
                    continue;

            }
            homeWork.solveTask();

            System.out.printf("Do you want to check another task?%n If yes, please press y%n" +
                    "If no, you can press any key %n");
            String decision ="";
            try {
                decision = bf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!decision.equals("y")) {
                System.out.println("Thank you for participation!");
                try {
                    bf.close();
                    this.em.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return;
            }
        }
    }
}