package edu.cesur.fullstack.exceptions.handlers;

import java.net.URI;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import edu.cesur.fullstack.exceptions.ReservationConflictException;
import edu.cesur.fullstack.services.exceptions.BookNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler( BookNotFoundException.class )
	public ProblemDetail handleBookNotFoundException(BookNotFoundException e) {

		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
		problemDetail.setTitle("Book Exception Occurred");
		problemDetail.setType(URI.create("http://cesurformacion.com"));
		problemDetail.setProperty("errorCategory", "Book");
		problemDetail.setProperty("timeStamp", Instant.now());

		return problemDetail;
	}
	
	@ExceptionHandler( ReservationConflictException.class )
	public ProblemDetail handleReservationConflictException(ReservationConflictException e) {

		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
		problemDetail.setTitle("Reservation Exception Occurred");
		problemDetail.setType(URI.create("http://cesurformacion.com"));
		problemDetail.setProperty("errorCategory", "Reservation");
		problemDetail.setProperty("timeStamp", Instant.now());

		return problemDetail;
	}
	
	@ExceptionHandler( MethodArgumentNotValidException.class )
	public ProblemDetail handleReservationConflictException(MethodArgumentNotValidException e) {

		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
		problemDetail.setTitle("Custom Exception Occurred");
		problemDetail.setType(URI.create("http://cesurformacion.com"));
		problemDetail.setProperty("errorCategory", "Book");
		problemDetail.setProperty("timeStamp", Instant.now());

		return problemDetail;
	}
	


}
