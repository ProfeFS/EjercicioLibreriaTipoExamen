package edu.cesur.fullstack.services;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import edu.cesur.fullstack.exceptions.BookNotFoundException;
import edu.cesur.fullstack.exceptions.ReservationConflictException;
import edu.cesur.fullstack.model.BookDTO;
import edu.cesur.fullstack.model.ReservationDTO;

@Service
public class ReservationServiceImpl implements ReservationService {

	ArrayList<ReservationDTO> reservas = new ArrayList<>();

	BookService bookService;
	UserService userService;

	Integer cont = 1;

	// DI de los beans que usará spring en tiempo de ejecución.
	public ReservationServiceImpl(BookService bookService, UserService userService) {
		this.bookService = bookService;
		this.userService = userService;
	}

	@Override
	public void reserveBook(Integer bookId, Integer userId) {

		BookDTO book = bookService.getBook(bookId);

		if (book != null) {
			if (!book.getReservado()) {
				book.setReservado(true);
				ReservationDTO reserva = new ReservationDTO(cont, bookId, userId, LocalDate.now(), null);
				reservas.add(reserva);
				cont++;
			} else {
				throw new ReservationConflictException("El libro con id: " + bookId + " ya se encuentra reservado");
			}

		} else {
			throw new BookNotFoundException("No extieste el libro con id: " + bookId);
		}
	}

	@Override
	public void cancelReservation(Integer bookId, Integer userId) {
		for (ReservationDTO re : reservas) {

			if (re.getLibroId() == bookId && re.getUsuarioId() == userId) {
				if (re.getReturnDate() == null) {
					throw new ReservationConflictException(
							"la persona con id: " + userId + " ya ha devuelto el libro con id" + bookId);
				} else {
					re.setReturnDate(LocalDate.now());
				}

			} else {
				throw new ReservationConflictException(
						"No existe una reserva para el user id:" + userId + " y el libro con id: " + bookId);

			}
		}

	}

	@Override
	public ArrayList<ReservationDTO> getActiveReservation(Integer userId) {

		ArrayList<ReservationDTO> activeReservations = new ArrayList<>();

		for (ReservationDTO re : reservas) {
			if (re.getUsuarioId() == userId) {
				if (re.getReturnDate() == null) {
					activeReservations.add(re);
				}

			} else {
				throw new ReservationConflictException(
						"La persona con el user id:" + userId + " nunca ha reservado un libro ");
			}
		}

		return activeReservations;
	}

	@Override
	public ArrayList<ReservationDTO> getAllReservations() {

		return reservas;
	}

}
