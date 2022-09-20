package hh.swd20.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.Bookstore.domain.BookRepository;

@Controller
@ResponseBody
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@RequestMapping(value ="/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getBooks() {
		return "No Books here yet...";		
	}
}
