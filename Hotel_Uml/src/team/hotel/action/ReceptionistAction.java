package team.hotel.action;

import team.hotel.bean.Admin;
import team.hotel.bean.Receptionist;
import team.hotel.dao.tools.BeanFactroy;
import team.hotel.service.ReceptionistService;

public class ReceptionistAction {

	ReceptionistService receptionistService;
	public Admin ReceptionistLoginView(Admin admin) {
		receptionistService = (ReceptionistService) BeanFactroy.getBeanByName("receptionistService");
		
		admin = (Admin) receptionistService.AdminLogin(admin);
		
		return admin;
	}

}
