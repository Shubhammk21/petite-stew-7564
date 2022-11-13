package Com.UseCases;

import java.io.BufferedReader;

import java.io.InputStreamReader;


import Com.HRMS_DAO.AdminDAO;
import Com.HRMS_DAO.IntAdminDAO;
import Com.Method.Employee;
import Com.Method.Leave;


public class Adminuses {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		IntAdminDAO admin = new AdminDAO();
		
		System.out.println("Enter Username");
		String username=in.readLine();
		System.out.println("Enter password");
		String password=in.readLine();
		
		String log = admin.AdimnLogIn(username, password);
		System.out.println(log);
		
		if(log != null) {
			boolean flag = true;
			while(flag){
				System.out.println("1 .Insert new Employee");
				System.out.println("2 .Transfer Employee Department");
				System.out.println("3 .Create new Department");
				System.out.println("4 .Update Department Data");
				System.out.println("5 .View Leaves Request");
				System.out.println("6 .Action on Leave Requests");
				System.out.println("7 .Change password");
				System.out.println("8 .Add new Admin");
				System.out.println("8 .Exit");
				
				int x = Integer.parseInt(in.readLine());
				
				switch(x) {
				
					case 1:
						System.out.println("Enter How much employes Add");
						int n = Integer.parseInt(in.readLine());
						
						for(int i=1; i<=n; i++) {
							Employee e = new Employee();
							System.out.println("Employee Number: "+1);
							
							System.out.println("Enter Name of Employee");
							String name = in.readLine();
							e.setName(name);
							
							System.out.println("Enter Age of Employee");
							int age = Integer.parseInt(in.readLine());
							e.setAge(age);
							
							System.out.println("Enter Email of Employee");
							String email = in.readLine();
							e.setEmail(email);
							
							System.out.println("Enter Address of Employee");
							String address = in.readLine();
							e.setAddress(address);
							
							System.out.println("Enter Contact Number of Employee");
							long number = Long.parseLong(in.readLine());
							e.setNumber(number);
							
							System.out.println("Enter Salary of Employee");
							int salary = Integer.parseInt(in.readLine());
							e.setSalary(salary);
							
							System.out.println("Enter Department ID of Employee");
							int dID = Integer.parseInt(in.readLine());
							e.setdID(dID);
							
							System.out.println("Enter Username of Employee");
							String c1username = in.readLine();
							e.setUsername(c1username);
							
							System.out.println("Enter Password of Employee");
							String c1password = in.readLine();
							e.setPassword(c1password);
							
							System.out.println("Enter Working Status of Employee");
							String workingStatus = in.readLine();
							e.setWorkingStatus(workingStatus);
							
							System.out.println("Enter Joining Date of Employee");
							String joiningDate = in.readLine();
							e.setJoiningDate(joiningDate);
//							System.out.println("Enter Name of Employee");
							
							System.out.println("===============================================");
							
							System.out.println(e.toString());
							
							System.out.println("===============================================");
							
							System.out.println("Enter 1 To Confirm Details");
							System.out.println("Enter 2 Re Enter Employee");
							int confirm = Integer.parseInt(in.readLine());
							
							if(confirm == 1) {
								System.out.println(admin.insertEmpl(e));
							}else {
								i=i-1;
							}
							System.out.println("=============================================");
							
						}
						break;
		
					case 2:
//						System.out.println("Enter Username");
//						String case2username=in.readLine();
//						System.out.println("Enter password");
//						String case2password=in.readLine();
//						System.out.println("Enter new password");
//						String case2newpass = in.readLine();
//						System.out.println(mm.updatepass(case2newpass, case2username, case2password));
//						break;
						
					case 3:
//						int empid = employee.getId();
//						String name = employee.getName();
//						int departmentId = employee.getdID();
//						System.out.println("Enter Days");
//						int duration = Integer.parseInt(in.readLine());
//						System.out.println("Enter start date in the format of yyyy-mm-dd");
//						String startDate = in.readLine();
//						//String leaveReq="Pending";
//						Leave lev=new Leave();
//						lev.setId(empid);
//						lev.setName(name);
//						lev.setDepartmentId(departmentId);
//						lev.setDuration(duration);
//						lev.setStartDate(startDate);
//						//mm.updateLevCol(empid);
//						System.out.println(mm.leaveReq(lev));
//						break;
						
					case 4:
//						System.out.println("Thank You");
//						flag=false;
//						break;
						
					default :
						System.out.println("something wrong try again");
						break;
				
				}
			}
			
			
		}
		
	}

}
