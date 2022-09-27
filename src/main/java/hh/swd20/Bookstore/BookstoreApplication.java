package hh.swd20.Bookstore;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {
	
	// uusi loggeriattribuutti
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
//  testidatan luonti H2-testitietokantaan aina sovelluksen käynnistyessä
	@Bean
	public CommandLineRunner bookTest(BookRepository bookRepository, CategoryRepository catRepository) { 
		return (args) -> {
			log.info("save some categories");
			Category cat1 = new Category("Satire");
			Category cat2 = new Category("Romance novel");
			Category cat3 = new Category("Historical fiction");
			catRepository.save(cat1);
			catRepository.save(cat2);
			catRepository.save(cat3);
			
			log.info("save a couple of books");
			Book book1 = new Book("Pride and Prejudice", "Jane Austen", 2012, "9780141199078", 9.20, cat2 );
			Book book2 = new Book("The Pillars of the Earth", "Ken Follett", 2017, "9781509848492", 21.95, cat3);
			bookRepository.save(book1);
			bookRepository.save(book2);	

			log.info("fetch all categories");
			for (Category c : catRepository.findAll()) {
				log.info(c.toString());
			}
			
			log.info("fetch all books");
			for (Book b : bookRepository.findAll()) {
				log.info(b.toString());	
			}
		};
	}

}
	

		
