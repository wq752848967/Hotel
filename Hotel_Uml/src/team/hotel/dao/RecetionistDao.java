package team.hotel.dao;

import team.hotel.bean.Admin;
import team.hotel.bean.Receptionist;

public interface RecetionistDao {

	/*
	 * ����name��ȡ����
	 * */
	public Receptionist getReceptionistByName(String name);
	
}
