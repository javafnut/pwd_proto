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
import com.ibexsys.pwd.entity.AppProfile;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=PwdApplication.class)
public class AppProfileRepositoryTest implements CommandLineRunner{
	
	@Autowired
	AppProfileRepository repo;
	
	@Autowired
	EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("Test is running....");
	}	
	
	
	@Test
	public void findByIdBasicTest() {

		AppProfile uap = repo.findById(40000L);
		assertNotNull(uap);
		assert(uap.getId() == 40000L);
	}
	
	
	
	
//	@Test
//	public void findByUserIdBasicTest() {
//		
//		UserAppProfile uap = repo.findUserAppProfileByUserId(20001L);
//		assertNotNull(uap);
//		assert(uap.getAppUserId() == 20001L);
//		
//	}
//	
//	@Test
//	public void findAllBasicTest() {
//		
//		List<UserAppProfile> uaps = repo.findAll();
//		assertNotNull(uaps);
//		assert(uaps.size() > 0);
//		
//	}
	
	
	@Test
	public void temp_foo() {
		assert true;
	}

}
