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


                            

  MVC (Model View Controller)
  =============================
                    Model                          View                   Controller
                    

JSP Model1         Java Bean                       JSP                    JSP

JSP Model2         Java Bean                       JSP                    Servlet

                                                             Struts1.x,JSF1.x,Spring Web MVC 
                                                                   



JSP Model3         Java Bean                       JSP                    Filter

JSP Model4         Java Bean                       JSP                    Tag Handler


                    
     
     
http://localhost:8080/spring-cms-mvc/spring/hello




@RequestMapping("/customers")
@Controller
public class CmsRestController{


@RequestMapping(value="/getAllcustomers",method=RequestMethod.GET)
public @ResponseBody List<Customer> getAllCustomers(){
return cs.getAllCustomers();
}


@RequestMapping(value="/getAllCustomers",method=RequestMethod.POST)
public @ResponseBody List<Customer> getAllCustomers(){
return cs.getAllCustomers();
}

}



@ResponseBody  => Java ->JSON =>Server-Client
@RequestBody  =>  JSON ->Java =>Client-Server





@RestController => @Controller +@ResponseBody


@RequestMapping("/customers")
@RestController
public class CmsRestController{

@GetMapping
public  List<Customer> getAllCustomers(){
return cs.getAllCustomers();
}


}

            
            
 @RequestMapping(value="/hi",method=RequestMethod.GET)    =>@GetMapping("/hi")                  
 @RequestMapping(value="/hi",method=RequestMethod.POST)   =>@PostMapping("/hi")                
 @RequestMapping(value="/hi",method=RequestMethod.PUT)    =>@PutMapping("/hi")               
 @RequestMapping(value="/hi",method=RequestMethod.DELETE) =>@DelettMapping("/hi")                  
 @RequestMapping(value="/hi",method=RequestMethod.PATCH)  =>@PatchMapping("/hi")                 
  





















