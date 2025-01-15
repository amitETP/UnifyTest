package com.etp.stepdefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.etp.commonlinks.Modulemenu;
import com.etp.commonlinks.Modulesubmenu;
import com.etp.commonlinks.ThreeDotsCommon;
import com.etp.helper.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EOD extends HelperClass{

	@Given("Eod link is displayed in menu")
	public void eod_link_is_displayed_in_menu() {
		try {
			Thread.sleep(1000);
			ThreeDotsCommon lines = new ThreeDotsCommon();
			lines.threedots();

			Thread.sleep(1000);
			Modulemenu menu = new Modulemenu();
			menu.StoreAdministration();

		} catch (Exception e) {
			System.out.println("exception occurred while opening eod link" + e);
		}
	}

	@Given("user is on Eod link from menu")
	public void user_is_on_eod_link_from_menu() {
		Modulesubmenu submenu = new Modulesubmenu();
		submenu.EOD();
	}

	@Then("user select store from dropdown for eod")
	public void user_select_store_from_dropdown_for_eod() {
		try {
		Thread.sleep(6000);
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement Selectstore = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@ng-reflect-placeholder='Select Store']")));
		Selectstore.click();
	//	select_store_value
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search By Store Name']")).sendKeys("Syl");
		//Thread.sleep(10000);
		WebElement a=waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='mat-option-text'])[1]")));
		a.click();
		
	
	}catch (Exception e) {
		System.out.println("Exception Occured while selecting date in eod"+e);
	}
	}

	@When("user clicks on Save for eod")
	public void user_clicks_on_save_for_eod() {
		try {
			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[contains(text(),' SAVE ')]")).click();
		} catch (Exception e) {
			System.out.println("execption occurred while save eod" + e);
		}
	}

	@Then("eod is done successfully")
	public void eod_is_done_successfully() throws Exception {
	Thread.sleep(1000);
	String Value2=driver.findElement(By.xpath("//span[contains(text(),'Eod Saved Successfully ')]")).getText();
	String Value1="Eod Saved Successfully";
	System.out.println("Value 1"+" "+Value1+" "+"Value 2"+":"+Value2); 
	}
}
