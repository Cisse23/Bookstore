package hh.swd20.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class BookController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getBooks() {
		return "No Books here yet...";
		
	}
}
