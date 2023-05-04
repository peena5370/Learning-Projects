# Object-Oriented Programming (Java)

### Java Comments

```java
// Single line comment
/* Multiple line comments 
 * line 1
 * line 2
 * line 3
 * line 4
 * */

```

### Variable Declaration

```java
String textString = "string here";
int iValue = 1000, iValue2 = 200, iValue3 = 4000;
float fValue = 1000.00, fValue2, fValue3 = 19.99;
char cChar = 'A', cChar2 = 'B';
//boolean = True / False
boolean x = true, y = false;
// Other datatype
byte, short, int, long, float, double, boolean, char
String, Arrays/* new Arrays() */, Classes /* declare class */, Interface /* interface class */
```

### Java Input

```java
import java.util.Scanner;
//declare datatype
int iValue = new Scanner(System.in).nextInt();
variableName = new Scanner(System.in).read value type();
// read int value, nextFloat() = read float value, 
Obj.nextInt();
// read double value
Obj.nextDouble();
//read string before whitespace, nextLine() = read entire string
Obj.next();
// read true or false value
Obj.nextBoolean;
```

### Java Print

```java
// prinln() with newline method
System.out.println(textString + iValue + fValue + x + y);
// print() without newline method
System.out.print("String without newline");
// printf() with functional method
System.out.printf("%2.2f\n",x);
```

### String Conversion

```java
String newStr = "Test string for output";
// string to upper case
System.out.println(newStr.toUpperCase());
// string to lower case
System.out.println(newStr.toLowerCase());
//return string location value(first string output first) output = 5
System.out.println(newStr.indexOf("string"));
```

### Input Symbol

```java
// single quote
" \' "
// double quote
" \" "
// backslash
" \\ "
```

### Escape Tag

```java
// newline
"\n"
// carriage return
"\r"
// tab
"\t"
// backspace
"\b"
// form feed
"\f"
```

### Operators(calculation)

#### 1. Calculation symbol

```java
int Val = x + y;
int Val = x - y;
int Val = x * y;
int Val = x / y;
int Val = x % y;
int Val = x++;
int Val =  ++x;
int Val =  x--;
int Val = --x;
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

#### 2. Comparison symbol

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

#### 3. Logical symbol

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

### Math Class

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

### Java Annotation

```java
@Override
//use for tell compiler to check error for rewrite code syntax
@Deprecated
//use for check class, method, interface wether it is expired and throw error 
@SuppressWarnings({"keywords"})
//suppress warning that trigger with keywords(all,boxing,cast,dep-ann,deprecation,fallthrough,finally,hiding....)
@SafeVarargs
@FunctionalInterface
```

### Java Conditional Statements

#### 1. If...else statement

```java
if( x == 1) {
  { /* code block */ } 
} else {
  { /* code block */ }
}
```

#### 2. If...else if...else statement

```java
if ( x == 1) {
  { /* code block */ }
} else if ( x == 2) {
  { /* code block */ } 
} else {
  { /* code block */ }
}
```

#### 3. Lambda if...else statement

```java
//variable = String output, expressionTrue = functionName1()/"output 1", expressionFalse = functionName2()/"output2";
variable = ( x == 1) ? expressionTrue : expressionFalse;
```

#### 4. Switch...case statement

```java
int iValue = 4;
switch(iValue) {
  case 1:
    { /* code block */ }
    break;
  case 2:
    { /* code block */ }
    break;
  case 3:
    { /* code block */ }
    break;
  case 4:
    { /* code block */ }
    break;
  case 5:
    { /* code block */ }
    break;
  default:
    { /* code block */ }
}
```

#### 5. While Loop statement

```java
while ( x < 6 ) {
  { /* code block */ }
  value ++;
}
```

#### 6. Do...while statement

```java
do {
  { /* code block */ }
}while ( x < 6 );
```

#### 7. For loop statement

```java
for( x = 0; x < 5; x++) {
  { /* code block */ }
}

