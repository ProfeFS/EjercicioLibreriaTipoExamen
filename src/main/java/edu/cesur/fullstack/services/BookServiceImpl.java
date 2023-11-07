package edu.cesur.fullstack.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import edu.cesur.fullstack.model.BookDTO;
import edu.cesur.fullstack.exceptions.BookNotFoundException;

@Service
public class BookServiceImpl implements BookService {
	
	ArrayList<BookDTO> libros = new ArrayList<>();
	BookDTO b1 = new BookDTO(1, "LibroT1", "Cervantes", false,"AAA123");
	BookDTO b2 = new BookDTO(2, "LibroT2", "María", false, "AAA123");
	BookDTO b3 = new BookDTO(3, "LibroT3", "Juana", false, "AAA123");
	
	
	public BookServiceImpl() {
		libros.add(b1);
		libros.add(b2);
		libros.add(b3);
	}

	@Override
	public ArrayList<BookDTO> getAllbooks() {
		
		return libros;
	}

	@Override
	public void createBook(BookDTO book) {
		libros.add(book);
		
	}

	@Override
	public Boolean IsReserved(Integer id) {
		String code = getCode(id);
		for (BookDTO b : libros) {

			if (b.getCode().equals(code)) {
				return b.getReservado();
			}
		}

		return null; // libro no encontrado
	}

	@Override
	public String getCode(Integer bookId) {
		for (BookDTO b : libros) {
			if (b.getId() == bookId) {
				return b.getCode();
			}
		}

		throw new BookNotFoundException("No existe un libro con el id: " + bookId); // libro no encontrado
	}

	@Override
	public BookDTO getBook(Integer bookId) {		
		
		for(BookDTO bo: libros) {
			if(bo.getId() == bookId) {			
				return bo;
			}
		}
			
		return null;
	}

}
