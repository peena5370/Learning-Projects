# Python Programming

### Comment

``` python
# Single line comment
"""
  Multi line comment
"""
```

### Calculation Symbol Operator

``` python
  +  # add
  -  # minus
  *  # multiply
  /  # devision
  // # floor division
  %  # modulus
  ** # power of
  =  # equal
```

### Python Module

Similar as Java import package method.
Example Java import:

```java
import java.io.File;
import com.tispackages.SoapTIS;

public class TISInterface {
  public static void main(String[] args) {
    SoapTIS.functName();
  }
} 
```

``` python
# Example Python import:
# otherClass.py
person1 = {
  "name": "John",
  "age": 36,
  "country": "Norway"
}

import otherClass

a = otherClass.person1["name"]
print(a)                                    # output = John

# Rename a module:
import otherClass as otrCls
a = otrCls.person1["age"]
print(a)                                    # output = 36

# Import from module (only import certain method to other class):
class mymodule:
  def greeting(name):
    print("Hello, " + name)

  person1 = {
    "name": "John",
    "age": 36,
    "country": "Norway"
  }

# otherClass.py
from mymodule import person1              # only import certain method to this class

print (person1["age"])

#mypackage1.py module file

# simple function use to print output.
class module1:
  def display(arc):
    print(arc)

#mypackage2.py module file
import mypackage1

# python file name.classname.methodname
mypackage1.module1.display("print function from package 1.")
```

### Print

``` python
print("string length") # result = string length
print(15 + 20)         # result = 35
print("a" + "5")       # result = a5
num = 1_310_547        # symbol _ stands for mathematical "," symbol meaning
print("Value is: " , num)

# method of print text into text file using print()
f = open("testtext.txt", "w")
print("string one", file = f)
print("string two", file = f)
f.close()

# print() method which similar with java printf()
a = "Value b and c is: "
b = 15
c = 0.432
print("%s%d and %.2f" %(a, b, c))     # output = "Value b and c is: 15 and 0.43"
```

### Input

``` python
# example 1
height = float(input("Please input height：")) 
weight = float(input("Please input weight：")) 
bmi = weight / (height * height)

# check input condition
if bmi < 18.5:                          # in python " : " = { code goes here }
    print("BMI value is：" + str(bmi))  # str = toString()
    print("Underweight.")
if bmi >= 18.5 and bmi < 24.9:
    print("BMI value is：" + str(bmi))
    print("Normal，please keep it up.")
if bmi >= 24.9 and bmi < 29.9:
    print("BMI value is：" + str(bmi))
    print("Overweight.")
if bmi >= 29.9:
    print("BMI value is：" + str(bmi))
    print("Fat.")

# example 2
a = input("Enter a number: ")
b = input("Enter another number: ")

print("aType: ", type(a))
print("bType: ", type(b))

result = a + b
print("resultValue: ", result)
print("resultType: ", type(result))
```

### Conversion

``` python
a = "15"
a = int(a)              # convert from string to int, int(string) = toInt(string)
print(type(a))          # output <class'int'>

b = "20"
b = float(b)            # convert from string to float, float(string) = toFloat(string)
print(type(b))          # output <class'float'>

c = "1"
c = bool(1)             # convert string to bool value, output = 1
print(type(c))          # output <class'bool'>
```

### Python String

``` python
str = "string split.with symbol"
x = str.split(".")                                  # using split() method split string with "."
print(x)                                            # output = ['string split','with symbol']
strTuple = ('Adam','John','Paul')
y = "#".join(strTuple)                              # join strings togather with "#" symbol
print(y)                                            # output = 'Adam#John#Paul'
```

### Object Access

``` python
  _width                            # protected variable
  class _Car                        # protected class
  def _double_price(self):          # protected method
    return self._price

  def __double_method(self):        # for mangling / private class
    pass

  def __init__(self, a):            # special method(only use for documentation)
    self.__a = a                    # __a is private variable, similar as Java private String a
```

### Python Variables

In Python, it's also same as VB Script and Java, consists of local and global variables.
When need to acquire variables inside a function, globals() method/ global keyword is used to use or let the variable inside the function visible outside the code.
While locals() is used as localize the variable inside the function, it is default setting in Python.

``` python
def myfunc():
  global x                                            # variable x is become global variable
  x = "fantastic"

myfunc()

print("Python is " + x)                               # x is usable outside the function and output is = Python is fantastic
```

### Python Collection

1. List             newList = []
2. Tuple            newTuple = ()
3. Set              newSet = {}
4. Dictionary       newDict = {'key':'value','key':'value'}

### 1. Python list (Does similar with java arraylist)

Python list is not fixed lenth, which is does have some similarity with Java arraylit.
Besides that it also be useable as array which similar with java array.
Python DON'T have array, only list are available.
Python list is not fixed type, it can add up data like this:

``` python
pyList = ["string one", 12, [1,2,3,4], 56]
```

#### 1.1 Python list method