// nested for loop
for( x = 0; x < 5; x++) {
  { code block };
  for( y = 0; y < 5; y++) {
    { /* code block */ };
  }
}
```

#### 8. For-Each loop (use to loop elements through array)

```java
String[] text = {"Str1","Str2","Str3"};
// for( datatype variableName : arrayName) {}
for(String newVar : text) {
  System.out.println(newVar);
}
```

#### 9. Use of break / continue during loop statement

```java
for(x=0; x<10; x++){
  if(x==4){
    { /* break entire loop if condition = true */ };
  break;
  }
}
for(x=0; x<10; x++){
  if(x==4){
    { /* break only one loop based on the condition */ }; 
  continue;
  }
}
```

### Java Arrays

```java
// array declaration(datatype[] arrayName)
String[] cars;
// 1D array
String[] cars = {"Str1","Str2","Str3"};
// 2D array
int[][] newArr = { {1,2,3,4},{5,6,7,8}};
// output length of cars array
System.out.println(cars.length);

/* for loop array */
for( int i = 0; i < newArr.length; i++) {
  for( int j = 0; j < newArr[i].length; j++) {
    { /* code block */ };
  }
}
```

### Java Function Calling

#### 1. Declare function in same class

```java
static void newFunc() {
  { /* code block */ };
}

public static void main(String[] args) {
  // execute newFunc() in main() class
  newFunc();
}
```

#### 2. Ceclare function with parameters

```java
static void strParse( String str) {
  System.out.println("This is the end of " + str + " string.");
}

public static void main(String[] args) {
  // output = This is the end of first string.
  strParse("first");
  // output = This is the end of second string.
  strParse("second");
}
```

#### 2. return function value

```java
static void funcAdd( int x, y) {
  return x + y;
}

public static void main(String[] args) {
  int z = duncAdd(5,3);
  // output = 8 (5 + 3)
  System.out.println(z);
}
```

#### 3. If...else return statement

```java
static void isVal(int x) {
  if (x == 5) {
    Systen.out.prinln("Input is equal to 5.");
  } else {
    System.out.println("Input is not equal to 5.")
  }
}

public static void main(String[] args) {
  // output = "Input is not equal to 5."
  isVal(10);
}
```

## Java Object-Oriented Programming

1. Make new class file is similar like declare universal variable, then reuse in other .java file,
2. Declare public class to make it usable at other places, then use pointer to access the items we need such as (newObj.x --> object.other class variables)
3. Before use at other .java file, need to declare as new class( otherClass newObj = new otherClass();  newObj.otherClassFunc();

### Creating a class method

```java
// declaring a class with name NewClass
public class NewClass {
  int i = 5;
  public static void main(String[] args){
        //declaring object call newObj
        NewClass newObj = new NewClass();
        // output value of i
        System.out.println(newObj.i);
}
```

### Creating a class with other .java folder

* SubClass.java

```java
public class SubClass {
  // final use to declare fixed value to prevent override
  final int i = 10;
  int j = 5;
}
```

* MainClass.java

```java
class MainClass {
  public static void main(String[] args) {
    SubClass newObj = new SubClass();
    System.out.println(newObj.j);         // output 5
  }
}
```

### Java Class and Object Modifier

#### 1. 'public' class which can be access by all classes

```java
public class str {
  String str = 'Hello World!';
};

public static void main(String[] args) {
  Main obj = new str();
  System.out.println(obj.str);          // output = Hello World!
}
```

#### 2. 'private' class which only can access in own class

```java
class PrivateClass {

// private class declaration
private class str {
  public void print() {
    System.out.println('Inner output in private class.');
  }
};

// getter
void getStr() {
  str getStr = new str();
  getStr.print();
}
}

public class mainClass {
  public static void main(String[] args) {
    // Instantiating the outer class 
    PrivateClass printOutput = new PrivateClass();
    
    // Accessing the getStr() method.
    printOutput.getStr();                    // output = Inner output in private class.
   }
}
```

#### 3. 'default/empty declaration' class which only accessible in same package

```java
class str {
  String msg = 'This is a string.';
};

public class mainClass {
  public static void main(String[] args) {
    str a = new Str();
    System.out.println(a.msg);              // output = This is a string.
  }
}
```

#### 4. 'protected' class which only accessible in same package and subclasses

* protectedClass.java

```java
public class protectedClass {
  protected void msg() {
    System.out.println('This string comes from protected class.');
  };
}
```

* mainClass.java

```java
public class mainClass extends protectedClass {
  public static void main(String[] args) {
    mainClass obj = new mainClass();
    obj.msg();                              // output = This string comes from protected class.
  }
}
```

#### 5. 'final' class cannot be override or inherit by other classes

```java
// final class
final class finalClass {
void msg(){
System.out.println("Final class output is here.");
}
}

// Inheriting finalClass class is not allowed as it is a final class, will throw error if inherit final class
/*class extendClass extends finalClass {
  
}
*/

//main class
class mainClass {
public static void main(String[] args) {
//creating instance of the finalClass class
finalClass obj = new finalClass();
obj.msg();                                  // output = Final class output is here.
}
}
```

#### 6. 'abstract' class or method don't have body and abstract inside the function, may inherit to other classes and extends the function after inherit the methods

```java
abstract class Car {  
  abstract void run();                     // Abstract method without body.
}

// extends Volvo from abstract class
class Volvo extends Car {
// declare body for the abstract class
void run(){
  System.out.println("Running safely");
}  
public static void main(String args[]){  
  Car obj = new Volvo();  
  obj.run();                              // output = Running safely 
}  
}  
```

### Java Variable Modifier

#### 1. 'final' declared variable or methods cannot be override or inherit

```java
final int intNum = 100;                   // final variable value cannot be changed.
```

#### 2. 'static' fixed for the class,cannot used outside

```java
class Student{  
  int rollno;  
  String name;  
  static String college = "ITS";  
  //static method to change the value of static variable  
  static void change(){  
  college = "BBDIT";  
  }  
  //constructor to initialize the variable  
  Student(int r, String n){  
  rollno = r;  
  name = n;  
  }  
  //method to display values  
  void display(){System.out.println(rollno+" "+name+" "+college);}  
}

//Test class to create and display the values of object  
public class TestStaticMethod{  
  public static void main(String args[]){  
  Student.change();//calling change method  
  //creating objects  
  Student s1 = new Student(111,"Karan");  
  Student s2 = new Student(222,"Aryan");  
  Student s3 = new Student(333,"Sonoo");  
  //calling display method  
  s1.display();                         // output = 111 Karan BBDIT 
  s2.display();                         // output = 222 Aryan BBDIT
  s3.display();                         // output = 333 Sonoo BBDIT
  }  
} 
```

#### 3. 'abstract' can used in an abstract class and abstract methods

```java
abstract void run();                     // Abstract method without body.
```

#### 4. transient = skip attributes and methods when serializing

```java
import java.io.*;
class Test implements Serializable
{
    // Normal variables
    int i = 10, j = 20;
  
