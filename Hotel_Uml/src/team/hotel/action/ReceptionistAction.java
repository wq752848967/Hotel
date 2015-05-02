package team.hotel.action;

import team.hotel.bean.Admin;
import team.hotel.bean.Receptionist;
import team.hotel.dao.tools.BeanFactroy;
import team.hotel.service.ReceptionistService;

public class ReceptionistAction {

	ReceptionistService receptionistService;
	public Receptionist ReceptionistLoginView(Receptionist receptionist) {
		receptionistService = (ReceptionistService) BeanFactroy.getBeanByName("receptionistService");
		
		receptionist = (Receptionist) receptionistService.AdminLogin(receptionist);
		
		return receptionist;
	}

}
