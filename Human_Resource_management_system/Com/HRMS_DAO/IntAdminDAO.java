
package Com.HRMS_DAO;

import java.util.List;

import Com.Exceptions.AdminException;
import Com.Exceptions.EmployeNotFound;
import Com.Method.Admin;
import Com.Method.Department;
import Com.Method.Employee;
import Com.Method.Leave;

public interface IntAdminDAO {
	
	public String AdimnLogIn(String username,String password)throws AdminException;
	public String insertEmpl(Employee employee);
	public String updateDepart(String depart, int dID, String value);//case4
	public String insertDepart(Department depart);//case3
	public String transDapart(int id, int newDId);//case2
	public String leaveReq(int id,String ans);//case7
	public List appliedLeaveList(String table,String asen,String colum) throws AdminException;//case5arr
	public String updatepass(String newpassword,String username,String password)throws AdminException;
	public String addAdmin(Admin admin) throws AdminException;
}
