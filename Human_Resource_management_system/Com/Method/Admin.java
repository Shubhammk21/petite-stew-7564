package Com.Method;

public class Admin {
	
	private int id;
	private String name;
	private String post;
	private String username;
	private String password;
	
	
	public Admin() {
		super();
	}


	public Admin(int id, String name, String post, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.post = post;
		this.username = username;
		this.password = password;
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


	public String getPost() {
		return post;
	}


	public void setPost(String post) {
		this.post = post;
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


	@Override
	public String toString() {
		return "Admin"+'\n'+"Admin_Id | name | post | username | password "+'\n'+id;
	
	}
	
	
	
	
	
}