``` python
strList = []                              # declare strList as list
strList.append("elem1")                   # add single element into list
strList.extend("elem2","elem3","elem4")   # add multiple element to the list
strList.clear()                           # clear list
y = strList.count("elem1")                # count value of the element appear
z = strList.index("elem3")                # output postion of first element
strList.insert(2, "newElem")              # add new element with specific position
strList.pop(2)                            # remove element with specific position
strList.remove("newElem")                 # remove specific element with first occurance
strList.reverse()                         # reverse list order
strList.sort()                            # sort the list
del strList[0:2]                          # delete list element start from 0 and before 2 position
del strList[1]                            # delete list element at specific location
```

#### 1.2 Create an empty list

```python
My_list = []
  
# Value to begin and end with
start, end = 10, 20
  
# Check if start value is smaller than end value
if start < end:
    # unpack the result
    My_list.extend(range(start, end))     # range() method which list will extend from a range of 10 to 20
    # Append the last value
    My_list.append(end)
  
# Print the list
print(My_list)                            # output = [10,11,12,13,14,15,16,17,18,19,20]
```

### 2. Python tuple

A little bit similar as array, but tuple is constant element.
Element inside tuple are unchangeable and fixed order, but can be replaced with new objects which is same name as previous tuple.
Suitable for permanent element which won't change after insert.
Example of tuple:

```python
obj = ()

num = (1,2,3,4,5)                                 # integer type tuple
strTuple = ("str1","str2","str3","str4")          # string type tuple
compTuple = ("str1", 2, ["str2","str3"], (4,5))   # complex type tuple

y = list(num)                                     # convert tuple(num) to list(num)
y[1] = 6                                          # changing list(num) element
x = tuple(y)                                      # convert list(num) to tuple(num)
print(x)                                          # output (1,6,3,4,5)
```

### 3. Python Set

Set is a collection of element which is unchangeable, unordered, and unindexed.
Set can make changes in adding items and remove items.
Set concept is similar as discrete mathematics sets, may have union set, intersection set....
Checking set directories:

``` python
# >>> dir(set)
# >>> dir(frozenset)

numSet = {1,2,3,4,5}                                 # integer type set
for x in numSet:                                     # loop through set
  print(x)                                           # output set = 1 2 3 4 5

numSet.add(6)                                        # adding 6 into set
print(numSet)                                        # output set = {1,2,3,4,5,6}

newList = ['str1','str2']                            # create a string list
numSet.update(newList)                               # using update() method to add item into set
print(numSet)                                        # output set = {1,2,3,4,5,6, 'str2', 'str1'}

numSet.remove(6)                                     # remove element 6 from the set
numSet.discard(5)                                    # remove element 5 from the set
print(numSet)                                        # output set = {1,2,3,4, 'str2', 'str1'}
```

### 4. Python Dictionary

Dictionary which is similar as struct in C, will have key : value.
Data in dictionary is changeable, non-duplicate and ordered.
Example dictionary:

``` python
thisdict = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
```

``` python
thisdict = {                                         # create dictionary
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}

x = thisdict["model"]                                # acquire thisdict["model"] value
print(x)                                             # output = Mustang
y = thisdict.get("model")                            # using get() method to acquire "model" value
print(y)                                             # output = Mustang
print(thisdict.keys())                               # output = ['brand','model','year']
print(thisdict.values())                             # output = ['Ford','Mustang','1964']
print(thisdict.items())                              # output = [('brand':'Ford'),('model':'Mustang'),('year':'1964')]
thisdict["color"] = "white"                          # adding new key and new value
print(thisdict)                                      # output = {'brand':'Ford','model':'Mustang','year':'1964','color':'white'}
thisdict.update({"year": 2020})                      # update the value of the key = update({key: value})
print(thisdict)                                      # output = {'brand':'Ford','model':'Mustang','year':'2020','color':'white'}
thisdict.update({"transmission" : "auto"})           # using update() method to add new key and value into dictionary
print(thisdict)                                      # output = {'brand':'Ford','model':'Mustang','year':'2020','color':'white','transmission':'auto'}
thisdict.pop("transmission")                         # remove specific item in dictionary
thisdict.clear()                                     # clear all key and values inside the dictionary
newdict = thisdict.copy()                            # copy thisdict to other new dictionary
print(newdict)                                       # output = {'brand':'Ford','model':'Mustang','year':'2020','color':'white'}
```

### Python If....Else statements

``` python
#### Simple if statement, if condition = true, then execute
a = 33
b = 200
if b > a:
  print("b is greater than a")

# Simple if...else if statement
a = 33
b = 33
if b > a:
  print("b is greater than a")
elif a == b:
  print("a and b are equal")

# Simple if...else if....else statement
a = 200
b = 33
if b > a:
  print("b is greater than a")
elif a == b:
  print("a and b are equal")
else:
  print("a is greater than b")

# Simple if...else statement
a = 200
b = 33
if b > a:
  print("b is greater than a")
else:
  print("b is not greater than a")

# Nested If
x = 41

if x > 10:
  print("Above ten,")
  if x > 20:
    print("and also above 20!")
  else:
    print("but not above 20.")
```

