package com.ibexsys.pwd.repository;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ibexsys.pwd.PwdApplication;
import com.ibexsys.pwd.entity.User;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=PwdApplication.class)
public class UserRepositoryTest implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	EntityManager em;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void findByIdBasicTest() {

		User user = repo.findById(10001L);
		assertNotNull(user);
		assert(user.getId() == 10001L);
	}
	
	
//	@Test
//	public void findByNameBasicTest() {
//		
//		User user = repo.findByFullName("Dave","McBrave-1");
//		assertNotNull(user);
//		assert(user.getFirstName().equals("Dave") && user.getLastName().equals("McBrave-1"));
//		
//	}
//	
//	@Test
//	public void findAllBasicTest() {
//		
//		List<User> users = repo.findAll();
//		assertNotNull(users);
//		assert(users.size() > 0);
//		
//	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}	
	


}
