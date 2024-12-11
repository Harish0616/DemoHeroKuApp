package pages;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.security.PublicKey;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeoutException;

import javax.security.auth.login.LoginContext;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.Assert;

import base.ProjectSpecificationMethod;


public class LoginPage extends ProjectSpecificationMethod {
	
	 @FindBy(name = "email")
	    WebElement emailField;
	    
	 @FindBy(name ="password")
	    WebElement passwordField;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	///Senerio 1
	//enter the email id
	@Test
	public LoginPage isEmailId(String vemail) {
		
		driver.findElement(By.id("email")).sendKeys(vemail);
		return this;
	}
	
	//enter the password
    public LoginPage isPassword(String vpass) {
		
		driver.findElement(By.id("password")).sendKeys(vpass);
		return this;
	}
    
    public LoginPage isSubmitButton() {
    	
    	driver.findElement(By.xpath("//button[text()='Submit']")).click();
    	return this;
    	
    }
    
    //verfied the messages
    
    public LoginPage invalidIdorPassvalid() {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	String expectedmessage = "Incorrect username or password";
    	
    	String actualmessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error"))).getText();
    	
    	Assert.assertEquals(actualmessage, expectedmessage," Not mached this message");
		return this;
    	
    }
    
    //Scenario 2
    
    public LoginPage addNewConductClick() {
    	try {
 		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 20 seconds timeout
 	        
 	        WebElement addNewCounduct =wait.until(ExpectedConditions.elementToBeClickable(By.id("add-contact")));
 	        addNewCounduct.click();
 	        System.out.println("Add Conduct Button Clicked");
 		}catch(Exception e) {
 		System.out.println("ConductClick Button"+e.getMessage());
 	    }
    	
		return this;
 	 }
    
//      public LoginPage titleValidate(String testCase, String expected) {
//    	
//    	//h1[contains(text(),'Contact List')]"
//    	  if(testCase.equals("ValidTitle")) {
//    		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
//    		  
//    		  WebElement validTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
//    	      String actualTitle = validTitle.getText();
//    	      
//    	      String expectedTitle ="Contact List";
//    	      
//    	      Assert.assertEquals(actualTitle, expectedTitle);
//    	      System.out.println("The Actal Assert"+actualTitle);
//    	  
//    	   }else {
//    		   System.out.println("The not get Actual Title");
//    	   }
//		return this;
//		
//    	
//      }
    public LoginPage conductListTitle() {
//    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        String expectedTitle = "Contact List"; // Adjust this based on the actual expected title
//        String actualTitle = driver.findElement(By.xpath("//h1[text()='Contact List']")).getText();
//
//        Assert.assertEquals(actualTitle, expectedTitle, "The page title does not match the expected title.");
//        System.out.println("The Actual Title is"+actualTitle);
//		return this;
    	try {
            // Initialize WebDriverWait with a timeout of 20 seconds
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            
            // Define the expected title
            String expectedTitle = "Contact List";
            
            // Retrieve the actual title of the web page
            String actualTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Contact List')]"))).getText();
            
            // Assert that the actual title equals the expected title
            Assert.assertEquals(actualTitle, expectedTitle, "The actual title does not match the expected title");
            System.out.println("The acutual Title is"+actualTitle);
        } catch (Exception e) {
            // Print an error message
            System.out.println("An error occurred: " + e.getMessage());
        }
		return this;
    }
    
      
     
         
    	  //Add the Conduct DETAILS
       public LoginPage addFirstName(String afirstname) {
    	  
    	   driver.findElement(By.id("firstName")).sendKeys(afirstname);
		   return this;
    	
        }
    
        public LoginPage addLastName(String alastname) {
    	
    	     driver.findElement(By.id("lastName")).sendKeys(alastname);
		     return this;
    	
         }
        public LoginPage addemail(String aemail) {
        	
   	     driver.findElement(By.id("email")).sendKeys(aemail);
		     return this;
   	
        }
 
          public LoginPage addPhoneNumber(String aphonenumber) {
 	
 	          driver.findElement(By.id("phone")).sendKeys(aphonenumber);
		      return this;
 	
          }
 
