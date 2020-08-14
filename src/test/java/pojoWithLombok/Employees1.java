package pojoWithLombok;


import lombok.Builder;
import lombok.Data;

@Data
//@Builder
public class Employees1 {
    private String Id;
    private String FirstName;
    private String LastName;
    private String Age;
    private String Salary;
    private String Department;
}
