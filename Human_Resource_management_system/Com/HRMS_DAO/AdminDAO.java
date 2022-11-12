package Com.HRMS_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Com.Method.Department;
import Com.Method.Employee;
import Com.Method.Leave;
import Com.Utility.DBUtil;

public class AdminDAO implements IntAdminDAO {

	@Override
	public String insertEmpl(Employee employee) {
		String massage = "Insert Employes unsuscessful";
		
		try (Connection conn = DBUtil.provideConn()){
			PreparedStatement pr = conn.prepareStatement("insert into Employes(name, age, email, address, Phone_number, salary, departmentid, username, password, working_status, leave_request, joining_date) "
					+ "value(?,?,?,?,?,?,?,?,?,?,?,?)");
			pr.setString(1, employee.getName());
			pr.setInt(2, employee.getAge());
			pr.setString(3, employee.getEmail());
			pr.setString(4, employee.getAddress());
			pr.setLong(5, employee.getNumber());
			pr.setInt(6, employee.getSalary());
			pr.setInt(7, employee.getDname());
			pr.setString(8, employee.getUsername());
			pr.setString(9, employee.getPassword());
			pr.setString(10, employee.getWorkingStatus());
			pr.setString(11, employee.getLeaveRequest());
			pr.setString(12, employee.getJoiningDate());
	
			int x = pr.executeUpdate();
			if(x>0) {
				massage="Insert Suscessfull";
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return massage;
	}

	@Override
	public String updateDepart(String depart, int dId, String value) {
		String massage="Update data falied";
		
		try (Connection conn = DBUtil.provideConn()){
			PreparedStatement pr = conn.prepareStatement("update department set ? = ? where DepartmentId = ?");
			pr.setString(1,depart);
			pr.setString(2, value);
			pr.setInt(3, dId);
			
			int x = pr.executeUpdate();
			if(x>0) {
				massage="Update Suscessfull";
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return massage;
	}

	@Override
	public String insertDepart(Department depart) {
		String massage = "Insert in Department fail";

		try (Connection conn = DBUtil.provideConn()){
			PreparedStatement pr = conn.prepareStatement("insert into Department value(?,?,?)");
			pr.setInt(1, depart.getDid());
			pr.setString(2, depart.getDname());
			pr.setString(3, depart.getLocation());
			
			int x = pr.executeUpdate();
			if(x>0) {
				massage="Insert Suscessfull";
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return massage;
	}

	@Override
	public String transDapart(int id, int newDId) {
		String massage = "Something Wrong try again";
		
		try (Connection conn = DBUtil.provideConn()){
			PreparedStatement pr = conn.prepareStatement("update Employes set departmentId=? where employesid=?");
			
			pr.setInt(1, id);
			pr.setInt(2, newDId);
			
			int x = pr.executeUpdate();
			if(x>0) {
				massage = "Transfering Suscessfull";
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return massage;
	}

	@Override
	public String leaveReq(int id, String ans) {
		String massage = "Something wrong try again";
		try (Connection conn = DBUtil.provideConn()){
			PreparedStatement pr = conn.prepareStatement("update employes inner join leaves on employes.employesid=leaves.employesid "
					+ "set employes.leave_request=?,leaves.leave_request=? where employes.employesid=?");
			pr.setString(1, ans);
			pr.setString(2, ans);
			pr.setInt(3, id);
			
			int x = pr.executeUpdate();
			if(x>0) {
				massage="Response Submit Suscessfull";
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return massage;
	}

	@Override
	public List appliedLeaveList(String table,String asen, String colum) {
		List<Employee> arr = new ArrayList<>();
		List<Leave> arr2 = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConn()){
			PreparedStatement pr = conn.prepareStatement("Select * from ? order by ? ?");
			pr.setString(1, table);
			pr.setString(2, asen);
			pr.setString(3, colum);
			
			ResultSet rs = pr.executeQuery();
			
			if(table=="employes") {
				while(rs.next()) {
				
					int id = rs.getInt("Employesid");
					String name = rs.getString(1, em);
					int age = rs.getInt("age");
					String email = rs.getString("email");
					String address = rs.getString("address");
					long phone = rs.getLong("Phone_number");
					int salary = rs.getInt("salary");
					int did = rs.getInt("departmentid");
					String user = rs.getString("username");
					String pass = rs.getString("password");
					String wstatus = rs.getString("working_status");
					String lreq = rs.getString("leave_request");
					String jdate = rs.getString("joining_date");
					arr.add(new Employee(id,name,age,email,address,phone,salary,
							did,user,pass,wstatus,lreq,jdate));
				}
				return arr;
			}
			else if(table=="leaves") {
				while(rs.next()) {
					
					int id = rs.getInt("Employesid");
					String name = rs.getString(1, em);
					int age = rs.getInt("age");
					String email = rs.getString("email");
					String address = rs.getString("address");
					long phone = rs.getLong("Phone_number");
					int salary = rs.getInt("salary");
					int did = rs.getInt("departmentid");
					String user = rs.getString("username");
					String pass = rs.getString("password");
					String wstatus = rs.getString("working_status");
					String lreq = rs.getString("leave_request");
					String jdate = rs.getString("joining_date");
					arr.add(new Employee(id,name,age,email,address,phone,salary,
							did,user,pass,wstatus,lreq,jdate));
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return arr;
	}

}