### Pass statement

pass keyword is used as empty function. In Python if statement, if condition is empty, code will throw error.
Using pass keyword will prevent code to throw error and the programmer may edit the code later on.

``` python
a = 33
b = 200

if b > a:
  pass

for x in [0, 1, 2]:
  pass
```

### Python While Loop

Similar as other languages concept, while condition = true, execute loop, end after condition false.

``` python
num = 1

while num < 100 :
    print("num=", num)
    num += 1
print("Loop End!")
```

### Python For Loop

Does have similarity as java for each concept.
Java example:

``` java
  for(Attribute attr : attrList) {
    String attrName = attr.getName();
    String attrValue = attr.getValue();
    System.out.println("Element name are: " + attrName + " --- Element value are: " + attrValue);
    if(attrName.equals("id")) {
      bookEntity.setId(attrValue);
    }
```

Python example:

``` python
  for attr in attrList:
    String attrName = attr.getName()
    String attrValue = attr.getValue()
    print("Element name are: ", attrName, " --- Element value are: ", attrValue)

    if(attrName.equals("id")):
      bookEntity.setId(attrValue)
```

``` python
# Simple for loop
for x in range(6):
  if x == 3: break
  print(x)
else:
  print("Finally finished!")                        # If the loop breaks, the else block is not executed.

# Nested for loop
adj = ["red", "big", "tasty"]
fruits = ["apple", "banana", "cherry"]

for x in adj:
  for y in fruits:
    print(x, y)                                     # output = [red apple, red banana, red cherry, big apple, big banana, big cherry, tasty apple, tasty banana, tasty cherry]
```

### Python Function

``` python
# Simple function declaration
def newFunc(num1, num2):
  c = num1 + num2
  return c

x = newFunc(3,4)
print(x)                                             # output = 7        
y = newFunc(5,6)
print(y)                                             # output = 11

# Passing list as arguments
def my_function(food):
  for x in food:
    print(x)

fruits = ["apple", "banana", "cherry"]

my_function(fruits)                                # output = apple banana cherry
```

### Python Lambda

Python lambda does similar as java lambda, used for shorten and saving time on development process.
It makes code easier to read and execute faster.
Example java lambda:

``` python
// (parameter) -> { code block }
public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    numbers.add(5);
    numbers.add(9);
    numbers.add(8);
    numbers.add(1);
    numbers.forEach( (n) -> { System.out.println(n); } );             // Lambda works here, shorten the for each statements.
  }
}
```

``` python
def myfunc(n):
  return lambda a : a * n                           # lambda function works here. Method lambda = lambda arguments : expression

mydoubler = myfunc(2)
mytripler = myfunc(3)

print(mydoubler(11))
print(mytripler(11))
```

### Python Datetime

Example Java datetime:

```java
import java.time.*;
/* classes
LocalDate = yyyy-MM-dd
LocalTime = HH-mm-ss-ns
LocalDateTime = yyyy-MM-dd-HH-mm-ss-ns
DateTimeFormatter = display and parse date-time objects */

/* date time formatter(.ofPattern("values")
yyyy-MM-dd = 1920-12-31
dd/MM/yyyy = 31/12/2020
dd-MMM-yyyy = 31-Dis-1920
E,MMM dd yyyy = Thu, Dis 31 1920 */

import java.time.LocalDateTime;        // import localdatetime class
import java.time.format.DateTimeFormatter;  // import datetimeformatter

public class hellotest {
  public static void main(String[] args) {
    LocalDateTime myDateObj = LocalDateTime.now();    // declare object for current date time
    System.out.println("Before change " + myDateObj);
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy");  // declare format
  
    String formattedDate = myDateObj.format(myFormatObj);  // convert to string
    System.out.println("After change " + formattedDate);  // output string
  }
}
```

``` python
# Simple datetime code
import datetime

x = datetime.datetime.now()
print(x)                                            # output = 2021-11-18 16:12:20.974120(current datetime)
# Method of formatting output from datetime
x = datetime.datetime(2021, 11, 18)

print(x.strftime("%B"))                             # output = November
```

### Python OOP

Object-Oriented Programming, concept similar as java with those implement methods such as, inheritance, encapsulation, polymorphism.
Using classes to implement object-oriented software design.
Example java class:

```java
public class myClass {
  private String strObject;

  public static void main(String[] args) {
    String x = "Hello, this is Java myClass object.";
    myClass classObj = new myClass(x);
    System.out.println(classObj.getStrObject());
  }

  public String getStrObject() {
    return this.strObject;
  }

  public myClass(String str) {
    this.strObject = str;
  }
}
```

```python
# Simple Python class example
class Person:
  def __init__(self, name, age):                  # self keyword is similar as java this keyword
    self.name = name
    self.age = age

  def myfunc(self):
    print("Hello my name is " + self.name)

p1 = Person("John", 36)
p1.myfunc()                                       # output = Hello my name is John
```

