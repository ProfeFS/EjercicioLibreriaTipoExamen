package edu.cesur.fullstack.services;

import java.util.List;

import edu.cesur.fullstack.model.BookDTO;

public interface BookService {
	
	List<BookDTO> getAllbooks();
	
	void createBook(BookDTO book);
	
	Boolean IsReserved(Integer bookId) ;
	
	BookDTO getBook(Integer bookId);
	
	String getCode(Integer bookId);

}
