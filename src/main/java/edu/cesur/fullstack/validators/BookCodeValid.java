package edu.cesur.fullstack.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookCodeValid implements ConstraintValidator<BookCodeValidator, String> {
	
	private static final Pattern CODE_PATTERN = Pattern.compile("^[A-Za-z]{3}\\d{3}$");

	@Override
	public void initialize(BookCodeValidator constraintAnnotation) {
	}	

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			log.info("Código null");
			return false;
		}
		
		Matcher matcher = CODE_PATTERN.matcher(value);
		//return matcher.matches();
		
		return Pattern.compile("^[A-Za-z]{3}\\d{3}$").matcher(value).matches(); //directo
	}

}