### Python code using @property

 ``` python
class Geeks:
  def __init__(self):
    self._age = 0
    
  # using property decorator
  # a getter function
  @property
  def age(self):
    print("getter method called")
    return self._age
    
  # a setter function
  @age.setter
  def age(self, a):
    if(a < 18):
      raise ValueError("Sorry you age is below eligibility criteria")
    print("setter method called")
    self._age = a
  
mark = Geeks()
  
mark.age = 19
  
print(mark.age)
```

``` python
class myClass:
  def __init__(self, strObj=""):                            # Python initialization function, use to assign value to object properties.
    self._strObj = strObj                                    # at here, self.strObj does similar to private String strObj

  def getStrObj(self):                                      # getter
    return self._strObj

  def setStrObj(self, str):                                 # setter
    self._strObj = str
  
classObj = myClass()                                        # declare object
classObj.setStrObj("String")                                # set "String" into strObj
print(classObj.getStrObj())                                 # output = String
```

### Python code using property()

property() widely used in Python, used to set property for the object.
Format property():

```python
myObj = property(getter=None, setter=None, fdel=None, doc=None)
myObj = property(getter=None)
myObj = property(getter=None, setter=None)
myObj = property(getter=None, setter=None, fdel=None)
```

```python
class myClass:
  def __init__(self,n):
    self._name = n

  def setname(self,n):                                                              # setter
    self._name = n

  def getname(self):                                                                # getter
    return self._name

  def delname(self):                                                                # delete
    self._name="String deleted."

  name = property(getname, setname, delname, 'Help doc goes here...')               # using property() to give object name to access for getter, setter, delete and documentation.
#2 methods of reading documentation
#print(CLanguage.name.__doc__)
help(myClass.name)                                                                  # output documentation
myObj = myClass("String one")                                                       # set variable for object

print(myObj.name)                                                                   # output = String one

myObj.name="Setter string"                                                          # method 2 for setting variable for object                                       
print(myObj.name)                                                                   # output = Setter string

del myObj.name                                                                      # variable deleted.
print(myObj.name)                                                                   # output = String Deleted.
```

### Python Encapsulation

Similar as Java encapsulation, in Java, we use to declare private variable in a class to prevent other classes access the variable,
and using getter and setter method to acquire value from the class.
Example in Java:

```java
public class myClass {
  // private variable
  private String strObject;

  public static void main(String[] args) {
    String x = "Hello, this is Java myClass object.";
    myClass classObj = new myClass(x);
    System.out.println(classObj.getStrObject());
  }
  // getter
  public String getStrObject() {
    return this.strObject;
  }
  // setter
  public myClass(String str) {
    this.strObject = str;
  }
}
```

```python
# Python code with private members
class myClass:
  def __init__(self):
    self.a = "GeeksforGeeks"
    self.__c = "GeeksforGeeks"

class Derived(myClass):
  def __init__(self):  
    # Calling constructor of myClass
    myClass.__init__(self)
    print("Calling private member of myClass class: ")
    print(self.__c)

obj1 = myClass()
print(obj1.__c)
 
# Uncommenting print(obj1.c) will raise an AttributeError
# Uncommenting obj2 = Derived() will also raise an AtrributeError as
# private member of myClass is called inside derived class

# Python code with protected members
class myClass:
  def __init__(self):  
    # Protected member
    self._a = 2
 
# Creating a derived class   
class Derived(myClass):
  def __init__(self):  
    # Calling constructor of myClass class
    myClass.__init__(self)
    print("Calling protected member of base class: ")
    print(self._a)
 
obj1 = Derived()
         
obj2 = myClass()

# Calling protected member outside class will  result in AttributeError
print(obj2.a)
```

### Python Inheritance

Concept does similar as Java inheritance, but Python supports multiple inheritance which is son can inherit as much father as he can.
It don't like Java where only sub class can inherit one super class.
Example Java:

```java
class Super_class {
   int num = 20;

   // display method of superclass
   public void display() {
      System.out.println("This is the display method of superclass");
   }
}

public class Sub_class extends Super_class {
   int num = 10;

   // display method of sub class
   public void display() {
      System.out.println("This is the display method of subclass");
   }

   public void my_method() {
    // Instantiating subclass
    Sub_class sub = new Sub_class();

    // Invoking the display() method of sub class
    sub.display();

    // Invoking the display() method of superclass
    super.display();

    // printing the value of variable num of subclass
    System.out.println("value of the variable named num in sub class:"+ sub.num);

    // printing the value of variable num of superclass
    System.out.println("value of the variable named num in super class:"+ super.num);
   }

   public static void main(String args[]) {
      Sub_class obj = new Sub_class();
      obj.my_method();
   }
}
```

