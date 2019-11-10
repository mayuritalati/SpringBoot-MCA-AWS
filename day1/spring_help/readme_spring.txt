WHY Spring ? 

To simplify Java development.

One line answer --- spring is not a JEE specification 
BUT its created —to make developing complex JEE applications easier.

Why learn one more frmwork --- when u already have EJB,Struts,Hibernate etc....

Spring is unique, for several reasons:

1. It helps you in  important areas that many other popular frameworks don't.  eg : readymade Hibernate templates.

2. Provides  a way to manage your business objects - based on Dependeny injection(DI)

3.Spring is both comprehensive and modular.
Offers you lot many features, yet gives you choice to integrate layers one by one, test it & then add new features via new layers.

4  Spring is an ideal framework for test driven projects.
    
5. It  is basically  a one-stop shop, addressing most of the concerns of typical enterprise  applications. 

6.Using Spring one can  centerally describe collaborating objects. From the earliest versions of Spring, there was an XML file that was used to describe the object graph.  
Contents of XML ---- Consists of beans. Each bean element describes an object that will be created and given an id. Each property element describes a setter method on the object and the value that should be given to it. These setters are called for you by the Spring application container.


Simpler answer to WHY Spring

Spring simplifies Java development.
Since above is a bold stmt -- to justify it --- there are main 4 reasons

Reasons ---it applies 4 key strategies
1. lightweight & min intrusive(POJOs not tied to spring)  dev with POJOs
2. Loose coupling thro' DI/IoC & with usage of i/f
3. Declarative approach(XML or anno or java config)  + thro Aspects & common conventions
4. Boilerplate code reduction thro aspects & templates.


What is Spring ? 

1. An open source framework since February 2003. 
Created by Rod Johnson and described in his book Expert One-on-One: J2EE Design and Development.

Allows us to give capability of EJBs to  plain JavaBeans without using (obviously!!!!) application server.

Any Java SE application can also use Spring to get simplicity, testability, and loose coupling.

2.Spring has been hosted on SourceForge. 


3. Spring is a lightweight framework.  Most of your Java classes will have  no dependency on Spring.   This means that you can easily transition your application from the Spring framework to any other frmwork. (Framework independence)

4. All Java applications that consist of multiple classes have inter-dependencies or coupling between classes.  Spring helps us develop applications that minimize the negative effects of coupling and encourages the use of interfaces in application development.  

5. Using interfaces in our applications to specify type helps make our applications easier to maintain and enhance later.

6. The Spring framework helps developers for separation of responsibilities. 

eg scenario -- Think of two situations – one is you’ve been told by your manager to do your normal work(eg - write stock trading appln) +  write down everything you do and how long it takes you. 

A better situation would be you do your normal work, but another person observes what you’re doing and records it and measures how long it took. 

Even better would be if you were totally unaware of that other person and that other person was able to also observe and record , not just yours but any other people’s work and time.  

That’s separation of responsibilities.   --- This is what spring offers u thro AOP

7. Def. of Spring ----
Spring is a lightweight , dependency injection and aspect-oriented container and framework. works on Ioc(Inversion of control)

Meaning 


7.1 Lightweight—Main of the Spring Framework can be distributed in a single JAR file that weighs ~ 2.5 MB.
JavaBeans / POJOs in Spring-enabled application often have no dependencies on Spring-specific classes.


7.2  Dependency Injection—Spring  allows loose coupling through dependency injection (DI). 
DI = JNDI(Naming service in j2ee ) in reverse—instead of an object looking up dependencies from a container, the container gives the dependencies to the object at instantiation without waiting to be asked.

7.3  Aspect-oriented—Spring supports aspect-oriented programming(AOP)
(AOP) allows  separating application business logic from system services (such as auditing and transaction management). Application objects perform only business logic—and nothing more. 
They are not responsible for (or even aware of) other system concerns, such as logging or transactional support or authentication.

7.4

Container—Spring is a container which manages
the lifecycle and configuration of application objects.
In Spring, using config XMLs or annotations you can
declare - how to create  each of your application objects
           - how to configure them            
           - how they should be associated with each other.(collaboration)




7.5  Framework—Spring allows you  to configure and compose complex applications from simpler components. In Spring, application objects are composed declaratively, typically in an XML file. 
Spring also provides you with ready made implemetations of services like - transaction management, persistence framework,web mvc etc.




8 Spring framework Modules
pg 17 of spring-ref 2.5.6 guide



9. Advantages of ApplicationContext over BeanFactory

9.1Application contexts resolve text messages, including support for internationalization (I18N).

9.2 Application contexts provide a generic way to load file resources, such as images.

9.3Application contexts can publish events to beans that are registered as listeners.




IOC -- rather a generic term 
Inversion of Control (IoC) is an object-oriented programming practice where the object coupling(dependent obj bound with dependency)  is bound at run time by an assembler object(eg spring container) and is typically not known at compile time using static analysis.
Unlike in traditional prog -- where dependent obj creates dependencies leading to tight coupling , container sets the dependencies (not us) ---so its inversion of control


Dependency. injection=Ioc+dependency inversion

What do u get with IoC (advantages of IoC)




    * There is a decoupling of the execution of a certain task from implementation.
    * Every module can focus on what it is designed for.
    * Modules make no assumptions about what other systems do but rely on their contracts.(i/f)
    * Replacing modules has no side effect on other modules.

Inversion of Control is sometimes  referred to as the "Hollywood Principle: Don't call us, we'll call you", 


Dependency injection (DI) is the ability to inject dependencies. DI can help make your code architecturally pure. It aids in using a design by interface approach as well as test driven development by providing a consistent way to inject dependencies. For example a data access object (DAO) may need a database connection. Thus the DAO depends on the database connection. Instead of looking up the database connection with JNDI, you could inject it. or another eg is JMS -- conn factory or destination


One way to think about a DI container like Spring is to think of JNDI turned inside out. Instead of the objects looking up other objects that it needs to get its job done (dependencies), with DI the container injects those dependent objects. This is the so-called Hollywood principle, you don't call us (lookup objects), we will call you (inject objects).

More on Ioc

IoC is also known as dependency injection (DI).

 It is a process whereby objects define their dependencies,that is, the other objects they work with, only through constructor arguments, arguments to a factory method, or properties that are set on the object instance after it is constructed or returned from a factory method. 

The container then injects those dependencies when it creates the bean. 

This process is fundamentally the inverse,( hence the name Inversion of Control (IoC)), of the bean itself controlling the instantiation or location of its dependencies by using direct construction of classes, or a mechanism such as the Service Locator pattern.

The org.springframework.beans and org.springframework.context packages are the
basis for Spring Framework's IoC container. The BeanFactory interface provides an advanced

configuration mechanism capable of managing any type of object. ApplicationContext is a
sub-interface of BeanFactory. It adds easier integration with Spring's AOP features; message resource handling (for use in internationalization), event publication; and application-layer specific contexts such as the WebApplicationContext for use in web applications.

