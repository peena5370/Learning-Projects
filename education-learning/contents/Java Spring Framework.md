# Java Project

## Spring Framework

### Setup Spring Environments

* Setup APACHE_HOME = C:\Apache
* Apache Commons Logging
  * Setup CLASSPATH = %CLASSPATH%; %APACHE_HOME%\commons-logging-1.2\commons-logging-1.2.jar;
* Install Eclipse IDE and download Spring Frameworks on Spring web site: <https://repo.spring.io/ui/native/release/org/springframework/spring>
* Install Spring-tool-suite in Eclipse (which use Spring framework without Eclipse IDE)
  * Help > Eclipse Marketplace > Search Spring Tool Suite 4 and click install.

## Steps of Creating Java Spring Project

* Configure Build Path > Adding Spring Framework jar files
* Create Beans.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- bean definitions here -->
    <!-- bean id="obj-name" class="package-class-path" -->
    <bean id="helloWorld" class="com.springlearning.lesson.HelloWorld">
       <!-- property name="parameter name" value="parameter value"-->
       <property name="message" value="Hello World!"/>
   </bean>

</beans>
```

### Spring IoC

#### Bean Definition

| No. | Properties & Description |
| :-: | :----------------------- |
| 1 | __class__</br>This attribute is mandatory and specifies the bean class to be used to create the bean.
| 2 | __name__</br>This attribute specifies the bean identifier uniquely. In XMLbased configuration metadata, use the id and/or name attributes to specify the bean identifier(s).
| 3 | __scope__</br>This attribute specifies the scope of the objects created from a particular bean definition. |
| 4 | __constructor-arg__</br>This is used to inject the dependencies. |
| 5 | __properties__</br>This is used to inject the dependencies. |
| 6 | __autowiring mode__</br>This is used to inject the dependencies. |
| 7 | __lazy-initialization mode__</br>A lazy-initialized bean tells the IoC container to create a bean instance when it is first requested, rather than at the startup. |
| 8 | __initialization method__</br>A callback to be called just after all necessary properties on the bean have been set by the container. |
| 9 | __destruction method__</br>A callback to be used when the container containing the bean is destroyed.  |

* Sample Beans.xml

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- bean definitions here -->
    <!-- A simple bean definition -->
   <bean id = "..." class = "...">
      <!-- collaborators and configuration for this bean go here -->
   </bean>

   <!-- A bean definition with lazy init set on -->
   <bean id = "..." class = "..." lazy-init = "true">
      <!-- collaborators and configuration for this bean go here -->
   </bean>

   <!-- A bean definition with initialization method -->
   <bean id = "..." class = "..." init-method = "...">
      <!-- collaborators and configuration for this bean go here -->
   </bean>

   <!-- A bean definition with destruction method -->
   <bean id = "..." class = "..." destroy-method = "...">
      <!-- collaborators and configuration for this bean go here -->
   </bean>

   <!-- more bean definitions go here -->

</beans>
```

* The Spring Framework supports the following five scopes, three of which are available only if we use a web-aware ApplicationContext.

| No. | Scope & Description |
| :-: | :------------------ |
| 1 | __singleton__</br>This scopes the bean definition to a single instance per Spring IoC container (default). |
| 2 | __prototype__</br>This scopes a single bean definition to have any number of object instances. |
| 3 | __request__</br>This scopes a bean definition to an HTTP request. Only valid in the context of a web-aware Spring ApplicationContext. |
| 4 | __session__</br>This scopes a bean definition to an HTTP session. Only valid in the context of a web-aware Spring ApplicationContext. |
| 5 | __global-session__</br>This scopes a bean definition to a global HTTP session. Only valid in the context of a web-aware Spring ApplicationContext. |

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- bean definitions here -->
    <bean id="helloWorld" class="com.springlearning.lesson.HelloWorld" scope="singleton">
   </bean>

   <bean id="helloWorld" class="com.springlearning.lesson.HelloWorld" scope="prototype">
   </bean>
</beans>
```

### Bean Life Cycle

* Initialization method (init-method="init")
  * Declare init() method at sub class
* Destroy method (destroy-method="destroy")
  * Declare destroy() method at sub class
* Run with AbstractApplicationContext() method to get Beans.xml
* Use RegisterShutdownHook() to shutdown the relevant context method

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- bean definitions here -->
    <bean id="bean-lc" class="com.springlearning.lesson.HelloWorld" init-method="init" destroy-method="destroy">
      <property name="message" value="Hello World">
    </bean>
</beans>
```

### Bean PostProcessor

* Create one class which implements BeanPostProcessor()
* Declare postProcessBeforeInitialization() method
* Declare postProcessBeforeInitialization() method
* Update Beans.xml

```xml
<bean class="com.springlearning.lesson.BeanInitProcessor"></bean>
```

### Bean Definition Inheritance

* Inherit happens on Beans.xml
* Can inherit value from parent bean

### Bean Dependency Injection

* There are 2 types of dependency injection:
  1. __Constructor-based dependency injection__</br>Constructor-based DI is accomplished when the container invokes a class constructor with a number of arguments, each representing a dependency on the other class.
  2. __Setter-based dependency injection__</br>Setter-based DI is accomplished by the container calling setter methods on your beans after invoking a no-argument constructor or no-argument static factory method to instantiate your bean.

* Sample Beans.xml

```xml
<!-- Constructur based dependency injection -->
   <!-- Definition for textEditor bean -->
   <bean id = "textEditor" class = "com.springlearning.di.TextEditor">
      <constructor-arg ref = "spellChecker"/>
   </bean>
   <!--  Definition for spellChecker bean -->
   <bean id = "spellChecker" class = "com.springlearning.di.SpellChecker"></bean>
   
   <!-- Setter based dependency injection -->
   <bean id = "textEditor" class = "com.springlearning.di.TextEditor">
      <property name = "spellChecker" ref = "spellChecker"/>
   </bean>

   <!-- Definition for spellChecker bean -->
   <bean id = "spellChecker" class = "com.springlearning.di.SpellChecker"></bean>
```

#### Injection Inner Bean

```xml
  <!-- Definition for textEditor bean using inner bean -->
  <bean id = "textEditor" class = "com.springlearning.di.TextEditor">
    <property name = "spellChecker">
        <bean id = "spellChecker" class = "com.springlearning.di.SpellChecker"/>
    </property>
  </bean>
```

#### Injecting Collection

* Spring offers four types of collection configuration elements which are as follows:

| No. | Element & Description |
| :-: | :-------------------- |
| 1 | __\<list\>__</br>This helps in wiring ie injecting a list of values, allowing duplicates. |
| 2 | __\<set\>__</br>This helps in wiring a set of values but without any duplicates. |
| 3 | __\<map\>__</br>This can be used to inject a collection of name-value pairs where name and value can be of any type. |
| 4 | __\<props\>__</br>This can be used to inject a collection of name-value pairs where the name and value are both Strings. |

* Example Beans.xml

```xml
  <!-- Definition for DICollection -->
  <bean id = "diCollection" class = "com.springlearning.di.DICollection">
    
    <!-- results in a setAddressList(java.util.List) call -->
    <property name = "addressList">
      <list>
        <value>Malaysia</value>
        <value>Singapore</value>
        <value>Korea</value>
        <value>Japan</value>
      </list>
    </property>

    <!-- results in a setAddressSet(java.util.Set) call -->
    <property name = "addressSet">
      <set>
        <value>Malaysia</value>
        <value>Singapore</value>
        <value>Korea</value>
        <value>Japan</value>
      </set>
    </property>

    <!-- results in a setAddressMap(java.util.Map) call -->
    <property name = "addressMap">
      <map>
        <entry key = "1" value = "Malaysia"/>
        <entry key = "2" value = "Singapore"/>
        <entry key = "3" value = "Korea"/>
        <entry key = "4" value = "Japan"/>
      </map>
    </property>
    
    <!-- results in a setAddressProp(java.util.Properties) call -->
    <property name = "addressProp">
      <props>
        <prop key = "one">Malaysia</prop>
        <prop key = "one">Malaysia</prop>
        <prop key = "two">Singapore</prop>
        <prop key = "three">Korea</prop>
        <prop key = "four">Japan</prop>
      </props>
    </property>
  </bean>
```

### Spring Autowire

* The Spring container can autowire relationships between collaborating beans without using \<constructor-arg> and \<property> elements, which helps cut down on the amount of XML configuration and write for a big Spring-based application.
* The autowire attribute of the \<bean/> element to specify autowire mode for a bean definition as shown below:

| No. | Mode & Description |
| :-: | :----------------- |
| 1 | __no__</br>This is default setting which means no autowiring and you should use explicit bean reference for wiring. You have nothing to do special for this wiring. This is what you already have seen in Dependency Injection chapter. |
| 2 | __byName__</br>Autowiring by property name. Spring container looks at the properties of the beans on which autowire attribute is set to byName in the XML configuration file. It then tries to match and wire its properties with the beans defined by the same names in the configuration file. |
| 3 | __byType__</br>Autowiring by property datatype. Spring container looks at the properties of the beans on which autowire attribute is set to byType in the XML configuration file. It then tries to match and wire a property if its type matches with exactly one of the beans name in configuration file. If more than one such beans exists, a fatal exception is thrown. |
| 4 | __constructor__</br>Similar to byType, but type applies to constructor arguments. If there is not exactly one bean of the constructor argument type in the container, a fatal error is raised. |
| 5 | __autodetect__</br>Spring first tries to wire using autowire by constructor, if it does not work, Spring tries to autowire by byType. |

