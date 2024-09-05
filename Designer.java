
package employeemanagementsystem;

/**
 *
 * 
 */
//inheritance, designer inherits Employee 
public class Designer extends Employee{
    public Designer(String name, int id, double salary) {
       super(name, id, salary);
    }
    /**
     *
     * @return
     */
    public double calculateBonus() {
        // 10% for each employee
        return getSalary() * 0.10;   
    }
}

   