```python
# A Python program to demonstrate inheritance Base or Super class. Note object in bracket. 
# (Generally, object is made ancestor of all classes)
# In Python 3.x "class Person" is equivalent to "class Person(object)"
class Base(object):     
  # Constructor
  def __init__(self, name):
    self.name = name

  def getName(self):
    return self.name
# Inherited or Sub class (Note Person in bracket)
class Child(Base):    
  # Constructor
  def __init__(self, name, age):
    Base.__init__(self, name)
    self.age = age

  def getAge(self):
    return self.age
# Inherited or Sub class (Note Person in bracket)
class GrandChild(Child):  
  # Constructor
  def __init__(self, name, age, address):
    Child.__init__(self, name, age)
    self.address = address

  def getAddress(self):
    return self.address        
# Driver code
g = GrandChild("Geek1", 23, "Noida")  
print(g.getName(), g.getAge(), g.getAddress())                      # output = Geek1 23 Noida
```

```python
# Python code to demonstrate how parent constructors are called. 
# parent class
class Person( object ):    
  # __init__ is known as the constructor         
  def __init__(self, name, idnumber):   
    self.name = name
    self.idnumber = idnumber

  def display(self):
    print(self.name)
    print(self.idnumber)
  
# child class
class Employee( Person ):           
  def __init__(self, name, idnumber, salary, post):
    self.salary = salary
    self.post = post
    # invoking the __init__ of the parent class 
    Person.__init__(self, name, idnumber)                 
# creation of an object variable or an instance
a = Employee('Rahul', 886012, 200000, "Intern")     
# calling a function of the class Person using its instance
a.display()                                                       # output = Rahul 886012
```

### Python Polymorphism

```python
# Polymorphism with class method
class India():
  def capital(self):
    print("New Delhi is the capital of India.")

  def language(self):
    print("Hindi is the most widely spoken language of India.")

  def type(self):
    print("India is a developing country.")
 
class USA():
  def capital(self):
    print("Washington, D.C. is the capital of USA.")

  def language(self):
    print("English is the primary language of USA.")

  def type(self):
    print("USA is a developed country.")
 
obj_ind = India()
obj_usa = USA()
for country in (obj_ind, obj_usa):
  country.capital()
  country.language()
  country.type()
"""
Output = New Delhi is the capital of India.
         Hindi is the most widely spoken language of India.
         India is a developing country.
         Washington, D.C. is the capital of USA.
         English is the primary language of USA.
         USA is a developed country.
"""
```

```python
# Polymorphism with inheritance
class Bird:
  def intro(self):
    print("There are many types of birds.")
     
  def flight(self):
    print("Most of the birds can fly but some cannot.")
   
class sparrow(Bird):
  def flight(self):
    print("Sparrows can fly.")
     
class ostrich(Bird):
  def flight(self):
    print("Ostriches cannot fly.")
     
obj_bird = Bird()
obj_spr = sparrow()
obj_ost = ostrich()
 
obj_bird.intro()
obj_bird.flight()
 
obj_spr.intro()
obj_spr.flight()
 
obj_ost.intro()
obj_ost.flight()
"""
output = There are many types of birds.
         Most of the birds can fly but some cannot.
         There are many types of birds.
         Sparrows can fly.
         There are many types of birds.
         Ostriches cannot fly.
"""
```

```python
# Code implementation polymorphism with function
class India():
  def capital(self):
    print("New Delhi is the capital of India.")

  def language(self):
    print("Hindi is the most widely spoken language of India.")

  def type(self):
    print("India is a developing country.")
  
class USA():
  def capital(self):
    print("Washington, D.C. is the capital of USA.")

  def language(self):
    print("English is the primary language of USA.")

  def type(self):
    print("USA is a developed country.")
 
def func(obj):
  obj.capital()
  obj.language()
  obj.type()
  
obj_ind = India()
obj_usa = USA()
  
func(obj_ind)
func(obj_usa)
"""
output = New Delhi is the capital of India.
         Hindi is the most widely spoken language of India.
         India is a developing country.
         Washington, D.C. is the capital of USA.
         English is the primary language of USA.
         USA is a developed country.
"""
```

### Python class variable and static variable

```python
# Python program to show that the variables with a value assigned in class declaration, are class variables
# Class for Computer Science Student
class CSStudent:
  stream = 'cse'                  # Class Variable
  def __init__(self,name,roll):
      self.name = name            # Instance Variable
      self.roll = roll            # Instance Variable
 
# Objects of CSStudent class
a = CSStudent('Geek', 1)
b = CSStudent('Nerd', 2)
 
print(a.stream)  # prints "cse"
print(b.stream)  # prints "cse"
print(a.name)    # prints "Geek"
print(b.name)    # prints "Nerd"
print(a.roll)    # prints "1"
print(b.roll)    # prints "2"
 
# Class variables can be accessed using class
# name also
print(CSStudent.stream) # prints "cse"
 
# Now if we change the stream for just a it won't be changed for b
a.stream = 'ece'
print(a.stream) # prints 'ece'
print(b.stream) # prints 'cse'
 
# To change the stream for all instances of the class we can change it
# directly from the class
CSStudent.stream = 'mech'
 
print(a.stream) # prints 'ece'
print(b.stream) # prints 'mech'
"""
output = 
cse
cse
Geek
Nerd
1
2
cse
ece
cse
ece
mech
"""
```

