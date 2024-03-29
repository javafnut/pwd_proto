package com.ibexsys.pwd.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.ibexsys.pwd.PwdApplication;
import com.ibexsys.pwd.entity.Site;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PwdApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class SiteRepositoryTest implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private byte[] BYTE_ARRAY = "TestPassword".getBytes();

	@Autowired
	SiteRepository repo;

	@Autowired
	EntityManager em;

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
	@DirtiesContext
	public void createSingleSite() {

		repo.save(new Site("Test Site", "ROOT", "test@test.com", "testLogin", BYTE_ARRAY, "notes"));
		Site site = repo.findSiteByName("Test Site");

		assertNotNull(site);
		assertEquals("Test Site", site.getSiteName());

	}

	 @Test
	 public void findByIdBasicTest() {
	
	 repo.save(new Site("Test Site","ROOT","test@test.com","testLogin",BYTE_ARRAY,"notes"));
	 Site site = repo.findSiteByName("Test Site");
	
	 Site testSite = repo.findById(site.getId());
	 assertNotNull(testSite);
	 assert(site.getId() == testSite.getId());
	 }

	 @Test
	 public void findByNameBasicTest() {
	
	 Site site = repo.findSiteByName("foo1.com");
	 assertNotNull(site);
	 assert(site.getSiteName().equals("foo1.com"));
	
	 }
	
	 @Test
	 public void findAllBasicTest() {
	
	 List<Site> sites = repo.findAll();
	 assertNotNull(sites);
	 assert(sites.size() > 0);
	
	 }

}
