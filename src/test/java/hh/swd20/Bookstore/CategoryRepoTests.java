package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepoTests {
	
	@Autowired
	private CategoryRepository catRepo;
	
	//Test create, delete and search functionalities //List<Category> findByName(String name);
	
	@Test
	public void testCreateNewCategory() {
		Category cat = new Category("Children's Books");
		catRepo.save(cat);
		assertThat(cat.getCategoryid()).isNotNull();
	}
	
	@Test
	public void testDeleteCategory() {
		catRepo.deleteById((long) 3);
		//assertThat(catRepo.findById((long) 3)).isNull();
		assertThat(catRepo.findByName("Historical fiction")).isEmpty();
	}
	
	@Test
	public void testFindByName() {
		List<Category> cats = catRepo.findByName("Romance novel");
		assertThat(cats).hasSize(1);
	}
}
