package dto;

import java.sql.Date;

public class Staff {

	private String sNo;
	private String name;
	private String dept;
	private Date regDate;
	
	
	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "Staff [sNo=" + sNo + ", name=" + name + ", dept=" + dept + ", regDate=" + regDate + "]";
	}
	
	
	
}
