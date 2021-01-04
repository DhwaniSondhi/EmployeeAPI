# Employee Rest API
This API was created to learn and practice the basics of [spring-rest-service](https://spring.io/guides/gs/rest-service/). It uses an XML-based configuration.
The API allows to see the information of all employees or a specific one, add, edit, and delete an employee. 
It has an embedded Tomcat configured in [pom.xml](https://github.com/DhwaniSondhi/EmployeeAPI/blob/master/pom.xml).
This API is tested using [Postman](https://www.postman.com/).

## Prerequisites
- Java 8
- Eclipse IDE
- GIT
- Maven Plugin
- Postman

## How to run?
- Download/Clone the project from git.
- Open terminal inside the project location.
- Use <code>mvn package cargo:run</code> to run the project.
- Open Postman and use following commands to get, post, put and delete an employee:<br/>
  1. To get information of all the employees- <code>GET: http://localhost:8080/EmployeeApp/getEmployees</code>
  2. To get information of an employee- <code>GET: http://localhost:8080/EmployeeApp/getEmployee/{employeeId}</code>
  3. To add an employee(give the employee JSON object in body)- <code>POST: http://localhost:8080/EmployeeApp/addEmployee</code>
  4. To edit an employee(give the employee JSON object in body)- <code>PUT: http://localhost:8080/EmployeeApp/editEmployee/{employeeId}</code>
  5. To delete an employee- <code>DELETE: http://localhost:8080/EmployeeApp/deleteEmployee/{employeeId}</code>
