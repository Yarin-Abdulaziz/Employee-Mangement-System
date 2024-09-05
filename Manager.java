
package employeemanagementsystem;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 *
 */
public class Manager extends Employee implements Approver {
    public Manager(String name, int id, double salary) {
        super(name, id, salary);
    }
    public double calculateBonus() {
        //salary for emplyee 15%
        return getSalary() * 0.15;
    }
    /**
     *
     * @param employee
     * @param startDate
     * @param daysOfLeave
     */
    public void approveLeave(Employee employee, Date startDate, int daysOfLeave) {
        //leave obj
        Leave leave = new Leave(employee, startDate, daysOfLeave); 
        //add leave obj to the records
        employee.addLeaveRecord(leave); 
        //set the emplyee state to leave 
        employee.setStateOnLeave(); // Set employee state to "Leave"   
    } 
    @Override
    public void markEmployeeAsWorking(Employee employee) {
        //set the emplyee as "Working"
        employee.setStateWorking(); 
        
    }

    @Override
    public void approveLeave(Employee employee, LocalDate startDate, int daysOfLeave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
    


  
    
    
