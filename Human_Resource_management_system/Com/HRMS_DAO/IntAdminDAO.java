package Com.HRMS_DAO;

import java.util.List;

import Com.Exceptions.AdminException;
import Com.Method.Department;
import Com.Method.Employee;
import Com.Method.Leave;

public interface IntAdminDAO {
	
	public String AdimnLogIn(String username,String password)throws AdminException;
	public String insertEmpl(Employee employee);
	public String updateDepart(String depart, int dID, String value);
	public String insertDepart(Department depart);
	public String transDapart(int id, int newDId);
	public String leaveReq(int id,String ans);
	public List appliedLeaveList(String table,String asen,String colum);
}
