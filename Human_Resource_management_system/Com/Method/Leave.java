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
		if(name.length()<20) {
			while(name.length()<20) {
				name+=" ";
			}
		}
		String strid= String.valueOf(id);
		if(id<10) {
			strid= "000"+strid;
		}
		else if(id<100 && id>10) {
			strid= "00"+strid;
		}
		if(id<1000 && id>100) {
			strid= "0"+strid;
		}
		
		String strdid= String.valueOf(departmentId);
		if(departmentId<10) {
			strdid= "000"+strdid;
		}
		else if(departmentId<100 && departmentId>10) {
			strdid= "00"+strdid;
		}
		if(departmentId<1000 && departmentId>100) {
			strdid= "0"+strdid;
		}
		String strdura= String.valueOf(duration);
		if(departmentId<10) {
			strdura= "0"+strdura;
		}
		
		
		return "| "+ strid +"        | "+name+" | "+ strdid +"         | "+ strdura +"       | "+startDate+" | "+ endDate +" | "+ leaveReq + "  |";
		          
	}
	
}
