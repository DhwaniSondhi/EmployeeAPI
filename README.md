# Employee Rest API
This API was developed to experiment with [rest-service](https://spring.io/guides/gs/rest-service/) and [JdbcTemplate](https://www.baeldung.com/spring-jdbc-jdbctemplate) in spring. It uses an XML-based configuration. It allows us to create, update, delete an employee, and get the information of a specific or all the employees using the data stored in MySQL. 
It has an embedded Tomcat configured in [pom.xml](https://github.com/DhwaniSondhi/EmployeeAPI/blob/master/pom.xml) and is tested using [Postman](https://www.postman.com/).

## Prerequisites
- Java 8
- Eclipse IDE
- GIT
- Maven Plugin
- MySQL
- Postman

## How to run?
- Download/Clone the project from git.
- In MySQL, create a database named "practice" or change the URL in [front-servlet.xml](https://github.com/DhwaniSondhi/EmployeeAPI/blob/master/src/main/webapp/WEB-INF/front-servlet.xml).
- In the database, create a table with the command given in [createTable.txt](https://github.com/DhwaniSondhi/EmployeeAPI/blob/master/createTable.txt).
- Open the terminal.
- Use <code>mvn package cargo:run</code> to run the project.
- Open Postman and use the following commands to get, post, put, and delete an employee:<br/>
  1. To get the information of all the employees- <code>GET: http://localhost:8080/EmployeeApp/getEmployees</code>
  2. To get the information of a specific employee- <code>GET: http://localhost:8080/EmployeeApp/getEmployee/{employeeId}</code>
  3. To create an employee(give the employee JSON object in the body)- <code>POST: http://localhost:8080/EmployeeApp/createEmployee</code>
  4. To update an employee(give the employee JSON object in the body)- <code>PUT: http://localhost:8080/EmployeeApp/updateEmployee/{employeeId}</code>
  5. To delete an employee- <code>DELETE: http://localhost:8080/EmployeeApp/deleteEmployee/{employeeId}</code>
