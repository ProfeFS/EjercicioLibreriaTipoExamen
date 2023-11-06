package edu.cesur.fullstack.services;

import edu.cesur.fullstack.model.UserDTO;

public interface UserService {
	
	UserDTO getUser(Integer id);
	
	Boolean existUser(Integer id);

}