```xml
  <!-- Autowired byName -->
  <bean id = "textEditor" class = "com.springlearning.di.TextEditor" autowire = "byName">
    <property name = "name" value = "Generic Text Editor" />
  </bean>
  <!-- Autowired byType -->
  <bean id = "textEditor" class = "com.springlearning.di.TextEditor" autowire = "byType">
    <property name = "name" value = "Generic Text Editor" />
  </bean>
  <!-- Autowired using constructor -->
  <bean id = "textEditor" class = "com.springlearning.di.TextEditor" autowire = "constructor">
    <constructor-arg value = "Generic Text Editor"/>
  </bean>

  <!-- Definition for spellChecker bean -->
  <bean id = "spellChecker" class = "com.springlearning.di.SpellChecker"></bean>
```

### Spring Annotation Based Configuration

* Configure __\<context:annotation-config/>__ at Beans.xml

| No. | Annotation & Description |
| :-: | :----------------------- |
| 1 | __@Required__</br>The @Required annotation applies to bean property setter methods. __**Deprecated on Spring version 5.1 and later.__ |
| 2 | __@Autowired__</br>The @Autowired annotation can apply to bean property setter methods, non-setter methods, constructor and properties. |
| 3 | __@Qualifier__</br>The @Qualifier annotation along with @Autowired can be used to remove the confusion by specifiying which exact bean will be wired. |
| 4 | __JSR-250 Annotations__</br>Spring supports JSR-250 based annotations which include @Resource, @PostConstruct(init-method) and @PreDestroy(destroy-method) annotations. |

* Configure Beans.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

    <bean id = "student" class = "com.springlearning.annotation.Student">
      <property name = "name" value = "Zara" />
      <property name = "age"  value = "11"/>
   </bean>
</beans>
```

#### Configure Student.java with @Required

```java
import org.springframework.beans.factory.annotation.Required;

public class Student {
  private Integer age;
  private String name;

  // Will require value from Beans.xml.
  // If don't have value parse from Beans.xml, program will throw error.
  @Required
  public void setAge(Integer age) {
     this.age = age;
  }
  
  public Integer getAge() {
     return age;
  }
     
  @Required
  public void setName(String name) {
     this.name = name;
  }
  
  public String getName() {
     return name;
  }
}
```

#### Configure TextEditor.java with @Autowired

```java
import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
  private SpellChecker spellChecker;
  
  // constructor based dependency injection
  @Autowired
  public TextEditor(SpellChecker spellChecker) {
     System.out.println("Inside TextEditor constructor." );
     this.spellChecker = spellChecker;
  }
  
  // a getter method to return spellChecker
  public SpellChecker getSpellChecker() {
     return spellChecker;
  }

}
```

* Beans.xml

```xml
<!-- @Autowired without constructor-arg -->
  <!-- Definition for textEditor bean without constructor-arg  -->
  <bean id = "textEditor" class = "com.springlearning.di.TextEditor">
  </bean>

  <!-- Definition for spellChecker bean -->
  <bean id = "spellChecker" class = "com.springlearning.di.SpellChecker">
  </bean>
```

### @Qualifier annotation method

* Beans.xml

```xml
<!-- @Qualifier Beans.xml definition -->
  <!-- Definition for profile bean -->
  <bean id = "profile" class = "com.springlearning.annotation.Profile"></bean>

  <!-- Definition for student1 bean -->
  <bean id = "student1" class = "com.springlearning.annotation.Student">
    <property name = "name" value = "John" />
    <property name = "age" value = "18"/>
  </bean>

  <!-- Definition for student2 bean -->
  <bean id = "student2" class = "com.springlearning.annotation.Student">
    <property name = "name" value = "Terry" />
    <property name = "age" value = "20"/>
  </bean>
```

* Profile.java with @Qualifier(beanID) and @Autowired

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Profile {
  @Autowired
  @Qualifier("student2")  // for output student2 property
  private Student student;

  public Profile(){
     System.out.println("Inside Profile constructor." );
  }
  
  public void printAge() {
     System.out.println("Age : " + student.getAge() );
  }
  
  public void printName() {
     System.out.println("Name : " + student.getName() );
  }
}
```

### Java Based Spring Configuration

* Happens on java class config
* Similar functions as Beans.xml
* Using:
  1. @Configuration for class method
  2. @Bean for bean method
  3. @Import for loading another class configuration
  4. @Bean(initMthod="init" destroyMethod="cleanup") for initialization dan destruction callback
  5. @Bean @Scope("prototype") for bean scope

* Example Java Based Configuration(config.java)

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TextEditorConfig {
  @Bean 
  public TextEditor textEditor(){
     return new TextEditor( spellChecker() );
  }

  @Bean 
  public SpellChecker spellChecker(){
     return new SpellChecker( );
  }
  
  @Bean(initMethod = "init", destroyMethod = "cleanup" )
  public Foo foo() {
     return new foo();
  }
  
  @Bean
  @Scope("prototype")
  public Foo foo() {
     return new Foo();
  }
}
```

* Main.java

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    // ApplicationContext context = new ClassPathXmlApplicationContext(Beans.xml);
    ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
    
    // HelloProfile hp = (HelloProfile) context.getBean(helloProfile);
    HelloProfile helloWorld = ctx.getBean(HelloProfile.class);
    helloWorld.setMessage("Hello World!");
    helloWorld.getMessage();
    
    ApplicationContext ctx2 = new AnnotationConfigApplicationContext(TextEditorConfig.class);

    TextEditor te = ctx2.getBean(TextEditor.class);
    te.spellCheck();

  }

}
```

### Spring Event Handling

* Spring provides the following standard events:

| No. | Spring Built-in Events & Description |
| :-: | :----------------------------------- |
| 1 | __ContextRefreshedEvent__</br>This event is published when the ApplicationContext is either initialized or refreshed. This can also be raised using the refresh() method on the ConfigurableApplicationContext interface. |
| 2 | __ContextStartedEvent__</br>This event is published when the ApplicationContext is started using the start() method on the ConfigurableApplicationContext interface. You can poll your database or you can restart any stopped application after receiving this event. |
| 3 | __ContextStoppedEvent__</br>This event is published when the ApplicationContext is stopped using the stop() method on the ConfigurableApplicationContext interface. You can do required housekeep work after receiving this event. |
| 4 | __ContextClosedEvent__</br>This event is published when the ApplicationContext is closed using the close() method on the ConfigurableApplicationContext interface. A closed context reaches its end of life; it cannot be refreshed or restarted. |
| 5 | __RequestHandledEvent__</br>This is a web-specific event telling all beans that an HTTP request has been serviced. |

#### Example Java and Beans.xml code

* Beans.xml

```xml
  <!-- Spring Event Handler -->
  <bean id = "helloWorldEvent" class = "com.springlearning.event.HelloWorldEvent">
    <property name = "message" value = "Hello World!"/>
  </bean>

  <bean id = "StartEventHandler" class = "com.springlearning.event.StartEventHandler"/>
  <bean id = "StopEventHandler" class = "com.springlearning.event.StopEventHandler"/>
```

* HelloWorldEvent.java

```java
public class HelloWorldEvent {
  private String message;

  public void setMessage(String message){
     this.message  = message;
  }
  
  public void getMessage(){
     System.out.println("Your Message : " + message);
  }
}
```

* StartEventHandler.java

```java
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class StartEventHandler implements ApplicationListener<ContextStartedEvent> {
  
  public void onApplicationEvent(ContextStartedEvent event) {
     System.out.println("ContextStartedEvent Received");
  }
}
```

* StopEventHandler.java

```java
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

public class StopEventHandler implements ApplicationListener<ContextStoppedEvent>{
  
  public void onApplicationEvent(ContextStoppedEvent event) {
     System.out.println("ContextStoppedEvent Received");
  }
}
```

* Main.java

```java
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

    // Raise a start event.
    context.start();
        
    HelloWorldEvent obj = (HelloWorldEvent) context.getBean("helloWorldEvent");
    obj.getMessage();

    // Raise a stop event.
    context.stop();
  }
}
```

#### Custom Event Handling

* Beans.xml

```xml
<!-- Custom Event Handler -->
  <bean id = "customEventHandler" class = "com.springlearning.event.CustomEventHandler"/>
  <bean id = "customEventPublisher" class = "com.springlearning.event.CustomEventPublisher"/>
```

* CustomEvent.java

```java
import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {
  public CustomEvent(Object source) {
     super(source);
  }
  
  public String toString(){
     return "My Custom Event";
  }
}
```

* CustomEventPublisher.java

