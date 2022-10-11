package hh.swd20.Bookstore;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;
import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.UserRepository;

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
	public CommandLineRunner bookTest(BookRepository bookRepository, CategoryRepository catRepository, UserRepository userRepo) { 
		return (args) -> {
			log.info("save some books");
			
			userRepo.save(new User("Pekka", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER"));
			userRepo.save(new User("Admiina", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN"));
			
			catRepository.save(new Category("Satire"));
			catRepository.save(new Category("Romance novel"));
			catRepository.save(new Category("Historical fiction"));
			
			log.info("save a couple of books");
			bookRepository.save(new Book("Pride and Prejudice", "Jane Austen", 2012, "9780141199078", 9.20, catRepository.findByName("Romance novel").get(0)));
			bookRepository.save(new Book("The Pillars of the Earth", "Ken Follett", 2017, "9781509848492", 21.95, catRepository.findByName("Historical fiction").get(0)));	
			
			log.info("fetch all books");
			for (Book b : bookRepository.findAll()) {
				log.info(b.toString());	
			}
		};
	}

}
	

		
