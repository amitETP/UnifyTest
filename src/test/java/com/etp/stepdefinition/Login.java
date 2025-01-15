package com.etp.stepdefinition;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.etp.helper.HelperClass;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends HelperClass {

	Properties prop = HelperClass.getProperties();
	String CSV_Login = ".\\CSV\\Login.csv";
//	String CSV_Login = ".\\CSV\\LoginImpl.csv";
	CSVReader reader = null;

	@Given("browser is open")
	public void browser_is_open() throws Exception {
		HelperClass.openPage();
	}

	@And("user is on login page")
	public void user_is_on_login_page() {
		// logger.info("user is on login page");
	}

	@When("user enter username and password")
	public void user_enter_username_and_password() {
		try {
			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_Login));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String txt_userName = cell[i];
				String loc_userName = cell[i + 1];
				String txt_userPassword = cell[i + 2];
				String loc_userPassword = cell[i + 3];

				Thread.sleep(1000);
				driver.findElement(By.name(loc_userName)).sendKeys(txt_userName);

				Thread.sleep(1000);
				driver.findElement(By.id(loc_userPassword)).sendKeys(txt_userPassword);

			}
		} catch (Exception e) {
			System.out.println("Exception occured for username" + " " + e);
		}

	}

	@And("user clicks on login")
	public void user_clicks_on_login() {
		try {
			reader = new CSVReader(new FileReader(CSV_Login));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String loc_loginButton = cell[i + 4];
				driver.findElement(By.id(loc_loginButton)).click();

			}
		} catch (Exception e) {
			System.out.println("exception occured while clicking on login button" + e);
		}

	}

	@Then("user is navigated to Select Group")
	public void user_is_navigated_to_select_group() {

		System.out.println("login Successful");
	}

	@And("user clicks on group")
	public void user_clicks_on_group() throws InterruptedException {

//		try {
//
//			String CSV_LoginResult = ".\\CSV Output\\loginresult.csv";
//			reader = new CSVReader(new FileReader(CSV_Login));
//			String[] cell = reader.readNext();
//			
//				while ((cell = reader.readNext()) != null) {
//					int i = 0;
//					String loc_selectGroup = cell[i + 5];
//					
//					Thread.sleep(6000);
//					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//					WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),' Sylphy Training')]")));
//					element3.click();	
//				}
//		} catch (Exception e) {
//			System.out.println("Exception Occured while selecting the group" + " " + e);
//		}
	}
		
		
	
	@Then("the login should be successful")
	public void the_login_should_be_successful() throws Exception {
		String CSV_LoginResult = ".\\CSV_Result\\loginresult.csv";
		try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_LoginResult))) {
			 writer.writeNext(new String[] { "After Successful Login ,we compare the Expected Result with  the Actual Result from UI." });
			 writer.writeNext(new String[] { "Expected Result", "Actual Result from UI", "Result" });
				
			reader = new CSVReader(new FileReader(CSV_Login));
			String[] cell = reader.readNext();
			
				while ((cell = reader.readNext()) != null) {
					int i = 0;
					String message = cell[i + 7];
			Thread.sleep(2000);
			String Value1 = message;
			Thread.sleep(10000);
			String loginverify = driver.findElement(By.xpath("//p[contains(text(),' Welcome back  EGS Enterprise!')]")).getText();
			String Value2 = loginverify;
			System.out.println(Value1+" "+Value2);
			String result = Value1.equalsIgnoreCase(Value2) ? "Passed" : "Failed";
			System.out.println(Value1+" "+Value2);
			writer.writeNext(new String[] { Value1, Value2, result });
//			if(Value1.equalsIgnoreCase(Value2))
//			{
//				System.out.println("Pass");
//			}else
//			{
//				System.out.println("Fail");
//				
//				TakesScreenshot ts =(TakesScreenshot)driver;
//				File screenshot=ts.getScreenshotAs(OutputType.FILE);
//				 try {
//			            // Save the screenshot to a specific location
//			            FileUtils.copyFile(screenshot, new File("screenshot.png"));
//			        } catch (Exception e) {
//			            System.out.println("Failed to capture screenshot: " + e.getMessage());
//			        }
//			}
	}
}}}
