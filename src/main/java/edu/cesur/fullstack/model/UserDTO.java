package edu.cesur.fullstack.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
    private Integer id;
    private String nombre;
    
    @Email
    private String correoElectronico;


}
