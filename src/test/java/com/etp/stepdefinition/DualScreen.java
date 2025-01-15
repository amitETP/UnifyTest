	package com.etp.stepdefinition;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.etp.helper.DualScreenDB;
import com.etp.helper.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DualScreen extends HelperClass{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	
	public static String rrp=null;
	public static String salesprice=null;
	public static String discount=null;
	public static String price=null;    //net amount
	public static String dualscreeninvoice=null;
	
	@Given("the user is on the primary screen")
	public void the_user_is_on_the_primary_screen() {
	    
	}

	@When("the user selects the salesperson dropdown")
	public void the_user_selects_the_salesperson_dropdown() throws Exception {
		WebElement salesperson = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='salesPersonFirstDiv']")));
		salesperson.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[contains(text(),'Aniket Dengre')]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).sendKeys("Jatin");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//li[@class='highlight ng-star-inserted']")).click();

		Thread.sleep(6000);
		driver.findElement(By.xpath("//input[@placeholder='Product Search']")).sendKeys("FA1101");
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//li[@id='productFirstLi']")).click();
		
	}

	@Then("the selected salesperson should be displayed on the primary screen")
	public void the_selected_salesperson_should_be_displayed_on_the_primary_screen() {
	//  String salesperson=driver.findElement(By.xpath("//input[@id='salesPersonFirstDiv']")).getText();
	//  System.out.println(salesperson);
	}

	@Then("the secondary screen should reflect same as the selected salesperson")
	public void the_secondary_screen_should_reflect_same_as_the_selected_salesperson() throws Exception {
		
		
		// ((JavascriptExecutor) driver).executeScript("window.open('https://test-unify.etpgroup.sg/pos/sell_dualscreen', '_blank');");
		
		  String currentWindow = driver.getWindowHandle();
		  // Get all window handles
        ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        

        // Switch to the new window
        for (String handle : windowHandles) {
            if (!handle.equals(currentWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
            // Wait for the element in the secondary window to load
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
          Thread.sleep(10000);
           rrp=driver.findElement(By.xpath("(//div[@id='scannedProduct']/table/tbody/tr/td[3]/table/tbody/tr/td[2])[1]")).getText();
           salesprice=driver.findElement(By.xpath("(//div[@id='scannedProduct']/table/tbody/tr/td[3]/table/tbody/tr/td[2])[2]")).getText();
           discount=  driver.findElement(By.xpath("(//div[@id='scannedProduct']/table/tbody/tr/td[3]/table/tbody/tr/td[2])[3]")).getText();          
           price=  driver.findElement(By.xpath("(//div[@id='scannedProduct']/table/tbody/tr/td[3]/table/tbody/tr/td[2])[4]")).getText(); 
  
	        Thread.sleep(1000);
	        driver.switchTo().window(currentWindow);
          
          	Thread.sleep(10000);
			driver.findElement(By.xpath("//div[contains(text(),' CHECKOUT ')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[contains(text(),' Proceed ')])[2]")).click();
			Thread.sleep(1000);
			WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(50));
			WebElement cash = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[contains(text(),' Cash')])[1]")));
			cash.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(),'ACCEPT')]")).click();
			
			Thread.sleep(10000);
			driver.findElement(By.xpath("(//div[contains(text(),' SUBMIT ')])[1]")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[contains(text(),' SAVE ')]")).click();
			
			Thread.sleep(6000);
			driver.findElement(By.xpath("//div[contains(text(),'Reprint')]")).click();
			
			Thread.sleep(4000);
			dualscreeninvoice=driver.findElement(By.xpath("(//tr[@class='table-row ng-star-inserted'])[1]/td[1]")).getText();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[@class='cross_x'])[1]")).click();	
			
			DualScreenDB db=new DualScreenDB();	
			db.dualscreenofferprice();
			db.dualscreenrrp();
			db.dualscreennetamount();
			db.dualscreeninvoice();
	}
}