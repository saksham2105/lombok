import org.lombok.annotations.*;
@AllArgsConstructor
@Data
@ToString
class Employee 
{
private Integer id;
private String firstName;
private String lastName;
private Double Salary;
private String Address;
private java.util.Date dateOfBirth;
private Character gender;
}