package Com.HRMS_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import Com.Exceptions.EmployeNotFound;
import Com.Method.Department;
import Com.Method.Employee;
import Com.Method.Leave;
import Com.Utility.DBUtil;

public class EmployeeDAO implements IntEmployeeDAO{

	@Override
	public String EmploLogIn(String username, String password) throws EmployeNotFound{
		
		String massage = "LogIn Unsuscessfull";
		try (Connection conn = DBUtil.provideConn()){
			
			PreparedStatement pr = conn.prepareStatement("Select from Employee Where username=? and password=?");
			pr.setString(1,username);
			pr.setString(1, password);
			ResultSet rs=pr.executeQuery();
			if(rs.next()) {
				massage = "Wlecome "+rs.getString("name");
			}else {
				throw new EmployeNotFound("Incorrect Username or Password");
			}
			
			
		} catch (SQLException e) {
			throw new EmployeNotFound(e.getMessage());
		}
		return massage;
	}

	@Override
	public List<Employee> viewProfile() throws EmployeNotFound {
		
		List<Employee> arr=new ArrayList<>();
		
		try (Connection conn=DBUtil.provideConn()){
			
			PreparedStatement pr = conn.prepareStatement("Select * from Employee");
			ResultSet rs = pr.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("EmployeeId");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("Email");
				String address = rs.getString("");
				long number = rs.getLong("Phone_number");
				int salary = rs.getInt("salary");
				String dname = rs.getString("department_name");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String workingStatus = rs.getString("workingStatus");
				String leaveRequest = rs.getString("leave_request");
				String joiningDate = rs.getString("joining_date");
				arr.add(new Employee(id, dname, age, email, address, number, salary, dname, username, password, workingStatus, leaveRequest, joiningDate));
			}
			else {
				throw new EmployeNotFound("Something Wrong Try again");
			}
			
		} catch (SQLException e) {
			throw new EmployeNotFound(e.getMessage());
		}
		
		return arr;
	}

	@Override
	public String updatepass(String password) throws EmployeNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String leaveReq(Leave leave) {
		// TODO Auto-generated method stub
		return null;
	}

}
