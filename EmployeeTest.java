import java.lang.reflect.*;
/**
* Testing Class to Scan Contents of a Employee Class by Java Reflection API
*/
class EmployeeTest
{
public static void main(String[] ar) throws Exception
{
Class c = Class.forName("Employee");
Constructor[] constructors = c.getConstructors();
Method[] methods = c.getMethods();
for(Method m : methods)
{
System.out.println(m.getName());
}
for(Constructor co : constructors)
{
Class[] pTypes = co.getParameterTypes();
System.out.println("Constructor : "+co.getName());
for(Class pType : pTypes)
{
System.out.println("Constructor Parameter : "+pType.getName());
}
}
}
}