```java
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class CustomEventPublisher implements ApplicationEventPublisherAware {
  private ApplicationEventPublisher publisher;
     
  public void setApplicationEventPublisher (ApplicationEventPublisher publisher) {
     this.publisher = publisher;
  }
  
  public void publish() {
     CustomEvent ce = new CustomEvent(this);
     publisher.publishEvent(ce);
  }
}
```

* CustomEventHandler.java

```java
public class CustomEventHandler implements ApplicationListener<CustomEvent>{
  public void onApplicationEvent(CustomEvent event) {
     System.out.println(event.toString());
  }
}
```

* Main.java

```java
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

    CustomEventPublisher cvp = (CustomEventPublisher) context.getBean("customEventPublisher");
    cvp.publish();  
    cvp.publish();
  }

}
```

### Spring AOP (Aspect Oriented Programming)

* AOP Terminology

| No. | Terms & Description |
| :-: | :------------------ |
| 1 | __Aspect__</br>This is a module which has a set of APIs providing cross-cutting requirements. For example, a logging module would be called AOP aspect for logging. An application can have any number of aspects depending on the requirement. |
| 2 | __Join point__</br>This represents a point in your application where you can plug-in the AOP aspect. You can also say, it is the actual place in the application where an action will be taken using Spring AOP framework. |
| 3 | __Advice__</br>This is the actual action to be taken either before or after the method execution. This is an actual piece of code that is invoked during the program execution by Spring AOP framework. |
| 4 | __Pointcut__</br>This is a set of one or more join points where an advice should be executed. You can specify pointcuts using expressions or patterns as we will see in our AOP examples. |
| 5 | __Introduction__</br>An introduction allows you to add new methods or attributes to the existing classes. |
| 6 | __Target object__</br>The object being advised by one or more aspects. This object will always be a proxied object, also referred to as the advised object. |
| 7 | __Weaving__</br>Weaving is the process of linking aspects with other application types or objects to create an advised object. This can be done at compile time, load time, or at runtime. |

* Type Of Advice

| No. | Advice & Description |
| :-: | :------------------- |
| 1 | __before__</br>Run advice before the a method execution. |
| 2 | __after__</br>Run advice after the method execution, regardless of its outcome. |
| 3 | __after-returning__</br>Run advice after the a method execution only if method completes successfully. |
| 4 | __after-throwing__</br>Run advice after the a method execution only if method exits by throwing an exception. |
| 5 | __around__</br>Run advice before and after the advised method is invoked. |

* Custom Aspects Implementation

| No. | Approach & Description |
| :-: | :--------------------- |
| 1 | __XML Schema based__</br>Aspects are implemented using the regular classes along with XML based configuration.</br> <https://docs.spring.io/spring-framework/docs/4.2.x/spring-framework-reference/html/xsd-configuration.html> |
| 2 | __@AspectJ based__</br>@AspectJ refers to a style of declaring aspects as regular Java classes annotated with Java 5 annotations.</br><https://docs.spring.io/spring-framework/docs/4.0.x/spring-framework-reference/html/aop.html> |

#### XML Schema Based Configuration

* Download AspectJ jar files from Eclipse website. Files needed for Spring 5.0 or later:
  1. aspectj-1.9.7.jar
  2. aspectjweaver-1.9.7.jar
* Beans.xml

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop 
        http://www.springframework.org/schema/aop/spring-aop.xsd">

    <!-- bean definition & AOP specific configuration -->
    <aop:config>
      <aop:aspect id = "log" ref = "logging">
        <!-- AOP pointcut with specific package and all methods -->
        <aop:pointcut id = "selectAll" 
          expression = "execution(* com.springlearning.springaop.*.*(..))"/>
        <!-- AOP pointcut with specific package and specific method -->  
        <aop:pointcut id = "selectAll" 
          expression = "execution(* com.springlearning.springaop.AOPStudent.getName(..))"/>
        
        <aop:before pointcut-ref = "selectAll" method = "beforeAdvice"/>
        <aop:after pointcut-ref = "selectAll" method = "afterAdvice"/>
        <aop:after-returning pointcut-ref = "selectAll" 
          returning = "retVal" method = "afterReturningAdvice"/>
        <aop:after-throwing pointcut-ref = "selectAll" 
          throwing = "ex" method = "AfterThrowingAdvice"/>

      </aop:aspect>
    </aop:config>

    <!-- Definition for student bean -->
    <bean id = "aopstudent" class = "com.springlearning.springaop.AOPStudent">
        <property name = "name" value = "John" />
        <property name = "age" value = "28"/>      
    </bean>

    <!-- Definition for logging aspect -->
    <bean id = "logging" class = "com.springlearning.springaop.Logging"/> 

</beans>
```

* Logging.java(AOP aspect file)

```java
public class Logging {
  // This is the method which would execute before a selected method execution.
  public void beforeAdvice(){
    System.out.println("Going to setup student profile.");
  }
  
  // This is the method which would execute after a selected method execution.
  public void afterAdvice(){
    System.out.println("Student profile has been setup.");
  }

  // This is the method which would execute when any method returns.
  public void afterReturningAdvice(Object retVal) {
    System.out.println("Returning:" + retVal.toString() );
  }

  // This is the method which would execute if there is an exception raised.
  public void AfterThrowingAdvice(IllegalArgumentException ex){
    System.out.println("There has been an exception: " + ex.toString());   
  }
}
```

* AOPStudent.java

```java
public class AOPStudent {
  private Integer age;
  private String name;

  public void setAge(Integer age) {
      this.age = age;
  }
  
  public Integer getAge() {
    System.out.println("Age : " + age );
      return age;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
      System.out.println("Name : " + name );
      return name;
  }
  
  public void printThrowException(){
    System.out.println("Exception raised");
      throw new IllegalArgumentException();
  }
}
```

* Main.java

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        
      AOPStudent student = (AOPStudent) context.getBean("aopstudent");
      student.getName();
      student.getAge();
      student.printThrowException();
  }
}
```

#### @AspectJ Based Configuration

* Beans.xml

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop 
        http://www.springframework.org/schema/aop/spring-aop.xsd">

    <!-- Adding aspectj-autoproxy inside beans.xml -->
    <aop:aspectj-autoproxy/>

    <!-- Definition for student bean -->
    <bean id = "aopstudent" class = "com.springlearning.springaop.AOPStudent">
        <property name = "name" value = "John" />
        <property name = "age" value = "28"/>      
    </bean>

    <!-- Definition for logging aspect -->
    <bean id = "aspectlogging" class = "com.springlearning.springaop.AspectLogging"/> 

</beans>
```

* AspectLogging.java(AOP aspect file)

```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;

@Aspect
public class AspectLogging {
  // Following is the definition for a pointcut to select all the methods available. 
  // So advice will be called for all the methods.
  @Pointcut("execution(* com.springlearning.springaop.*.*(..))")
  private void selectAll(){}
  
  // This is the method which would execute before a selected method execution.
  @Before("selectAll()")
  public void beforeAdvice(){
    System.out.println("Going to setup student profile.");
  }
  
  // This is the method which would execute after a selected method execution.
  @After("selectAll()")
  public void afterAdvice(){
    System.out.println("Student profile has been setup.");
  }
  
  // This is the method which would execute when any method returns.
  @AfterReturning(pointcut = "selectAll()", returning = "retVal")
  public void afterReturningAdvice(Object retVal){
    System.out.println("Returning:" + retVal.toString() );
  }
  
  // This is the method which would execute if there is an exception raised by any method.
  @AfterThrowing(pointcut = "selectAll()", throwing = "ex")
  public void AfterThrowingAdvice(IllegalArgumentException ex){
    System.out.println("There has been an exception: " + ex.toString());   
  }
}
```

* AOPStudent.java

```java
public class AOPStudent {
  private Integer age;
  private String name;

  public void setAge(Integer age) {
      this.age = age;
  }
  
  public Integer getAge() {
    System.out.println("Age : " + age );
      return age;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
      System.out.println("Name : " + name );
      return name;
  }
  
  public void printThrowException(){
    System.out.println("Exception raised");
      throw new IllegalArgumentException();
  }
}
```

* Main.java

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        
      AOPStudent student = (AOPStudent) context.getBean("aopstudent");
      student.getName();
      student.getAge();
      student.printThrowException();
  }
}
```

### Spring JDBC (Spring Database Access)