```python
# Python program to demonstrate use of class method and static method.
from datetime import date
  
class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age
      
    # a class method to create a Person object by birth year.
    @classmethod
    def fromBirthYear(cls, name, year):
        return cls(name, date.today().year - year)
      
    # a static method to check if a Person is adult or not.
    @staticmethod
    def isAdult(age):
        return age > 18
  
person1 = Person('mayank', 21)
person2 = Person.fromBirthYear('mayank', 1996)
  
print (person1.age)
print (person2.age)
  
# print the result
print (Person.isAdult(22))
"""
output = 
21
25
True
"""
```

### Python Iterator

Similar as Java Iterator, but code looks more simplier than Java.
Iterator is used to traverse through the element object and get the value we want.
Basic methods for Python iterator:

```python
iter(object)                              # iterate through object
object.next()                             # get the next value
```

Example Java Iterator:

```java
public class DOM4JTest {

public static void main(String[] args) {
  //analyse books.xml 
  //create SAXReader reader object
  SAXReader reader = new SAXReader();
  //
  try {
    //through reader object use read method to load books.xml file and sent to document object 
    Document document = reader.read(new File("src/res/books.xml"));
    //through document object to get parent node(bookstore)
    Element bookStore = document.getRootElement();
    //use iterator to iterate through the element
    Iterator it = bookStore.elementIterator();
    //read through iterator, get parent node source
    while(it.hasNext()) {
      System.out.println("=====Start to analyse book =====");
      Element book = (Element) it.next();
      //get book element name and value
      List<Attribute> bookAttrs = book.attributes();
      for(Attribute attr : bookAttrs) {
        System.out.println("Element name: " + attr.getName() + " --- Element value: " + attr.getValue());
      }
      Iterator itt = book.elementIterator();
      while(itt.hasNext()) {
        Element bookChild = (Element) itt.next();
        System.out.println("Child node name is: "+ bookChild.getName() + " --- Child node value is: " + bookChild.getStringValue());
      }
      System.out.println("=====End of analyse book =====");
    }
  } catch (DocumentException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }
}
```

```python
class MyNumbers:
  def __iter__(self):
    self.a = 1
    return self

  def __next__(self):
    if self.a <= 20:
      x = self.a
      self.a += 1
      return x
    else:
      raise StopIteration                                             # raise StopIteration when no value is return.

myclass = MyNumbers()
myiter = iter(myclass)

for x in myiter:
  print(x)
```

### Python Generator

Similar methods as iterator, but it have more efficient in memory saving and return value when we need.
Keyword for generator: yield i (in iterator called return i)
Generator iterator methods:

```python
send(value), __next__(), throw(type, value, traceback), close()
```

It don't like iterator, iterator will iterate all the element inside the file and output the elements everytime we iterate it.
Generator also will iterate the element inside the file, but it only output the element when we call it.

```python
# Python code using iterator method
class PowTwo:
  def __init__(self, max=0):
    self.n = 0
    self.max = max

  def __iter__(self):
    return self

  def __next__(self):
    if self.n > self.max:
      raise StopIteration

    result = 2 ** self.n
    self.n += 1
    return result

# Python code with generator which is different structure as above code
def PowTwoGen(max=0):
  n = 0
  while n < max:
    yield 2 ** n
    n += 1

def intNum():
    print("Start operation.")                       # start iterate
    for i in range(5):
        yield i                                     # output value
        print("Continue operation.")                # pause function
num = intNum()

print(next(num))

print(num.__next__())

for i in num:
    print(i)                                        
# output = Start operation., 0, Continue operation., 1, Continue operation., 2, Continue operation., 3, Continue operation., 4, Continue operation.

num = intNum()                                      # declare object num to store list value
print(list(num))                                    
# output = Start operation., Continue operation., Continue operation., Continue operation., Continue operation., Continue operation., [0,1,2,3,4]
num = intNum()                                      # declare object num to store tuple value
print(tuple(num))                                   
# output = Start operation., Continue operation., Continue operation., Continue operation., Continue operation., Continue operation., (0,1,2,3,4)
```

### Python Exception Handling

Similar as Java exception handling, try code, if fail throw exception error.
Quite often saw this type of code during program implement process.
Example Java exception handling:

```java
public class hellotest {
public static void main(String args[]) {
  try {
    byte[] bWrite = { 11, 21, 3, 40, 5 };
    OutputStream os = new FileOutputStream("C:\\Temp\\file\\newfile.txt");
      for(int x = 0; x < bWrite.length; x++) {
        os.write(bWrite[x]);
      }
      os.close();
      
      InputStream is = new FileInputStream("C:\\Temp\\file\\newfile.txt");
      int size = is.available();
        for(int i = 0; i < size; i++) {
          System.out.print((char) is.read() + " ");
        }
        is.close();
  }catch (IOException e) {
    System.out.print("Exception");
  }
}
}
```

