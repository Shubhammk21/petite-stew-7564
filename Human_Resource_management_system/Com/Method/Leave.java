package Com.Method;

public class Leave {
	private int id;
	private String name;
	private int departmentId;
	private int duration;
	private String startDate;
	private String endDate;
	private String leaveReq;
	
	
	public Leave() {
		
	}
	
	public Leave(int id, String name, int departmentId, int duration, String startDate, String endDate,
			String leaveReq) {
		super();
		this.id = id;
		this.name = name;
		this.departmentId = departmentId;
		this.duration = duration;
		this.startDate = startDate;
		this.endDate = endDate;
		this.leaveReq = leaveReq;
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

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getLeaveReq() {
		return leaveReq;
	}

	public void setLeaveReq(String leaveReq) {
		this.leaveReq = leaveReq;
	}

	@Override
	public String toString() {
		return "Leave [id=" + id + ", name=" + name + ", departmentId=" + departmentId + ", duration=" + duration
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", leaveReq=" + leaveReq + "]";
	}
	
}
