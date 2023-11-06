package edu.cesur.fullstack.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.cesur.fullstack.model.ReservationDTO;

public interface ReservationService {
	
	void reserveBook(Integer bookId, Integer userId);
	
	void cancelReservation(Integer bookId, Integer userId);
	
	ArrayList<ReservationDTO> getAllReservations();
	
	ArrayList<ReservationDTO> getActiveReservation(Integer userId);

	

}
