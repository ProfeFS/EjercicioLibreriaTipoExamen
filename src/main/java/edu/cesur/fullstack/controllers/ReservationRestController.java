package edu.cesur.fullstack.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.cesur.fullstack.services.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationRestController {
	
	@Autowired
	ReservationService reservationService;
	
	@PostMapping("/{bookId}/{userId}")
	public ResponseEntity<?> reserveBook(@PathVariable Integer bookId, @PathVariable Integer userId){
		
		reservationService.reserveBook(bookId, userId);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/")
				.buildAndExpand()
				.toUri();
		
		return ResponseEntity.created(location).build();
			
	}
	
	@GetMapping()
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(reservationService.getAllReservations());
	}
	
	@PatchMapping("/books/{bookId}/users/{userId}")
	public ResponseEntity<?> cancelReservation(@PathVariable Integer bookId, @PathVariable Integer userId){
		
		reservationService.cancelReservation(bookId, userId);
		
		return ResponseEntity.noContent().build();
		
	}

}