           public LoginPage addcity(String acity ) {
	 	
	 	         driver.findElement(By.id("city")).sendKeys(acity);
			      return this;
            }
 
           public LoginPage addpostalcode(String apostalcode ) {
	 	
	 	        driver.findElement(By.id("postalCode")).sendKeys(apostalcode);
			    return this;
            }
 
          public LoginPage addSubmitButton() {
	 	
	 	      driver.findElement(By.id("submit")).click();
	 	      System.out.println("Successfully Click the Submit button");
			 return this;
			 
           }
          
          //invalid DATE OF BIRTH
          public LoginPage addInvalidDOB(String aidob) {
        	  driver.findElement(By.id("birthdate")).sendKeys(aidob);
			return this;
          }
          
          public LoginPage invalidDobMessage() {
        		try {
                    // Initialize WebDriverWait with a timeout of 20 seconds
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                    
                    // Define the expected title
                    String expectedTitle = "Contact validation failed: birthdate: Birthdate is invalid";
                    
                    // Retrieve the actual title of the web page
                    String actualTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error"))).getText();
                    
                    // Assert that the actual title equals the expected title
                    Assert.assertEquals(actualTitle, expectedTitle, "The actual title does not match the expected title");
                    System.out.println("The acutual Title is"+actualTitle);
                } catch (Exception e) {
                    // Print an error message
                    System.out.println("An error occurred: " + e.getMessage());
                }
				return this;
          }
         
          // Again to come Conduct List Page click the edit button
          
          //click the edit table
          
          //Scenario 3
          
          public LoginPage validateConductDetails() {
			return this;
        	  
          }
          
          public void conductDetails() {
        	  List<WebElement> conducts = driver.findElements(By.className("contactTableBodyRow")) ;
          }
          
          
      
          
          //Scenerio 4
          //edit the button conduct Details
        public LoginPage isEditConductLinkClicked() throws IOException {
        	
//        	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
//   		  
//   		     WebElement clickEditBut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='edit-button-class']")));
//   		     
//   		     clickEditBut.click();
//   		     System.out.println("The Edit Button clicked");
        //	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickEditBut);
 	        
 	        // Click using JavaScript executor if needed
 	   //     ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickEditBut);
        	
        	        // Locate all rows in the contact table
       	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
		  
		      WebElement clickEditBut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='contacts']//tr/td[contains(text(),'amazon B')]")));
		      //parent to xpath //div[@class='contacts']//tr/td[contains(text(),'james j')]
		      //Table xpath //div[@class='contacts']/table/tr)[2]
		      //name out xpath   //table[@id='myTable']/tr/td[contains(text(), 'babyboy sh')]
		      clickEditBut.click();
		      System.out.println("the cliced"+clickEditBut);
		      File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	           
	           //Mention the target path
	           
	           File dest = new File("D:\\Apps and software\\JavaProjects\\DemoHeroKuAppMiniProject\\snap\\LoginPage.png");
	           
	           //move source to dest
	           
