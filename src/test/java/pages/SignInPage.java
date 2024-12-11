package pages;

import java.time.Duration;
import java.util.jar.Attributes.Name;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class SignInPage extends ProjectSpecificationMethod {
	
	public SignInPage (WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(name = "firstName")
    WebElement firstNameField;

    @FindBy(name = "lastName")
    WebElement lastNameField;

    @FindBy(name = "email")
    WebElement emailField;
    
    @FindBy(name ="password")
    WebElement passwordField;

    @FindBy(id = "addUser")
     WebElement addUserButton;

    //enter the firstname
    public SignInPage isFirstName(String firstNameField) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	driver.findElement(By.id("firstName")).sendKeys(firstNameField);
    	return this;
    }
    
    //Enter the lastname
    public SignInPage isLastName(String lastNameField) {
    	
    	driver.findElement(By.id("lastName")).sendKeys(lastNameField);
    	return this;
    }
    
    //enter the email
    public SignInPage isEmailId(String emailField) {
    	
    	driver.findElement(By.id("email")).sendKeys(emailField);
    	return this;
    }
    //enter the password
    
    public SignInPage ispassword(String passwordField) {
    	driver.findElement(By.id("password")).sendKeys(passwordField);
		return this;
    }
    //enter the email
    public SignInPage isSubmitButton() {
    	
    	driver.findElement(By.id("submit")).click();
    	System.out.println("The Add user Button clicked");
    	return this;
    }

}
