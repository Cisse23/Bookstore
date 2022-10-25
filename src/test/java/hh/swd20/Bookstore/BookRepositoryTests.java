package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.web.BookController;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTests {

	@Autowired
	private BookRepository bookRepo;
	
	//Test create, delete and search functionalities
	
	@Test
	public void testCreateNewBook() {
		Book book = new Book("Fairytales", "Unknown", 1806, "123456", 13.00);
		bookRepo.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void testDeleteBook() {
		bookRepo.deleteById((long) 4);
		//assertThat(bookRepo.findById((long)4)).isNull(); //Expected null, but was Optional.empty
		assertThat(bookRepo.findById((long)4)).isEmpty();
	}
	
	@Test
	public void testFindAllBooks() {
		List<Book> books = (List<Book>) bookRepo.findAll();
		assertThat(books).hasSizeGreaterThanOrEqualTo(1);
	}
}
