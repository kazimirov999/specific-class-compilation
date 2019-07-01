Show how scpecific classses like inner, nested, anonymous, enum are compiled. How class file is named etc.
Compiled classes must be provided in PR and result should be described in this file.


   **Nested inner class**
The inner class is defined in the scope of the outer class.
An inner class, like any member of a class, can be set to one of three levels of visibility: public, protected, or private. 
If none of these modifiers is specified, then packet visibility is applied by default.
An inner class cannot have a name that matches the name of the surrounding class or package.
A nested inner class can access any private field or instance method of the outer class. 
You cannot create an instance of a nested class without first creating an instance of the outer class.
Inner class does not have a constructor, it uses the constructor of the external class through its object.
Inner classes have the right to extends other classes, implement interfaces, and act as objects of inheritance.

  **Static Nested class**
From the class visible static properties and methods OuterClass.
A static nested class does not have access to non-static fields and methods of the outer class. 
Access to non-static fields and methods can only be done through a link to an instance of the outer class.
methods of the surrounding class have access to all static members of a static nested class, including its private static members, 
however, when accessing them, you must specify the name of the static nested class to which they belong.
If another class is nested in a static nested class, this does not automatically make it static, it will be an inner nested class, 
even if its surrounding class is nested in the interface. 
In order for a class nested in a static class to be static it is necessary to explicitly indicate this using the static keyword.

  **Local class** 
Local classes are defined in the Java code block.
Most often the declaration occurs in a method of some other class.
An instance of a class can be created within the same method as the class, but below the class declaration.
In local classes, static initializers (initialization blocks) or interfaces cannot be declared. But local classes can have static members, 
provided they are static final.
Instances of local classes, as well as instances of inner classes, have an ambient instance, a link to which is implicitly passed to all constructors of local classes.


  **Anonymous class**
Anonymous class is a local class with no name. 
Used when you need to override a class or interface method.
Constructors in anonymous classes can neither be defined nor redefined. Anonymous class cannot have constructors
since the name of the constructor must match the name of the class, and in this case the class does not have a name.
Any arguments we specify in parentheses behind the name of the parent class in the definition of an anonymous class,
implicitly passed to the parent class constructor.

 **Enum**
Enumerations are a set of logically related constants. An enumeration is declared using the enum operator, followed by the enumeration name. 
Then there is a list of listing elements, separated by commas.
The enumeration actually represents a new type, so we can define a variable of this type and use it.
Enumerations can be used in data storage classes.
Enum can contain concrete methods only i.e. no any abstract method.
All enums implicitly extend java.lang.Enum class. As a class can only extend one parent in Java, so an enum cannot extend anything else.


After compilation files are created with .class extension. The file name consists of the name of the external class, the $ sign, and the name of the internal class. 
Anonymous class is created а file whose name consists of the name of the class where the object and the numbers that identifies the object are created. 
Вecause character $ when creating the name of the class we can not add to ourselves, then allnames are unique.