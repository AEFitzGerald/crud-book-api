package com.fitzgerald.bookmvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fitzgerald.bookmvc.models.Book;
import com.fitzgerald.bookmvc.services.BookService;

@Controller
public class BooksController {
	
	    private final BookService bookService;
	    
	    public BooksController(BookService bookService) {
	        this.bookService = bookService;
	    }
	    
	    @RequestMapping("/books")
	    public String index(Model model) {
	        List<Book> books = bookService.allBooks();
	        model.addAttribute("books", books);
	        return "index.jsp";
	    }
	    
		@GetMapping("/books/new")
		public String getForm(@ModelAttribute("book") Book book, Model model) {
			return "new.jsp";
		}
		
		@PostMapping("/books/create")
		public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
			if(result.hasErrors()) {
				return "new.jsp";
			}else {
				this.bookService.createBook(book);
				return "redirect:/books";
			}
		}	
		
		@GetMapping("/books/show/{id}")
		public String showBook(@PathVariable("id")Long id, Model model) {
				Book b = this.bookService.findBook(id);
				model.addAttribute("book", b);
				
				return "show.jsp";
			}
		
		 @RequestMapping("/books/edit/{id}")
		 public String edit(@PathVariable("id") Long id, Model model) {
		        Book book = bookService.findBook(id);
		        model.addAttribute("book", book);
		        
		        return "edit.jsp";
		    }
		    
		 @PostMapping(value="/books/{id}")
		 public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		        if (result.hasErrors()) {
		            return "edit.jsp";
		        } else {
		            bookService.updateBook(book);
		            return "redirect:/books";
		        }
		    }
		 
		 @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
		 public String destroy(@PathVariable("id") Long id) {
		       
			 	bookService.deleteBook(id);
		        
			 	return "redirect:/books";
		    }
	}