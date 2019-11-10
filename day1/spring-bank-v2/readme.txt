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