    // Transient variables
    transient int k = 30;
  
    // Use of transient has no impact here
    transient static int l = 40;
    transient final int m = 50;
  
    public static void main(String[] args) throws Exception
    {
        Test input = new Test();
  
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
        /* output
        i = 10
        j = 20
        k = 0
        l = 40
        m = 50
         */
    }
}
```

#### 5. 'synchronized' methods can be use only by one thread at same time (Use in threading process)

```java
import java.io.*;
import java.util.*;
 
// A Class used to send a message
class Sender
{
    public void send(String msg)
    {
        System.out.println("Sending\t"  + msg );
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println("Thread  interrupted.");
        }
        System.out.println("\n" + msg + "Sent");
    }
}
 
// Class for send a message using Threads
class ThreadedSend extends Thread
{
    private String msg;
    Sender  sender;
 
    // Receives a message object and a string
    // message to be sent
    ThreadedSend(String m,  Sender obj)
    {
        msg = m;
        sender = obj;
    }
 
    public void run()
    {
        // Only one thread can send a message
        // at a time.
        synchronized(sender)
        {
            // synchronizing the snd object
            sender.send(msg);
        }
    }
}
 
// Driver class
class SyncDemo
{
    public static void main(String args[])
    {
        Sender snd = new Sender();
        ThreadedSend S1 =
            new ThreadedSend( " Hi " , snd );
        ThreadedSend S2 =
            new ThreadedSend( " Bye " , snd );
 
        // Start two threads of ThreadedSend type
        S1.start();
        S2.start();
 
        // wait for threads to end
        try
        {
            S1.join();
            S2.join();
        }
        catch(Exception e)
        {
            System.out.println("Interrupted");
        }
    }
}

/* output =
Sending    Hi
Hi sent

Sending    Bye
Bye sent
*/
```

#### 6. 'volatile' value not cached thread-locally, always read from the 'main memory'

```java
class SharedObj {
   // volatile keyword here makes sure that
   // the changes made in one thread are 
   // immediately reflect in other thread
   static volatile int sharedVar = 6;
}
```

### Java Encapsulation - private modifier

```java
public class Person {
  // restricted access variable
  private String name;

