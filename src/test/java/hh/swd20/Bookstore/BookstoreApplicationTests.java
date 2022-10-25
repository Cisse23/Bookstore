package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.Bookstore.web.BookController;
import hh.swd20.Bookstore.web.CategoryController;
import hh.swd20.Bookstore.web.UserDetailServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {
	@Autowired
	private BookController bookController;
	@Autowired
	private CategoryController catController;
	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	
	@Test
	void contextLoads_bookController() throws Exception{
		assertThat(bookController).isNotNull();
	}
	
	@Test
	void contextLoads_catController() throws Exception{
		assertThat(catController).isNotNull();
	}
	
	@Test
	void contextLoads_userDetailServiceImpl() throws Exception{
		assertThat(userDetailServiceImpl).isNotNull();
	}

}
