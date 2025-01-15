package com.etp.stepdefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.etp.helper.HelperClass;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginNegative extends HelperClass {
	 
	Properties prop = HelperClass.getProperties();
	String CSV_loginneagativeresult = prop.getProperty("loginnegativeresult");
	String CSV_loginnegative= prop.getProperty("loginnegativevalue");
	CSVReader reader = null;
	
    
	
    @Given("browser is open for unify")
    public void browser_is_open_for_unify() {
        try {
            HelperClass.openPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Given("user is on login page for unify")
    public void user_is_on_login_page_for_unify() {
    	
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() throws Exception {
        try {
        	reader = new CSVReader(new FileReader(CSV_loginnegative));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String user1 = cell[i];
				String pass1= cell[i + 1];
        	
            Thread.sleep(1000); 
            driver.findElement(By.name("txtusername")).sendKeys(user1);
            Thread.sleep(1000);
            driver.findElement(By.id("inputPassword")).sendKeys(pass1);
        } }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("user leaves username field empty")
    public void user_leaves_username_field_empty() {
        try {
        
        	Thread.sleep(1000);
            driver.findElement(By.name("txtusername")).clear(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @When("user enters a valid username")
    public void user_enters_a_valid_username() {
        try { 
        	reader = new CSVReader(new FileReader(CSV_loginnegative));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String email1 = cell[i+2];
        
            Thread.sleep(1000);
            driver.findElement(By.id("txtLoginId")).sendKeys(email1);
        }} catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

    @When("user enters a valid password")
    public void user_enters_a_valid_password() {
        try { 
        	reader = new CSVReader(new FileReader(CSV_loginnegative));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String pass2 = cell[i+3];
        
            Thread.sleep(1000);
            driver.findElement(By.id("inputPassword")).sendKeys(pass2);
        }} catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("user leaves the password field empty")
    public void user_leaves_the_password_field_empty() {
        try {
            Thread.sleep(1000);
            driver.findElement(By.id("inputPassword")).clear(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("user leaves both username and password fields empty")
    public void user_leaves_both_username_and_password_fields_empty() {
        try {
        	Thread.sleep(1000);
            driver.findElement(By.name("txtusername")).clear(); 
            Thread.sleep(1000);
            driver.findElement(By.id("inputPassword")).clear(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @When("user enters an incorrect password multiple times")
    public void user_enters_an_incorrect_password_multiple_times() {
        try { 
        	reader = new CSVReader(new FileReader(CSV_loginnegative));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String pass3 = cell[i+4];
        
            Thread.sleep(1000);
           
            driver.findElement(By.id("inputPassword")).sendKeys(pass3);
            for(int j=0;j<=5;j++) {
            driver.findElement(By.id("btnLogin")).click(); 
            }
        } }catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    @When("user clicks on login for unify")
    public void user_clicks_on_login_for_unify() throws Exception {
    	Thread.sleep(1000);
        driver.findElement(By.id("btnLogin")).click();
    }

    @Then("an error message is displayed indicating that the username is required")
    public void an_error_message_for_username_required() throws Exception {
    	try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_loginneagativeresult,true))) {
    		reader = new CSVReader(new FileReader(CSV_loginnegative));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String message1 = cell[i+5];	
    		
    	
    	String ExpectedResult=message1;
        String messageemail = driver.findElement(By.xpath("//span[contains(text(),'Please Enter Email Id To Login')]")).getText();
        String actualResult=messageemail;
        String result = ExpectedResult.equalsIgnoreCase(actualResult) ? "Passed" : "Failed";
        writer.writeNext(new String[] { actualResult, ExpectedResult, result });
    	}
    }}

    @Then("an error message is displayed indicating that the password is required")
    public void an_error_message_for_password_required() throws Exception {
    	try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_loginneagativeresult,true))) {
    		reader = new CSVReader(new FileReader(CSV_loginnegative));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String message2 = cell[i+6];	
    	
    	String ExpectedResult=message2;
        String messageemail = driver.findElement(By.xpath("//span[contains(text(),'Please Enter Password To Login')]")).getText();
        String actualResult=messageemail;
        String result = ExpectedResult.equalsIgnoreCase(actualResult) ? "Passed" : "Failed";
        writer.writeNext(new String[] { actualResult, ExpectedResult, result });
     
    }}}

    @Then("an error message is displayed indicating that both fields are required")
    public void an_error_message_for_both_fields_required() throws Exception {
    	try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_loginneagativeresult,true))) {
    		reader = new CSVReader(new FileReader(CSV_loginnegative));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String message3 = cell[i+7];		
    	
    	String ExpectedResult=message3;
        String messageemail = driver.findElement(By.xpath("//span[contains(text(),'Please Enter Email Id and Password To Login')]")).getText();
        String actualResult=messageemail;
        String result = ExpectedResult.equalsIgnoreCase(actualResult) ? "Passed" : "Failed";
        writer.writeNext(new String[] { actualResult, ExpectedResult, result });
    }}}

    @Then("an error message is displayed indicating that the account is locked")
    public void an_error_message_for_account_locked() throws InterruptedException, IOException, CsvValidationException {
    	try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_loginneagativeresult,true))) {
    		reader = new CSVReader(new FileReader(CSV_loginnegative));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String message4 = cell[i+8];	
    
    	
    	String ExpectedResult=message4;
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement messageblock = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'User is blocked / Inactive please contact HR / IT Manager.')]")));
        String actualResult=messageblock.getText();
        String result = ExpectedResult.equalsIgnoreCase(actualResult) ? "Passed" : "Failed";
        writer.writeNext(new String[] { actualResult, ExpectedResult, result });       
        
   
    }}}

    @Then("user remains on the login page")
    public void user_remains_on_login_page() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://test-unify.etpgroup.sg/", currentUrl); 
    }
    }
