Show how scpecific classses like inner, nested, anonymous, enum are compiled. How class file is named etc.
Compiled classes must be provided in PR and result should be described in this file.

<b>Nested Classes</b >  <br />

  Java allows classes and interfaces to be nested within each other. These nested types have unrestricted access <br />
  to each other, including to private fields, methods, and constructors. However, from the JVM point of view, access to <br />
  the private members of another class is not allowed. To circumvent this limitation, compilers create special [access methods](https://www.yihangho.com/java-nested-classes-behind-the-scenes/). <br />
  All of them are static, have access to the package-private and are called starting with access$. <br />

  Java 11 brings the notion of [nestmates](https://www.baeldung.com/java-nest-based-access-control) and the associated access rules within the JVM. To achieve this, the class <br />
  file format now contains two new attributes:                  
     <li>One nest member (typically the top-level class) is designated as the nest host. It contains an attribute<br />
      (NestMembers) to identify the other statically known nest members.<br />
     <li>Each of the other nest members has an attribute (NestHost) to identify its nest host.<br />
     
  Thus, for types C and D to be nestmates they must have the same nest host. A type C claims to be a member of the<br />
  nest hosted by D, if it lists D in its NestHost attribute. The membership is validated if D also lists C in its NestMembers <br /> 
  attribute. Also, type D is implicitly a member of the nest that it hosts. Now there is no need for the compiler to <br /> 
  generate the bridge methods.

<b>Static Nested Classes</b >  <br />

 As with static members, these belong to their enclosing class, and not to an instance of the class<br />
 They can have all types of access modifiers in their declaration. They can define both static and <br />
 non-static members. <br />

<b>Accessing Members of the Static Nested Class: </b> <br /> 
  <li>they only have access to static members in the enclosing class<br />
  <li>declaration of a type in an anonymous class shadows any other declarations in the enclosing scope that<br />
      have the same name.<br />
      
  After [compilation static nested](https://wuciawe.github.io/jvm/2017/03/10/nested-class-in-java.html) classes is created Outer$NestedStatic.class where Outer is a name enclosing <br />
  class and Inner is a name nested class. In Outer$NestedStatic.class  is  created constructor with no parameter.<br />
  
<br />
 Basically, a static nested class interacts with the instance members of its top-level class, just like any <br />
 other classes. So, basically you can and should consider a static nested class as a top-level class which has <br />
 been nested inside another top-level class just for packaging convenience.So whenever you are using a nested <br />
 class, start by making it static, and then see if you need to access any instance members thereby having an <br /> 
 opportunity to make it non-static. <br />
<br />

<b> Inner classes </b> <br />

 Just like instance variables and methods, inner classes are associated with an instance of the enclosing class. <br /> 
 They can only define non-static members. They can have all types of access modifiers in their declaration. To <br />
 instantiate an inner class, we must first instantiate its enclosing class. <br /> 

<b>Accessing Members of the Inner Class: </b> <br />
   <li>has access to all members of the enclosing class, regardless of whether they are static or non-static<br />
<br />
After compilation a classes is generated Outer$Inner.class where Outer is a name enclosing class and Inner is a <br />
name nested class. In Outer$Inner.class  is  created constructor with takes as a parameter instance of the enclosing class.<br />

 Use inner class if you require access to an enclosing instance's non-public fields and methods. Use a static <br />
 nested class if you don't require this access. <br />
<br />
 
 <b> Local Classes </b> <br />

 Local classes are a special type of inner classes – in which the class is defined inside a method or scope block.<br />
 They cannot have access modifiers in their declaration. They can only define instance members.<br />   

<b> Accessing Members of the Local Class: </b> <br />
    <br />
    <li> has access to both static and non-static members in the enclosing context
    <li> local inner classes can’t use local variable of outer method until that local variable is not declared as final
<br />
<br />
After compilation a classes is generated Outer$1InnerLocal.class where Outer is a name enclosing class and InnerLocal is a <br />
name nested class. In Outer$InnerLocal.class  is  created constructor with takes as a parameter instance of the enclosing class.<br />

 Use it if you need to create more than one instance of a class, access its constructor, or introduce a new, named type<br />
<br />

<b> Anonymous classes </b><br />
   
 Anonymous classes enable you to make your code more concise. They enable you to declare and instantiate a <br />
 class at the same time. They are like local classes except that they do not have a name. Use them if you,<br /> 
 need to use a local class only once.<br />

<b>Accessing Members of the Anonymous Class: </b><br />
  <li>has access to the members of its enclosing class  <br />
  <li>cannot access local variables in its enclosing scope that are not declared as final or effectively final.<br />
  <li>declaration of a type in an anonymous class shadows any other declarations in the enclosing scope that<br />
      have the same name.<br />
      
<b>Polymorphism and Anonymous Inner Classes </b>  <br /> 

 Because we are using a superclass reference to a subclass object, per the laws of polymorphism,<br />
 we can only refer to <br />
 1) methods defined by the superclass or <br /> 
 2) override virtual methods in the subclass <br />
```java
class Anon { }
public class AnonDemo {
    public static void main (String[] args) {
          Anon anonInner = new Anon() {
             public void doSomething() { }          
          };
          anonInner.doSomething(); // Won't compile! 
    }
}
```
 With a bit of reflection magic, we can achieve a similar effect in Pre-Java 10 code as follows:
```java
anonInner.getClass().getMethod("doSomething").invoke(anonInner);
```
 One of the most visible enhancements in JDK 10 is type inference of local variables with initializers <br />
 By using the reserved type name var, Java was able to deduce the exact type of the anonymous inner class. <br />
 Consequently, we are no longer stuck with using a superclass reference to access the subclass object. <br />
```java
class Anon { }
public class AnonDemo {
    public static void main (String[] args) {
          var anonInner = new Anon() {
             public void doSomething() { }          
          };
          anonInner.doSomething(); // Work`s! 
    }
}
```
 After compilation a classes is created Outer$1.class where Outer is a name enclosing class and 1 is a <br />
 number anonymous class. In Outer$NestedStatic.class  is  created constructor with no parameter.<br />
 
 Use it if you need to declare fields or additional methods.<br />

[Link in article "How Java 10 Changes the way we Use Anonymous Inner Classes"](https://dzone.com/articles/how-java-10-changes-the-way-we-use-anonymous-inner)

<b> Enums </b> <br />

 The enum keyword was introduced in Java 5. It denotes a special type of class that always extends the < br />
 java.lang.Enum class.Constants defined this way make the code more readable, allow compile-time <br />
 checking, document upfront the list of accepted values and avoid unexpected behavior due to invalid <br />
 values being passed in. The [Enums can be rewritten in Java 8](https://www.baeldung.com/a-guide-to-java-enums) methods can become so concise with the <br />
 use of lambdas and the Stream APIs.<br />
 
 If we compile this code: <br />
 ```java
public enum Season {
  WINTER, SUMMER, SPRING, FALL;
}
```
 and the disassemble with javap  MyEnum.class, we'll see this: 
 ```java
 public final class Season extends Enum<Season> {
   public static final Season WINTER;
   public static final Season SUMMER;
   public static final Season SPRING;
   public static final Season FALL;
   private static final Season[] $VALUES;
   public static Season[] values();
   public static Season valueOf(String);
   static {};
 }
 ```
  In values() is a getter for a field $VALUES, which also clones the value before returning it. <br />
  That's where our ObjectClone comes from. In static initialiser (the last method) creates this <br />
  array as a simple object array, and writing it to the $VALUES field. <br />