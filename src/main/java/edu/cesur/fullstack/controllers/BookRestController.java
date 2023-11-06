package edu.cesur.fullstack.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.cesur.fullstack.model.BookDTO;
import edu.cesur.fullstack.services.BookService;

@RestController
@RequestMapping("/books")
public class BookRestController {
	
	@Autowired
	BookService bookService;
	
	
	@PostMapping()
	public ResponseEntity<?> createBook(@RequestBody @Validated BookDTO book){
		
		bookService.createBook(book);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(book.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();		
		
	}
	
	@GetMapping()
	public ResponseEntity<?> getAllBooks(){
		return ResponseEntity.ok(bookService.getAllbooks());
	}

}
