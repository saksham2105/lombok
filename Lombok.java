import java.lang.reflect.*;
import org.lombok.annotations.Setter;
import org.lombok.annotations.Getter;
import org.lombok.annotations.Data;
import org.lombok.annotations.NoArgsConstructor;
import org.lombok.annotations.AllArgsConstructor;
import org.lombok.annotations.ToString;
/**
** Project Lombok Clone
** Author - Saksham Solanki
*Starting Date -03 Oct 2021
* Last Modified - 09 Oct 2021
@javassist - ByteCode manipulation library
*/
class Lombok
{
private static String className;
private static Class c;
private static Field[] fields;
private static Constructor[] constructors;
public static void main(String[] gg)
{
try
{
className = gg[0];
c = Class.forName(className);
fields = c.getDeclaredFields();
constructors = c.getConstructors();
boolean isClassAnnotatedWithData = false;
if(c.isAnnotationPresent(ToString.class))
{
LombokUtility.generateToString(className);
}
if(c.isAnnotationPresent(NoArgsConstructor.class))
{
if(constructors==null || constructors.length==0)
{
LombokUtility.generateNoArgumentConstructor(className);
}
}
if(c.isAnnotationPresent(AllArgsConstructor.class))
{
if(constructors==null || constructors.length==0 && fields.length>0)
{
LombokUtility.generateAllArgumentsConstructor(fields,constructors,className);
}
}
if(c.isAnnotationPresent(Data.class))
{
isClassAnnotatedWithData = true;
//generating Both Setters and Getters
LombokUtility.generateSettersAndGetters(fields,className);
}
if(c.isAnnotationPresent(Setter.class))
{
if(!isClassAnnotatedWithData)
{
//If it is not annotated with Data then generate Setters only
LombokUtility.generateSetters(fields,className);
}
}
if(c.isAnnotationPresent(Getter.class))
{
if(!isClassAnnotatedWithData)
{
//If it is not annotated with Data then generate Getters only
LombokUtility.generateGetters(fields,className);
}
}
//Generating Boiler Plate Code for Fields using Lombok
boolean isFieldAnnotatedWithData;
for(Field field : fields)
{
isFieldAnnotatedWithData = false;
if(field.isAnnotationPresent(Data.class))
{
isFieldAnnotatedWithData = true;
LombokUtility.generateSetterAndGetter(field,className);
}
if(field.isAnnotationPresent(Setter.class))
{
if(!isFieldAnnotatedWithData)
{
LombokUtility.generateSetter(field,className);
}
}
if(field.isAnnotationPresent(Getter.class))
{
if(!isFieldAnnotatedWithData)
{
LombokUtility.generateGetter(field,className);
}
}
}
}catch(Exception e) {
e.printStackTrace();
}
}
}