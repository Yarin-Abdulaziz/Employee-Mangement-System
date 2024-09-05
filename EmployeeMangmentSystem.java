
package employeemanagementsystem;
import java.util.ArrayList;


/**
 *
 * 
 */
public class EmployeeMangmentSystem {
    //use the array lisy to store emplyee in the arraylist 
     private static final ArrayList<Employee> employees = new ArrayList<>();
    
public EmployeeMangmentSystem(){
    
}
    // 1st method (addEmployee) it takes an employee object as an argument 
    public static String addEmployee(Employee employee) {
        //add employee to the array list 
        employees.add(employee);
        // used instance of because it checks whether an object is an instance of a particular class or interface and then return true or false
        if (employee instanceof Manager) {
            //confirmation message for Manager
        return "Manager " + employee.getName() + " added.";
    } else if (employee instanceof Developer) {
        //confirmation message for Developer
        return "Developer " + employee.getName() + " added.";
    } else {
        //confermation message for Designer 
        return "Designer " + employee.getName() + " added.";
    }

        
    }
// 2nd method (removeEmployee) it removes an employee from the system based on thier Id

    public static String removeEmployee(int id) {
        //Search for employee object using the method (find employee by ID )
        Employee employee = findEmployeeByID(id);
        if(employee == null){// if the employee is not fouu\nd or null
            return "Employee with id"+id+" not found";
        }
        else{
        //remove emplyee from the list
        employees.remove(employee);
        return "Employee removed successfully";
    }
        
    
    }

    private static Employee findEmployeeByID(int id) {
        int i = 0;
while (i < employees.size()) {
    if (employees.get(i).getId() == id) {
        return employees.get(i);
    }
    i++;
}
return null;

    }

    public static String printAllEmployees() {
        //return string contains all formatted list of all employees
       String outcome = "";
       outcome+="Name            ID    Salary     Bonus";
       //loop for every employee the array have 
       for (int i = 0; i < employees.size(); i++) {
            
            outcome += String.format("\n%-16s%-6d%-11f%11", 
                    //each employee infomation included output
                    employees.get(i).getName(), 
                    employees.get(i).getId(), 
                    employees.get(i).getSalary());
                    
                    }
        
        return outcome;
     
    }
//this methdd to update the employee state to working 
    public static String markEmployeeAsWorking(int managerId, int employeeId) {
    // Search for the manager object using the method "findEmployeeById"
    Employee manager = findEmployeeById(managerId);
    
    // Check if the manager object is an instanceof Approver or not
    if (manager != null) {
        switch (manager.getClass().getSimpleName()) {
            case "Approver":
                // Search for the employee object using the method "findEmployeeById"
                Employee employee = findEmployeeById(employeeId);
                
                if (employee != null) { // If the employee found
                    
                    employee.setStateWorking(); // Set employee state to "Working"
                    
                    return "Employee " + employee.getName() + " is now marked as working.";
                } else { // If the employee not found
                    
                    return "Either manager ID is incorrect or employee ID does not exist.";
                }
            default:
                return "Either manager ID is incorrect or employee ID does not exist.";
        }
    } else {
        return "Either manager ID is incorrect or employee ID does not exist.";
    }
}
    
// This method will search for the id in the employees ArrayList
private static Employee findEmployeeById(int id) {
    
    for (int i = 0; i < employees.size(); i++) {
        if (employees.get(i).getId() == id) {
            return employees.get(i);
        }
    }
    
    return null;
    
}


 public static String approveLeave(int manager_ID, int employee_Id, String date, int duration) {
    // Search for manager object using the method "findEmployeeById"
    Employee manager = findEmployeeById(manager_ID);

    // Check if the specified manager is an instance of Approver and whether the employee exists
    if (manager instanceof Approver) {
        // Search for employee object using the method "findEmployeeById"
        Employee employee = findEmployeeById(employee_Id);

        // Using switch
        if (employee != null) {
            switch (employee.getState()) {
                // if the employee is working, then approve the leave for the employee
                case "Working":
                    // leave object
                    Leave leave = new Leave(employee, date, duration);
                    // Add leave to the employee leave records
                    employee.addLeaveRecord(leave);
                    // set employee to leave
                    employee.setStateOnLeave();
                    // return and show the message with employee name
                    return "Leave approved for " + employee.getName() + ".";
                // if the employee is on leave, return this message
                case "Leave":
                    return "Cannot approve leave for " + employee.getName() + " as they are already on leave.";
                default:
                    // return this message since the state is unknown
                    return "Cannot approve leave for " + employee.getName() + " due to unknown state.";
            }
        } else {
            return "Leave approval failed. Either manager ID is incorrect or employee ID does not exist.";
        }
    } else {
        return "Leave approval failed. Either manager ID is incorrect or employee ID does not exist.";
    }
 }

    public static String printEmployeeLeaveRecords(int employeeid) {
       //using the method (find employeebyid) go and search for employee
       Employee employee = findEmployeeById(employeeid);
       //if the employee equals null, means not found, then return this message 
       if(employee==null){
           return "Employee with ID " + employeeid + " not found.";
           
       }else{
           String result = "";
           result += "Leave Records for " + employee.getName() + ":";
           result += "\nStart Date   Days of Leave";
           int i = 0;
           while (i < employee.getLeaveRecords().size()) {
                result += "\n" + employee.getLeaveRecords().get(i).displayLeaveDetails();
                i++;
    
           
       }
         return result;
       
       }
    }
}
