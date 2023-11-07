package edu.cesur.fullstack.services;

import java.util.ArrayList;

import edu.cesur.fullstack.model.ReservationDTO;

public interface ReservationService {
	
	void reserveBook(Integer bookId, Integer userId);
	
	void cancelReservation(Integer bookId, Integer userId);
	
	ArrayList<ReservationDTO> getAllReservations();
	
	ArrayList<ReservationDTO> getAllReservations(Integer userId);	
	
	ArrayList<ReservationDTO> getActiveReservation(Integer userId);

	

}
