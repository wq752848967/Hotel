package team.hotel.bean;

/*
 * 该系统使用者
 * 0超级用户
 * 1高级管理员（例如 ：经理等高级职工）
 * 2普通管理员（一般的职工，比如：大堂经理）
 * 
 * */
public class Admin {

	private int id;
	private int adminType;
	private String adminName = null;
	private String password =  null;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAdminType() {
		return adminType;
	}
	public void setAdminType(int adminType) {
		this.adminType = adminType;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
