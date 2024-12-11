package pages;

import java.lang.classfile.instruction.ReturnInstruction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;

import base.ProjectSpecificationMethod;

public class HomePage extends ProjectSpecificationMethod {

	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public SignInPage cickSignInButton() {
		driver.findElement(By.id("signup")).click();
		return new SignInPage(driver);
	}
	
	public LoginPage isEnterdetails() {
		
		return new LoginPage(driver);
	}
	
	
}
