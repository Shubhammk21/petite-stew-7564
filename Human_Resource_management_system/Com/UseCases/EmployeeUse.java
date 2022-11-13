package Com.UseCases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Com.Exceptions.EmployeNotFound;
import Com.HRMS_DAO.EmployeeDAO;
import Com.HRMS_DAO.IntEmployeeDAO;
import Com.Method.Employee;
import Com.Method.Leave;

public class EmployeeUse {
	
	public static void main(String[] args)throws IOException, EmployeNotFound {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		IntEmployeeDAO mm = new EmployeeDAO();
		
		System.out.println("Enter Username");
		String username=in.readLine();
		System.out.println("Enter password");
		String password=in.readLine();
		Employee employee=mm.EmploLogIn(username, password);
		boolean flag=true;
		while(flag) {
			System.out.println("Enter 1 to view profile");
			System.out.println("Enter 2 to Change pasword");
			System.out.println("Enter 3 to Generate Leave request");
			System.out.println("Enter 4 to exit");
			int x=Integer.parseInt(in.readLine());
			System.out.println("=============================================");
			
			switch(x) {
				case 1:
					System.out.println(employee.toString());
					System.out.println("=============================================");
					break;
	
				case 2:
					System.out.println("Enter Username");
					String case2username=in.readLine();
					System.out.println("Enter password");
					String case2password=in.readLine();
					System.out.println("Enter new password");
					String case2newpass = in.readLine();
					System.out.println(mm.updatepass(case2newpass, case2username, case2password));
					System.out.println("=============================================");
					break;
					
				case 3:
					int empid = employee.getId();
					String name = employee.getName();
					int departmentId = employee.getdID();
					System.out.println("Enter Days");
					int duration = Integer.parseInt(in.readLine());
					System.out.println("Enter start date in the format of yyyy-mm-dd");
					String startDate = in.readLine();
					//String leaveReq="Pending";
					Leave lev=new Leave();
					lev.setId(empid);
					lev.setName(name);
					lev.setDepartmentId(departmentId);
					lev.setDuration(duration);
					lev.setStartDate(startDate);
					//mm.updateLevCol(empid);
					System.out.println(mm.leaveReq(lev));
					System.out.println("=============================================");
					break;
					
				case 4:
					System.out.println("Thank You");
					flag=false;
					break;
					
				default :
					System.out.println("something wrong try again");
					System.out.println("=============================================");
					break;
					
			}
				
			
		}
		//System.out.println();
	}

}
