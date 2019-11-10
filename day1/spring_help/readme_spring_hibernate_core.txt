1.Create Java SE project

2. Add external jars (share_data\additional_help\hibernate4.1_jars) + jdbc driver jar.

3. Create database properties file & store it under run-time class path(either directly under src or under source folder -- resources ) --consists of ---driver class name,db url, user name & password.(key & value pairs)
eg --- db.properties

jdbc.driver=oracle.jdbc.OracleDriver
jdbc.url=jdbc:oracle:thin:@localhost:1521:orcl
jdbc.username=scott
jdbc.password=tiger

4. Create separate hibernate-persistence.xml (under <reosurces>  -- add bean,context,p,tx namespaces to  xml configuration file

4.1 Supply location details of the db property file.

<context:property-placeholder location="classpath:/db.properties" />

4.2 Create connection pool based (supplied by apache 's commons pooling jar) Data Source bean.

	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"
		p:driverClassName="${jdbc.driver}" p:url="${jdbc.url}" p:username="${jdbc.username}"
		p:password="${jdbc.password}" p:initialSize="1" p:maxActive="2"
		destroy-method="close">
	</bean>

4.3 Create Hibernate's SessionFactory bean by injecting ----
1. dataSource property(created in earlier step)
2. annotatedClasses -- list of POJOs or packagesToScan
3. hibernateProperties --- to set db dialect,show_sql,hbm2ddl.auto

	<bean id="sessionFactory"
		class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<property name="annotatedClasses">
			<list>
				<value>demo.domain.Person</value>
			</list>
		</property>
		<property name="hibernateProperties">
			<value>
			hibernate.dialect=org.hibernate.dialect.Oracle10gDialect
				hibernate.format_sql=true
				hibernate.show_sql=true
				hibernate.hbm2ddl.auto=update
			</value>
		</property>
	</bean>



5. Create main spring-config xml -- under run time class path
 Add tags -- context:annotation-config,context:component-scan & import hibernate-persistence config file.

6.
To enable annotated transaction supprt(spring container managed txs)
<tx:annotation-driven/>


7. Declare transaction mgr bean by injecting session factory bean ref into it.
<bean id="transactionManager" 		class="org.springframework.orm.hibernate4.HibernateTransactionManager">
<property name="sessionFactory" ref="sessionFactory" />
</bean>



This finishes config steps

8. Identify persistence requirements -- create annotated pojos or use rev eng to generate it.(class level annotation --- @Entity)

9. Create DAO layer i/f & add implementation class -- annotate DAO layer with @Repository annotation.

Inject (using @AutoWired or @Resource) , hib's session factory into DAO impl bean.

Just as in case of JPA based DAO(SLSB/SFSB facade) , simply use ready made session factory instance to --- get current session --- use Session api for CRUD(eg --- createQuery,save,update,delete )

10. Create Service layer (optional but recommended --- since u can keep tx management dtls separate from DAO layer)
Create service i/f & its implementation class. -- annotated with @Service class level annotation. 
This layer simply invokes DAO layer methods

Additional method level annotation --- org.springframework.transaction.annotation.Transactional
@Transactional ---  can supply follwoing attributes 
--- readonly sts,tx propagation,isolation,timeout,rollback rules etc.

11. Create Tester layer(main() based or unit test based)
Load application context , retrieve service bean & invoke B.L


