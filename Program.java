class Program
{
public static void main(String[] gg)
{
Employee emp = new Employee();
emp.setId(101);
emp.setFirstName("Kalu");
emp.setSalary(10000.0);
emp.setGender('M');
System.out.println(emp);
System.out.println(emp.getFirstName());
System.out.println(emp.getId());
System.out.println(emp.getSalary() instanceof Double);
System.out.println(emp.getGender());
}
}