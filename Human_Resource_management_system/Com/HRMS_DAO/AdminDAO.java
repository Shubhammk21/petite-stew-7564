package Com.HRMS_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Com.Exceptions.AdminException;
import Com.Method.Admin;
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
			pr.setInt(7, employee.getdID());
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
			PreparedStatement pr = conn.prepareStatement("update department set "+ depart+"=? where departmentId = ?");
			//pr.setString(1,depart);
			pr.setString(1, value);
			pr.setInt(2, dId);
			
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
		
			pr.setInt(1, newDId);
			pr.setInt(2, id);
			
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
	public List appliedLeaveList(String table,String asen, String colum) throws AdminException {
		List<Employee> arr = new ArrayList<>();
		List<Leave> arr2 = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConn()){
			PreparedStatement pr = conn.prepareStatement("Select * from "+table+" order by "+colum+" "+asen);
//			pr.setString(1, table);
//			pr.setString(2, asen);
//			pr.setString(3, colum);
			
			ResultSet rs = pr.executeQuery();
			
			if(table=="Employes") {
				boolean flag = true;
				
				while(rs.next()) {
					flag = false;
		
					int id = rs.getInt("Employesid");
					String name = rs.getString("name");
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
				if(flag) {
					throw new AdminException("No Data there");
				}
				
				return arr;
			}
			else if(table=="Leaves") {
				boolean flag = true;
				
				while(rs.next()) {
					flag = false;
					
					int id = rs.getInt("Employesid");
					String name = rs.getString("name");
					int did = rs.getInt("departmentid");
					int dura = rs.getInt("duration");
					String start = rs.getString("startdate");
					String wstatus = rs.getString("enddate");
					String lreq = rs.getString("leave_request");
					arr2.add(new Leave(id,name,
							did,dura,start,wstatus,lreq));
				}
				
				if(flag) {
					throw new AdminException("No Data there");
				}
				
				//System.out.println("arr2");
				return arr2;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage());
		}
		
		return arr;
	}

	@Override
	public String AdimnLogIn(String username, String password) throws AdminException {
		String massage = "Incorrect Username or Password try again";
		//Admin admin=n
		
		try (Connection conn = DBUtil.provideConn()){

			PreparedStatement pr = conn.prepareStatement("Select * from admin Where username=? and password=?");
			pr.setString(1,username);
			pr.setString(2, password);
			ResultSet x = pr.executeQuery();
			
			if(x.next()) {
				String name = x.getString("name");
				String post = x.getString("post");
				massage = "Welcome Sir "+name+" "+post;
			}
			else {
				throw new AdminException("Incorrect Username or Password try again");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage());
		}
		
		return massage;
	}

	@Override
	public String updatepass(String newpassword, String username, String password) throws AdminException {
		
		String massage="Please something wrong please try again";
		
		try(Connection conn=DBUtil.provideConn()){
			
			PreparedStatement pr = conn.prepareStatement("Update Admin set Password=? where username=? and password=? and password != ?");
			pr.setString(1, newpassword);
			pr.setString(2, username);
			pr.setString(3, password);
			pr.setString(4, newpassword);
			
			int x = pr.executeUpdate();
			
			if(x>0) {
				massage="Password Changes";
			}
			else {
				throw new AdminException("Invaild");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage());
		}
		
		
		return massage;
	}

	@Override
	public String addAdmin(Admin admin) throws AdminException {
		String massage = "Something wrong try again";
		
		try(Connection conn=DBUtil.provideConn()){
			
			PreparedStatement pr = conn.prepareStatement("Insert into Admin(name,post,username,password) values (?,?,?,?)");
			pr.setString(1, admin.getName());
			pr.setString(2, admin.getPost());
			pr.setString(3, admin.getUsername());
			pr.setString(4, admin.getPassword());
			
			int x = pr.executeUpdate();
			
			if(x>0) {
				massage="New Admin Added Suscessfully";
			}
			else {
				throw new AdminException("Invaild");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage());
		}
		
		
		return massage;
	}
	
}