  public static void main(String[] args) {
    Person strName = new Person();
    strName.setName('John');
    
    // output = My name is John.
    System.out.println('My name is ' + strName.getName());
  }

  // getter
  public String getName() {
    // read restricted variable and return to public by using getName(),value read-only
    return this.name;
  }
  // setter
  public void setName(String newName) {
    // write new variable to restricted variable,value can get by setName(),value write-only
    this.name = newName;
  }
}
```

### Java Packages and API

```java
// Reference library packages

// import single class
import package.name.Class;
// java Scanner library
import java.util.Scanner;
// import whole package
import package.name.*;
// java util library
import java.util.*;
```

#### structure direction of package

_____>root                         --> root folder ie. java  
    _____>mypack                   --> package folder ie. util  
      _____>MyPackageClass.java    --> class folder ie.Scanner

output package name = import root.mypack.MyPackageClass

#### package keyword

```java
// declare package name(must in lower case)
package com.testpackage.mypack;

// declare class name
class MyPackageClass {
  public static void main(String[] args) {
    { /* code block */ };
  }
}  
```

### Java Inheritance

#### sublass (child class) extends superclass (parent class)

```java
(public/default) class class_name extends extend_class { 
  { /* code block */ };
}

public class this_class.java extends new_class { 
  { /* code block */ };
} 
```

* superclass(create new parent class)

```java
class Vehicle {
  protected String brand = "Ford";
  public void honk() {
    System.out.println("honk honk");
  }
}
```

* subclass(inherit Car.java from superclass(Vehicle.java))

```java
class Car extends Vehicle {
  private String modelName = "Mustang";

  public void main(String[] args) {
    // create object
    Car myCar = new Car();
    myCar.honk();
    // output = Ford honk honk
    System.out.println(myCar.brand + " " + myCar.modelName):
  }
}
```

### Java Polymorphism

* In Java, one subclass only can inherit one parent class, while in Python/ C++, one subclass can inherit multiple parent classes.

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

### Java Inner Class/Nested Class

* To access inner class, need to create an outer class, then access inner class through outer class

#### Declare inner class

```java
// outer layer part 
OuterClass{
  { /* code block */ };
  
  // nested layer inner class
  InnerClass{
  { /* code block */ };
  }
}
```

#### Example inner and outer class explained with nested loop statement

```java
// outer layer
for(int i=0; i<10; i++) {
  Systen.out.println('Outer loop: ' + [i]);

  // inner layer
  for(int j=0; j<10; j++) {
    System.out.println('Inner loop' + [j]);
  }
}
```

#### Example running nested class

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

  public static void main(String[] args) {
    OuterClass myOuter = new OuterClass();
    OuterClass.InnerClass myInner = myOuter.InnerClass();
    System.out.println(myInner.myInnerMethod());
  }
}
```

### Java Abstract

* To improve security by hiding certain details and show only important details by using abstract method.

