package test;

import java.io.IOException;

import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class TC_002_LoginTestDifFunction extends ProjectSpecificationMethod {

	@BeforeTest
	public void data() throws IOException {
		readFromPropFile("SignLoginTestData");
		testName="LoginTest";
		testDescription="Test the LoginFunctionality with postive and negtive";
		testAuthor="Harish";
		testCategory="smokeTesting";
	}
	
	@Test
	public void LoginTest() throws InterruptedException, IOException {
		HomePage obj = new HomePage(driver);
		obj.isEnterdetails()
		.isEmailId(prop.getProperty("validEmail"))
		.isPassword(prop.getProperty("validpassword"))
		.isSubmitButton()
		.addNewConductClick()
		.addFirstName(prop.getProperty("AddFirstName"))
		.addLastName(prop.getProperty("AddLastName"))
		.addemail(prop.getProperty("AddEmail"))
		.addPhoneNumber(prop.getProperty("AddPhone"))
		.addcity(prop.getProperty("AddCity"))
		.addpostalcode(prop.getProperty("AddPostalCode"))
		.addSubmitButton()
		.conductListTitle()
		.isEditConductLinkClicked()
		.isEditButtonclick()
		.editLastName(prop.getProperty("EditLastName"))
		.editPhone(prop.getProperty("EditphoneNum"))
		.isChangeCountryEdit(prop.getProperty("EditCountry"))
		.editSubmitButton()
		.isCheckConductDetailsheader()
		.isDeleteConduct()
		.isCheckConductListheader()
		.clickLogOutButton()
		.linkVerified();
	}
}
