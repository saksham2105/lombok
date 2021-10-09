/**
* A main Class to verify if all BoilerPlate has been generated successfully or not
*/
class Program
{
public static void main(String[] gg)
{
Employee emp = new Employee();
emp.setId(101);
emp.setFirstName("John");
emp.setSalary(10000.0);
emp.setGender('M');
System.out.println(emp); //To String will be invoked
System.out.println(emp.getFirstName());
System.out.println(emp.getId());
System.out.println(emp.getSalary() instanceof Double);
System.out.println(emp.getGender());
}
}
