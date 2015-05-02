package team.hotel.dao.impl;

import team.hotel.bean.Admin;
import team.hotel.bean.Receptionist;
import team.hotel.dao.RecetionistDao;
import team.hotel.dao.tools.NameValue;
import team.hotel.dao.tools.WerunDao;

public class RceptionistDaoImpl extends WerunDao implements RecetionistDao{


	@Override
	public Admin getReceptionistByName(String name) {
		// TODO Auto-generated method stub
		return (Receptionist) getSingleObject("receptionist",Receptionist.class,new NameValue("username",name));

		
	}

	
}
