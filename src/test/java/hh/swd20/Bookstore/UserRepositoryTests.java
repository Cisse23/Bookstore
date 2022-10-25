package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepo;
	
	//Test create, delete and search functionalities //userRepo.findByUsername(username);
	
	@Test
	public void testCreateNewUser() {
		User user = new User("Ulla", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		userRepo.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void testDeleteUser() {
		userRepo.deleteById((long) 1);
		assertThat(userRepo.findById((long) 1)).isEmpty();
	}
	
	@Test
	public void testFindByUsername() {
		User user = userRepo.findByUsername("Admiina");
		assertThat(user.getUsername()).isEqualTo("Admiina");
	}
}
