package org.prac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.prac.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeJdbcTemplate implements EmployeeDao {
		
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	private class EmployeeMapper implements RowMapper<Employee>{

		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Employee.EmployeeBuilder()
					.setId(rs.getString("id"))
					.setfName(rs.getString("fName"))
					.setlName(rs.getString("lName"))
					.setPhoneNum(rs.getString("phoneNum"))
					.setRole(rs.getString("role"))
					.build();
		}
		
	}
	
	public void setDataSource(DataSource dataSource){
		this.dataSource=dataSource;
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}

	public List<Employee> getEmployees() {
		String sql="SELECT * FROM Employee";
		return this.jdbcTemplate.query(sql, new EmployeeMapper());
	}

	public Employee getEmployee(String id) {
		String sql="SELECT * FROM Employee WHERE id=?";
		return this.jdbcTemplate.queryForObject(sql, new EmployeeMapper(), id);
	}
	
	public void createEmployee(Employee employee) {
		String sql="INSERT INTO Employee (id, fName, lName, role, phoneNum) "
				+ "VALUES (?, ?, ?, ?, ?)";
		try {
			this.jdbcTemplate.update(sql, 
					employee.getId(),
					employee.getfName(),
					employee.getlName(),
					employee.getRole(),
					employee.getPhoneNum());
		}catch(NullPointerException e) {
			System.out.println("------------------------------hey--------------------------------------");
			e.printStackTrace();
		}
		
		
	}

	public void updateEmployee(Employee employee) {
		String sql="UPDATE Employee "
				+ "SET id=?, fName=?, lName=?, role=?, phoneNum=? "
				+ "WHERE id=?";
		this.jdbcTemplate.update(sql, 
				employee.getId(),
				employee.getfName(),
				employee.getlName(),
				employee.getRole(),
				employee.getPhoneNum(),
				employee.getId());	
	}

	public void deleteEmployee(String id) {
		String sql="Delete from Employee where id=?";
		this.jdbcTemplate.update(sql, id);
	}

}
