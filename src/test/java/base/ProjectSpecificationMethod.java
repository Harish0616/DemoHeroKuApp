package base;

import java.security.PublicKey;

import org.apache.poi.xdgf.util.Util;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import util.Utility;

public class ProjectSpecificationMethod extends Utility {

	    @Parameters({"url","browser"})
		// TODO Auto-generated method stub
	    @BeforeMethod
		public void launchLoadUrl(String url, String browser) {
			browserLancher(browser,url);
		}
	    
	    @AfterMethod
	    public void closeLauncher() {
	    	closeBrowser();
	    }

}
