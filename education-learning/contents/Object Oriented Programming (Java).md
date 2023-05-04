# <b>Object-Oriented Programming Language with Java</b>

## Contents
1. [Common Types of Java Functions and Features](#common)
2. [Object-Oriented Programming Concepts with Java](#oop)
3. [Data Structures and Algorithm](#dss)
4. [Others](#oth)

## <a id="common"></a>Common Types of Java Functions and Features
### 1.0 Implementation for comments
1. Single line comment/Implementation comment
```java
public class MainApplication {
  public static void main(String[] args) {
    // System.out.println("This line won't execute on console.");
    /* System.out.println("This line will not execute on console."); */
    System.out.println("This line will execute on console.");
  }
}
```
2. Multi line comment/Documentation comment
```java
/**
 * This is documentation comment. Documentation comment allows to include tags such as: 
 * @author authorname
 * @param parameter
 * @return returned value/object
 */
public class MainApplication {
  public static void main(String[] args) {
    /**
     * This is multi line comment. It will not execute during program run.
     * 
     */
    System.out.println("This line will execute on console.");
  }
}
```

### 2.0 Data types
- Java contains of variety types of data types. There are some example data types which similar as C language data type such as int, float and char.
- In java, there's also contain data type that can be declare as a reference data type that points to an object of a given class by allowing to access the value of an object.
- Below shows some of the common data type that available for Java by default:
1. String data type
```java
String str = "Sample string";
```
2. Integer data type
```java
int val = 1000;
```
3. Float data type
```java
float val = 1234.56;
```
4. Double data type used to represent decimal numbers. It uses 64-bit to store a data type value and has a range greater than float data type.
```java
double val = 1234.56
```
5. Char data type
```java
char character = "A";
```
6. Boolean data type
```java
boolean bool = true;
```
7. Byte data type can holds 8-bit integer value
```java
byte val = 120; 
```
8. Short data type can holds 16-bit integer value
```java
short val = 12345;
```
9. long data type can holds 64-bit integer value
```java
long val = 12345678910;
```
10. Single dimensional array
```java
String[] array = {"str1", "str2", "str3"};
```
11. Multi dimensional array
```java
int[][] array = { {1,3}, {2,4} };
```
12. List
```java
List<String> list = new ArrayList<String>();
```
13. <b>final</b> keyword
```java
final int val = 10;
// applying new value to val
val = 12; // this will throw error as final keyword does not allow to modification made for the variable
```
14. <b>private</b> keyword which only allow the variable only able to access within the class only
```java
private int val = 10;
```
- Below shows the reference data type that used to point to Student class:
```java
public class Student {
  private int val = 10;

  public int getVal() {
    return val;
  }

  public String output() {
    return "This is student class string.";
  }
}

public class MainApplication {
  public static void main(String[] args) {
    // Declare reference data type for Student class
    Student stud = new Student();

    System.out.println("x: " + stud.getVal());
    System.out.println("Output: " + stud.output());
    /**
     * Output:
     * x: 10
     * Output: This is student class string.
     */
  }
}
```
### 3.0 Basic User Input with <b>Scanner</b> class
- <b>Scanner</b> in Java used to read input value from user. There are may types of input type available in Scanner class and below shows an example of how to input data using Scanner class: 
```java
import java.util.Scanner;

public class MainApplication {
  public static void main(String[] args) {
    // Declare scanner object
    Scanner scanner = new Scanner(System.in);

    System.out.println("Please input name: ");
    // Declare name variable to receive scanner value
    String name = scanner.nextLine();
    
    System.out.println("Please input age: ");
    // Declare age variable to receive scanner value
    int age = scanner.nextInt();
    
    System.out.println("Please input true/false: ");
    // Declare bool variable to receive scanner value
    boolean bool = scanner.nextBoolean();

    // Output received value
    System.out.println("\nResult: \nName: " + name + "\nAge: " + age + "\nboolean: " + bool);

    /**
     * Output at console:
     * 
     * Please input name:
     * Apple Pie
     * Please input age:
     * 21
     * Please input true/false:
     * false
     * 
     * Result:
     * Name: Apple Pie
     * Age: 21
     * boolean: false
     */
  }
}
```

### 4.0 Basic Result Output with print() Method
- For Java, it provides several methods by allowing user to output data to the console. Below the common methods available for print text in Java:
1. Output with println() method
```java
System.out.println("This is first line output.");
System.out.println("This is second line output.");
/**
 * Output:
 * This is first line output.
 * This is second line output.
 */
```
2. Output with print() method
```java
System.out.print("This is first line output.");
System.out.println("This is second line output.");
/**
 * Output:
 * This is first line output.This is second line output.
 */
```
3. Output with prinf() method
```java
double x = 2.34;
System.out.printf("X equals: %2.2f\n", x);
/**
 * Output:
 * X equals: 2.34
 */
```

### 5.0 String Conversions
- Below show the methods of converting string to different cases:
1. Convert string to upper case letters
```java
String str = "apple pie";

System.out.println(str.toUpperCase());
/**
 * Output:
 * APPLE PIE
 */
```
2. Convert string to lower case letters
```java
String str = "APPLE PIE";

System.out.println(newStr.toLowerCase());
/**
 * Output:
 * apple pie
 */
```
3. Locate string with indexOf()
```java
String str = "apple pie";

System.out.println("Location for 'pie' string is: " + str.indexOf("pie"));
/**
 * Output:
 * Location for 'pie' string is: 6
 */
```

### 6.0 Method for Input Symbol in String
- By default, some symbols are not able to input into string. They need to be processes by adding('\\') symbol before output to the console. Below shows the method of input symbol in a string:
```java
public class MainApplication {
  public static void main(String[] args) {
    System.out.println("This is a string with quotation \" symbol.");
    // Output: This is a string with " symbol.
    System.out.println("This is a string with backslash \\ symbol.");
    // Output: This is a string with slash \ symbol.
  }
}
```

### 7.0 Escape characters
- Java provides several types of escape characters by allowing user to take changes for the output text. Below shows some of the escape characters available in Java:
1. Insert newline in the text at this point
```java
"\n"
```
2. Carriage return in the text
```java
"\r"
```
3. Adding a tab in the text
```java
"\t"
```
4. Adding backspace in the text
```java
"\b"
```
5. Form-feed escape character
```java
"\f"
```

### 8.0 Operators That Used to Perform Calculation
1. Calculation symbol
```java
int val = x + y;
int val = x - y;
int val = x * y;
int val = x / y;
int val = x % y;
int val = x++;
int val =  ++x;
int val =  x--;
int val = --x;
int x = 5;
int x += 5  // x = x + 5;
int x -= 5  // x = x - 5;
int x *= 5  // x = x * 5;
int x /= 5  // x = x / 5;
int x %= 5  // x = x % 5;
int x &= 5  // x = x & 5;
int x |= 5  // x = x | 5;
int x ^= 5  // x = x ^ 5;
int x >>= 5 // x = x >> 5;
int x <<= 5 // x = x << 5;
```
2. Comparison symbol
```java
// equal to
x == y;
// not equal to
x != y;
// greater than
x > y;
// less than 
x < y;
// greater than equal to 
x >= y;
// less than equal to
x <= y;
```
3. Logical symbol
```java
// logical and
x = 5 && x = 10
// logical or
x = 5 || x <9
// logical not(return false if result true)
!(x <5 && x <10)

// Bitwise symbol(for binary calculation use)
// AND
&
// OR
|
// NOT
~
// XOR
^
// zero-fill left shift
<<
// signed right shift
>>
// zero-fill right shift
>>>
```

### 9.0 <b>Math</b> Class

```java
// find highest value between val1 and val2
Math.max(val1, val2);
// find smallest value between val1 and val2
Math.mix(val1, val2);
// square root of val
Math.sqrt(val);
// return positive value of value
Math.abs(-4.7);
// return random number between a range 0 to max number
Math.random();
```

### 10.0 Annotations
- Annotation in Java is a tag that represents the metadata that provide data about a program that is not part of the program itself. 
```java
@Override
//use for tell compiler to check error for rewrite code syntax
@Deprecated
//use for check class, method, interface wether it is expired and throw error 
@SuppressWarnings({"keywords"})
//suppress warning that trigger with keywords(all,boxing,cast,dep-ann,deprecation,fallthrough,finally,hiding....)
@SafeVarargs
@FunctionalInterface
// Annotations that commonly used in Spring framework
@Controller
@Service
@Repository
@Component
```

### 11.0 Conditional Statements
1. <b>if...else</b> statement
```java
int x = 0;

if( x == 1) {
  System.out.println("x is one."); 
} else {
  System.out.println("x is not one.");
}
/**
 * Output:
 * x is not one.
 */
```
2. <b>if...else if...else</b> statement
```java
int x = 2;

if ( x == 1) {
  System.out.println("x is one.");
} else if ( x == 2) {
  System.out.println("x is two.");
} else {
  System.out.println("x is something else.");
}
/**
 * Output:
 * x is two.
 */
```
3. Lambda if...else statement
```java
//data type = String output, expressionTrue = functionName1()/"output 1", expressionFalse = functionName2()/"output2";
String val = x -> x ? return "success" : return "fail";
```
4. <b>switch</b> statement
```java
int val = 4;

switch(val) {
  case 1:
    System.out.println("Output is one.");
    break;
  case 2:
    System.out.println("Output is two.");
    break;
  case 3:
    System.out.println("Output is three.");
    break;
  case 4:
    System.out.println("Output is four.");
    break;
  default:
    break;
}
/**
 * Output:
 * Output is four.
 */
```
5. <b>while</b> statement execute statement block while the condition is true.
```java
int x = 0;

while( x < 6 ) {
  System.out.println("x: " + x++);
}
/**
 * Output:
 * x: 0
 * x: 1
 * x: 2
 * x: 3
 * x: 4
 * x: 5
 */
```
6. <b>do...while</b> statement execute statement block continuously until while condition is true.
```java
int x = 0;

do {
  System.out.println("x: " + x++);
}while ( x < 6 );
/**
 * Output:
 * x: 0
 * x: 1
 * x: 2
 * x: 3
 * x: 4
 * x: 5
 */
```
7. <b>for</b> loop statement
```java
// Simple array for loop
String[] array = {"str 1", "str 2", "str 3", "str 4", "str 5"};

for(int x = 0; x < 5; x++) {
  System.out.println("String[" + x + "] is: " + array[x]);
}
/**
 * Output:
 * String[0] is: str 1
 * String[1] is: str 2
 * String[2] is: str 3
 * String[3] is: str 4
 * String[4] is: str 5
 */
```
```java
// Nested array for loop
String[][] array = { {"str 1", "str 2"}, {"str 3", "str 4"}, {"str 5", "str 6"} };

for(int x = 0; x < array.length; x++) {
  System.out.println("Outer loop[" + x + "]");

  for(int y = 0; y < array[x].length; y++) {
    System.out.println("Inner loop[" + x + "][" + y + "]: " + array[x][y]);
  }
}
/**
 * Output:
 * Outer loop[0]
 * Inner loop[0][0]: str 1
 * Inner loop[0][1]: str 2
 * Outer loop[1]
 * Inner loop[1][0]: str 3
 * Inner loop[1][1]: str 4
 * Outer loop[2]
 * Inner loop[2][0]: str 5
 * Inner loop[2][1]: str 6
 */
```
8. <b>for-each</b> loop (use to loop elements through array)
```java
String[] array = {"str 1","str 2","str 3"};

for(String str : array) {
  System.out.println("String: " + str);
}
/**
 * Output:
 * String: str 1
 * String: str 2
 * String: str 3
 */
```
9. Use of <b>break/continue</b> during loop statement
```java
// Loop with break keyword
for(int x = 0; x< 10; x++) {
  System.out.println("Loop starts: " + x);
  if(x==4) {
    System.out.println("Loop is break.");
    break;
  }
}
/**
 * Output:
 * Loop starts: 0
 * Loop starts: 1
 * Loop starts: 2
 * Loop starts: 3
 * Loop starts: 4
 * Loop is break.
 */
```
```java
// Loop with continue keyword
for(int x = 0; x< 10; x++) {
  System.out.println("Loop starts: " + x);
  if(x==4) {
    System.out.println("Loop continue here.");
    continue;
  }
}
/**
 * Output:
 * Loop starts: 1
 * Loop starts: 2
 * Loop starts: 3
 * Loop starts: 4
 * Loop continue here.
 * Loop starts: 5
 * Loop starts: 6
 * Loop starts: 7
 * Loop starts: 8
 * Loop starts: 9
 */
```
### 12.0 Arrays
1. Empty array declaration
```java
String[] array;
```
2. 1-dimensional array(1D array)
```java
String[] array = {"str 1","str 2","str 3"};
```
3. 2-dimensional array(2D array)
```java
String[][] array = { {"str 1", "str 2"},{"str 3", "str 4"}};
```
4. Output array with length method
```java
System.out.println(array.length);
```
5. Loop through array
```java
String[][] array = { {"str 1", "str 2"},{"str 3", "str 4"}};

for( int i = 0; i < array.length; i++) {
  for( int j = 0; j < array[i].length; j++) {
    System.out.println("Location[" + i + "][" + j + "]: " + array[i][j]);
  }
}
/**
 * Output:
 * Location[0][0]: str 1
 * Location[0][1]: str 2
 * Location[1][0]: str 3
 * Location[1][1]: str 4
 */
```

### 13.0 Function Calling
1. Declaring function within same class
```java
public class MainApplication {
  public static void main(String[] args) {
    output();
    /**
     * Output:
     * This is static class function
     */
  }

  static void output() {
    System.out.println("This is static class function.")
  }
}
```
2. Declare function with parameters
```java
public class MainApplication {
  public static void main(String[] args) {
    String str1 = "apple";
    String str2 = "pie";
    
    output(str1);
    output(str2);
    /**
     * Output:
     * The output is: apple
     * The output is: pie
     */
  }

  static String output(String str) {
    return "The output is: " + str;
  }
}
```
3. Return function value
```java
public class MainApplication {
  public static void main(String[] args) {
    int z = add(5,3);
    System.out.println("Value is: " + z);
    /**
     * Output: 
     * Value is: 8
     */
  }

  static int add(int x, int y) {
    return x + y;
  }
}
```
3. Conditional function return
```java
public class MainApplication {
  public static void main(String[] args) {
    isVal(10);
    /**
     * Output:
     * Input is not equal to 5.
     */
  }

  static void isVal(int x) {
    if (x == 5) {
      Systen.out.prinln("Input is equal to 5.");
    } else {
      System.out.println("Input is not equal to 5.")
    }
  }
}
```

### 14.0 Enums
- 'enum' is a special "class"(data type unchangeable like final data type).
- It usually use for the values/data types that not going to change for future.
- It use pointer to point the data types in other class (LEVEL.MEDIUM).
- It cannot be used to create object, but it can be implemented for interfaces class.
```java
enum LEVEL {
  LOW, MEDIUM, HIGH
}

public class EnumClass {
  public static void main(String[] args) {
    // declare enum LEVEL
    LEVEL myVar = LEVEL.MEDIUM;

    // switch between LEVEL data type
    switch(myVar) {
    case LOW:
      System.out.println("Low level");
      break;
    case MEDIUM:
      System.out.println("Medium level");
      break;
    case HIGH:
      System.out.println("High level");
      break;
    }
  }
}
```
```java
public class EnumClass {
  public static void main(String[] args) {
    // loop through LEVEL data types
    for(LEVEL myVar : LEVEL.values()) {
      // output = LOW MEDIUM HIGH
      System.out.println(myVar);
    }
  }
}
```

### 15.0 Date and Time Related Information
- Below library only available for JDK 8 and above.
```java
// java datetime library package
import java.time.*;

// LocalDate = yyyy-MM-dd
// LocalTime = HH-mm-ss-ns
// LocalDateTime = yyyy-MM-dd-HH-mm-ss-ns
// DateTimeFormatter = display and parse date-time objects

// date time formatter(.ofPattern("values")
// yyyy-MM-dd = 1920-12-31
// dd/MM/yyyy = 31/12/2020
// dd-MMM-yyyy = 31-Dis-1920
// E,MMM dd yyyy = Thu, Dis 31 1920
```
- Example of executing date time method
```java
//import localdatetime class
import java.time.LocalDateTime;
// import datetimeformatter
import java.time.format.DateTimeFormatter;

public class GetDateTime {
  public static void main(String[] args) {
    // declare object for current date time
    LocalDateTime myDateObj = LocalDateTime.now();
    System.out.println("Before change " + myDateObj);
    // declare format
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
    // convert to string
    String formattedDate = myDateObj.format(myFormatObj);
    // output string
    System.out.println("After change " + formattedDate);
  }
}
```
- An Instant class in Java
```java
import java.time.Instant;

public class MainApplication {
  public static void main(String[] args) {
    Instant instant = Instant.now();
    System.out.println(instant);
    /**
     * It will output current date and time
     */
  }
}
```

## <a id="oop"></a>Object-Oriented Programming Concepts with Java
<b>Definition of OOP Concepts in Java</b></br>
The main ideas behind Java’s Object-Oriented Programming, OOP concepts include abstraction, encapsulation, inheritance and polymorphism. Basically, Java OOP concepts let us create working methods and variables, then re-use all or part of them without compromising security. Grasping OOP concepts is key to understanding how Java works.

Java defines OOP concepts as follows:

- <b>Abstraction.</b> Using simple things to represent complexity. We all know how to turn the TV on, but we don’t need to know how it works in order to enjoy it. In Java, abstraction means simple things like objects, classes and variables represent more complex underlying code and data. This is important because it lets you avoid repeating the same work multiple times.
- <b>Encapsulation.</b> The practice of keeping fields within a class private, then providing access to those fields via public methods. Encapsulation is a protective barrier that keeps the data and code safe within the class itself. We can then reuse objects like code components or variables without allowing open access to the data system-wide.
- <b>Inheritance.</b> A special feature of Object-Oriented Programming in Java, Inheritance lets programmers create new classes that share some of the attributes of existing classes. Using Inheritance lets us build on previous work without reinventing the wheel.
- <b>Polymorphism.</b> Allows programmers to use the same word in Java to mean different things in different contexts. One form of polymorphism is method overloading. That’s when the code itself implies different meanings. The other form is method overriding. That’s when the values of the supplied variables imply different meanings. Let’s delve a little further.
[Source](https://stackify.com/oops-concepts-in-java/)

### 1.0 Method of Creating a Class Object
1. Create Student class in Student.java
```java
public class Student {
  private String name;
  private int age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
     this.age= age;
  }
}
```
2. Declare class in MainApplication.java
```java
public class MainApplication {
  public static void main(String[] args){
    // Declare Student class object
    Student stud = new Student();

    String str = "Apple Pie";

    // Set value to student object
    stud.setName(str);

    System.out.println("Student name is: " + stud.getName());
    /**
     * Output:
     * Student name is: Apple Pie
     */
  }
}
```
### 2.0 Java Class and Object Modifier
1. A class declare as <b>public</b> can be access by all other sub classes.
- Student.java
```java
public class Student {
  String name = "Apple Pie";
}
```
- MainApplication.java
```java
public class MainApplication {
  public static void main(String[] args) {
    Student stud = new Student();

    System.out.println("Student name is: " + stud.name);
    /**
     * Output:
     * Student name is: Apple Pie
     */
  }
}
```
2. <b>private</b> object modifier only allow the object being accessed within its own class.
- Student.java
```java
public class Student {
  private String name = "Apple Pie";
}
```
- MainApplication.java
```java
public class MainApplication {
  public static void main(String[] args) {
    Student stud = new Student();

    System.out.println("Student name is: " + stud.name);
    // Will throw error as name variable only able to be accesse within Student class
  }
}
```
- For accessing private variable for other classes:
```java
// Student.java
public class Student {
  private String name = "Apple Pie";

  // Declare public method for accepting private variable value
  public String getName() {
    return name;
  }
}

// MainApplication.java
public class MainApplication {
  public static void main(String[] args) {
    Student stud = new Student();

    System.out.println("Student name is: " + stud.getName());
    /**
     * Output:
     * Student name is: Apple Pie
     */
  }
}
```
3. <b>default/empty</b> declaration class which only accessible within same package
- Student.java
```java
package com.learning.demo;

class Student {
  String msg = "This is a string.";
};
```
- MainApplication.java
```java
package com.learning.demo;

public class MainApplication {
  public static void main(String[] args) {
    Student stud = new Student();

    System.out.println(a.msg);
    /**
     * Output:
     * This is a string.
     */
  }
}
```
4. <b>protected</b> object modifier which only accessible in same package and subclasses
- Message.java
```java
public class Message {
  protected void output() {
    System.out.println("This string comes from protected class.");
  };
}
```
- MainApplication.java inherit Message.java class
```java
public class MainApplication extends Message {
  public static void main(String[] args) {
    Message message = new Message();

    message.output();
    /**
     * Output:
     * This string comes from protected class.
     */
  }
}
```
5. <b>final</b> class cannot be override or inherit by other classes. Inheriting final class is not allowed as it is a final class, system will throw error if the final class is inherited.
- Student.java
```java
final class Student {
  String name = "Apple.Pie";

  void output(){
    System.out.println("Final class output is here.");
  }
}
```
- MainApplication.java
```java
public class MainApplication {
  public static void main(String[] args) {
    Student stud = new Student();

    stud.output();
    /**
     * Output: 
     * Final class output is here.
     */
  }
}
```
6. <b>abstract</b> class is a class don't have body and abstract inside the function, the class declared as abstrat are able to inherit to other classes and extends the function after inherit the methods.
- Abstract class without body:
- Student.java
```java
public abstract class Student {  
  abstract void output();
}
```
- School.java
```java
public class School extends Student {
  // inherit abstract class method
  @Override
  void output() {
    System.out.println("Student output here.")
  }
}  
```
- MainApplication.java
```java
public class MainApplication {
  public static void main(String[] args) {
    School school = new School();

    school.output();
    /**
     * Output:
     * Student output here.
     */
  }
}
```
- Abstract class with body:
- Student.java
```java
public abstract class Student {
  protected String convertToString(int val) {
    return String.valueOf(val);
  }
}
```
- MainApplication.java
```java
public class MainApplication extends Student {
  public static void main(String[] args) {
    int num = 1;

    // execute abstract class method
    System.out.println("Convert int to string: " + convertToString(num));
    /**
     * Output:
     * Convert int to string: 1
     */
  }
}
```
- Abstract class is used to improve security by hiding certain details and show only important details by using abstract method. Below shows the example for abstract class: 
```java
// restricted class
abstract class Animal {
  // declare abstract method without body
  public abstract void animalSound();

  public void sleep() {
    System.out.println("Sleep...Zzz...");
  }
}

// inherit restricted class using extends
class Pig extends Animal {
  public void animalSound() {
    System.out.println("Snork...");
  }
}

//main class execute abstract class using inherited class name
class MainApplication {
  public static void main(String[] args) {
    // create object using inherited class 
    Pig myPig = new Pig();
    // output = Snork...
    myPig.animalSound();
    // output = Sleep...Zzz...
    myPig.sleep();
  }
}
```
- Java <b>interface</b> class is different with abstract class, it don't have body and only dan define method name inside interface class.
- Animal.java
```java
public interface Animal {
  // cannot define structure for interface class function, will throw error
  public void animalSound();
  public void sleep() ;
}
```
- Pig.java
```java
// use 'implements' keyword to create body for interface class
public class Pig implements Animal {
  public void animalSound() {
    System.out.println("Snork...");
  }

  public void sleep() {
    System.out.println("Sleep...Zzz...");
  }
}
```
- MainApplication.java
```java
public class MainApplication {
  public static void main(String[] args) {
    Pig myPig = new Pig();
    // output = Snork...
    myPig.animalSound();
    // output = Sleep...Zzz...
    myPig.sleep();
  }
}
```
- Another example for Java interface:
```java
// FirstInterface.java
public interface FirstInterface {
  public void myMethod();
}

// SecondInterface.java
public interface SecondInterface {
  public void oOtherMethod();
}

/**
 * ClassImpl.java
 * ClassImpl that implements FirstInterface and SecondInterface
 * interface class can be implement in many interfaces class in one time, to create structure in one class
 */
public class ClassImpl implements FirstInterface, SecondInterface {
  // interface 1, declare function for interface class
  public void myMethod() {
    System.out.println("Woo....");
  }

  // interface 2, declare function for interface class
  public void oOtherMethod() {
    System.out.println("Goo....");
  }
}

// MainApplication.java
public class MainApplication {
  public static void main(String[] args) {
    ClassImpl myTest = new ClassImpl();
    myTest.myMethod();
    myTest.oOtherMethod();
  }
}
```
### 3.0 Data Type Modifier
1. <b>final</b> declared data type or methods cannot be override/inherit or changed.
```java
// Declare final type variable
final int num = 10;

// Declare final type method
public final String convertToString() {
  return "Final string";
}
```
2. <b>static</b> data type only able to be accessed within static method.
- Student.java
```java
class Student {  
  int id;  
  String name;  
  static String school = "Apple School";
    
  public Student(int id, String name) {  
    this.id = id;
    this.name = name; 
  }
   
  public static void change() {  
    this.school = "Pie School";  
  } 
    
  void toString() {
    System.out.println("String: [" + id + " " + name + " " + school + "]");
  }
}
```
- MainApplication.java
```java  
public class MainApplication {  
  public static void main(String[] args) {
    // execute static method
    Student.change();  
    
  Student stud1 = new Student(1, "Apple");
  Student stud2 = new Student(2, "Pear");
   
  stud1.toString();
  stud2.toString();
  /**
   * Output:
   * String: [1 Apple Pie School]
   * String: [2 Pear Pie School]
   */
  }  
} 
```
3. <b>abstract</b> can used in an abstract class and abstract methods
- An abstract method without body
```java
abstract void output();
```
4. <b>transient</b> keyword used to skip attributes and methods when during serializing
```java
import java.io.*;

public class MainApplication implements Serializable {
  // Normal data types
  int i = 10;
  int j = 20;

  // Transient data types
  transient int k = 30;

  // Use of transient has no impact here
  transient static int l = 40;
  transient final int m = 50;

  public static void main(String[] args) throws Exception {
    MainApplication input = new MainApplication();

    // serialization
    FileOutputStream fos = new FileOutputStream("abc.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(input);

    // de-serialization
    FileInputStream fis = new FileInputStream("abc.txt");
    ObjectInputStream ois = new ObjectInputStream(fis);
    Test output = (Test)ois.readObject();
    System.out.println("i = " + output.i);
    System.out.println("j = " + output.j);
    System.out.println("k = " + output.k);
    System.out.println("l = " + output.l);  
    System.out.println("m = " + output.m);
    /**
     * Output:
     * i = 10
     * j = 20
     * k = 0
     * l = 40
     * m = 50
     */
  }
}
```
5. <b>synchronized</b> methods can be use only by one thread at same time (Use in threading process)
```java
import java.io.*;
import java.util.*;
 
// Sender.java used to send a message
class Sender {
  public void send(String msg) {
    System.out.println("Sending\t"  + msg);

    try {
      Thread.sleep(1000);
    } catch (Exception e) {
      System.out.println("Thread  interrupted.");
    }

    System.out.println("\n" + msg + "Sent");
  }
}
 
// ThreadSend.java for send a message using Threads
class ThreadedSend extends Thread {
  private String msg;
  Sender  sender;

  // Receives a message object and a string
  // message to be sent
  ThreadedSend(String m,  Sender obj) {
    msg = m;
    sender = obj;
  }

  public void run() {
    // Only one thread can send a message
    // at a time.
    synchronized(sender) {
      // synchronizing the snd object
      sender.send(msg);
    }
  }
}
 
// MainApplication.java
public class MainApplication {
  public static void main(String args[]) {
    Sender snd = new Sender();
    ThreadedSend S1 = new ThreadedSend( " Hi " , snd);
    ThreadedSend S2 = new ThreadedSend( " Bye " , snd);

    // Start two threads of ThreadedSend type
    S1.start();
    S2.start();

    // wait for threads to end
    try {
      S1.join();
      S2.join();
    } catch(Exception e) {
      System.out.println("Interrupted");
    }
    /**
     * Output:
     * Sending  Hi
     * Hi sent
     * 
     * Sending  Bye
     * Bye sent
     */
  }
}
```
6. <b>volatile</b> value not cached thread-locally, always read from the <b>main memory</b>
```java
class SharedObj {
   // volatile keyword here makes sure that
   // the changes made in one thread are 
   // immediately reflect in other thread
   static volatile int sharedVar = 6;
}
```
### 4.0 Java Packages and API
- Method of import classes and referenced library packages
```java
// Import Student class
import com.learning.demo.Student;
// Import whole package classes
import com.learning.demo.*;
// Import java Scanner class
import java.util.Scanner;
// Import Java util library packages
import java.util.*;
```
- For accessing project packages, it is similar as file directories. For example: User would like to access to Student.java file and the directory may looks like this(/project/com/learning/demo/Student.java). Hence, the import package may looks like this: <b>com.learning.demo.Student</b>. Below illustrate how a package file can be found:</br>
\>project                          --\> project root folder</br>
____\>com                          --\> package folder 'com'</br>
________\>learning                 --\> package folder 'learning'</br>
____________\>demo                 --\> package folder 'demo'</br>
________________\>Student.java     --\> Student.java class file</br>
Hence, the import path will looks like this:
```java
import com.learning.demo.Student;
```
- Declaring project package
```java
// Declaring project package
package com.learning.demo;

// Declaring class under the package path
public class MainApplication {

  public static void main(String[] args) {
    System.out.println("Hello MainApplication!");
  }
}  
```
### 5.0 Encapsulation
- Encapsulation in Java will declare variables of a class as private and provide getter and setter methods to allow other classes to view variable values.
- Below shows example of Encapsulation with Student class and MainApplication class:
- Student.java
```java
public class Student {
  private String name;
  private int age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
```
- MainApplication.java
```java
public class MainApplication {
  public static void main(String[] args) {
    Student stud = new Student();
    stud.setName("Apple Pie");
    
    System.out.println("Student name is: " + stud.getName());
    /**
     * Output:
     * Student name is: Apple Pie
     */
  }
}
```
- Inner Class/Nested Class for encapsulation
- To access inner class, need to create an outer class, then access inner class through outer class
- Method of declaring inner class:
- OuterClass.java
```java
class OuterClass {
  
  static class StaticNestedClass {
    void output() {
      System.out.println("Static nested class.");
    }
  }
}
```
- MainApplication.java
```java
public class MainApplication {
  public static void main(String[] args) {
    OuterClass.StaticNestedClass object = new OuterClass.StaticNestedClass();

    object.output();
    /**
     * Output:
     * Static nested class.
     */
  }
}
```
- Example running nested class:
```java
public class MainClass {
  // declare object for outer class
  OuterClass myOuter = new OuterClass();
  // declare object for inner class
  OuterClass.InnerClass myInner = myOuter.InnerClass();
  // output object
  System.out.println(myInner.myInnerMethod());

  class OuterClass {
    int x = 10;
    class InnerClass {
      public int myInnerMethod() {
        return x;
      }
    }
  }

  public static void main(String[] args) {
    OuterClass myOuter = new OuterClass();
    OuterClass.InnerClass myInner = myOuter.InnerClass();
    
    System.out.println(myInner.myInnerMethod());
  }
}
```
### 6.0 Inheritance
1. Method of inherit class with <b>extends</b> keyword
- Student.java
```java
public abstract class Student {
  public void output() {
    System.out.println("Abstract class output.");
  }
}
```
- School.java
```java
public class School extends Student {
  public void toString() {
    System.out.println("School class method output.");
  }
}
```
- MainApplication.java
```java
public class MainApplication {
  public static void main(String[] args) {
    School school = new School();

    school.output();
    school.toString();
    /**
     * Output:
     * Abstract class output.
     * School class method output.
     */
  }
}
```
### 7.0 Polymorphism
- In Java, one subclass only can inherit one parent class, while in Python/ C++, one subclass can inherit multiple parent classes.

```java
// 1 superclass being used by many subclasses

// parent class
class Animal {
  public void animalSound() {
    System.out.println("Animal sound");
  }
}

// subclass 1
class Pig extends Animal {
  public void animalSound() {
    System.out.println("Snork...");
  }
}

// subclass 2
class Dog extends Animal {
  public void animalSound() {
    System.out.println("Woof...");
  }
}

// main class
class MainClass {
  public static void main(String[] args ) {
    // declare object myAnimal
    Animal myAnimal = new Animal();
    // declare object myPig
    Animal myPig = new Pig();
    // declare object myDog
    Animal myDog = new Dog();
    // output = Animan sound
    myAnimal.animalSound();
    // output = Snork...
    myPig.animalSound();
    // output = Woof...
    myDog.animalSound();
  }
}
```
## <a id="dss"></a>Data Structures and Algorithm 
### 1.0 List
1. ArrayList
- There are several common array list methods: add(), get(), set(), remove(), clear(), size(), sort().
```java
import java.util.ArrayList; 
import java.util.Collections;

// declare arraylist as object
ArrayList<datatype> data type_name = new ArrayList<datatype>();
// declare raw type
ArrayList data type_name = new ArrayList();
//arraylist(no datatype,can store multiple items)

// add items to arraylist
data type_name.add("values1");
data type_name.add("values2");
data type_name.add("values3");
data type_name.add("values4");
// get arr_position value
data type_name.get(arr_position);
// set arr_position with new value
data type_name.set(arr_position, new_value);
// remove arr_position value
data type_name.remove(arr_position);
// clear all array elements
data type_name.clear();
// to determine the actual array size
data type_name.size();
// sort value in ascending order
Collections.sort(data type_name);
```
```java
import java.util.ArrayList;
import java.util.Collections;

public class MainApplication {
  public static void main(String[] args) {
    // declare arraylist object
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");

    // loop through arraylist
    for(int i = 0; i < cars.size(); i++) {
      System.out.println(cars.get(i));
    }
    // sort arraylist
    Collections.sort(cars);
      for (String i : cars) {
        System.out.println(i);
      }
  }
}
```
2. Linked List
```java
import java.util.LinkedList;
import java.util.Collections;

// declare linked list
LinkedList<dataype> data type_name = new LinkedList<datatype>();
// add value to first element
data type_name.addFirst();
// add value to last element
data type_name.addLast();
// get value for (index) element
data type_name.get(index);
// get value from first element
data type_name.getFirst();
// get value from last element
data type_name.getLast();
// remove first element value
data type_name.removeFirst();
// remove last element value
data type_name.removeLast();
```
```java
import java.util.LinkedList;
import java.util.Collections;

public class MainClass {
  public static void main(String[] args) {
    LinkedList<String> products = new LinkedList<String>();
    String p1 = new String("Volvo");
    String p2 = new String("BMW");
    String p3 = new String("Ford");
    String p4 = new String("Mazda");
    products.add(p1);
    products.add(p2);
    products.add(p3);
    products.add(p4);
    String p5 = new String("Benz");
    products.addLast(p5);
      for(int i = 0; i < products.size(); i++) {
        System.out.println(products.get(i));
      }

    System.out.println("**********");
    System.out.println("The first product is : "+ products.getFirst());
    System.out.println("The last product is : " + products.getLast());

    products.removeLast();
    System.out.println("After deleted the product remaining : ");
      for( int i = 0; i < products.size(); i ++) {
        System.out.print(products.get(i) + "\t");
      }

    System.out.println("\n**********");

    Collections.sort(products);
    for (String i : products) {
      System.out.println(i);
    }
  }
}
```

### 2.0 Map (HashMap and TreeMap)
1. HashMap
- HashMap is element with pair of key + value, key is unique, value can be same.
- Example reference packages:
```java
import java.util.HashMap;

HashMap<datatype> data type_name = new HashMap<datatype>();
// clear all key-value
data type_name.clear();
// find Map object value
data type_name.containsKey(Object value);
// return object value
data type_name.get(Object key);
// add key-value to Map,if key exists, replace old key-value
data type_name.put("key","value");
// copy other Map to selected Map
data type_name.putAll(Map);
// selected key-value,if not exist,return null
data type_name.remove(Object key);
// Java 8 new delete key-value method
data type_name.remove(Object key, Object value);
// return all Map key-value to a Set
data type_name.entrySet();
// return Map key
data type_name.keySet();
// check Map is empty(no key-value), if empty return true
data type_name.isEmpty();
// return size of Map
data type_name.size();
// return Map values
data type_name.values();
```
```java
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class MainClass {
  public static void main(String[] args) {
    HashMap users = new HashMap();
    users.put("11", "User1");
    users.put("22", "User2");
    users.put("33", "User3");
    users.put("44", "User4");
    users.put("55", "User5");
    System.out.println("**********");

    Iterator it = users.keySet().iterator();
    while(it.hasNext()) {
        Object key = it.next();
        Object val = users.get(key);
        System.out.println("User ID : " + key + " User Name : " + val);
    }

    Scanner input = new Scanner(System.in);
    System.out.println("Please input deleted ID : ");
    int num = input.nextInt();

    if(users.containsKey(String.valueOf(num))) {
      users.remove(String.valueOf(num));
    } else {
      System.out.println("This user is not exists! ");
    }

    System.out.println("*****Users List*****");
    it = users.keySet().iterator();
    while(it.hasNext()) {
      Object key = it.next();
      Object val = users.get(key);
      System.out.println("User ID : " + key + " User Name : " + val);
    }
  }
}
```
### 3.0 Sets (HashSet and TreeSet)
1. HashSet
- Items in Sets is unique and wont appears twice although have same items.
- Example reference packages and syntax:
```java
import java.util.HashSet;

HashSet<datatype> data type_name = new HashSet<datatype>();
```
```java
import java.util.HashSet;

public class MainClass {
  public static void main(String[] args) {
    HashSet<Integer> numbers = new HashSet<Integer>();
    numbers.add(4);
    numbers.add(7);
    numbers.add(8);

    for(int i = 1; i <= 10; i++) {
      if(numbers.contains(i)) {
        System.out.println(i + " was found in the set.");
      } else {
        System.out.println(i + " was not found is the set.");
      }
    }
  }
}
```
```java
import java.util.HashSet;
import java.util.Iterator;

public class MainClass {
  public static void main(String[] args) {
    HashSet<String> courseSet = new HashSet<String>();
    String course1 = new String("Java");
    String course2 = new String("Python");
    String course3 = new String("HTML");
    String course4 = new String("PHP");
    courseSet.add(course1);
    courseSet.add(course2);
    courseSet.add(course3);
    courseSet.add(course4);
    System.out.println("All courses : ");

    Iterator<String> it = courseSet.iterator();
    while(it.hasNext()) {
      System.out.println(" <" + (String)it.next() + "> ");
    }

    System.out.println("There are " + courseSet.size() + " course.");
  }
}
```
2. TreeSet
- TreeSet different with HashSet is becuase have SortedSet interface.
- It can implement using SortedSet to sort value in ASCENDING ORDER, only can arrange and compare with same object type.
- Example reference packages and methods:

```java
import java.util.TreeSet;
import java.util.SortedSet;

// return first set element
data type_name.first();
//SortedSet
data type_name.headSet();
// return last set element
data type_name.last();
//SortedSet
data type_name.tailSet();
```

```java
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;

public class MainClass {
  public static void main(String[] args) {
    TreeSet<Double> scores = new TreeSet<Double>();
    Scanner input = new Scanner(System.in);
    System.out.println("********* Student Result System *********");
    for(int i =0; i < 5; i++) {
      System.out.println("No: " + (i + 1) + " student's result : ");
      double score = input.nextDouble();
      scores.add(Double.valueOf(score));
    }

    Iterator<Double> it = scores.iterator();
    System.out.println("Student result in ascending order: ");
    while(it.hasNext()) {
      System.out.print(it.next() + "\t");
    }

    System.out.println("\nPlease input searching result: ");
    double searchScore = input.nextDouble();
    if(scores.contains(searchScore)) {
      System.out.println("The result's: " + searchScore + " student is exists! ");
    } else {
      System.out.println("The result's: " + searchScore + " students is not exists.");
    }

    SortedSet<Double> score1 = scores.headSet(60.0);
    System.out.println("\nFailed results are: ");
    for(int i = 0; i< score1.toArray().length; i++) {
      System.out.print(score1.toArray()[i] + "\t");
    }
    SortedSet<Double> score2 = scores.tailSet(90.0);
    System.out.println("\n90% and above score are: ");
    for(int i = 0; i < score2.toArray().length; i++) {
      System.out.print(score2.toArray()[i] + "\t");
    }
  }
}
```

### 4.0 Iterator
- Use iterator to loop through Collection, ArrayList and HashSet.
- Iterator are common especially in iterate XML files, finding it attributes and value.
- Example reference packages:
```java
import java.util.Iterator;
import java.util.Collection;

Iterator<datatype> it(data type_name) = arrObj.iterator();
data type_name.next(); 
data type_name.hasNext();
// remove targeted element
data type_name.remove();
data type_name.forEachRemaining();
```

```java
import java.util.HashSet;
import java.util.Iterator;
import java.util.Collection;

public class MainClass {
  public static void main(String[] args) {
    Collection objs = new HashSet();
    objs.add("Java");
    objs.add("HTML");
    objs.add("PHP");

    Iterator it= objs.iterator();
    while(it.hasNext()) {
      String obj = (String) it.next();
      System.out.println(obj);
      if(obj.contentEquals("HTML")) {
        it.remove();
      }
    obj = "Python";
    }
    System.out.println(objs);
  }
}
```
### 5.0 Wrapper Classes
- use for working with objects declaration such as ArrayList
- Example keyword used in wrapper class:
```java
// byte,byteValue()
Byte
//short,shortValue()
Short
// int,intValue()
Integer
//long,longValue()
Long
// float,floatValue()
Float
// double,doubleValue()
Double
// boolean,booleanValue()
Boolean
// char,charValue()
Character
// convert objects to string(Integet to String)
varName.toString();
// equals to ( == )
obj.equals(Object o);
// return class name
obj.getClass().getName();
// get parent class name
obj.getClass().getSuperClass().getName();
obj.getClass().getInterfaces()[i]
```

## <a id="oth"></a> Others
### 1.0 Exceptions (try...catch)

* use for debugging the program and troubleshoot errors for the code, and for other code statement purpose

```java
try {
  { /* code block */ };
}catch (Exception e) {
  // Exception code block works here, output exception error to terminal
  e.printStackTrace();
  // System.out.println("Error is: " + e);
}
finally {
  //code to execute after try...catch(message after error code) 
}
throw new (/*Exception type*/) {
  System.out.println("text here");
};
```

* Java exception type:

1. ArithmeticException(Access denied,access granted)
2. FileNotFoundException
3. ArrayIndexOutOfBoundsException
4. SecurityException

### 2.0 Regular Expression

* Java regular expression are used to perform text search and text replace operations during executing the data.
* Commonly used to search strings, split strings, sorting and etc.
* Example reference packages for Java regular expression:

```java
import java.util.regex.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;
```

* Range of expression to find(Pattern.compile("Expression",Flag), symbols may combined together during searching process.

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// find 1 character between bracket
[abc]
// find 1 character not between bracket
[^abc]
// find 1 character from range 0 to 9
[0-9]
// find a | b
|
// just one instance of any character
.
// find a match beginning of a string as in : ^Hello
^
// find a match at the end of string as in : World$
$
// find a digit
\d
// find a whitespace character
\s
// find a word like \bWORD or WORD\b
\b
// find the Unicode character with hexadecimal number xxxx
\\uxxxx
// quantifiers define quantities to match
n+,n*,n?,n{x},n{x,y},n{x,}
```

```java
public class RegexString {
  public static void main(String[] args) {
    // pattern need to find,pattern flag(CASE_INSENSITIVE,LITERAL,UNICODE_CASE)
    Pattern pattern = Pattern.compile("patternTxt", Pattern.CASE_INSENSITIVE);
    // text need to match with pattern
    Matcher matcher = pattern.matcher("Match the patternTxt.");
    // find through matcher
    boolean matchFound = matcher.find();
    if(matchFound) {
      // if true, throw code
      System.out.println("Match found");
    } else {
      // if false, throw code
      System.out.println("Match not found");
    }
  }
}
```

### 3.0 Threads

* Thread life cycle
![Thread Life Cycle](https://www.runoob.com/wp-content/uploads/2014/01/java-thread.jpg)

* Thread Priority

1. Range from 1 - 10
2. Thread.MIN_PRIORITY(1) - Thread.NORM_PRIORITY(5) - 10 Thread.MAX_PRIORITY(10)

```java
/* Creating thread */
public class class_name implements Runnable {}
public class class_name extends Thread {}
public class class_name implements Callable {}

// class extends thread
public class ThreadClass extends Thread {
  public static int amount = 0;

  public static void main(String[] args) {
    // create object
    ThreadClass thread = new ThreadClass();
    // start thread
    thread.start();
    // check thread is still alive
    while(thread.isAlive()) {
      System.out.println("Waiting...");
    }
    System.out.println("Main: " + amount);
    amount++;
    System.out.println("Main: " + amount);
  }

  public void run() {
    amount++;
  }
}
```

* MainClass.java

```java
public class MainClass extends Thread {
  private int number;

  public MainClass(int number) {
    this.number = number;
  }

  public void run() {
    int counter = 0;
    int guess = 0;
    do {
      guess = (int) (Math.random() * 100 + 1);
      System.out.println(this.getName() + " guesses " + guess);
      counter++;
    } while( guess != number);

    System.out.println("** Correct! " + this.getName() + " in " + counter + " guesses.**");
  }
}
```

* OtherClass.java

```java
public class OtherClass implements Runnable {
  private String message;
  // setter
  public OtherClass(String message) {
    this.message = message;
  }

  public void run() {
    while(true) {
      System.out.println(message);
    }
  }
}
```

* ThreadClass.java

```java
public class ThreadClass {
  public static void main(String[] args) {
    Runnable hello = new OtherClass("Hello");
    Thread thread1 = new Thread(hello);
    thread1.setDaemon(true);
    thread1.setName("hello");
    System.out.println("Starting hello thread...");

    Runnable bye = new OtherClass("Goodbye");
    Thread thread2 = new Thread(bye);
    thread2.setPriority(Thread.MIN_PRIORITY);
    thread2.setDaemon(true);
    System.out.println("Starting goodbye thread...");
    thread2.start();

    System.out.println("Starting thread3...");
    Thread thread3 = new MainClass(27);
    thread3.start();
    try {
      thread3.join();
    }catch(InterruptedException e) {
      System.out.println("Thread interrupted.");
    }

    System.out.println("Starting thread4...");
    Thread thread4 = new MainClass(75);
    thread4.start();
    System.out.println("main() is ending...");
  }
}
```

### 4.0 Lambda Expression

* Lambda expression is supported by many languages such as C++, C#, Java, Python, Javascript.
* It used to shorten the time to write code and makes the codes easy to read and clean.
* Example lambda:

```java
(parameter) -> { Lambda code }
result = (int a,int b) -> {return a + b}; 
```

* OtherClass.java

```java
public interface OtherClass {
  int calculateInt(int a, int b);
}
```

* MainClass.java

```java
public class MainClass {
  public static OtherClass calculate(char opr) {
    OtherClass result;
    if(opr == '+') {
      // Regular Expression(result = new OtherClass() {public int calculateInt(int a, int b) {}
      result = (int a, int b) -> { return a + b; };
    } else {
      // Regular Expression(result = new OtherClass() {public int calculateInt(int a, int b) {}
      result = (int a, int b) -> { return a - b; };
    }
    return result;
  }

  public static void main(String[] args) {
    int n1 = 10;
    int n2 = 5;

    OtherClass f1 = calculate('+');
    OtherClass f2 = calculate('-');
    System.out.println(n1 + " + " + n2 + " = " + f1.calculateInt(n1, n2));
    System.out.println(n1 + " - " + n2 + " = " + f1.calculateInt(n1, n2));
  }
}
```

### 5.0 File Handling

* Example Java file handling reference packages:

```java
// to create file
import java.io.File;
// write to a file
import java.io.FileWriter;
// IO exception (try...catch)
import java.io.IOException;
```

* File handling syntax:

```java
FileReader obj = new FileReader();
FileWriter obj = new FileWriter();
BufferedReader obj = new BufferedReader();
BufferedWriter obj = new BufferedWriter();
FileInputStream obj = new FileInputStream();
FileOutputStream obj = new FileOutputStream();

// declare object with specific directory(Mac/ Linux - dir(/Users/name/filename.txt)
File myObj = new File("C:\\Users\\MyName\\filename.txt");
// check file readable,return true/false
canRead();
// check file writeable,return true/false
canWrite();
// create new file 
obj.createNewFile();
// delete file / folder(folder must be empty)
obj.delete();
// check file existance
obj.exists();
// get file name
obj.getName();
// get path of file
obj.getAbsolutePath();
// get size of file in bytes
obj.length();
mkdir();
```

```java
import java.io.*;

public class fileOutputStream {
  public static void main(String args[]) {
    try {
      byte[] bWrite = { 11, 21, 3, 40, 5 };
      OutputStream os = new FileOutputStream("C:\\Users\\MyName\\newfile.bar");
      for(int x = 0; x < bWrite.length; x++) {
        os.write(bWrite[x]);
      }
      os.close();

      InputStream is = new FileInputStream("C:\\Users\\MyName\\newfile.bar");
      int size = is.available();
      for(int i = 0; i < size; i++) {
        System.out.print((char) is.read() + " ");
      }
      is.close();

    }catch (IOException e) {
      System.out.print("Exception error: " + e);
    }
  }
}
```

```java
import java.io.File;
import java.io.IOException;

public class fileCreate {
  public static void main(String[] args) {
    try {
      // make directory
      File newObj = new File("C:\\Users\\MyName\\newfile.txt");
      // if object create new file = true
      if (newObj.createNewFile()) {
        // output
        System.out.println("File created: " + newObj.getName());
      } else {
        // if false, output code
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      // if error occur, throw exception
      System.out.println("An error occured.");
      e.printStackTrace();
    }
  }
}
```

* Input stream  syntax:

```java
// Reader to read input
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// Input stream to read file
InputStream f = new FileInputStream("C:\\Users\\MyName\\filename.txt");
// create a file directory 
File f = new File("C:\\Users\\MyName\\filename.txt");
// Input stream to read file
InputStream out = new FileInputStream(f);
```

```java
import java.io.*;

public class fileReader {
  public static void main(String args[]) throws IOException {
    char c;
    // input stream(like Scanner)
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Input charater and press 'q' to exit.");
    do {
      // read input
      c = (char) br.read();
      // write input 
      System.out.print(c);
    // if 'q' press,exit loop
    }while (c != 'q');
  }
}

/* Output at terminal
Input character and press 'q' to exit.
H202031IA      <-- input string
H202031IA      <-- output
q              <-- input string
q              <-- output and exit
*/
```

* Output Stream syntax

```java
OutputStream f = new FileOutputStream("C:\\Users\\MyName\\filename.txt");
File f = new File("C:\\Users\\MyName\\filename.txt");
OutputStream out = new FileOutputStream(f);
```

* Input and Output String to file without unicode, output file will become unreadable if array declared as int and byte

```java
import java.io.FileWriter;
import java.io.IOException;

public class fileWriteArray {
  public static void main(String[] args) {
    try {
      String[] iWrite = { "11", "21", "3", "40", "5" };
      FileWriter myWriter = new FileWriter("C:\\Users\\MyName\\newfile2.txt");
      for(int x = 0; x < iWrite.length; x++) {
        myWriter.append(iWrite[x]);
        myWriter.append("\r\n");
      }
      myWriter.write("#End");
      myWriter.close();

      System.out.println("Successful write to file.");
    }catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
    }
  }
}
```

* Input and Output to file with Unicode

```java
import java.io.*;

public class fileOutputStream {
  public static void main(String[] args) throws IOException {
    File f = new File("D:\\Temp\\AOI+AXI\\newfile.txt");
    FileOutputStream fop = new FileOutputStream(f);
    OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");

    writer.append("中文字体");
    writer.append("\r\n");
    writer.append("English");
    writer.close();
    fop.close();

    FileInputStream fip = new FileInputStream(f);
    InputStreamReader reader = new InputStreamReader(fip, "UTF-8");

    StringBuffer sb = new StringBuffer();
    while(reader.ready()) {
      sb.append((char) reader.read());
    }
    System.out.println(sb.toString());
    reader.close();
    fip.close();
  }
}
```

* Read a file content

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fileRead {
  public static void main(String[] args) {
    try {
      File obj = new File("C:\\Users\\MyName\\newfile2.txt");
      // using Scanner to read file data
      Scanner myReader = new Scanner(obj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();

    }catch (FileNotFoundException e) {
      System.out.println("An error occured.");
      e.printStackTrace();
    }
  }
}
```

* Delete file / folder

```java
import java.io.File;

public class fileDelete {
  public static void main(String[] args) {
    File obj = new File("C:\\Users\\MyName\\newfile.txt");
    if(obj.delete()) {
      System.out.println("Deleted file: " + obj);
    } else {
      System.out.println("Failed to delete file.");
    }
  }
 }
```