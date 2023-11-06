package edu.cesur.fullstack.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

	private Integer id;
	private Integer libroId;
	private Integer usuarioId;
	private LocalDate fechaReserva;
	private LocalDate returnDate;

}
