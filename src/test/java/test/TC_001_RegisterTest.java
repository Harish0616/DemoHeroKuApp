package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class TC_001_RegisterTest extends ProjectSpecificationMethod {

	@BeforeTest
	public void data() throws IOException {
		readFromPropFile("SignLoginTestData");
		testName="RegisterTest";
		testDescription="Test the RegisterFunctionality with postive and negtive";
		testAuthor="Harish";
		testCategory="smokeTesting";
	}
	
	
	
	@Test
	public void RegisterTest() {
		
		// TODO Auto-generated method stub
		HomePage obj = new HomePage(driver);
		obj.cickSignInButton()
		.isFirstName(prop.getProperty("validFirstname"))
		.isLastName(prop.getProperty("validLastname"))
		.isEmailId(prop.getProperty("validEmailId"))
		.ispassword(prop.getProperty("validPassword"))
		.isSubmitButton();
	}
	

}
