package com.etp.stepdefinition;

import org.openqa.selenium.By;

import com.etp.commonlinks.ThreeDotsCommon;
import com.etp.helper.DropDB;
import com.etp.helper.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Drop extends HelperClass{

	@Given("the user is on billing screen for drop")
	public void the_user_is_on_billing_screen_for_drop() {
	   
	}

	@When("the user click on lift and drop button")
	public void the_user_click_on_lift_and_drop_button() throws Exception {
//	ThreeDotsCommon common=new ThreeDotsCommon();
//	common.threedots();
//	Thread.sleep(1000);
//	driver.findElement(By.xpath("//span[contains(text(),'LIFT & DROP ')]")).click();
//	
//	 Thread.sleep(1000);
//	   driver.findElement(By.xpath("(//button[contains(text(),' Yes ')])[2]")).click();
	}

	@When("the user is on drop page")
	public void the_user_is_on_drop_page() throws Exception {
		  Thread.sleep(1000);
		String message=   driver.findElement(By.xpath("//a[contains(text(),' Lift And Drop ')]")).getText();
		System.out.println(message);
	}

	@Then("the user enter cashier password for drop")
	public void the_user_enter_cashier_password_for_drop() throws Exception {
		  Thread.sleep(1000);
		   driver.findElement(By.xpath("//input[@id='cashPass']")).sendKeys("Egs@1310");
	}

	@Then("the user click on submit for drop")
	public void the_user_click_on_submit_for_drop() throws Exception {
		  Thread.sleep(1000);
		   driver.findElement(By.xpath("//button[contains(text(),' SUBMIT ')]")).click();
	}

	@Then("the drop screen open")
	public void the_drop_screen_open() throws Exception {
		  Thread.sleep(1000);
		   driver.findElement(By.xpath("//div[contains(text(),'Drop Amount')]")).click();
	}

	@Then("the user enter the amount in drop amount")
	public void the_user_enter_the_amount_in_drop_amount() throws Exception {
		  Thread.sleep(1000);
		   driver.findElement(By.xpath("//input[@ng-reflect-name='dropAmt']")).sendKeys("25");
	}

	@Then("the user select the reason for drop")
	public void the_user_select_the_reason_for_drop() throws Exception {
		  Thread.sleep(1000);
		   driver.findElement(By.xpath("//mat-select[@ng-reflect-name='dropRsn']")).click();
		   
		   
		   Thread.sleep(1000);
		   driver.findElement(By.xpath("//mat-option[@class='mat-option ng-star-inserted mat-active']")).click();
	}

	@Then("the user click on save for drop")
	public void the_user_click_on_save_for_drop() throws Exception {
		  Thread.sleep(1000);
		   driver.findElement(By.xpath("//button[contains(text(),' SAVE ')]")).click();
	}

	@Then("drop was successful")
	public void drop_was_successful() throws Exception {
		  Thread.sleep(1000);
		String drop=driver.findElement(By.xpath("//span[contains(text(),'Drop Was Successful')]")).getText();
		System.out.println(drop);
		DropDB db=new DropDB();
		db.liftamountdb();
	}
}
