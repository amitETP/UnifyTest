package com.etp.stepdefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import com.etp.commonlinks.ThreeDotsCommon;
import com.etp.helper.HelperClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Lift extends HelperClass{
	

	@Given("the user is on billing screen")
	public void the_user_is_on_billing_screen() {
	    
	}

	@When("the user click on lift and drop")
	public void the_user_click_on_lift_and_drop() throws Exception {
		
		ThreeDotsCommon common=new ThreeDotsCommon();
		common.threedots();
		
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//span[contains(text(),'LIFT & DROP ')]")).click();
	   
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("(//button[contains(text(),' Yes ')])[2]")).click();
	}

	@When("the user is on lift and drop page")
	public void the_user_is_on_lift_and_drop_page() throws Exception {
	  Thread.sleep(1000);
	 String liftdrop= driver.findElement(By.xpath("//a[contains(text(),' Lift And Drop ')]")).getText();
	 System.out.println(liftdrop);
	}

	@Then("the user enter cashier password")
	public void the_user_enter_cashier_password() throws Exception {
		Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@id='cashPass']")).sendKeys("Egs@1310");
	}

	@Then("the user click on submit")
	public void the_user_click_on_submit() throws Exception {
		Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[contains(text(),' SUBMIT ')]")).click();
	}

	@Then("the lift and drop screen open")
	public void the_lift_and_drop_screen_open() throws Exception {
		Thread.sleep(1000);
	   driver.findElement(By.xpath("//div[contains(text(),'Lift Amount')]")).click();
	}

	@Then("the user enter the amount in lift amount")
	public void the_user_enter_the_amount_in_lift_amount() throws Exception {
		Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@ng-reflect-name='liftAmt']")).sendKeys("5");
	}

	@Then("the user select the reason")
	public void the_user_select_the_reason() throws Exception {
		Thread.sleep(1000);
	    driver.findElement(By.xpath("//mat-select[@ng-reflect-name='liftRsn']")).click();
	    
	    Thread.sleep(1000);
		driver.findElement(By.xpath("//mat-option[@class='mat-option ng-star-inserted mat-active']")).click();
	}

	@Then("the user click on save")
	public void the_user_click_on_save() throws Exception {
		Thread.sleep(1000);
	   driver.findElement(By.xpath("//button[contains(text(),' SAVE ')]")).click();
	}

	@Then("lift was successful")
	public void lift_was_successful() throws Exception {
		Thread.sleep(1000);
	    String message=driver.findElement(By.xpath("//span[contains(text(),'Lift Was Successful')]")).getText();
	    System.out.println(message);
	}

}
