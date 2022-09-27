package hh.swd20.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository catRepo;
	
	@RequestMapping(value="/categorylist")
	public String catList(Model model) {
		model.addAttribute("cats", catRepo.findAll());
		return "categorylist";
	}
	
	@RequestMapping(value="/create")
	public String createCategory(Model model) {
		model.addAttribute("cat", new Category());
		return "addcategory";
	}
	
	@RequestMapping(value = "/savecategory", method= RequestMethod.POST)
	public String saveCategory(Category cat) {
		catRepo.save(cat);
		return "redirect:categorylist";
	}
}
