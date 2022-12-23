package Com.Method;
//import javax.management.loading.PrivateClassLoader;

public class Employee {
	private int id;
	private String name;
	private int age;
	private	String email;
	private String address;
	private long number;
	private int salary;
	private int dID;
	private String username;
	private String password;
	private String workingStatus;
	private String leaveRequest;
	private String joiningDate;
	
	public Employee() {
		super();
	}
  
	public Employee(int id, String name, int age, String email, String address, long number, int salary, int dname,
			String username, String password, String workingStatus, String leaveRequest, String joiningDate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.address = address;
		this.number = number;
		this.salary = salary;
		this.dID = dname;
		this.username = username;
		this.password = password;
		this.workingStatus = workingStatus;
		this.leaveRequest = leaveRequest;
		this.joiningDate = joiningDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getdID() {
		return dID;
	}

	public void setdID(int dname) {
		this.dID = dname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWorkingStatus() {
		return workingStatus;
	}

	public void setWorkingStatus(String workingStatus) {
		this.workingStatus = workingStatus;
	}

	public String getLeaveRequest() {
		return leaveRequest;
	}

	public void setLeaveRequest(String leaveRequest) {
		this.leaveRequest = leaveRequest;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "| EmployeeId=" + id + " | name=" + name + " | age=" + age + " | email=" + email + " | address=" + address
				+ " | number=" + number + " | salary=" + salary + " | dID=" + dID + " | username=" + username
				+ " | password=" + password + " | workingStatus=" + workingStatus + " | leaveRequest=" + leaveRequest
				+ " | joiningDate=" + joiningDate + " |";
	}

	
}
