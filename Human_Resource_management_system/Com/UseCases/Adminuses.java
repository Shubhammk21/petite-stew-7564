package Com.UseCases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import Com.Exceptions.AdminException;
import Com.HRMS_DAO.AdminDAO;
import Com.HRMS_DAO.IntAdminDAO;
import Com.Method.Admin;
import Com.Method.Department;
import Com.Method.Employee;
import Com.Method.Leave;


public class Adminuses {

	public static void main(String[] args)throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		IntAdminDAO admin = new AdminDAO();
		System.out.println("☻-------------------------------------☻");
		System.out.println("Enter Username");
		String username= in.readLine();
		System.out.println("☻-------------------------------------☻");
		System.out.println("Enter password");
		String password= in.readLine();
		System.out.println("☻-------------------------------------☻");
		
		String log= "";
		try {
			log = admin.AdimnLogIn(username, password);
		} catch (AdminException e1) {
			e1.printStackTrace();
		}
		System.out.println("|   "+log+"      |");
		
		if(!log.isEmpty()) {
			boolean flaggg = true;
			while(flaggg){
				System.out.println("☻-------------------------------------☻");
				System.out.println("|    1⇒ Insert new Employee           |");
				System.out.println("☻-------------------------------------☻");
				System.out.println("|   2⇒ Transfer Employee Department   |");
				System.out.println("☻-------------------------------------☻");
				System.out.println("|   3⇒ Create new Department          |");
				System.out.println("☻-------------------------------------☻");
				System.out.println("|   4⇒ Update Department Data         |");
				System.out.println("☻-------------------------------------☻");
				System.out.println("|   5⇒ View Leaves Request            |");
				System.out.println("☻-------------------------------------☻");
				System.out.println("|   6⇒ View Employes List             |");
				System.out.println("☻-------------------------------------☻");
				System.out.println("|   7⇒ Action on Leave Requests       |");
				System.out.println("☻-------------------------------------☻");
				System.out.println("|   8⇒ Change password                |");
				System.out.println("☻-------------------------------------☻");
				System.out.println("|   9⇒ Add new Admin                  |");
				System.out.println("☻-------------------------------------☻");
				System.out.println("|   10⇒ Exit                          |");
				System.out.println("☻-------------------------------------☻");
				System.out.println("+------+");
				int x = Integer.parseInt(in.readLine());
				System.out.println("+------+");
				
				switch(x) {
				
					case 1:
						System.out.println("Enter How much employes Add");
						int n = Integer.parseInt(in.readLine());
						System.out.println("☻-------------------------------------☻");
						
						for(int i=1; i<=n; i++) {
							Employee e = new Employee();
							System.out.println("|   Employee Number: "+i);
							System.out.println("☻-------------------------------------☻");
							
							System.out.println("Enter Name of Employee");
							String name = in.readLine();
							e.setName(name);
							System.out.println("☻-------------------------------------☻");
							
							System.out.println("Enter Age of Employee");
							int age = Integer.parseInt(in.readLine());
							e.setAge(age);
							System.out.println("☻-------------------------------------☻");
							
							System.out.println("Enter Email of Employee");
							String email = in.readLine();
							e.setEmail(email);
							System.out.println("☻-------------------------------------☻");
							
							System.out.println("Enter Address of Employee");
							String address = in.readLine();
							e.setAddress(address);
							System.out.println("☻-------------------------------------☻");
							
							System.out.println("Enter Contact Number of Employee");
							long number = Long.parseLong(in.readLine());
							e.setNumber(number);
							System.out.println("☻-------------------------------------☻");
							
							System.out.println("Enter Salary of Employee");
							int salary = Integer.parseInt(in.readLine());
							e.setSalary(salary);
							System.out.println("☻-------------------------------------☻");
							
							System.out.println("Enter Department ID of Employee");
							int dID = Integer.parseInt(in.readLine());
							e.setdID(dID);
							System.out.println("☻-------------------------------------☻");
							
							System.out.println("Enter Username of Employee");
							String c1username = in.readLine();
							e.setUsername(c1username);
							System.out.println("☻-------------------------------------☻");
							
							System.out.println("Enter Password of Employee");
							String c1password = in.readLine();
							e.setPassword(c1password);
							System.out.println("☻-------------------------------------☻");
							
							System.out.println("Enter Working Status of Employee");
							String workingStatus = in.readLine();
							e.setWorkingStatus(workingStatus);
							System.out.println("☻-------------------------------------☻");
							
							System.out.println("Enter Joining Date of Employee in yyy-mm-dd format");
							String joiningDate = in.readLine();
							e.setJoiningDate(joiningDate);
							
							System.out.println("========================================");
							
							System.out.println(e.toString());
							
							System.out.println("========================================");
							
							System.out.println("Enter 1 To Confirm Details");
							System.out.println("☻-------------------------------------☻");
							System.out.println("Enter 2 Re Enter Employee");
							int confirm = Integer.parseInt(in.readLine());
							
							if(confirm == 1) {
								try {
									System.out.println(admin.insertEmpl(e));
								} catch (AdminException e1) {
									e1.printStackTrace();
								}
							}else if(confirm==2){
								i=i-1;
							}
							System.out.println("========================================");
							
						}
						break;
						
					case 2:
						
						System.out.println("Enter Employee ID");
						int c2id = Integer.parseInt(in.readLine());
						System.out.println("☻-------------------------------------☻");
						
						System.out.println("Enter New DepartmentID");
						int c2did = Integer.parseInt(in.readLine());
						System.out.println("☻-------------------------------------☻");
						
						
					try {
						System.out.println(admin.transDapart(c2id, c2did));
					} catch (AdminException e3) {
						e3.printStackTrace();
					}
						
						System.out.println("=============================================");
						break;
						
					case 3:
						
						System.out.println("Enter new Department Id");
						int c3id = Integer.parseInt(in.readLine());
						System.out.println("☻-------------------------------------☻");
						
						System.out.println("Enter new Department Name");
						String c3name = in.readLine();
						System.out.println("☻-------------------------------------☻");
						
						System.out.println("Enter new Department Location");
						String c3location = in.readLine();
						System.out.println("☻-------------------------------------☻");
						
						Department depart = new Department(c3id,c3name,c3location);
						
					try {
						System.out.println(admin.insertDepart(depart));
					} catch (AdminException e2) {
						e2.printStackTrace();
					}
						
						System.out.println("=============================================");
						break;
		
					case 4:
						
						System.out.println("Enter Department ID");
						int c4id = Integer.parseInt(in.readLine());
						System.out.println("☻-------------------------------------☻");
						
						System.out.println("Enter Which colum to update");
						System.out.println("|-------------------------------------|");
						
						System.out.println("|   1 .Department ID                  |");
						System.out.println("☻-------------------------------------☻");
						System.out.println("|   2 .Department Name                |");
						System.out.println("☻-------------------------------------☻");
						System.out.println("|   3 .Department Location            |");
						System.out.println("☻-------------------------------------☻");
						System.out.println("+------+");
						int updatec = Integer.parseInt(in.readLine());
						System.out.println("+------+");
						
						
						String c4value = "";
						switch(updatec) {
							
							case 1:
								c4value = "departmentId";
								break;
								
							case 2:
								c4value = "department_name";
								break;
								
							case 3:
								c4value = "location";
								break;
								
							default :
								System.out.println("Invaild input");
								continue;
						}
						
						System.out.println("Enter Update Value");
						String case4depart = in.readLine();
						System.out.println("☻-------------------------------------☻");
						
					try {
						System.out.println(admin.updateDepart(c4value, c4id, case4depart));
					} catch (AdminException e1) {
						e1.printStackTrace();
					}
						System.out.println("=============================================");
						break;
						
					case 5:
						
						System.out.println("☻-------------------------------------☻");
						System.out.println("|   1 .Direct View Leaves List        |");
						System.out.println("☻-------------------------------------☻");
						System.out.println("|   2 .View in Sorting order          |");
						System.out.println("☻-------------------------------------☻");
						System.out.println("+------+");
						int c5n= Integer.parseInt(in.readLine());
						System.out.println("+------+");
						
						String c5table = "Leaves";
						String c5order = "asc";
						String c5colum = "startdate";
						
						List<Leave> arr = new ArrayList<>();
						
						if(c5n==1) {
							
							try {
								arr = admin.appliedLeaveList(c5table,c5order,c5colum);
		
							}catch(AdminException e) {
								e.printStackTrace();
								//System.out.println(e.getMessage());
							}
							
						}
						else if(c5n==2){
							
							System.out.println("☻-------------------------------------☻");
							System.out.println("|   1 .For Start Date                 |");
							System.out.println("☻-------------------------------------☻");
							System.out.println("|   2 .For Duration                   |");
							System.out.println("☻-------------------------------------☻");
							
							System.out.println("+------+");
							int c521 = Integer.parseInt(in.readLine());
							System.out.println("+------+");
							
							if(c521 == 1) {
								c5colum = "startdate";
							}else if(c521 == 2) {
								c5colum = "duration";
							}else {
								System.out.println("Invalid Input");
							}
							
							System.out.println("☻-------------------------------------☻");
							System.out.println("|   1 .For Ascending order            |");
							System.out.println("☻-------------------------------------☻");
							System.out.println("|   2 .For Descending order           |");
							System.out.println("☻-------------------------------------☻");
							
							System.out.println("+------+");
							int c522 = Integer.parseInt(in.readLine());
							System.out.println("+------+");
							
							if(c522 == 1) {
								c5order = "asc";
							}else if(c522 == 2) {
								c5order = "desc";
							}else {
								System.out.println("Invalid Input");
							}
							
							try {
								arr = admin.appliedLeaveList(c5table,c5order,c5colum);
		
							}catch(AdminException e) {
								e.printStackTrace();
								//System.out.println(e.getMessage());
							}
						}
						System.out.println("☻---------------------------------------------------------------------------------------------------☻");
						System.out.println("| Employee id | Name                 | departmentId | duration | startDate  | endDate    | leaveReq |");
						System.out.println("☻---------------------------------------------------------------------------------------------------☻");
						arr.forEach(i -> {
							
							System.out.println(i.toString());
							System.out.println("☻---------------------------------------------------------------------------------------------------☻");
										
						});
						
						System.out.println("=============================================");
						break;
						
					case 6:
						System.out.println("☻-------------------------------------☻");
						System.out.println("|   1 .Direct View Employes List      |");
						System.out.println("☻-------------------------------------☻");
						System.out.println("|   2 .View in Sorting order          |");
						System.out.println("☻-------------------------------------☻");
						
						System.out.println("+------+");
						int c6n= Integer.parseInt(in.readLine());
						System.out.println("+------+");
						
						
						String c6table = "Employes";
						String c6order = "asc";
						String c6colum = "name";
						
						List<Employee> arr2 = new ArrayList<>();
						
						if(c6n==1) {
							
							try {
								arr2 = admin.appliedLeaveList(c6table,c6order,c6colum);
		
							}catch(AdminException e) {
								e.printStackTrace();
								//System.out.println(e.getMessage());
							}
							
						}
						else if(c6n==2){
							
							System.out.println("☻-------------------------------------☻");
							System.out.println("|   1 .For salary                     |");
							System.out.println("☻-------------------------------------☻");
						    System.out.println("|   2 .For Joing Date                 |");
						    System.out.println("☻-------------------------------------☻");
						    
							System.out.println("+------+");
							int c621 = Integer.parseInt(in.readLine());
							System.out.println("+------+");
							
							if(c621 == 1) {
								c6colum = "salary";
							}else if(c621 == 2) {
								c6colum = "joining_date";
							}else {
								System.out.println("Invaild Input");
							}
							
							System.out.println("☻-------------------------------------☻");
							System.out.println("|   1 .For Acending order             |");
							System.out.println("☻-------------------------------------☻");
							System.out.println("|   2 .For Decending order            |");
							System.out.println("☻-------------------------------------☻");
							
							System.out.println("+------+");
							int c622 = Integer.parseInt(in.readLine());
							System.out.println("+------+");
							
							if(c622 == 1) {
								c6order = "asc";
							}else if(c622 == 2) {
								c6order = "desc";
							}else {
								System.out.println("Invaild Input");
							}
							
							try {
								arr2 = admin.appliedLeaveList(c6table,c6order,c6colum);
		
							}catch(AdminException e) {
								e.printStackTrace();
								//System.out.println(e.getMessage());
							}
						}
						
						arr2.forEach(e -> {
							System.out.println("☻---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------☻");
							System.out.println(e.toString());
							System.out.println("☻---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------☻");
							
							
						});
						System.out.println("=============================================");
						break;
						
					case 7:
						
						System.out.println("☻-------------------------------------☻");
						System.out.println("|  Enter Employee ID                  |");
						int c7id = Integer.parseInt(in.readLine());
						
						System.out.println("☻-------------------------------------☻");
						System.out.println("|   1 .For Approve                    |");
						System.out.println("☻-------------------------------------☻");
					    System.out.println("|   2 .decline                        |");
					    System.out.println("☻-------------------------------------☻");
					    
						System.out.println("+------+");
						int c7a = Integer.parseInt(in.readLine());
						System.out.println("+------+");
						
						String c7ans = "";
						
						if(c7a==1) {
							c7ans = "Approve";
						}
						else if(c7a==2) {
							c7ans = "Decline";
						}else {
							System.out.println("Invaild Input Try Again");
						}
						
					try {
						System.out.println("☻-------------------------------------☻");
						System.out.println("|   "+admin.leaveReq(c7id, c7ans)+"   |");
						System.out.println("☻-------------------------------------☻");
					} catch (AdminException e2) {
						e2.printStackTrace();
					}
						System.out.println("=============================================");
						break;
						
					case 8:
						
						System.out.println("☻-------------------------------------☻");
						System.out.println("|   Enter Username                    |");
						String case8username=in.readLine();
						System.out.println("☻-------------------------------------☻");
						System.out.println("|   Enter password                    |");
						String case8password=in.readLine();
						System.out.println("☻-------------------------------------☻");
						System.out.println("|   Enter new password                |");
						String case8newpass = in.readLine();
						System.out.println("☻-------------------------------------☻");
					try {
						System.out.println("|   "+admin.updatepass(case8newpass, case8username, case8password)+"                 |");
						System.out.println("☻-------------------------------------☻");
					} catch (AdminException e1) {
						e1.printStackTrace();
					}
						System.out.println("=============================================");
						break;
						
					case 9:
						
						Admin aa = new Admin();
						System.out.println("☻-------------------------------------☻");
						System.out.println("|   Enter Name of Admin               |");
						String c9name = in.readLine();
						System.out.println("☻-------------------------------------☻");
						aa.setName(c9name);
						
						System.out.println("|   Enter Name of Post                |");
						String c9post = in.readLine();
						System.out.println("☻-------------------------------------☻");
						aa.setPost(c9post);
						
						System.out.println("|   Enter Username of Employee        |");
						String c9username = in.readLine();
						System.out.println("☻-------------------------------------☻");
						aa.setUsername(c9username);
						
						System.out.println("|   Enter Password of Employee        |");
						String c9password = in.readLine();
						System.out.println("☻-------------------------------------☻");
						aa.setPassword(c9password);
						
					try {
						System.out.println("|   "+admin.addAdmin(aa)+"            |");
						System.out.println("☻-------------------------------------☻");
					} catch (AdminException e1) {
						e1.printStackTrace();
					}
						
						System.out.println("=============================================");
						break;
						
					case 10:
						
						System.out.println("☻ Thank You ☻");
						flaggg = false;
						
						break;
						
					default :
						System.out.println("something wrong try again");
						System.out.println("=============================================");
						break;
				
				}
			}
			
			
		}
		
	}

}
