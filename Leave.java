
package employeemanagementsystem;
/**
 *
 *
 */
import java.time.LocalDate;
import java.util.Date;

public class Leave {  
    private Employee employee;
    private Date startDate;
    private int daysOfLeave;
    public Leave(Employee employee, Date startDate, int daysOfLeave) {
        this.employee = employee;
        this.startDate = startDate;
        this.daysOfLeave = daysOfLeave;
    }
    Leave(Employee employee, String date, int duration) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Leave(Employee employee, LocalDate startDate, int daysOfLeave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String displayLeaveDetails() {
        String intrToString = String.format("%4d-%2d-%2d",
                startDate.getYear(),
                startDate.getMonth(),
                startDate.getDate());
        //this will replace every space with zeros
        intrToString = intrToString.replace(" ", "0");
        return intrToString + "   " + daysOfLeave;
    }
    
}
