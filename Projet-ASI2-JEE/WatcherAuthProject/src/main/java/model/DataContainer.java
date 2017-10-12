package model;

import fr.cpe.model.UserModel;
import fr.cpe.model.enums.Role;


public class DataContainer {
	
	public Role checkUser( UserModel user){
		return user.getRole();
	}

}
