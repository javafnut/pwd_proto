package com.ibexsys.pwd;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.ibexsys.pwd.entity.AppProfile;
import com.ibexsys.pwd.entity.Site;
import com.ibexsys.pwd.entity.User;
import com.ibexsys.pwd.repository.AppProfileRepository;
import com.ibexsys.pwd.repository.SiteRepository;
import com.ibexsys.pwd.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PwdApplicationTests implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	SiteRepository siteRepo;
	
	@Autowired
	AppProfileRepository appProfileRepo;
	
	@Override
	public void run(String... args) throws Exception {
		 logger.info("Test is running....");
	}
		
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	@Transactional
	@DirtiesContext
	public void createCompleteAppProflie() {
		
		byte[] salt = "UserSite".getBytes();
	    byte[] password = "TestPassword".getBytes();
		
	    AppProfile profile = new AppProfile("TestLogin","PWDFile.pwd");	    
	    User user = new User("Foo","Barr","Foo@Foo.bar",salt,password);
	    appProfileRepo.insertUserAndAppProfile(user, profile);
	    
	    Site site = null;
	   
	    for (int i = 0; i < 4; i++) {
	    	site = new Site("Test Site " + i,"ROOT","test@test.com","testLogin",password,"notes");
	    	profile = appProfileRepo.saveSite(profile, site);
	      	//em.merge(site);
	    }
	    
	    assert(profile.getId() > 0);
	    assert(profile.getUser().getId() > 0);
	    assert(profile.getUser().getEmail().equalsIgnoreCase("Foo@Foo.bar"));
	    assert(profile.getSiteList().size() == 4);
	
	}
	
	@Test
	public void contextLoads() {
	}
	
	
}
