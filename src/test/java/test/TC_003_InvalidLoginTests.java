package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class TC_003_InvalidLoginTests extends ProjectSpecificationMethod  {
	
	@BeforeTest
	public void data() throws IOException {
		readFromPropFile("SignLoginTestData");
		testName="InvalidLoginTest";
		testDescription="Test the InvalidLoginFunctionality with postive and negtive";
		testAuthor="Harish";
		testCategory="smokeTesting";
	}
	
	
	
	@Test
	public void InvalidLoginTest() {
		
		HomePage obj = new HomePage(driver);
		obj.isEnterdetails()
		.isEmailId(prop.getProperty("validEmail"))
		.isPassword(prop.getProperty("InvalidLoginPass"))
		.isSubmitButton()
		.invalidIdorPassvalid();
	}

}
