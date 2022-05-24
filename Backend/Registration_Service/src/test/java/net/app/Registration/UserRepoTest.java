package net.app.Registration;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import net.app.Registration.Entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserRepoTest {
	@Autowired
	private TestEntityManager testEntity;
	@Autowired
	private User repo;
	
	@Test
	public void testCreateUser() {
		User user=new User();
		user.setUser_id(01);
		user.setUsername("Yaazhan");
		user.setAge(21);
		user.setGender("Male");
		user.setHobbies("Sleeping");
		user.setPassword("1234");
		
		User SavedUser=repo.save(user);
		User existUser = testEntity.find(User.class, SavedUser.getUser_id());
		
		assertThat(user.getUser_id()).isEqualTo(existUser.getUser_id());
		
	}
	
	
	
}
