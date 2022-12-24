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
	
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		IntEmployeeDAO mm = new EmployeeDAO();
		System.out.println("☻-------------------------------------☻");
		System.out.println("Enter Username");
		String username=in.readLine();
		System.out.println("☻-------------------------------------☻");
		System.out.println("Enter password");
		String password=in.readLine();
		System.out.println("☻-------------------------------------☻");
		Employee employee=null;
		try {
			employee = mm.EmploLogIn(username, password);
		} catch (EmployeNotFound e1) {
			e1.printStackTrace();
		}
		boolean flag=true;
		while(flag) {
			System.out.println("☻-------------------------------------☻");
			System.out.println("|   Enter 1 to view profile.          |");
			System.out.println("☻-------------------------------------☻");
			System.out.println("|   Enter 2 to Change pasword.        |");
			System.out.println("☻-------------------------------------☻");
			System.out.println("|   Enter 3 to Generate Leave request.|");
			System.out.println("☻-------------------------------------☻");
			System.out.println("|   Enter 4 to exit.                  |");
			System.out.println("☻-------------------------------------☻");
			
			System.out.println("+------+");
			int x = Integer.parseInt(in.readLine());
			System.out.println("+------+");
			
			switch(x) {
				case 1:
					System.out.println("☻-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------☻");
					System.out.println(employee.toString());
					System.out.println("☻-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------☻");
					System.out.println("===============================================================");
					break;
	
				case 2:
					System.out.println("☻-------------------------------------☻");
					System.out.println("   Enter Username");
					String case2username=in.readLine();
					System.out.println("☻-------------------------------------☻");
					System.out.println("   Enter password");
					String case2password=in.readLine();
					System.out.println("☻-------------------------------------☻");
					System.out.println("   Enter new password");
					String case2newpass = in.readLine();
					System.out.println("☻-------------------------------------☻");
				try {
					
					// there we call method in classes of Dao package  and printing its output.
					
					System.out.println("|   "+mm.updatepass(case2newpass, case2username, case2password)+"                 |");
					System.out.println("☻-------------------------------------☻");
				} catch (EmployeNotFound e) {
					e.printStackTrace();
				}
					System.out.println("================================================================");
					break;
					
				case 3:
					int empid = employee.getId();
					String name = employee.getName();
					int departmentId = employee.getdID();
					System.out.println("☻---------------------------------------------☻");
					System.out.println("| Enter Days |");
					int duration = Integer.parseInt(in.readLine());
					System.out.println("☻----------------------------------------------☻");
					System.out.println("| Enter start date in the format of yyyy-mm-dd |");
					String startDate = in.readLine();
					Leave lev=new Leave();
					lev.setId(empid);
					lev.setName(name);
					lev.setDepartmentId(departmentId);
					lev.setDuration(duration);
					lev.setStartDate(startDate);
					
				try {
					
					// there we call method in classes of Dao package  and printing its output.
					
					System.out.println("☻------------------------------------------------☻");
					System.out.println("|   "+mm.leaveReq(lev)+" |");
					System.out.println("☻------------------------------------------------☻");
				} catch (EmployeNotFound e) {
					System.out.println(e.getMessage());
				}
				System.out.println("================================================================");
					break;
					
				case 4:
					System.out.println("☻ Thank You ☻");
					flag=false;
					break;
					
				default :
					System.out.println("☻ Something wrong try again ☻");
					System.out.println("================================================================");
					break;
					
			}
				
			
		}
	}

}
