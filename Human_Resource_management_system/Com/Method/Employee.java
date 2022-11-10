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
	private int dname;
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
		this.dname = dname;
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

	public int getDname() {
		return dname;
	}

	public void setDname(int dname) {
		this.dname = dname;
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
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", email=");
		builder.append(email);
		builder.append(", address=");
		builder.append(address);
		builder.append(", number=");
		builder.append(number);
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", dname=");
		builder.append(dname);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", workingStatus=");
		builder.append(workingStatus);
		builder.append(", leaveRequest=");
		builder.append(leaveRequest);
		builder.append(", joiningDate=");
		builder.append(joiningDate);
		builder.append("]");
		return builder.toString();
	}
}
