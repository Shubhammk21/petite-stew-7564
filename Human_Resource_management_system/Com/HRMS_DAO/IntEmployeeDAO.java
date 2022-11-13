package Com.HRMS_DAO;
import java.util.List;

import Com.Exceptions.EmployeNotFound;
import Com.Method.Employee;
import Com.Method.Leave;

public interface IntEmployeeDAO {
	
	public Employee EmploLogIn(String username,String password)throws EmployeNotFound; 
	//public List<Employee> viewProfile() throws EmployeNotFound;
	public String updatepass(String newpassword,String username,String password)throws EmployeNotFound;
	public String leaveReq(Leave leave) throws EmployeNotFound;
	//public void updateLevCol(int id) throws EmployeNotFound;
}
