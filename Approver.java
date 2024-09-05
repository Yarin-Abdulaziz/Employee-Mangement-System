
package employeemanagementsystem;

import java.time.LocalDate;

/**
 *
 * 
 */
//interface class
//interface treated like speical class in java   
public interface Approver {
    public void approveLeave(Employee employee, LocalDate startDate, int daysOfLeave);
    public void markEmployeeAsWorking(Employee employee);
    
}

