package team.hotel.dao;

import team.hotel.bean.Admin;
import team.hotel.bean.Receptionist;

public interface RecetionistDao {

	/*
	 * 根据name获取对象
	 * */
	public Receptionist getReceptionistByName(String name);
	
}
