package team.hotel.bean;

/*
 * 顾客
 * 
 */

public class Customer {

	private int id;
	private String cusName = null;
	
	/*
	 * 性别：
	 * 0男 1女  or?
	 * 
	 * */
	private int cusSex;
	/*
	 * 顾客身份证号码或者护照号码
	 * */
	private String cusIDCardNum = null;
	/*
	 * 身份证还是护照办理
	 * */
	private int idType;
	/*
	 * 国籍
	 * 
	 * */
	private String country = null;
	/*
	 * 顾客的电话号码
	 * */
	private String cusPhone = null;
}
