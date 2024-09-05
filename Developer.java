
package employeemanagementsystem;

/**
 *
 * 
 */
public class Developer extends Employee {
    public Developer(String name, int id, double salary) {
        super(name, id, salary);
    }
    /**
     *
     * @return
     */
    public double calculateBonus() {
        // 12% for each employee
        return getSalary() * 0.12;   
    }
    
}
