package team.hotel.bean;

/*
 * ��ϵͳʹ����
 * 0�����û�
 * 1�߼�����Ա������ ������ȸ߼�ְ����
 * 2��ͨ����Ա��һ���ְ�������磺���þ���
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
