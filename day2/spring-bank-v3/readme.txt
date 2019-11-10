day1  :13-Oct-2019
=====
Account
     accno (auto generated)
     name 
     balance
     doc (auto generated)
     pan 
     email
     mobile  


Employee
     id (auto generated)
     name 
     salary
     doj (auto generated)
     pan 
     email
     mobile  


                          BeanFactory (I)
                               |
                          ApplicationContext (I)
                               |
     ClassPathXMLApplicationContext|AnotationConfigApplicationContext                          |
                               |
                          ServletWebApplicationContext(I)            




IOC

DI
  setter   -><property>
  constructor -><constructor-arg>
                          
                                                    
Spring Bean Life Cycle
==========================
1.Instantation
2.Dependency Injection
3.Initialization
4.Service
5.Destruction



Scope of Beans: singleton|prototype|request|session


day2:19-Oct-2019
================

Wiring :Associations of spring beans with each other

Autowiring :It is a mechanism of delegating the responsibilty of
            Associations of spring beans with each other to 
            spring container                       


             auto-wire=no|byName|byType|constructor



Spring Bean configuration via annotations
==========================================
                          @Component
                          
@Controller              @Service                @Reposiotry


                            























