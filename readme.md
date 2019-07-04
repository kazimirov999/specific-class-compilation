Show how scpecific classses like inner, nested, anonymous, enum are compiled. How class file is named etc.
Compiled classes must be provided in PR and result should be described in this file.

#Nested inner class </br>
Java inner class or nested class is a class which is declared inside the class or interface.</br>
We use inner classes to logically group classes and interfaces in one place so that it can be more readable and maintainable.</br>
Additionally, it can access all the members of outer class including private data members and methods.</br>
A nested inner class can access any private field or instance method of the outer class. </br>
You cannot create an instance of a nested class without first creating an instance of the outer class. </br>
Inner class does not have a constructor, it uses the constructor of the external class through its object. </br>
Inner classes have the right to extends other classes, implement interfaces, and act as objects of inheritance. </br>

#Static Nested class </br>
From the class visible static properties and methods OuterClass.
A static nested class does not have access to non-static fields and methods of the outer class. </br>
Access to non-static fields and methods can only be done through a link to an instance of the outer class.</br>
If another class is nested in a static nested class, this does not automatically make it static, it will be an inner nested class, even if its surrounding class is nested in the interface. </br>
It can access static data members of outer class including private.</br>
Static nested class cannot access non-static (instance) data member or method.</br>

#Local class</br>
Local classes are defined in the Java code block.</br>
Most often the declaration occurs in a method of some other class.</br>
An instance of a class can be created within the same method as the class, but below the class declaration.</br>
In local classes, static initializers (initialization blocks) or interfaces cannot be declared. But local classes can have static members, provided they are static final. </br>
Instances of local classes, as well as instances of inner classes, have an ambient instance, a link to which is implicitly passed to all constructors of local classes.</br>


#Anonymous class</br>
Anonymous class is a local class with no name. </br>
Used when you need to override a class or interface method.</br>
Constructors in anonymous classes can neither be defined nor redefined. Anonymous class cannot have constructors.</br>
Since the name of the constructor must match the name of the class, and in this case the class does not have a name.</br>
Any arguments we specify in parentheses behind the name of the parent class in the definition of an anonymous class, implicitly passed to the parent class constructor.</br>

#Enum</br>
Enumerations are a set of logically related constants. An enumeration is declared using the enum operator, followed by the enumeration name. </br>
Then there is a list of listing elements, separated by commas.</br>
The enumeration actually represents a new type, so we can define a variable of this type and use it.</br>
Enumerations can be used in data storage classes.</br>
Enum can contain concrete methods only i.e. no any abstract method.</br>
All enums implicitly extend java.lang.Enum class. As a class can only extend one parent in Java, so an enum cannot extend anything else. </br>

