package team.hotel.service.impl;

import team.hotel.bean.Admin;
import team.hotel.bean.Receptionist;
import team.hotel.dao.RecetionistDao;
import team.hotel.dao.tools.BeanFactroy;
import team.hotel.service.ReceptionistService;

public class ReceptionistServiceImpl implements ReceptionistService {

	private RecetionistDao recetionistDao =  null;
	@Override
	public Admin AdminLogin(Admin admin) {
		// TODO Auto-generated method stub
		/*
		 * �ӿ�Ԥ��
		 * �ж���ʲô����Ա��½
		 * 
		 * */
		recetionistDao = (RecetionistDao) BeanFactroy.getBeanByName("recetionistDao");
		if(adminAllow(admin))
		{
			Admin  adminInfo =  recetionistDao.getReceptionistByName(admin.getAdminName());
			//�û�����  ��Ȼ��������
			if(adminInfo.getPassword().equals(admin.getPassword()))
			{
				admin = adminInfo;
				//System.out.println("test rename:"+(admin).getReName());
			}
			else
			{
				admin.setPassword(null);
			}
		}
		else
		{
			admin.setAdminName(null);
		}
		return admin;
	}
	public boolean adminAllow(Admin admin) {
		recetionistDao = (RecetionistDao) BeanFactroy.getBeanByName("recetionistDao");
		
		try {
			admin = recetionistDao.getReceptionistByName(admin.getAdminName());
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		return true;
	}


}