* Require to include __MySQL ConnectorJ(mysql-connector-java-8.0.27.jar)__ into spring project library to access MySQL database.
* Initialize database data source at Beans.xml:
  1. Include JDBC driver(com.mysql.cj.jdbc.Driver")
  2. sql host name(jdbc:mysql:://localhost:..../db_name)
  3. User name(root)
  4. Password(******)
* Create Data Access Object(DAO)
* Create Constructor class
* Create Mapper class
* Create JDBC template implements from DAO class
* Input data from Main class

* Create MySQL table

```sql
CREATE TABLE (
  studentID     INT         NOT NULL AUTO_INCREMENT,
  student_name  VARCHAR(50) NOT NULL,
  student_age   INT         NOT NULL,
  PRIMARY KEY (studentID)
);
```

* Beans.xml

```xml
<!-- Initialization for data source -->
   <bean id="dataSource" 
      class = "org.springframework.jdbc.datasource.DriverManagerDataSource">
      <!-- com.mysql.cj.jdbc.Driver is used for MySQL 8.0 or later -->
      <property name = "driverClassName" value = "com.mysql.cj.jdbc.Driver"/>
      <property name = "url" value = "jdbc:mysql://localhost:3306/java_db"/>
      <property name = "username" value = "root"/>
      <property name = "password" value = "password"/>
   </bean>

   <!-- Definition for studentJDBCTemplate bean -->
   <bean id = "studentJDBCTemplate" 
      class = "com.springlearning.springdb.StudentJDBCTemplate">
      <property name = "dataSource" ref = "dataSource" />    
   </bean>
```

* StudentDAO.java

```java
import java.util.List;
import javax.sql.DataSource;

public interface StudentDAO {
    
  // This is the method to be used to initialize database resources ie. connection.
  public void setDataSource(DataSource ds);
  
  // This is the method to be used to create a record in the Student table.
  public void create(String name, Integer age);
  
  // This is the method to be used to list down a record from the Student table
  // corresponding to a passed student id.
  public Student getStudent(Integer id);
  
  // This is the method to be used to list down all the records from the Student table.
  public List<Student> listStudents();
  
  // This is the method to be used to delete a record from the Student table 
  // corresponding to a passed student id.
  public void delete(Integer id);
  
  // This is the method to be used to update a record into the Student table.
  public void update(Integer id, Integer age);
}
```

* Student.java

```java
public class Student {
  private Integer age;
  private String name;
  private Integer id;

  public void setAge(Integer age) {
      this.age = age;
  }
  
  public Integer getAge() {
      return age;
  }
  
  public void setName(String name) {
      this.name = name;
  }
  
  public String getName() {
      return name;
  }
  
  public void setId(Integer id) {
      this.id = id;
  }
  
  public Integer getId() {
      return id;
  }
}
```

* StudentMapper.java

```java
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {
  public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
    Student student = new Student();
    student.setId(rs.getInt("studentID"));
    student.setName(rs.getString("student_name"));
    student.setAge(rs.getInt("student_age"));
        
    return student;
  }
}
```

* StudentJDBCTemplate.java

```java
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO {
  private DataSource dataSource;
  private JdbcTemplate jdbcTemplateObject;
     
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
  }
  
  public void create(String name, Integer age) {
    String SQL = "INSERT INTO student_db (student_name, student_age) VALUES (?, ?)";
    jdbcTemplateObject.update( SQL, name, age);
    System.out.println("Created Record Name = " + name + "\nAge = " + age);
    return;
  }
  
  public Student getStudent(Integer id) {
    String SQL = "SELECT * FROM student_db WHERE studentID = ?";
    Student student = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new StudentMapper());
            
    return student;
  }
  
  public List<Student> listStudents() {
    String SQL = "SELECT * FROM student_db";
    List <Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
    return students;
  }
  
  public void delete(Integer id) {
    String SQL = "DELETE FROM student_db WHERE studentID = ?";
    jdbcTemplateObject.update(SQL, id);
    System.out.println("Deleted Record with ID = " + id );
    return;
  }
  
  public void update(Integer id, Integer age){
    String SQL = "UPDATE student_db SET student_age = ? WHERE studentID = ?";
    jdbcTemplateObject.update(SQL, age, id);
    System.out.println("Updated Record with ID = " + id );
    return;
  }
}
```

* Main.java

```java
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

    StudentJDBCTemplate studentJDBCTemplate =  (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
        
    System.out.println("------Records Creation--------" );
    studentJDBCTemplate.create("John", 28);
    studentJDBCTemplate.create("Perry", 26);
    studentJDBCTemplate.create("Ahmad", 25);
  
    System.out.println("------Listing Multiple Records--------" );
    List<Student> students = studentJDBCTemplate.listStudents();
        
    for (Student record : students) {
      System.out.print("ID : " + record.getId() );
      System.out.print(", Name : " + record.getName() );
      System.out.println(", Age : " + record.getAge());
    }

    System.out.println("----Updating Record with ID = 2 -----" );
    studentJDBCTemplate.update(2, 20);

    System.out.println("----Listing Record with ID = 2 -----" );
    Student student = studentJDBCTemplate.getStudent(2);
    System.out.print("ID : " + student.getId() );
    System.out.print(", Name : " + student.getName() );
    System.out.println(", Age : " + student.getAge());
  }
}
```

#### Injecting SQL Procedure in Spring

* Create Procedure at MySQL

```sql
DELIMITER $$

DROP PROCEDURE IF EXISTS `java_db`.`getRecord` $$
CREATE PROCEDURE `java_db`.`getRecord` (
IN in_id      INTEGER,
OUT out_name  VARCHAR(50),
OUT out_age   INTEGER)
BEGIN
   SELECT student_name, student_age
   INTO out_name, out_age
   FROM student_db where studentID = in_id;
END $$

DELIMITER ;
```

* Beans.xml

```xml
  <!-- Spring JDBC Beans.xml -->
  <!-- Initialization for data source -->
  <bean id="dataSource" 
    class = "org.springframework.jdbc.datasource.DriverManagerDataSource">
    <property name = "driverClassName" value = "com.mysql.cj.jdbc.Driver"/>
    <property name = "url" value = "jdbc:mysql://localhost:3306/java_db"/>
    <property name = "username" value = "root"/>
    <property name = "password" value = "password"/>
  </bean>

  <bean id = "studentJDBCProcedureTemplate" 
    class = "com.springlearning.springdb.StudentJDBCProcedureTemplate">
    <property name = "dataSource" ref = "dataSource" />    
  </bean>
```

* StudentDAO.java

```java
import java.util.List;
import javax.sql.DataSource;

public interface StudentDAO {
    
  // This is the method to be used to initialize database resources ie. connection.
  public void setDataSource(DataSource ds);
  
  // This is the method to be used to create a record in the Student table.
  public void create(String name, Integer age);
  
  // This is the method to be used to list down a record from the Student table
  // corresponding to a passed student id.
  public Student getStudent(Integer id);
  
  // This is the method to be used to list down all the records from the Student table.
  public List<Student> listStudents();
}
```

* Student.java

```java
public class Student {
  private Integer age;
  private String name;
  private Integer id;

  public void setAge(Integer age) {
      this.age = age;
  }
  
  public Integer getAge() {
      return age;
  }
  
  public void setName(String name) {
      this.name = name;
  }
  
  public String getName() {
      return name;
  }
  
  public void setId(Integer id) {
      this.id = id;
  }
  
  public Integer getId() {
      return id;
  }
}
```

* StudentMapper.java

```java
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {
  public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
    Student student = new Student();
    student.setId(rs.getInt("studentID"));
    student.setName(rs.getString("student_name"));
    student.setAge(rs.getInt("student_age"));
        
    return student;
  }
}
```

* StudentJDBCProcedureTemplate.java

```java
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class StudentJDBCProcedureTemplate implements StudentDAO {
  private DataSource dataSource;
  private SimpleJdbcCall jdbcCall;

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
    this.jdbcCall =  new SimpleJdbcCall(dataSource).withProcedureName("getRecord");
  }
  
  public void create(String name, Integer age) {
    JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
    String SQL = "INSERT INTO student_db (student_name, student_age) VALUES (?, ?)";

    jdbcTemplateObject.update( SQL, name, age);
    System.out.println("Created Record Name = " + name + " Age = " + age);
    return;
  }
  
  public Student getStudent(Integer id) {
    SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
    Map<String, Object> out = jdbcCall.execute(in);

    Student student = new Student();
    student.setId(id);
    student.setName((String) out.get("out_name"));
    student.setAge((Integer) out.get("out_age"));
    return student;
  }
  
  public List<Student> listStudents() {
    JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
    String SQL = "SELECT * FROM student_db";
    List <Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
    return students;
  }
}
```

* Main.java

```java
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    StudentJDBCProcedureTemplate studentJDBCProcedureTemplate =  (StudentJDBCProcedureTemplate)context.getBean("studentJDBCProcedureTemplate");
     
    System.out.println("------Records Creation--------" );
    studentJDBCProcedureTemplate.create("Amirul", 27);
    studentJDBCProcedureTemplate.create("Ananth", 35);
    studentJDBCProcedureTemplate.create("Cristina", 26);

    System.out.println("------Listing Multiple Records--------" );
    List<Student> students = studentJDBCProcedureTemplate.listStudents();
      
    for (Student record : students) {
        System.out.print("ID : " + record.getId() );
        System.out.print(", Name : " + record.getName() );
        System.out.println(", Age : " + record.getAge());
    }
    
    System.out.println("----Listing Record with ID = 5 -----" );
    Student student = studentJDBCProcedureTemplate.getStudent(5);
    System.out.print("ID : " + student.getId() );
    System.out.print(", Name : " + student.getName() );
    System.out.println(", Age : " + student.getAge());
  }
}
```

### Spring Transaction Management

* The concept of transactions can be described with the following four key properties described as __ACID__:
  1. __Atomicity__</br>A transaction should be treated as a single unit of operation, which means either the entire sequence of operations is successful or unsuccessful.
  2. __Consistency__</br>This represents the consistency of the referential integrity of the database, unique primary keys in tables, etc.
  3. __Isolation__</br>There may be many transaction processing with the same data set at the same time. Each transaction should be isolated from others to prevent data corruption.
  4. __Durability__</br>Once a transaction has completed, the results of this transaction have to be made permanent and cannot be erased from the database due to system failure.

#### Spring Transaction Abstractions

* The key to the Spring transaction abstraction is defined by the __org.springframework.transaction.PlatformTransactionManager__ interface, which is as follows:

| No. | Method & Description |
| :-: | :------------------- |
| 1 | __TransactionStatus getTransaction(TransactionDefinition definition)__</br>This method returns a currently active transaction or creates a new one, according to the specified propagation behavior. |
| 2 | __void commit(TransactionStatus status)__</br>This method commits the given transaction, with regard to its status. |
| 3 | __void rollback(TransactionStatus status)__</br>This method performs a rollback of the given transaction. |

```java
public interface PlatformTransactionManager extends TransactionManager {

  TransactionStatus getTransaction(@Nullable TransactionDefinition definition)
      throws TransactionException;

  void commit(TransactionStatus status) throws TransactionException;

  void rollback(TransactionStatus status) throws TransactionException;

}
```

* The TransactionDefinition is the core interface of the transaction support in Spring and it is defined as follows:

| No. | Method & Description |
| :-: | :------------------- |
| 1 | __int getPropagationBehavior()__</br>This method returns the propagation behavior. Spring offers all of the transaction propagation options familiar from EJB CMT. |
| 2 | __int getIsolationLevel()__</br>This method returns the degree to which this transaction is isolated from the work of other transactions. |
| 3 | __String getName()__</br>This method returns the name of this transaction. |
| 4 | __int getTimeout()__</br>This method returns the time in seconds in which the transaction must complete. |
| 5 | __boolean isReadOnly()__</br>This method returns whether the transaction is read-only. |

```java
public interface TransactionDefinition {
  int getPropagationBehavior();
  int getIsolationLevel();
  String getName();
  int getTimeout();
  boolean isReadOnly();
}
```

* Following are the possible values for isolation level:

| No. | Isolation & Description |
| :-: | :---------------------- |
| 1 | __TransactionDefinition.ISOLATION_DEFAULT__</br>This is the default isolation level. |
| 2 | __TransactionDefinition.ISOLATION_READ_COMMITTED__</br>Indicates that dirty reads are prevented; non-repeatable reads and phantom reads can occur. |
| 3 | __TransactionDefinition.ISOLATION_READ_UNCOMMITTED__</br>Indicates that dirty reads, non-repeatable reads, and phantom reads can occur. |
| 4 | __TransactionDefinition.ISOLATION_REPEATABLE_READ__</br>Indicates that dirty reads and non-repeatable reads are prevented; phantom reads can occur. |
| 5 | __TransactionDefinition.ISOLATION_SERIALIZABLE__</br>Indicates that dirty reads, non-repeatable reads, and phantom reads are prevented. |

* Following are the possible values for propagation types:

| No. | Propagation & Description |
| :-: | :------------------------ |
| 1 | __TransactionDefinition.PROPAGATION_MANDATORY__</br>Supports a current transaction; throws an exception if no current transaction exists. |
| 2 | __TransactionDefinition.PROPAGATION_NESTED__</br>Executes within a nested transaction if a current transaction exists. |
| 3 | __TransactionDefinition.PROPAGATION_NEVER__</br>Does not support a current transaction; throws an exception if a current transaction exists. |
| 4 | __TransactionDefinition.PROPAGATION_NOT_SUPPORTED__</br>Does not support a current transaction; rather always execute nontransactionally. |
| 5 | __TransactionDefinition.PROPAGATION_REQUIRED__</br>Supports a current transaction; creates a new one if none exists. |
| 6 | __TransactionDefinition.PROPAGATION_REQUIRES_NEW__</br>Creates a new transaction, suspending the current transaction if one exists. |
| 7 | __TransactionDefinition.PROPAGATION_SUPPORTS__</br>Supports a current transaction; executes non-transactionally if none exists. |
| 8 | __TransactionDefinition.TIMEOUT_DEFAULT__</br>Uses the default timeout of the underlying transaction system, or none if timeouts are not supported. |

* The TransactionStatus interface provides a simple way for transactional code to control transaction execution and query transaction status.

| No. | Method & Description |
| :-: | :------------------- |
| 1 | __boolean hasSavepoint()__</br>This method returns whether this transaction internally carries a savepoint, i.e., has been created as nested transaction based on a savepoint. |
| 2 | __boolean isCompleted()__</br>This method returns whether this transaction is completed, i.e., whether it has already been committed or rolled back. |
| 3 | __boolean isNewTransaction()__</br>This method returns true in case the present transaction is new. |
| 4 | __boolean isRollbackOnly()__</br>This method returns whether the transaction has been marked as rollback-only. |
| 5 | __void setRollbackOnly()__</br>This method sets the transaction as rollback-only. |

```java
public interface TransactionStatus extends SavepointManager {
  boolean isNewTransaction();
  boolean hasSavepoint();
  void setRollbackOnly();
  boolean isRollbackOnly();
  boolean isCompleted();
}
```

* Spring supports two types of transaction management:
  1. __Programmatic transaction management__</br>This means that we have to manage the transaction with the help of programming. That gives us extreme flexibility, but it is difficult to maintain.
  2. __Declarative transaction management__</br>This means we separate transaction management from the business code. Only use annotations or XML-based configuration to manage the transactions.

#### Programmatic Transaction Management

* student_db table

```sql
CREATE TABLE student_db (
  studentID     INT NOT NULL auto_increment,
  student_name  INT NOT NULL,
  student_age   INT NOT NULL,
  PRIMARY KEY(studentID)
);
```

* student_marks table

```sql
CREATE TABLE student_marks (
   marksID     INT NOT NULL auto_increment,
   marks       INT NOT NULL,
   years       INT NOT NULL,
   studentID   int,
   PRIMARY KEY(marksID),
   FOREIGN KEY(studentID) references student_db(studentID)
);
```

* StudentDAO.java

```java
import java.util.List;
import javax.sql.DataSource;

public interface StudentDAO {

  // This is the method to be used to initialize database resources ie. connection.
  public void setDataSource(DataSource ds);
  
  // This is the method to be used to create a record in the Student and Marks tables.
  public void create(String name, Integer age, Integer marks, Integer year);
  
  // This is the method to be used to list down all the records from the Student and Marks tables.
  public List<StudentMarks> listStudents();
}
```

* StudentMarks.java

```java
public class StudentMarks {
  private Integer age;
  private String name;
  private Integer id;
  private Integer marks;
  private Integer year;
  private Integer sid;

  public void setAge(Integer age) {
    this.age = age;
  }
  
  public Integer getAge() {
    return age;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public Integer getId() {
    return id;
  }
  
  public void setMarks(Integer marks) {
    this.marks = marks;
  }
  
  public Integer getMarks() {
    return marks;
  }
  
  public void setYear(Integer year) {
    this.year = year;
  }
  
  public Integer getYear() {
    return year;
  }
  
  public void setSid(Integer sid) {
    this.sid = sid;
  }
  
  public Integer getSid() {
    return sid;
  }
}
```

* StudentMarksMapper.java

```java
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class StudentMarksMapper implements RowMapper<StudentMarks>{
  public StudentMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
    StudentMarks studentMarks = new StudentMarks();
    studentMarks.setId(rs.getInt("student_db.studentID"));
    studentMarks.setName(rs.getString("student_name"));
    studentMarks.setAge(rs.getInt("student_age"));
    studentMarks.setSid(rs.getInt("student_marks.studentID"));
    studentMarks.setMarks(rs.getInt("marks"));
    studentMarks.setYear(rs.getInt("years"));

    return studentMarks;
  }
}
```

* StudentTransactionTemplate.java

```java
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class StudentTransactionTemplate implements StudentDAO {
  private DataSource dataSource;
  private JdbcTemplate jdbcTemplateObject;
  private PlatformTransactionManager transactionManager;

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
  }
  
  public void setTransactionManager(PlatformTransactionManager transactionManager) {
    this.transactionManager = transactionManager;
  }
  
  public void create(String name, Integer age, Integer marks, Integer year){
    TransactionDefinition def = new DefaultTransactionDefinition();
    TransactionStatus status = transactionManager.getTransaction(def);

    try {
      String SQL1 = "INSERT INTO student_db (student_name, student_age) VALUES (?, ?)";
      jdbcTemplateObject.update( SQL1, name, age);

      // Get the latest student id to be used in Marks table
      String SQL2 = "SELECT max(studentID) FROM student_db";
      int sid = jdbcTemplateObject.queryForObject( SQL2, Integer.class );

      String SQL3 = "INSERT INTO student_marks(studentID, marks, years) " + "VALUES (?, ?, ?)";
      jdbcTemplateObject.update( SQL3, sid, marks, year);

      System.out.println("Created Name = " + name + ", Age = " + age);
      transactionManager.commit(status);
    } catch (DataAccessException e) {
      System.out.println("Error in creating record, rolling back");
      transactionManager.rollback(status);
    throw e;
    }
    return;
  }
  
  public List<StudentMarks> listStudents() {
    String SQL = "SELECT * FROM student_db, student_marks WHERE student_db.studentID=student_marks.studentID";
    List <StudentMarks> studentMarks = jdbcTemplateObject.query(SQL, new StudentMarksMapper());
      return studentMarks;
  }
}
```

* Main.java

```java
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    StudentTransactionTemplate studentJDBCTemplate =  (StudentTransactionTemplate)context.getBean("studentTransactionTemplate");
        
    System.out.println("------Records creation--------" );
    studentJDBCTemplate.create("Foxy", 18, 85, 2015);
    studentJDBCTemplate.create("Sky", 20, 95, 2016);
    studentJDBCTemplate.create("Apple", 25, 100, 2018);

    System.out.println("------Listing all the records--------" );
    List<StudentMarks> studentMarks = studentJDBCTemplate.listStudents();
        
    for (StudentMarks record : studentMarks) {
      System.out.print("ID : " + record.getId() );
      System.out.print(", Name : " + record.getName() );
      System.out.print(", Marks : " + record.getMarks());
      System.out.print(", Year : " + record.getYear());
      System.out.println(", Age : " + record.getAge());
    }
  }
}
```

#### Spring Declarative Transaction Management

* The steps associated with declarative transaction:
  1. Use __\<tx:advice />__ tag, which creates a transaction-handling advice and at the same time we define a pointcut that matches all methods we wish to make transaction and reference the transactional advice.
  2. If a method name has been included in the transactional configuration, then the created advice will begin the transaction before calling the method.
  3. Target method will be executed in a __try / catch__ block.
  4. If the method finishes normally, the AOP advice commits the transaction successfully otherwise it performs a rollback.

* student_db table

```sql
CREATE TABLE student_db (
  studentID     INT NOT NULL auto_increment,
  student_name  INT NOT NULL,
  student_age   INT NOT NULL,
  PRIMARY KEY(studentID)
);
```

* student_marks table

```sql
CREATE TABLE student_marks (
   marksID     INT NOT NULL auto_increment,
   marks       INT NOT NULL,
   years       INT NOT NULL,
   studentID   int,
   PRIMARY KEY(marksID),
   FOREIGN KEY(studentID) references student_db(studentID)
);
```

* StudentDAO.java

```java
import java.util.List;
import javax.sql.DataSource;

public interface StudentDAO {
  
  // This is the method to be used to initialize database resources ie. connection.
  public void setDataSource(DataSource ds);
  
  // This is the method to be used to create a record in the Student and Marks tables.
  public void create(String name, Integer age, Integer marks, Integer year);
  
  // This is the method to be used to list down all the records from the Student and Marks tables.
  public List<StudentMarks> listStudents();
}
```

* StudentMarks.java

```java
public class StudentMarks {
  private Integer age;
  private String name;
  private Integer id;
  private Integer marks;
  private Integer year;
  private Integer sid;

  public void setAge(Integer age) {
    this.age = age;
  }
  
  public Integer getAge() {
    return age;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public Integer getId() {
    return id;
  }
  
  public void setMarks(Integer marks) {
    this.marks = marks;
  }
  
  public Integer getMarks() {
    return marks;
  }
  
  public void setYear(Integer year) {
    this.year = year;
  }
  
  public Integer getYear() {
    return year;
  }
  
  public void setSid(Integer sid) {
    this.sid = sid;
  }
  
  public Integer getSid() {
    return sid;
  }
}
```

* StudentMarksMapper.java

```java
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class StudentMarksMapper implements RowMapper<StudentMarks>{
  public StudentMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
    StudentMarks studentMarks = new StudentMarks();
    studentMarks.setId(rs.getInt("student_db.studentID"));
    studentMarks.setName(rs.getString("student_name"));
    studentMarks.setAge(rs.getInt("student_age"));
    studentMarks.setSid(rs.getInt("student_marks.studentID"));
    studentMarks.setMarks(rs.getInt("marks"));
    studentMarks.setYear(rs.getInt("years"));

    return studentMarks;
  }
}
```

* StudentDeclarativeTransactionTemplate.java

```java
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDeclarativeTransactionTemplate implements StudentDAO {
  private JdbcTemplate jdbcTemplateObject;
  
  public void setDataSource(DataSource dataSource) {
    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
  }
  
  public void create(String name, Integer age, Integer marks, Integer year){
    try {
      String SQL1 = "INSERT INTO student_db (student_name, student_age) VALUES (?, ?)";
      jdbcTemplateObject.update( SQL1, name, age);
  
      // Get the latest student id to be used in Marks table
      String SQL2 = "SELECT max(studentID) FROM student_db";
      int sid = jdbcTemplateObject.queryForObject( SQL2, Integer.class );
  
      String SQL3 = "INSERT INTO student_marks(studentID, marks, years) " + "VALUES (?, ?, ?)";
      jdbcTemplateObject.update( SQL3, sid, marks, year);
      System.out.println("Created Name = " + name + ", Age = " + age);
           
      // to simulate the exception.
      throw new RuntimeException("simulate Error condition");
    } catch (DataAccessException e) {
      System.out.println("Error in creating record, rolling back");
      throw e;
    }
  }
  
  public List<StudentMarks> listStudents() {
    String SQL = "SELECT * FROM student_db, student_marks WHERE student_db.studentID=student_marks.studentID";
    List <StudentMarks> studentMarks = jdbcTemplateObject.query(SQL, new StudentMarksMapper());
        
    return studentMarks;
  }
}
```

* Main.java

```java
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
  StudentDAO studentDeclarativeTemplate = 
        (StudentDAO)context.getBean("studentDeclarativeTemplate");
          
    System.out.println("------Records creation--------" );
    studentDeclarativeTemplate.create("Hellen", 25, 76, 2018);
    studentDeclarativeTemplate.create("Nagihah", 25, 88, 2014);
    studentDeclarativeTemplate.create("Hayati", 27, 95, 2017);

    System.out.println("------Listing all the records--------" );
    List<StudentMarks> studentMarks = studentDeclarativeTemplate.listStudents();
          
    for (StudentMarks record : studentMarks) {
      System.out.print("ID : " + record.getId() );
      System.out.print(", Name : " + record.getName() );
      System.out.print(", Marks : " + record.getMarks());
      System.out.print(", Year : " + record.getYear());
      System.out.println(", Age : " + record.getAge());
    }
  }
}
```

* Beans.xml
* Adding xmlns:tx schema

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xmlns:tx="http://www.springframework.org/schema/tx"
    xsi:schemaLocation=" 
        http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/tx 
        http://www.springframework.org/schema/tx/spring-tx.xsd
        http://www.springframework.org/schema/aop 
        http://www.springframework.org/schema/aop/spring-aop.xsd">

        <!-- bean definitions here -->

</beans>
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xmlns:tx="http://www.springframework.org/schema/tx"
    xsi:schemaLocation=" 
        http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/tx 
        http://www.springframework.org/schema/tx/spring-tx.xsd
        http://www.springframework.org/schema/aop 
        http://www.springframework.org/schema/aop/spring-aop.xsd">
        
    <context:annotation-config/>
    <aop:aspectj-autoproxy/>

   <!-- Declarative Transaction Bean -->
   <tx:advice id = "txAdvice" transaction-manager = "transactionManager">
      <tx:attributes>
      <tx:method name = "create"/>
      </tx:attributes>
   </tx:advice>
  
   <aop:config>
      <aop:pointcut id = "createOperation" 
         expression = "execution(* com.springlearning.dbtransaction.StudentDeclarativeTransactionTemplate.create(..))"/>
      
      <aop:advisor advice-ref = "txAdvice" pointcut-ref = "createOperation"/>
   </aop:config>
  
   <!-- Initialization for TransactionManager -->
   <bean id = "transactionManager"
      class = "org.springframework.jdbc.datasource.DataSourceTransactionManager">
      <property name = "dataSource" ref = "dataSource" />    
   </bean>

   <!-- Definition for studentJDBCTemplate bean -->
   <bean id = "studentDeclarativeTemplate"  
      class = "com.springlearning.dbtransaction.StudentDeclarativeTransactionTemplate">
      <property name = "dataSource" ref = "dataSource"/>  
   </bean>
</beans>
```

### Spring MVC Framework

#### Methods of creating and deploy Spring Web Project into Apache Tomcat server

* Jar file needed(without Maven dependency) for Spring MVC project, include it inside webapps/WEB-INF/lib file directory:
  1. javax.servlet.api-3.0.1.jar
  2. spring-aop-5.3.9.jar
  3. spring-beans-5.3.9.jar
  4. spring-context-5.3.9.jar
  5. spring-core-5.3.9.jar
  6. spring-expression-5.3.9.jar
  7. spring-jcl-5.3.9.jar
  8. spring-web-5.3.9.jar
  9. spring-webmvc-5.3.9.jar

* Use Apache-tomcat 9.x version for web.xml (j2ee/javaee context use tomcat-9, jakartaEE context use tomcat-10).
* Create Dynamic Web Project using Eclipse.
* Place web.xml(DispatcherServlet) and xxxx-servlet.xml(servlet config) file in webapps/WEB-INF/ file directory.
* Create Java package file(controller and model jar file) under src/main/java file directory.
* Create views file( *.jsp file) under webapps/WEB-INF/views file directory.
* After complete testing the projects, click on __File > Export > Web > WAR File__ to export xxxx.WAR file and placed it into apache/webapps folder.
* Restart the server and the .WAR file will extracted itself into apache/webapps folder.

#### Simple Hello World Spring MVC Web Project

* HelloController.java (Controller file with @Controller annotation)

```java
package com.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// RequestMapping("url address to view the info")
// url address(http://localhost:8080/SpringMVCProject/hello)
@RequestMapping("/hello")
public class HelloController {
  @RequestMapping(method = RequestMethod.GET)
  public String printHello(ModelMap model) {
    model.addAttribute("message", "Hello Spring MVC Framework!");
    // returning hello.jsp
    return "hello";
  }
  
  // inner url address(http://localhost:8080/SpringMVCProject/hello/helloagain)
  @RequestMapping(value="/helloagain", method = RequestMethod.GET)
    public String printHelloAgain(ModelMap model) {
        model.addAttribute("message", "Hello World Again, from Spring 5 MVC");
        // returning hello.jsp
        return "hello";
    }
}
```

* web.xml(DispatcherServlet to handle, use for URL mapping)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    xmlns="http://xmlns.jcp.org/xml/ns/j2ee" 
    xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/j2ee 
              http://xmlns.jcp.org/xml/ns/j2ee/web-app_3_1.xsd"
    id="WebApp_ID" version="3.1">

  <display-name>Spring MVC Project</display-name>
  
  <servlet>
    <!-- servlet-name must match with xxx.-servlet.xml file name -->
    <servlet-name>SpringMVCProject</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
  </servlet>

  <servlet-mapping>
    <!-- servlet-name must match with xxx.-servlet.xml file name -->
    <servlet-name>SpringMVCProject</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
   
</web-app>
```

* SpringMVCProject-servlet.xml (Spring Web Configuration file)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation=" 
        http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">
  
  <!-- Scan for java package file -->
  <context:component-scan base-package = "com.springmvc.controller" />

  <bean class = "org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name = "prefix" value = "/WEB-INF/jsp/" />
    <property name = "suffix" value = ".jsp" />
    </bean>        

</beans>
```

* hello.jsp(Save under web/WEB-INF/jsp directory. Use as view page)

```jsp
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
   <head>
      <title>Hello World</title>
   </head>
   
   <body>
      <h2>${message}</h2>
   </body>
</html>
```

#### Spring MVC Form Handling

* web.xml

```java
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    xmlns="http://xmlns.jcp.org/xml/ns/j2ee" 
    xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/j2ee 
              http://xmlns.jcp.org/xml/ns/j2ee/web-app_3_1.xsd"
    id="WebApp_ID" version="3.1">

  <display-name>Spring MVC Project</display-name>
  
  <servlet>
    <servlet-name>SpringMVCProject</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
  </servlet>

  <servlet-mapping>
    <servlet-name>SpringMVCProject</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
   
</web-app>
```

* StudentModel.java

```java
public class StudentModel {
  private Integer age;
  private String name;
  private Integer id;

  public void setAge(Integer age) {
    this.age = age;
  }
  
  public Integer getAge() {
    return age;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public Integer getId() {
    return id;
  }
}
```

* StudentController.java

```java
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.ModelMap;

@Controller
public class StudentController {
  
  @RequestMapping(value="/student", method = RequestMethod.GET)
  public ModelAndView student() {
    // Get data from student.jsp and return data to StudentModel()
    // ModelAndView("view-name(/student)", "model-name", "model-object")
    return new ModelAndView("student", "command", new StudentModel());
  }
  
  @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("SpringMVCProject")StudentModel student,  ModelMap model) {
      // Get data from StudentModel and setting constructor data
      model.addAttribute("name", student.getName());
      model.addAttribute("age", student.getAge());
      model.addAttribute("id", student.getId());
      
      // return to result.jsp
      return "result";
  }
}
```

* SpringMVCProject-servlet.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation=" 
        http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">
        
  <context:component-scan base-package = "com.springmvc.formhandling" />

  <bean class = "org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name = "prefix" value = "/WEB-INF/jsp/" />
    <property name = "suffix" value = ".jsp" />
    </bean>        

</beans>
```

* student.jsp and result.jsp

```jsp
<!-- student.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC Form Handling</title>
</head>
<body>
    <h2>Student Information</h2>
      <form:form method = "POST" action = "/SpringMVCProject/addStudent">
        <table>
          <tr>
            <td><form:label path = "name">Name</form:label></td>
            <td><form:input path = "name" /></td>
          </tr>
          <tr>
            <td><form:label path = "age">Age</form:label></td>
            <td><form:input path = "age" /></td>
           </tr>
          <tr>
             <td><form:label path = "id">ID</form:label></td>
            <td><form:input path = "id" /></td>
          </tr>
          <tr>
            <td colspan = "2">
              <input type = "submit" value = "Submit"/>
            </td>
          </tr>
        </table>  
      </form:form>
</body>
</html>
```

```jsp
<!-- result.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored = "false" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC Form Handling</title>
</head>
<body>
  <h2>Submitted Student Information</h2>
  <table>
    <tr>
      <td>Name: </td>
      <td>${name}</td>
    </tr>
    <tr>
      <td>Age: </td>
      <td>${age}</td>
    </tr>
    <tr>
      <td>ID: </td>
      <td>${id}</td>
    </tr>
  </table>
</body>
</html>
```

#### Spring MVC Page Redirection

* WebController.java

```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
  @RequestMapping(value = "/index", method = RequestMethod.GET)
  public String index() {
    return "index";
  }
  
  @RequestMapping(value = "/redirect", method = RequestMethod.GET)
  public String redirect() {
    // After fetching the response from index page, the redirect function will help to redirect web page to finalPage
    return "redirect:finalPage";
  }
  
  @RequestMapping(value = "/finalPage", method = RequestMethod.GET)
  public String finalPage() {
    return "final";
  }
}
```

* web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    xmlns="http://xmlns.jcp.org/xml/ns/j2ee" 
    xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/j2ee 
              http://xmlns.jcp.org/xml/ns/j2ee/web-app_3_1.xsd"
    id="WebApp_ID" version="3.1">

  <display-name>Spring MVC Project</display-name>
  
  <servlet>
    <servlet-name>SpringMVCProject</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
  </servlet>

  <servlet-mapping>
    <servlet-name>SpringMVCProject</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
   
</web-app>
```

* SpringMVCProject-servlet.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation=" 
        http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">
        
  <context:component-scan base-package = "com.springmvc.pageredirect" />

  <bean id="viewResolver" class = "org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name = "prefix" value = "/WEB-INF/jsp/" />
    <property name = "suffix" value = ".jsp" />
    </bean>        

</beans>
```

* index.jsp and final.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First Index Page</title>
</head>
<body>
  <h2>Spring Page Redirection</h2>
  <p>Click the below button to redirect the result to new page</p>
  <form:form action = "/SpringMVCProject/redirect" method = "GET">
    <table>
      <tr>
        <td>
          <input type = "submit" value = "Redirect Page"/>
        </td>
      </tr>
    </table>  
  </form:form>
</body>
</html>
```

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Redirected Final Page</title>
</head>
<body>
  <h2>Redirected Page from Index Page.</h2>
</body>
</html>
```

#### Methods Redirecting to Static Page

* web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    xmlns="http://xmlns.jcp.org/xml/ns/j2ee" 
    xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/j2ee 
              http://xmlns.jcp.org/xml/ns/j2ee/web-app_3_1.xsd"
    id="WebApp_ID" version="3.1">

  <display-name>Spring MVC Project</display-name>
  
  <servlet>
    <servlet-name>SpringMVCProject</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
  </servlet>

  <servlet-mapping>
    <servlet-name>SpringMVCProject</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
   
</web-app>
```

* SpringMVC-servlet.xml(Adding MVC schema into beans.xml tag)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:mvc = "http://www.springframework.org/schema/mvc"
    xsi:schemaLocation=" 
        http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/mvc
         http://www.springframework.org/schema/mvc/spring-mvc.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">
        
  <context:component-scan base-package = "com.springmvc.pageredirect" />

  <bean id="viewResolver" class = "org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name = "prefix" value = "/WEB-INF/jsp/" />
    <property name = "suffix" value = ".jsp" />
    </bean>
  <!-- mvc:resources used to map static page -->        
  <mvc:resources mapping = "/pages/**" location = "/WEB-INF/pages/" />
   <mvc:annotation-driven/>
</beans>
```

* WebController.java

```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
  @RequestMapping(value = "/index", method = RequestMethod.GET)
  public String index() {
    return "index";
  }
  
  @RequestMapping(value = "/redirect", method = RequestMethod.GET)
  public String redirect() {
    return "redirect:finalPage";
  }
  
  @RequestMapping(value = "/finalPage", method = RequestMethod.GET)
  public String finalPage() {
    return "final";
  }
  
  // Mapping method which redirect to output.html
  @RequestMapping(value = "/staticPage", method = RequestMethod.GET)
  public String redirect2() {
    return "redirect:/pages/output.html";
  }
}
```

* index.jsp and output.html

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First Index Page</title>
</head>
<body>
  <h2>Spring Page Redirection</h2>
  <p>Click the below button to redirect the result to new page</p>
  <form:form action = "/SpringMVCProject/redirect" method = "GET">
    <table>
      <tr>
        <td>
          <input type = "submit" value = "Redirect Page"/>
        </td>
      </tr>
    </table>  
  </form:form>
  </br>
  <p>Click the below button to redirect the result to new page</p>
  <form:form action = "/SpringMVCProject/staticPage" method = "GET">
    <table>
      <tr>
        <td>
          <input type = "submit" value = "Redirect To HTML Page"/>
        </td>
      </tr>
    </table>  
  </form:form>
</body>
</html>
```

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Static Output Spring Page</title>
</head>
<body>
  <h2>A simple HTML5 page</h2>
</body>
</html>
```

#### Spring MVC Exception Handling Methods

* web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    xmlns="http://xmlns.jcp.org/xml/ns/j2ee" 
    xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/j2ee 
              http://xmlns.jcp.org/xml/ns/j2ee/web-app_3_1.xsd"
    id="WebApp_ID" version="3.1">

  <display-name>Spring MVC Project</display-name>
  
  <servlet>
    <servlet-name>SpringMVCProject</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
  </servlet>

  <servlet-mapping>
    <servlet-name>SpringMVCProject</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
   
</web-app>
```

* SpringMVCProject-servlet.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:mvc = "http://www.springframework.org/schema/mvc"
    xsi:schemaLocation=" 
        http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/mvc
         http://www.springframework.org/schema/mvc/spring-mvc.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">
        
  <context:component-scan base-package = "com.springmvc.formhandling" />

  <bean id="viewResolver" class = "org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name = "prefix" value = "/WEB-INF/jsp/" />
    <property name = "suffix" value = ".jsp" />
    </bean>
   
  <bean class = "org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
    <property name = "exceptionMappings">
      <props>
        <prop key = "com.springmvc.formhandling.SpringException">
          <!-- Output for ExceptionPage.jsp if there is any mismatch input with StudentController.java
               ExceptionHandler()
           -->
          ExceptionPage
        </prop>
      </props>
    </property>
    <!-- Output for error.jsp if there is input error besides the exception error -->
    <property name = "defaultErrorView" value = "error"/>
   </bean>
</beans>
```

* StudentModel.java

```java
public class StudentModel {
  private Integer age;
  private String name;
  private Integer id;

  public void setAge(Integer age) {
    this.age = age;
  }
  
  public Integer getAge() {
    return age;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public Integer getId() {
    return id;
  }
}
```

* StudentController.java

```java
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.ModelMap;

@Controller
public class StudentController {
  
  @RequestMapping(value="/student", method = RequestMethod.GET)
  public ModelAndView student() {
    // ModelAndView("view-name", "model-name", "model-object")
    return new ModelAndView("student", "command", new StudentModel());
  }
  
  @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
  // Add exception handler
  @ExceptionHandler(SpringException.class)
    public String addStudent(@ModelAttribute("SpringMVCProject")StudentModel student,  ModelMap model) {
    
    // Adding Exception Handling inside Controller Method
    if(student.getName().length() < 5 ){
      throw new SpringException("Given name is too short");
    } else {
      model.addAttribute("name", student.getName());
    }

    if( student.getAge() < 10 ){
      throw new SpringException("Given age is too low");
    } else {
      model.addAttribute("age", student.getAge());
    }
    
    model.addAttribute("id", student.getId());
    
    return "result";
  }
}
```

* SpringException.java

```java
public class SpringException extends RuntimeException {
  private String exceptionMsg;
     
  public SpringException(String exceptionMsg) {
    this.exceptionMsg = exceptionMsg;
  }
  
  public String getExceptionMsg() {
    return this.exceptionMsg;
  }
  
  public void setExceptionMsg(String exceptionMsg) {
    this.exceptionMsg = exceptionMsg;
  }
}
```

* student.jsp, ExceptionPage.jsp and error.jsp

```jsp
<!-- student.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC Form Handling</title>
</head>
<body>
    <h2>Student Information</h2>
      <form:form action="/SpringMVCProject/addStudent" method="POST">
        <table>
          <tr>
            <td><form:label path = "name">Name</form:label></td>
            <td><form:input path = "name" /></td>
          </tr>
          <tr>
            <td><form:label path = "age">Age</form:label></td>
            <td><form:input path = "age" /></td>
           </tr>
          <tr>
             <td><form:label path = "id">id</form:label></td>
            <td><form:input path = "id" /></td>
          </tr>
          <tr>
            <td colspan = "2">
              <input type = "submit" value = "Submit"/>
            </td>
          </tr>
        </table>  
      </form:form>
</body>
</html>
```

```jsp
<!-- ExceptionPage.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Exception Page</title>
</head>
<body>
  <h2>Spring MVC Exception Handling</h2>
  <h3>${exception.exceptionMsg}</h3>
</body>
</html>
```

```jsp
<!-- error.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Error Message</title>
</head>
<body>
  <p>An error occured, please contact administrator for further assistance.</p>
</body>
</html>
```

### Spring Logging with Log4j

* Adding logging for Java Projects, include following jar files: (Method without Maven dependency)
  1. log4j-api-x.x.x.jar
  2. log4j-core-x.x.x.jar

* __**NOTE:__ log4j 1.x are different with log4j2, this two version of logging file properties are different and need to take attention on it.

#### Configure Dynamic Web Project with log4j2

* HelloLogging.java

```java
public class HelloLogging {
  private String message;
     
  public void setMessage(String message){
    this.message  = message;
  }
  
  public void getMessage() {
    System.out.println("Your Message : " + message);
  }
}
```

* Beans.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns = "http://www.springframework.org/schema/beans"
   xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation = "http://www.springframework.org/schema/beans
                       http://www.springframework.org/schema/beans/spring-beans.xsd">

   <bean id = "helloLog" class = "com.springlogging.HelloLogging">
      <property name = "message" value = "Hello, this is logging message!"/>
   </bean>

</beans>
```

* log4j2.properties

```python
# status = error(only output log4j error event on console)
# status = debug(output log4j event message to console)
status = debug
dest = err
name = log4j2PropertiesConfig

appender.console.type = Console
appender.console.name = LogToConsole
appender.console.layout.type = PatternLayout
appender.console.layout.pattern = [%-5level] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %c{1} - %msg%n
# Filter log message output to console
appender.console.filter.threshold.type = ThresholdFilter
# threshold.level = debug (log INFO, DEBUG, ERROR, WARN message)
# threshold.level = error(only log error message)
appender.console.filter.threshold.level = debug

# Rotate log file
appender.rolling.type = RollingFile
appender.rolling.name = LogToRollingFile
# file path to save logs
appender.rolling.fileName = C:/logs/app.log
appender.rolling.filePattern = logs/$${date:yyyy-MM}/app-%d{MM-dd-yyyy}-%i.log.gz
appender.rolling.layout.type = PatternLayout
appender.rolling.layout.pattern = %d %p %C{1.} [%t] %m%n
appender.rolling.policies.type = Policies
appender.rolling.policies.time.type = TimeBasedTriggeringPolicy
appender.rolling.policies.size.type = SizeBasedTriggeringPolicy
appender.rolling.policies.size.size=10MB
appender.rolling.strategy.type = DefaultRolloverStrategy
appender.rolling.strategy.max = 10

# Log to console and rolling file
logger.app.name = com.springlogging
# logger.app.level = debug(log INFO, DEBUG, ERROR, WARN message)
# logger.app.level = error(only log ERROR message in console and file)
logger.app.level = debug
logger.app.additivity = false
logger.app.appenderRef.rolling.ref = LogToRollingFile
logger.app.appenderRef.console.ref = LogToConsole

rootLogger.level = info
rootLogger.appenderRef.stdout.ref = LogToConsole
```

* Main.java

```java
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  private static final Logger log = LogManager.getLogger(Main.class.getName());

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    log.info("Going to create HelloLogging Object");
    HelloLogging obj = (HelloLogging) context.getBean("helloLog");
    log.debug("This is log4j debug message");
    log.error("This is log4j error message");
    obj.getMessage();
    log.info("Exiting the program");
  }
}
```
