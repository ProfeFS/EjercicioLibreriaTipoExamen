package edu.cesur.fullstack.model;

import java.time.LocalDate;

import edu.cesur.fullstack.validators.BookCodeValidator;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
	
	@NotNull
    private Integer id;
	
    private String titulo;
    private String autor;
    private Boolean reservado;
    
    @BookCodeValidator
    private String code;

	
	

}
