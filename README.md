# REST-EJB-JPA-CRUD

This repository is just an example on how to create a provider and a client of REST resources as well as invoking them from URL directly or from client application using HTTP protocol. These REST enable us to perform CRUD operations using particular HTTP methods i.e. GET, POST, PUT, and DELETE.

List of URLs (assuming you run it on your local host with wildfly's default port 8080):
1. Return employees data with json format (HTTP Method-> GET): http://localhost:8080/REST-EJB-JPA-1.0-SNAPSHOT/resources/employee/getEmployeesJSON
2. Return employees data with xml format (HTTP Method-> GET): http://localhost:8080/REST-EJB-JPA-1.0-SNAPSHOT/resources/employee/getEmployeesXML
3. Return an employee object with json format (HTTP Method-> GET): http://localhost:8080/REST-EJB-JPA-1.0-SNAPSHOT/resources/employee/getEmployeeByIdJSON/id=?
4. Return an employee object with xml format (HTTP Method-> GET): http://localhost:8080/REST-EJB-JPA-1.0-SNAPSHOT/resources/employee/getEmployeeByIdXML/id=?
5. Add employee (HTTP Method-> POST): http://localhost:8080/REST-EJB-JPA-1.0-SNAPSHOT/resources/employee/addEmployee/name=?/address=?
6. Update employee (HTTP Method-> PUT): http://localhost:8080/REST-EJB-JPA-1.0-SNAPSHOT/resources/employee/updateEmployee/id=?/name=?/address=?
7. Delete employee (HTTP Method-> DELETE): http://localhost:8080/REST-EJB-JPA-1.0-SNAPSHOT/resources/employee/deleteEmployeeById/id=?

Prerequisites:
1. Netbeans 8.1
2. Maven
3. Java EE
4. Java SE
5. EJB 3
6. Hibernate (JPA 2.1)
7. JPQL
8. JAX-RS
9. Wildfly 10.1.0.Final (Make sure you have created the required file and directory for adding MySQL's jdbc driver, configure the datasource name in standalone-full.xml inside your wildfly directory and put the datasource name defined in persistence.xml)
9. MySQL