```python
# Example1: simple try...except....finally method
try:
  f = open("testtext.txt")
  try:
    f.write("Lorum Ipsum")
  except:
    print("Something went wrong when writing to the file")
  finally:
    f.close()
except:
  print("Something went wrong when opening the file")

# Example 2:
try:
    a = int(input("Input a value:"))                      # input a value
    print(20/a)
except:
    print("Error！")                                      # if value not integer, throw exception "Error!"
else:
    print("implement else block code...")                 # if value is integer, run else code block.
finally :
    print("implement finally block code...")              # output whether the code is error or not, use to end the try exception.

# Example 3: with raise sexception (use to raise exception error during debugging)
try:
    a = int(input("Input a value:"))
    print(20/a)
except:
    raise                                                 # will output exception error with detailed information.
else:
    print("implement else block code...")   
finally :
    print("implement finally block code...")

# Example 4: exception of using traceback method (good to have this method, read the log for trace code error)
# import trackback module
import traceback
class SelfException(Exception): pass
def main():
    firstMethod()
def firstMethod():
    secondMethod()
def secondMethod():
    thirdMethod()
def thirdMethod():
    raise SelfException("User defined exception message.")
try:
    main()
except:
    # catch exception, throw message to terminal.
    traceback.print_exc()
    # catch exception, throw message to selected file.
    traceback.print_exc(file=open('log.txt', 'a'))
```

### Python regular expression

```python
# Simple regex function
import re                                                     # import regex module
#Check if the string starts with "The" and ends with "Spain":
txt = "The rain in Spain"
x = re.search("^The.*Spain$", txt)                            # regex works here...

if x:
  print("YES! We have a match!")
else:
  print("No match")
```

### Python File Handling

```python
# Simple file handling method
# open("filename", "r"), "r"=read, "w"=write, "a"=append(will append text in text file without delete previous data), "x", create file is file not exist
f = open("testtext.txt", "w")
x = ["string one", "\nstring two", "\nstring three"]
f.writelines(x)                                           # writelines() use to write list to file, write() only write a simple string to file
f.close()
f = open("testtext.txt", "r")
z = f.read()                                              # read()=read entire file, readline(), readlines()
f.close()
print(z)
```

### Python 常用重载运算符

| 重载运算符 | 含义 |
| :----- | :----- |
| \_\_new\_\_ | 创建类，在 \_\_init\_\_ 之前创建对象|
| \_\_init\_\_ | 类的构造函数，其功能是创建类对象时做初始化工作。 |
| \_\_del\_\_ | 析构函数，其功能是销毁对象时进行回收资源的操作 |
| \_\_add\_\_ | 加法运算符 +，当类对象 X 做例如 X+Y 或者 X+=Y 等操作，内部会调用此方法。但如果类中对 \_\_iadd\_\_ 方法进行了重载，则类对象 X 在做 X+=Y 类似操作时，会优先选择调用 \_\_iadd\_\_ 方法。 |
| \_\_radd\_\_ | 当类对象 X 做类似 Y+X 的运算时，会调用此方法。 |
| \_\_iadd\_\_ | 重载 += 运算符，也就是说，当类对象 X 做类似 X+=Y 的操作时，会调用此方法。 |
| \_\_or\_\_ | “或”运算符 |，如果没有重载 \_\_ior\_\_，则在类似 X|Y、X|=Y 这样的语句中，“或”符号生效 |
| \_\_repr\_\_，\_\_str\_\_ |格式转换方法，分别对应函数 repr(X)、str(X) |
| \_\_call\_\_ |函数调用，类似于 X(*args, **kwargs) 语句 |
| \_\_getattr\_\_ | 点号运算，用来获取类属性 |
| \_\_setattr\_\_ | 属性赋值语句，类似于 X.any=value |
| \_\_delattr\_\_ | 删除属性，类似于 del X.any |
| \_\_getattribute\_\_ | 获取属性，类似于 X.any |
| \_\_getitem\_\_ | 索引运算，类似于 X[key]，X[i:j] |
| \_\_setitem\_\_ | 索引赋值语句，类似于 X[key], X[i:j]=sequence |
| \_\_delitem\_\_  | 索引和分片删除 |
| \_\_get\_\_, \_\_set\_\_, \_\_delete\_\_ | 描述符属性，类似于 X.attr，X.attr=value，del X.attr |
| \_\_len\_\_ | 计算长度，类似于 len(X) |
| \_\_lt\_\_，\_\_gt\_\_，\_\_le\_\_，\_\_ge\_\_，\_\_eq\_\_，\_\_ne\_\_ | 比较，分别对应于 <、>、<=、>=、=、!= 运算符。|
| \_\_iter\_\_，\_\_next\_\_ | 迭代环境下，生成迭代器与取下一条，类似于 I=iter(X) 和 next() |
| \_\_contains\_\_ | 成员关系测试，类似于 item in X |
| \_\_index\_\_ | 整数值，类似于 hex(X)，bin(X)，oct(X) |
| \_\_enter\_\_，\_\_exit\_\_ |在对类对象执行类似 with obj as var 的操作之前，会先调用 \_\_enter\_\_ 方法，其结果会传给 var；在最终结束该操作之前，会调用 \_\_exit\_\_ 方法(常用于做一些清理、扫尾的工作) |

