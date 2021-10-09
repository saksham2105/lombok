import java.lang.reflect.*;
import org.lombok.annotations.*;
import javassist.*;
/**
** Author - Saksham Solanki
Start Date - 03 Oct 2021
Last Modified - 06 Oct 2021
*/
class LombokUtility
{
enum MethodType 
{
  SETTERS,
  GETTERS,
  SETTERS_AND_GETTERS
}
public static Boolean checkIfMethodAlreadyExist(Field field,String className,MethodType methodType) throws Exception
{
Class c = Class.forName(className);
if(methodType==methodType.SETTERS)
{
Boolean isMethodExist = false;
for(Method method : c.getMethods())
{
String setterMethod = "set"+field.getName()
      .substring(0,1).toUpperCase()+field.getName()
      .substring(1,field.getName().length());
if(method.getName().equals(setterMethod))
{
isMethodExist = true;
break;
}
}
return isMethodExist;
}
//if getters exist
if(methodType==methodType.GETTERS)
{
Boolean isMethodExist = false;
for(Method method : c.getMethods())
{
String getterMethod = "get"+field.getName()
                                           .substring(0,1).toUpperCase()+field.getName()
                                           .substring(1,field.getName().length());
if(method.getName().equals(getterMethod))
{
isMethodExist = true;
break;
}
}
return isMethodExist;
}
return false;
} 
public static void generateMethodByType(Field field,String className,MethodType methodType) throws Exception
{
if(methodType==methodType.SETTERS)
{
ClassPool cp=ClassPool.getDefault();
CtClass ctclass = ClassPool.getDefault().get(className);
//check if method doesn't exist before
if(!checkIfMethodAlreadyExist(field,className,MethodType.SETTERS))
{
String setterMethod = "public void set"+field.getName()
                                           .substring(0,1).toUpperCase()+field.getName()
                                           .substring(1,field.getName().length())+"("+field.getType().toString()
                                           .substring(6)+" "+field.getName()+") {this."+field.getName()+"="+field.getName()+";"+"}";
CtMethod newsettermethod = CtNewMethod.make(setterMethod,ctclass);
ctclass.addMethod(newsettermethod);
ctclass.writeFile();
if(ctclass.isFrozen()) ctclass.defrost();
}
}
if(methodType==methodType.GETTERS)
{
ClassPool cp=ClassPool.getDefault();
CtClass ctclass = ClassPool.getDefault().get(className);
//check if getters already exist or not
if(!checkIfMethodAlreadyExist(field,className,MethodType.GETTERS))
{
String getterMethod = "public "+field.getType().toString()
                                           .substring(6)+" get"+field.getName()
                                           .substring(0,1).toUpperCase()+field.getName()
                                           .substring(1,field.getName().length())+"() {return this."+field.getName()+";"+"}";
CtMethod newgettermethod = CtNewMethod.make(getterMethod,ctclass);
ctclass.addMethod(newgettermethod);
ctclass.writeFile();
if(ctclass.isFrozen()) ctclass.defrost();
}
}
if(methodType==methodType.SETTERS_AND_GETTERS)
{
ClassPool cp=ClassPool.getDefault();
CtClass ctclass = ClassPool.getDefault().get(className);
if(!checkIfMethodAlreadyExist(field,className,MethodType.SETTERS))
{
String setterMethod = "public void set"+field.getName()
                                           .substring(0,1).toUpperCase()+field.getName()
                                           .substring(1,field.getName().length())+"("+field.getType().toString()
                                           .substring(6)+" "+field.getName()+") {this."+field.getName()+"="+field.getName()+";"+"}";
CtMethod newsettermethod = CtNewMethod.make(setterMethod,ctclass);
ctclass.addMethod(newsettermethod);
}
if(!checkIfMethodAlreadyExist(field,className,MethodType.GETTERS))
{
String getterMethod = "public "+field.getType().toString()
                                           .substring(6)+" get"+field.getName()
                                           .substring(0,1).toUpperCase()+field.getName()
                                           .substring(1,field.getName().length())+"() {return this."+field.getName()+";"+"}";
CtMethod newgettermethod = CtNewMethod.make(getterMethod,ctclass);
ctclass.addMethod(newgettermethod);
}
ctclass.writeFile();
if(ctclass.isFrozen()) ctclass.defrost();
}
}

public static void generateMethodsByType(Field[] fields,String className,MethodType methodType) throws Exception
{
if(methodType==methodType.SETTERS)
{
//Generating Setters
for(Field field : fields)
{
ClassPool cp=ClassPool.getDefault();
CtClass ctclass = ClassPool.getDefault().get(className);
//check if method doesn't exist before
if(!checkIfMethodAlreadyExist(field,className,MethodType.SETTERS))
{
String setterMethod = "public void set"+field.getName()
                                           .substring(0,1).toUpperCase()+field.getName()
                                           .substring(1,field.getName().length())+"("+field.getType().toString()
                                           .substring(6)+" "+field.getName()+") {this."+field.getName()+"="+field.getName()+";"+"}";
CtMethod newsettermethod = CtNewMethod.make(setterMethod,ctclass);
ctclass.addMethod(newsettermethod);
ctclass.writeFile();
if(ctclass.isFrozen()) ctclass.defrost();
}
}
}
if(methodType==methodType.GETTERS)
{
//Generating Getters
for(Field field : fields)
{
ClassPool cp=ClassPool.getDefault();
CtClass ctclass = ClassPool.getDefault().get(className);
//check if getters already exist or not
if(!checkIfMethodAlreadyExist(field,className,MethodType.GETTERS))
{
String getterMethod = "public "+field.getType().toString()
                                           .substring(6)+" get"+field.getName()
                                           .substring(0,1).toUpperCase()+field.getName()
                                           .substring(1,field.getName().length())+"() {return this."+field.getName()+";"+"}";
CtMethod newgettermethod = CtNewMethod.make(getterMethod,ctclass);
ctclass.addMethod(newgettermethod);
ctclass.writeFile();
if(ctclass.isFrozen()) ctclass.defrost();
}
}
}
if(methodType==methodType.SETTERS_AND_GETTERS)
{
//Generating both Setters & Getters
for(Field field : fields)
{
ClassPool cp=ClassPool.getDefault();
CtClass ctclass = ClassPool.getDefault().get(className);
if(!checkIfMethodAlreadyExist(field,className,MethodType.SETTERS))
{
String setterMethod = "public void set"+field.getName()
                                           .substring(0,1).toUpperCase()+field.getName()
                                           .substring(1,field.getName().length())+"("+field.getType().toString()
                                           .substring(6)+" "+field.getName()+") {this."+field.getName()+"="+field.getName()+";"+"}";
CtMethod newsettermethod = CtNewMethod.make(setterMethod,ctclass);
ctclass.addMethod(newsettermethod);
}
if(!checkIfMethodAlreadyExist(field,className,MethodType.GETTERS))
{
String getterMethod = "public "+field.getType().toString()
                                           .substring(6)+" get"+field.getName()
                                           .substring(0,1).toUpperCase()+field.getName()
                                           .substring(1,field.getName().length())+"() {return this."+field.getName()+";"+"}";
CtMethod newgettermethod = CtNewMethod.make(getterMethod,ctclass);
ctclass.addMethod(newgettermethod);
}
ctclass.writeFile();
if(ctclass.isFrozen()) ctclass.defrost();
}
}
}
public static void generateSetters(Field[] fields,String className) throws Exception
{
MethodType methodTypeSetter = MethodType.SETTERS;
generateMethodsByType(fields,className,methodTypeSetter);
}
public static void generateGetters(Field[] fields,String className) throws Exception
{
MethodType methodTypeGetter = MethodType.GETTERS;
generateMethodsByType(fields,className,methodTypeGetter);
}
public static void generateSettersAndGetters(Field[] fields,String className) throws Exception
{
MethodType methodTypeSetterAndGetter = MethodType.SETTERS_AND_GETTERS;
generateMethodsByType(fields,className,methodTypeSetterAndGetter);
}
public static void generateSetterAndGetter(Field field,String className) throws Exception
{
MethodType methodTypeSetterAndGetter = MethodType.SETTERS_AND_GETTERS;
generateMethodByType(field,className,methodTypeSetterAndGetter);
}
public static void generateGetter(Field field,String className) throws Exception
{
MethodType methodTypeGetter = MethodType.GETTERS;
generateMethodByType(field,className,methodTypeGetter);
}
public static void generateSetter(Field field,String className) throws Exception
{
MethodType methodTypeSetter = MethodType.SETTERS;
generateMethodByType(field,className,methodTypeSetter);
}
public static void generateNoArgumentConstructor(String className) throws Exception
{
ClassPool cp=ClassPool.getDefault();
CtClass ctclass = ClassPool.getDefault().get(className);
StringBuilder stringBuilder = new StringBuilder();
stringBuilder.append("public "+className+"(Object o){super();}");
CtConstructor constructor = CtNewConstructor.make(stringBuilder.toString(),ctclass);
ctclass.addConstructor(constructor);
ctclass.writeFile();
if(ctclass.isFrozen()) ctclass.defrost();
}
public static void generateAllArgumentsConstructor(Field[] fields,Constructor[] constructors,String className) throws Exception
{
ClassPool cp=ClassPool.getDefault();
CtClass ctclass = ClassPool.getDefault().get(className);
int x = 0;
//Make StringBuilder from all the fields
//Before that first we have to check whether all args constructor exists or not
for(Constructor c : constructors)
{
if(c.getParameterTypes().length==fields.length)
{
//check if all param are matches if yes then throw an exception
x=0;
Class[] parameterTypes = c.getParameterTypes();
for(Class parameterType : parameterTypes)
{
for(Field field : fields)
{
if(parameterType.getName().equals(field.getName())) x++;
}
}
if(x==fields.length)
{
//all args Constructor already present
throw new Exception("All arguments constructor already present");
}
}
}
StringBuilder stringBuilder = new StringBuilder();
stringBuilder.append("public "+className+"(");
for(x=0;x<fields.length;x++)
{
if(x==fields.length-1)
{
stringBuilder.append(fields[x].getType().toString().substring(6)+" "+fields[x].getName());
break;
}
else stringBuilder.append(fields[x].getType().toString().substring(6)+" "+fields[x].getName()+",");
}
stringBuilder.append(")\r\n");
stringBuilder.append("{\r\n");
for(x=0;x<fields.length;x++)
{
stringBuilder.append("this."+fields[x].getName()+" = "+fields[x].getName()+";"+"\r\n");
}
stringBuilder.append("}");
CtConstructor constructor = CtNewConstructor.make(stringBuilder.toString(),ctclass);
ctclass.addConstructor(constructor);
ctclass.writeFile();
if(ctclass.isFrozen()) ctclass.defrost();
}
public static void generateToString(String className) throws Exception
{
ClassPool cp=ClassPool.getDefault();
CtClass ctclass = ClassPool.getDefault().get(className);
//check if method doesn't exist before
String toStringMethod = "public String toString(){ return getClass().getName()+\"@\"+Integer.toHexString(hashCode());}";
CtMethod newToStringMethod = CtNewMethod.make(toStringMethod,ctclass);
ctclass.addMethod(newToStringMethod);
ctclass.writeFile();
if(ctclass.isFrozen()) ctclass.defrost();
}
}