#### Classes and Methods

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
class MainClass {
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

### Java Interface

* Java interface class is different with abstract class, it don't have body and only dan define method name inside interface class.

```java
interface Animal {
  // cannot define structure for interface class function, will throw error
  public void animalSound();
  public void sleep() ;
}

// use 'implements' keyword to create body for interface class
class Pig implements Animal {
  public void animalSound() {
    System.out.println("Snork...");
  }

  public void sleep() {
    System.out.println("Sleep...Zzz...");
  }
}

// execute implemented class into main class
class MainClass {
  public static void main(String[] args) {
    Pig myPig = new Pig();
    // output = Snork...
    myPig.animalSound();
    // output = Sleep...Zzz...
    myPig.sleep();
  }
}
```

```java
interface FirstInterface {
  public void myMethod();
}

interface SecondInterface {
  public void oOtherMethod();
}

// interface class can be implement in many interfaces class in one time, to create structure in one class 
class ImplClass implements FirstInterface,SecondInterface {
  // interface 1, declare function for interface class
  public void myMethod() {
    System.out.println("Woo....");
  }

  // interface 2, declare function for interface class
  public void oOtherMethod() {
    System.out.println("Goo....");
  }
}

class MainClass {
  public static void main(String[] args) {
    ImplClass myTest = new ImplClass();
    myTest.myMethod();
    myTest.oOtherMethod();
  }
}
```

### Java Enums

* 'enum' is a special "class"(variable unchangeable like final variable).
* It usually use for the values/variables that not going to change for future.
* It use pointer to point the variables in other class (LEVEL.MEDIUM).
* It cannot be used to create object, but it can be implemented for interfaces class.

```java
enum LEVEL {
  LOW,MEDIUM,HIGH
}

public class EnumClass {
  public static void main(String[] args) {
    // declare enum LEVEL
    LEVEL myVar = LEVEL.MEDIUM;

    // switch between LEVEL variable
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
    // loop through LEVEL variables
    for(LEVEL myVar : LEVEL.values()) {
      // output = LOW MEDIUM HIGH
      System.out.println(myVar);
    }
  }
}
```

### Java DateTime

#### Java reference library and classes

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

### Java List

#### 1. ArrayList

* Common arralist methods = add(), get(), set(), remove(), clear(), size(), sort()

```java
import java.util.ArrayList; 
import java.util.Collections;

// declare arraylist as object
ArrayList<datatype> variable_name = new ArrayList<datatype>();
// declare raw type
ArrayList variable_name = new ArrayList();
//arraylist(no datatype,can store multiple items)

// add items to arraylist
variable_name.add("values1");
variable_name.add("values2");
variable_name.add("values3");
variable_name.add("values4");
// get arr_position value
variable_name.get(arr_position);
// set arr_position with new value
variable_name.set(arr_position, new_value);
// remove arr_position value
variable_name.remove(arr_position);
// clear all array elements
variable_name.clear();
// to determine the actual array size
variable_name.size();
// sort value in ascending order
Collections.sort(variable_name);
```

```java
import java.util.ArrayList;
import java.util.Collections;

public class MainClass {
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

#### 2. Linked List

```java
import java.util.LinkedList;
import java.util.Collections;

// declare linked list
LinkedList<dataype> variable_name = new LinkedList<datatype>();
// add value to first element
variable_name.addFirst();
// add value to last element
variable_name.addLast();
// get value for (index) element
variable_name.get(index);
// get value from first element
variable_name.getFirst();
// get value from last element
variable_name.getLast();
// remove first element value
variable_name.removeFirst();
// remove last element value
variable_name.removeLast();
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

### Java Map (HashMap and TreeMap)

#### HashMap

* HashMap is element with pair of key + value, key is unique, value can be same.
* Example reference packages:

```java
import java.util.HashMap;

HashMap<datatype> variable_name = new HashMap<datatype>();
// clear all key-value
variable_name.clear();
// find Map object value
variable_name.containsKey(Object value);
// return object value
variable_name.get(Object key);
// add key-value to Map,if key exists, replace old key-value
variable_name.put("key","value");
// copy other Map to selected Map
variable_name.putAll(Map);
// selected key-value,if not exist,return null
variable_name.remove(Object key);
// Java 8 new delete key-value method
variable_name.remove(Object key, Object value);
// return all Map key-value to a Set
variable_name.entrySet();
// return Map key
variable_name.keySet();
// check Map is empty(no key-value), if empty return true
variable_name.isEmpty();
// return size of Map
variable_name.size();
// return Map values
variable_name.values();
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

### Java Sets (HashSet and TreeSet)

1. HashSet

* Items in Sets is unique and wont appears twice although have same items.
* Example reference packages and syntax:

```java
import java.util.HashSet;

HashSet<datatype> variable_name = new HashSet<datatype>();
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

* TreeSet different with HashSet is becuase have SortedSet interface.
* It can implement using SortedSet to sort value in ASCENDING ORDER, only can arrange and compare with same object type.
* Example reference packages and methods:

```java
import java.util.TreeSet;
import java.util.SortedSet;

// return first set element
variable_name.first();
//SortedSet
variable_name.headSet();
// return last set element
variable_name.last();
//SortedSet
variable_name.tailSet();
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

### Java Iterator

* Use iterator to loop through Collection, ArrayList and HashSet.
* Iterator are common especially in iterate XML files, finding it attributes and value.
* Example reference packages:

```java
import java.util.Iterator;
import java.util.Collection;

Iterator<datatype> it(variable_name) = arrObj.iterator();
variable_name.next(); 
variable_name.hasNext();
// remove targeted element
variable_name.remove();
variable_name.forEachRemaining();
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

### Java Wrapper Classes

* use for working with objects declaration such as ArrayList
* Example keyword used in wrapper class:

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

### Java Exceptions (try...catch)

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

### Java Regular Expression

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

### Java Threads

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

### Java Lambda Expression

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

### Java File Handling

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
