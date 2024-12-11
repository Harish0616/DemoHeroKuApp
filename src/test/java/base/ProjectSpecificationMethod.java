package base;

import java.security.PublicKey;

import org.apache.poi.xdgf.util.Util;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import util.Utility;

public class ProjectSpecificationMethod extends Utility {
	
	@BeforeSuite
	public void reportInitilization(){
		
		String path =("D:\\Apps and software\\JavaProjects\\DemoHeroKuAppMiniProject\\reports\\DemoHeroAppMiniReport");
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setReportName("DemoHeroKuApp Report");
		
		//capture the screenshot
		extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		
	}

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
	    
	    
	    @AfterSuite
		public void closesuite() {
			 extent.flush();
		}

}
