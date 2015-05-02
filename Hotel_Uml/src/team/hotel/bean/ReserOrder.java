package team.hotel.bean;


/*
 * 预定订单的父类
 * 其子类：网络预订  电话预定
 * 
 * */
public class ReserOrder {

	private int id;
	private Customer customer = null;
	private String roomNum = null;
}
