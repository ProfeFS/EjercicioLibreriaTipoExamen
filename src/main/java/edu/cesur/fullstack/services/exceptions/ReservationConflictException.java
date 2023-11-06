package edu.cesur.fullstack.services.exceptions;

public class ReservationConflictException extends RuntimeException {

	public ReservationConflictException(String msg) {
		super(msg);
	}

}
