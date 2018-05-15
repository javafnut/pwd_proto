package com.ibexsys.pwd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ibexsys.pwd.repository.SiteRepository;
import com.ibexsys.pwd.entity.AppProfile;
import com.ibexsys.pwd.entity.Site;
import com.ibexsys.pwd.entity.User;
import com.ibexsys.pwd.repository.AppProfileRepository;
import com.ibexsys.pwd.repository.UserRepository;

import com.ibexsys.pwd.util.PwdApplicationDataDump;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class PwdApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public UserRepository userRepo;

	@Autowired
	public SiteRepository siteRepo;

	@Autowired
	public AppProfileRepository userAppProfileRepo;


	public static void main(String[] args) {
		SpringApplication.run(PwdApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		runDumpAppData();
		// quickSave();
	}
	
//	public void quickSave() {
//		
//	    byte[] byteArray = "TestPassword".getBytes();	    
//	    siteRepo.save(new Site("Test Site","ROOT","test@test.com","testLogin",byteArray,"notes"));
//		
//	}
	
	public void runDumpAppData() {
		
		PwdApplicationDataDump data = new PwdApplicationDataDump(this);
    	//data.dumpAllTableData();
    	logger.info("Data Dump\n\n" + data.dumpStrings());
    	
    	 data.createCompleteAppProflie();

	}

}