### A reference of all the legal format codes

| Directive | Description | Example |
| :-------: | :---------- | :------ |
| %a | Weekday, short version | Wed |
| %A | Weekday, full version | Wednesday |
| %w | Weekday as a number 0-6, 0 is Sunday | 3 |
| %d | Day of month 01-31 | 31 |
| %b | Month name, short version | Dec |
| %B | Month name, full version | December |
| %m | Month as a number 01-12 | 12 |
| %y | Year, short version, without century | 18 |
| %Y | Year, full version | 2018 |
| %H | Hour 00-23 | 17 |
| %I | Hour 00-12 | 5 |
| %p | AM/PM | PM |
| %M | Minute 00-59 | 41 |
| %S | Second 00-59 | 8 |
| %f | Microsecond 000000-999999 | 548513 |
| %z | UTC offset | 100 |
| %Z | Timezone | CST |
| %j | Day number of year 001-366 | 365 |
| %U | Week number of year, Sunday as the first day of week, 00-53 | 52 |
| %W | Week number of year, Monday as the first day of week, 00-53 | 52 |
| %c | Local version of date and time | Mon Dec 31 17:41:00 2018 |
| %C | Century | 20 |
| %x | Local version of date | 43465 |
| %X | Local version of time | 0.736805556 |
| %% | A % character | % |
| %G | ISO 8601 year | 2018 |
| %u | ISO 8601 weekday (1-7) | 1 |
| %V | ISO 8601 weeknumber (01-53) | 1 |

### The __re__ module offers a set of functions that allows us to search a string for a match

| Function | Description |
| :------- | :---------- |
| findall | Returns a list containing all matches |
| search | Returns a Match object if there is a match anywhere in the string |
| split | Returns a list where the string has been split at each match |
| sub | Replaces one or many matches with a string |

### Metacharacters are characters with a special meaning

| Character | Description | Example |
| :-------: | :---------- | :------ |
| [] | A set of characters | "[a-m]" |
| \ | Signals a special sequence (can also be used to escape special characters) | "\d" |
| . | Any character (except newline character) | "he..o" |
| ^ | Starts with | "^hello" |
| $ | Ends with | "planet$" |
| * | Zero or more occurrences | "he.*o" |
| + | One or more occurrences | "he.+o" |
| ? | Zero or one occurrences | "he.?o" |
| {} | Exactly the specified number of occurrences | "he{2}o" |
| \| | Either or | "falls|stays" |
| () | Capture and group |

### A special sequence is a \ followed by one of the characters in the list below, and has a special meaning

| Character | Description | Example |
| :-------: | :---------- | :------ |
| \A | Returns a match if the specified characters are at the beginning of the string | "\AThe" |
| \b | Returns a match where the specified characters are at the beginning or at the end of a word | r"\bain" |
|    | (the "r" in the beginning is making sure that the string is being treated as a "raw string") | r"ain\b" |
| \B | Returns a match where the specified characters are present, but NOT at the beginning (or at the end) of a word | r"\Bain" |
|    | (the "r" in the beginning is making sure that the string is being treated as a "raw string") | r"ain\B" |
| \d | Returns a match where the string contains digits (numbers from 0-9) | "\d" |
| \D | Returns a match where the string DOES NOT contain digits | "\D" |
| \s | Returns a match where the string contains a white space character | "\s" |
| \S | Returns a match where the string DOES NOT contain a white space character | "\S" |
| \w | Returns a match where the string contains any word characters (characters from a to Z, digits from 0-9, and the underscore _ character | "\w" |
| \W | Returns a match where the string DOES NOT contain any word characters | "\W" |
| \Z | Returns a match if the specified characters are at the end of the string | "Spain\Z" |

### A set is a set of characters inside a pair of square brackets [] with a special meaning

| Set | Description |
| :-- | :---------- |
| [arn] | Returns a match where one of the specified characters (a, r, or n) are present |
| [a-n] | Returns a match for any lower case character, alphabetically between a and n |
| [^arn] | Returns a match for any character EXCEPT a, r, and n |
| [0123] | Returns a match where any of the specified digits (0, 1, 2, or 3) are present |
| [0-9] | Returns a match for any digit between 0 and 9 |
| [0-5][0-9] | Returns a match for any two-digit numbers from 00 and 59 |
| [a-zA-Z] | Returns a match for any character alphabetically between a and z, lower case OR upper case |
| [+] | In sets, +, *, ., \|, (), $,{} has no special meaning, so [+] means: return a match for any + character in the string |
