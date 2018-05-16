package com.ibexsys.pwd.util;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ibexsys.pwd.PwdApplication;
import com.ibexsys.pwd.entity.Site;
import com.ibexsys.pwd.repository.AppProfileRepository;
import com.ibexsys.pwd.repository.SiteRepository;
import com.ibexsys.pwd.repository.UserRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=PwdApplication.class)
public class PwdApplicationDataDumpTest implements CommandLineRunner{

	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired	 
    public SiteRepository siteRepo;
	
	@Autowired	 
	public AppProfileRepository userAppProfileRepo;

	public PwdApplicationDataDumpTest() {}
	
	public void sayFoo() {
		logger.info("This is foo'd");
	}
	
	
//	@Test
//    public void dumpApp() {
//    	dumpAllTablesSingles();
//    	dumpAllTableData();
//    }
//	
//	
//	public void dumpAllTablesSingles() {
//		findSingleUser();
//		findSingleCategory();
//		findSingleSite();
//		findSingleUserAppProfile();
//	}
	
//	public void findSingleUserAppProfile() {
//		UserAppProfile userAppProfile = userAppProfileRepo.findUserAppProfileByUserId(20002L);
//		logger.info("User App Profile -> {}",userAppProfile);
//		
//	}
//	
//	public void findSingleSite() {
//		Site site = siteRepo.findSiteByName("Foo Mfg1");
//		logger.info("Site -> {}", site);
//	}
//	
//	public void findSingleCategory() {
//		Category category = categoryRepo.findCategoryByName("category 1");
//		
//		logger.info("Category -> {}", category);
//	}
//	
//	public void findSingleUser() {
//		User user = userRepo.findByFullName("Dave","McBrave-1");
//		
//		logger.info("User -> {}",user);
//	}
//	
//	private void dumpAllTableData() {
//		dumpUsers();
//		dumpSites();
//		dumpCategories();
//		dumpUserAppProfiles();
//	}
	
//	public void dumpUsers() {
//		
//		List<User> allUsers = userRepo.findAll();
//		
//		for(User user :allUsers) {
//		   logger.info("User -> {}",user);
//		}
//    }
//	
//	public void dumpSites() {
//		
//		List<Site> allSites = siteRepo.findAll();
//		
//		for(Site site :allSites) {
//			logger.info("Site -> {}",site);
//		}
//    }
//	
//	public void dumpCategories() {
//		
//		List<Category> allCategories = categoryRepo.findAll();
//		
//		for(Category category : allCategories) {
//			logger.info("Category -> {}",category);
//		}
//    }
//	
//	public void dumpUserAppProfiles() {
//		
//		List<UserAppProfile> allUserAppProfiles = userAppProfileRepo.findAll();
//		
//		for(UserAppProfile userAppProfile : allUserAppProfiles) {
//			logger.info("UserAppProfile -> {}",userAppProfile);
//		}
//    }

	public void createCompleteAppProflie() {
		
		byte[] salt = "UserSite".getBytes();
	    byte[] password = "TestPassword".getBytes();	
	    
	    Site site = null;
	   
	    for (int i =0; i < 4; i++) {
	    	site = new Site("Test Site " + i,"ROOT","test@test.com","testLogin",password,"notes");
	    	em.merge(site);
	    	
	    }
	    
	    
	    //siteRepo.save());
		
	}
	
	
	public UserRepository getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public SiteRepository getSiteRepo() {
		return siteRepo;
	}

	public void setSiteRepo(SiteRepository siteRepo) {
		this.siteRepo = siteRepo;
	}


	public AppProfileRepository getUserAppProfileRepo() {
		return userAppProfileRepo;
	}

	public void setUserAppProfileRepo(AppProfileRepository userAppProfileRepo) {
		this.userAppProfileRepo = userAppProfileRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
}