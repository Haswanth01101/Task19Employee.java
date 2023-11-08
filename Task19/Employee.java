import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
class Employee {
    private int employeeId;
    private String name;
    private double salary;
    public Employee(int employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
}
class PermanentEmployee extends Employee {
    private String department;

    public PermanentEmployee(int employeeId, String name, double salary, String department) {
        super(employeeId, name, salary);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
class PartTimeEmployee extends Employee {
    private String shiftTime;
    public PartTimeEmployee(int employeeId, String name, double salary, String shiftTime) {
        super(employeeId, name, salary);
        this.shiftTime = shiftTime;
    }

    public String getShiftTime() {
        return shiftTime;
    }
}
class ContractEmployee extends Employee {
    private int contractDuration;
    public ContractEmployee(int employeeId, String name, double salary, int contractDuration) {
        super(employeeId, name, salary);
        this.contractDuration = contractDuration;
    }

    public int getContractDuration() {
        return contractDuration;
    }
}
public class Employe{
    private List<Employee> employees = new ArrayList<>();
    private Map<Integer, Employee> employeeMap = new HashMap<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employeeMap.put(employee.getEmployeeId(), employee);
    }
    public void removeEmployee(int employeeId) {
        Employee employee = employeeMap.get(employeeId);
        if (employee != null) {
            employees.remove(employee);
            employeeMap.remove(employeeId);
        } else {
            System.out.println("Employee with ID " + employeeId + " does not exist.");
        }
    }
    public void displayAllEmployees() {
        System.out.println("List of Employees:");
        for (Employee employee : employees) {
            if (employee instanceof PermanentEmployee) {
                PermanentEmployee permEmp = (PermanentEmployee) employee;
                System.out.println("Permanent Employee - ID: " + employee.getEmployeeId() + ", Name: " + employee.getName() +
                        ", Department: " + permEmp.getDepartment());
            } else if (employee instanceof PartTimeEmployee) {
                PartTimeEmployee partTimeEmp = (PartTimeEmployee) employee;
                System.out.println("Part-Time Employee - ID: " + employee.getEmployeeId() + ", Name: " + employee.getName() +
                        ", Shift Time: " + partTimeEmp.getShiftTime());
            } else if (employee instanceof ContractEmployee) {
                ContractEmployee contractEmp = (ContractEmployee) employee;
                System.out.println("Contract Employee - ID: " + employee.getEmployeeId() + ", Name: " + employee.getName() +
                        ", Contract Duration: " + contractEmp.getContractDuration() + " months");
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employe employeeManagement = new Employe();

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Display All Employees");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Employee Type (1 - Permanent, 2 - Part-Time, 3 - Contract):");
                    int type = scanner.nextInt();
                    System.out.println("Enter Employee ID:");
                    int empId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter Employee Name:");
                    String empName = scanner.nextLine();
                    System.out.println("Enter Employee Salary:");
                    double empSalary = scanner.nextDouble();
                    switch (type) {
                        case 1:
                            System.out.println("Enter Department:");
                            scanner.nextLine(); // Consume newline
                            String department = scanner.nextLine();
                            employeeManagement.addEmployee(new PermanentEmployee(empId, empName, empSalary, department));
                            break;
                        case 2:
                            System.out.println("Enter Shift Time:");
                            scanner.nextLine(); // Consume newline
                            String shiftTime = scanner.nextLine();
                            employeeManagement.addEmployee(new PartTimeEmployee(empId, empName, empSalary, shiftTime));
                            break;
                        case 3:
                            System.out.println("Enter Contract Duration (in months):");
                            int contractDuration = scanner.nextInt();
                            employeeManagement.addEmployee(new ContractEmployee(empId, empName, empSalary, contractDuration));
                            break;
                        default:
                            System.out.println("Invalid employee type.");
                    }
                    break;
                case 2:
                    System.out.println("Enter Employee ID to remove:");
                    int idToRemove = scanner.nextInt();
                    employeeManagement.removeEmployee(idToRemove);
                    break;

                case 3:
                    employeeManagement.displayAllEmployees();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
