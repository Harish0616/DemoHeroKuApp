package util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Utility {
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName,testDescription,testCategory,testAuthor;
	
	public void browserLancher(String browserName, String url) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver =new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("edge" )) {
			driver =new EdgeDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(115));
	}
	public void closeBrowser() {
		driver.close();
	}
	
	public void sendKeysMethod(WebElement ele, String input) {
		ele.sendKeys(input);
	}
	
	public void visibilityofElement(WebElement validateTitle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(validateTitle));
	}
	
	public static void readFromPropFile(String filename ) throws IOException {
		FileReader file = new FileReader("D:\\Apps and software\\JavaProjects\\DemoHeroKuAppMiniProject\\src\\test\\resources\\Data\\"+filename+".properties");
		prop = new Properties();
		prop.load(file);
	}
	
	public String screenshot(String name) throws IOException {

		
		String path ="D:\\Apps and software\\JavaProjects\\DemoHeroKuAppMiniProject\\snap"+name+".png";
		
		File dest = new File(path);
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, dest);
		return path;
	}
        

}
