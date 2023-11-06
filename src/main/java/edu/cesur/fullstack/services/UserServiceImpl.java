package edu.cesur.fullstack.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.cesur.fullstack.model.BookDTO;
import edu.cesur.fullstack.model.UserDTO;
import jakarta.validation.constraints.Email;


@Service
public class UserServiceImpl implements UserService{
	
//    private Integer id;
//    private String nombre;
//    
//    @Email
//    private String correoElectronico;
	
	List<UserDTO> usuarios = Arrays.asList(
			new UserDTO(1, "Angel", "gynny@gmail.com"),
			new UserDTO(2, "Gynny", "Maria@gmail.com"),
			new UserDTO(3, "José", "Juana@gmail.com"));

	@Override
	public UserDTO getUser(Integer id) {
		
		return null;
	}

	@Override
	public Boolean existUser(Integer id) {
		for(UserDTO u : usuarios) {
			if(u.getId() ==id) {
				return true;
			}
		}
		
		return false;
	}

}
