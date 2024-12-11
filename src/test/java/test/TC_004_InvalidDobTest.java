package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class TC_004_InvalidDobTest extends ProjectSpecificationMethod{

	@BeforeTest
	public void data() throws IOException {
		readFromPropFile("SignLoginTestData");
	}
	
	
	
	@Test
	public void RegisterTest() {
		
		// TODO Auto-generated method stub
		HomePage obj = new HomePage(driver);
		obj.isEnterdetails()
		.isEmailId(prop.getProperty("validEmail"))
		.isPassword(prop.getProperty("validpassword"))
		.isSubmitButton()
		.addNewConductClick()
		.addFirstName(prop.getProperty("AddFirstName"))
		.addLastName(prop.getProperty("AddLastName"))
		.addInvalidDOB(prop.getProperty("invalidDob"))
		.addSubmitButton()
		.invalidDobMessage();
	}
}
