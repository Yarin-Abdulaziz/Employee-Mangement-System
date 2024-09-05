
package employeemanagementsystem;

import java.util.ArrayList;

/**
 *
 * 
 */
//abstract class
public abstract class Employee {
    private final String name;
    private final int id;
    private final double salary;
    private String state = "Working";
    //array list structure 
    private final ArrayList<Leave> leaveRecords = new ArrayList<>();
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee{" + "name=" + name 
                + ", id=" +
                id + ", salary=" +
                salary + ", state=" + 
                state + ", leaveRecords=" + 
                leaveRecords + '}';
    }
    public void setStateOnLeave() {
        state = "Leave";
    }
    public void setStateWorking() { 
        state = "Working"; 
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public double getSalary() {
        return salary;
    }
    public String getState() {
        return state;
    }
    public void addLeaveRecord(Leave leave) {
        leaveRecords.add(leave); 
    }
    public ArrayList<Leave> getLeaveRecords() {
        return leaveRecords;
    }
    
}
    