	           FileUtils.copyFile(source, dest);
			  return this;
			  
        	       
        	 }
        
        public LoginPage isEditButtonclick() {
        	driver.findElement(By.id("edit-contact")).click();
			return this;
        }
        public LoginPage editLastName(String elastname) throws InterruptedException {
            WebElement lastNameField = driver.findElement(By.id("lastName"));
            System.out.println("The Before name"+lastNameField);
            
            Thread.sleep(5000);
            lastNameField.clear();
            
            lastNameField.sendKeys(elastname);
            System.out.println("the edit the name"+lastNameField);
            
			return this;
        }
        
        
        public LoginPage editPhone(String ephone) {
            WebElement phoneField = driver.findElement(By.id("phone"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            System.out.println("The Before mobilephone"+phoneField);
            phoneField.clear();
            
            phoneField.sendKeys(ephone);
            System.out.println("The After mobilephone"+phoneField);
			return this;
        }
        
        //empty field add the country name
        public LoginPage isChangeCountryEdit(String cCountry) {
        	
        	driver.findElement(By.id("country")).sendKeys(cCountry);
        	
			return this;
        }
        
        public LoginPage editSubmitButton() {
        	driver.findElement(By.id("submit")).click();
        	System.out.println("Successfully Edit Details");
			return this;
        }
        
        public LoginPage isCheckConductDetailsheader() {
        	// Verify redirection (adjust expected URL based on actual implementation)
        	try {
                // Initialize WebDriverWait with a timeout of 20 seconds
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                
                // Define the expected title
                String expectedTitle = "Contact Details";
                
                // Retrieve the actual title of the web page
                String actualTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Contact Details')]"))).getText();
                
                // Assert that the actual title equals the expected title
                Assert.assertEquals(actualTitle, expectedTitle, "The actual title does not match the expected title");
                System.out.println("The acutual Title is"+actualTitle);
            } catch (Exception e) {
                // Print an error message
                System.out.println("An error occurred: " + e.getMessage());
            }
    		return this;
          
        }
        
        public LoginPage isDeleteConduct() {
        	
        	driver.findElement(By.id("delete")).click();
        	isDeleteAlert();
			return this;
        	
        }
        
        private void isDeleteAlert() {
        	 
        	try {
        	      Alert alert = driver.switchTo().alert(); // Switch to alert
        	      System.out.println("Alert text: " + alert.getText()); // Print alert text
        	      alert.accept(); // Accept the alert
        	    } catch (Exception e) {
        	            System.out.println("No alert present.");
        	      }
        }
        
        
        
        public LoginPage returnToConductList() {
			
        	driver.findElement(By.id("return")).click();
        	return this;
        }
        
        
        public LoginPage isCheckConductListheader() {
        	// Verify redirection (adjust expected URL based on actual implementation)
        	try {
                // Initialize WebDriverWait with a timeout of 20 seconds
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                
                // Define the expected title
                String expectedTitle = "Contact List";
                
                // Retrieve the actual title of the web page
                String actualTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Contact List')]"))).getText();
                
                // Assert that the actual title equals the expected title
                Assert.assertEquals(actualTitle, expectedTitle, "The actual title does not match the expected title");
                System.out.println("The acutual Title is"+actualTitle);
            } catch (Exception e) {
                // Print an error message
                System.out.println("An error occurred: " + e.getMessage());
            }
    		return this;
          
        }
        
       public LoginPage clickLogOutButton() {
    	   LogOutButtonVisible();
		
    	   driver.findElement(By.id("logout")).click();
    	   return this;
    	   
        }
       
       
       public LoginPage linkVerified() {
    	   
    	// Set an implicit wait (though explicit waits are generally preferred)
    	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	    
    	    // Adjusted expected URL based on actual behavior
    	    String expectedUrl = "https://thinking-tester-contact-list.herokuapp.com/"; // Update this if necessary
    	    
    	    // Wait for a moment if needed (use WebDriverWait for better practice)
    	    try {
    	        Thread.sleep(2000); // Simple wait; consider using WebDriverWait
    	        String actualUrl = driver.getCurrentUrl();
    	    	  
        	    System.out.println("Expected URL: " + expectedUrl);
        	    System.out.println("Actual URL: " + actualUrl);
        	    
        	    Assert.assertEquals(actualUrl, expectedUrl, "The page did not redirect to the login page after logging out.");
        	   
    	    } catch (InterruptedException e) {
    	        e.printStackTrace();
    	    }

    	   
    	    
    	    return this;
    	   
       }
       
       private void LogOutButtonVisible() {
    	   
    	   
    	   try {
    		   WebElement visibleLogout =driver.findElement(By.id("logout"));
    		   visibleLogout.isDisplayed();
    		   
    		   
    	   }catch(Exception e) {
    		   
    		   System.out.println("The not Diplayed Logoutbutton");
    	   }
       }
        
       ///screenshot code
       
       //captue the screenshot
       public LoginPage Screenshot() {
       try {
    	   File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           
           //Mention the target path
           
           File dest = new File("D:\\Apps and software\\JavaProjects\\DemoHeroKuAppMiniProject\\snap\\LoginPage.png");
           
           //move source to dest
           
           FileUtils.copyFile(source, dest);
    	    }catch(Exception e) {
    	    	System.out.println("The Exception is:"+e.getMessage());
    	    }
	return this;
       }
       
       
       
       
        
     }



        
      


