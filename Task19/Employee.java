import java.util.Scanner;
import java.util.HashMap;
class Employ{
    int id;
    String name;
    Scanner sc=new Scanner(System.in);
    HashMap<Integer,String> employees=new HashMap<>();
    public void addEmploy(){
        System.out.println("Enter ID of Employee");
        int id=sc.nextInt();
        System.out.println("Enter Name of the Employee");
        String name=sc.next();
        System.out.println("\nEmployee Added");
        System.out.println("\nID of Employee :"+id+"\nName of Employee :"+name);
        employees.put(id,name);
        System.out.println(employees);
    }
    public void removeEmployee(){
        System.out.println("Enter ID of Employee to remove ");
        int id=sc.nextInt();
        System.out.println("Employee with ID :"+id+" with name :"+employees.get(id)+" is Deleted from data ");
        employees.remove(id);

    }
    public void modifyEmployee(){
        System.out.println("Enter the ID to modify the Employee");
        int id=sc.nextInt();
        String temp=employees.get(id);
        System.out.println("Enter the Employee Name to modify");
        String value=sc.next();
        employees.put(id,value);
        System.out.println("Initial Name "+temp+"\n Name after Modification :"+employees.get(id));
    }
    public void search(){
        System.out.println("Enter id to search");
        int i=sc.nextInt();
        if(employees.containsKey(i)){
            System.out.println("Your requested Employee with ID :"+i+" is :"+employees.get(i));
        }
        else{
            System.out.println("Employee with ID :"+i+" is not Found");
        }
    }
}
class PermanentEmploy extends Employ{
    int id=super.id;
    void display(int id,String name){
        System.out.println("Employee Type : Permanent ,"+"Employee id : "+id+",Employee Name  :"+name);
    }
}
class PartTimeEmploy extends Employ{
    public void display(int id,String name){
        System.out.println("Employee Type : PartTime ,"+"Employee id :"+id+", Employee Name :"+name);
    }
}
class ContractEmploy extends Employ{
    public void display(int id,String name){
        System.out.println("Employee Type : Contract ,"+"Employee id :"+id+", Employee Name :"+name);
    }
}
public class Employee {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        Employ e=new Employ();
        System.out.println("Program 1 :");
        System.out.println("Enter Employee ID ");
        int id=sc.nextInt();
        System.out.println("Enter the name of the Employee ");
        String name=sc.next();
        PermanentEmploy pe=new PermanentEmploy();
        pe.display(id,name);
        PartTimeEmploy pte=new PartTimeEmploy();
        pte.display(id,name);
        ContractEmploy ce=new ContractEmploy();
        ce.display(id,name);
        System.out.println("Program 2 :");
        e.addEmploy();
        e.addEmploy();
        e.modifyEmployee();
        e.removeEmployee();
        e.search();
    }
}