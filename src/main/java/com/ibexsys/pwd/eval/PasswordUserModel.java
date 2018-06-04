package com.ibexsys.pwd.eval;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.ibexsys.pwd.entity.Site;
import com.ibexsys.pwd.entity.User;

@XmlRootElement(name = "PwdUserModel")
public class PasswordUserModel {

	// XmLElementWrapper generates a wrapper element around XML representation
	@XmlElementWrapper(name = "UserSiteList")
	@XmlElement(name = "Site")

	private List<Site> siteList;
	private Map<String, Site> siteMap;
	private String pwdFileName;
	private User appUser;

	// public List<Site> getSitesList() {
	// return siteList;
	// }
	//
	// public void setSiteList(List<Site> siteList2) {
	// this.siteList = siteList2;
	// }
	//
	// public void addSite(Site site) throws Exception {
	//
	// // @TODO - Exception
	// if (site == null || appUser == null)
	// throw new Exception("Either Site or AppUser is Null");
	//
	// if (siteList != null) {
	// siteList.add(site);
	// } else {
	// siteList = new ArrayList<Site>();
	// siteList.add(site);
	// }
	// }
	//
	public Map<String, Site> getSitesMap() {
		return siteMap;
	}

	public void setSiteMap(Map<String, Site> siteMap) {
		this.siteMap = siteMap;
	}

	public void addSite(Site site) throws Exception {

		// @TODO - Exception
		if (site == null || appUser == null)
			throw new Exception("Either Site or AppUser is Null");

		if (siteMap != null) {
			siteMap.put(String.valueOf(site.getId()), site);
		} else {
			siteMap = new ConcurrentHashMap<String, Site>();
			siteMap.put(String.valueOf(site.getId()), site);
		}
	}

	public String getPwdFileName() {
		return pwdFileName;
	}

	public void setPwdFileName(String pPwdFileName) {
		pwdFileName = pPwdFileName;
	}

	public User getAppUser() {
		return appUser;
	}

	public void setAppUser(User pAppUser) {
		appUser = pAppUser;
	}

	@Override
	public String toString() {
		return "PasswordFileHandler [siteList=" + siteList + ", pwdFileName=" + pwdFileName + ", appUser=" + appUser
				+ "]";
	}

}
