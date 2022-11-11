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
	public Employee EmploLogIn(String username, String password) throws EmployeNotFound{
		Employee em=null;
		String massage = "LogIn Unsuscessfull";
		
		try (Connection conn = DBUtil.provideConn()){
			
			PreparedStatement pr = conn.prepareStatement("Select from Employee Where username=? and password=?");
			pr.setString(1,username);
			pr.setString(2, password);
			ResultSet rs=pr.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("EmployeeId");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("Email");
				String address = rs.getString("address");
				long number = rs.getLong("Phone_number");
				int salary = rs.getInt("salary");
				int did = rs.getInt("departmentid");
				String user = rs.getString("username");
				String pass = rs.getString("password");
				String workingStatus = rs.getString("workingStatus");
				String leaveRequest = rs.getString("leave_request");
				String joiningDate = rs.getString("joining_date");
				
				massage = "Wlecome "+name;
				
				em = new Employee(id,name,age,email,address,number,salary,did,user,pass,workingStatus,leaveRequest,joiningDate);
				System.out.println(massage);
				
			}else {
				throw new EmployeNotFound("Incorrect Username or Password");
			}
			
			
		} catch (SQLException e) {
			throw new EmployeNotFound(e.getMessage());
		}
		return em;
	}

//	@Override
//	public Employee viewProfile() throws EmployeNotFound {
//		
//		Employee=null;
//		
//		try {
//			Employee em=EmployeeDAO.EmploLogIn()
////			else {
////				throw new EmployeNotFound("Something Wrong Try again");
////			}
//			
//		} catch (SQLException e) {
//			throw new EmployeNotFound(e.getMessage());
//		}
//		
//		return null;
//	}

	@Override
	public String updatepass(String newpassword,String username,String password) throws EmployeNotFound {
		String massage="Please something wrong please try again";
		
		try(Connection conn=DBUtil.provideConn()){
			
			PreparedStatement pr = conn.prepareStatement("Update Employes set Password=? where username=? and password=? and password != ?");
			pr.setString(1, newpassword);
			pr.setString(2, username);
			pr.setString(3, password);
			pr.setString(4, newpassword);
			
			int x = pr.executeUpdate();
			
			if(x>0) {
				massage="Password Changes";
			}
			else {
				throw new EmployeNotFound("Invaild");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new EmployeNotFound(e.getMessage());
		}
		
		
		return massage;
	}

	@Override
	public String leaveReq(Leave leave)throws EmployeNotFound {
		String massage="Something Wrong";
		
		try(Connection conn=DBUtil.provideConn()){
			
			PreparedStatement pr = conn.prepareStatement("insert into leaves value(?,?,?,?,?,?,?)");
			pr.setInt(1,leave.getId());
			pr.setString(2,leave.getName());
			pr.setInt(3,leave.getDepartmentId());
			pr.setInt(4,leave.getDuration());
			pr.setString(5,leave.getStartDate());
			pr.setString(6,leave.getEndDate());
			pr.setString(7,"Pending");
			int x = pr.executeUpdate();
			
			if(x>0) {
				
				PreparedStatement pr2 = conn.prepareStatement("Update Employes set leave_request=Pending");
				pr2.executeUpdate();
				massage="Request Generated please wait for conformation";
			}
			else {
				throw new EmployeNotFound("Already appied wait until admin approve");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new EmployeNotFound(e.getMessage());
		}
		
		
		return massage;
	}

}
