package team.hotel.service.impl;

import team.hotel.bean.Receptionist;
import team.hotel.dao.RecetionistDao;
import team.hotel.dao.tools.BeanFactroy;
import team.hotel.service.ReceptionistService;

public class ReceptionistServiceImpl implements ReceptionistService {

	private RecetionistDao recetionistDao =  null;
	@Override
	public Receptionist AdminLogin(Receptionist receptionist) {
		// TODO Auto-generated method stub
		/*
		 * 接口预留
		 * 判断是什么管理员登陆
		 * 
		 * */
		recetionistDao = (RecetionistDao) BeanFactroy.getBeanByName("recetionistDao");
		if(adminAllow(receptionist))
		{
			Receptionist  adminInfo =  recetionistDao.getReceptionistByName(receptionist.getReName());
			//用户存在  再然后检查密码
			if(adminInfo.getPassword().equals(receptionist.getPassword()))
			{
				receptionist = adminInfo;
				System.out.println("test rename:"+(receptionist).getReName());
			}
			else
			{
				receptionist.setPassword(null);
			}
		}
		else
		{
			receptionist.setAdminName(null);
		}
		return receptionist;
	}
	public boolean adminAllow(Receptionist receptionist) {
		recetionistDao = (RecetionistDao) BeanFactroy.getBeanByName("recetionistDao");
		
		try {
			receptionist = recetionistDao.getReceptionistByName(receptionist.getReName());
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		return true;
	}


}
