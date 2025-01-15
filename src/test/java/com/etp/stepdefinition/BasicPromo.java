package com.etp.stepdefinition;

import io.cucumber.java.en.Given;

import org.openqa.selenium.By;

import com.etp.helper.HelperClass;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class BasicPromo extends HelperClass{
	
//	BasicPromoActions promo=new BasicPromoActions();
	
	@Given("Basic Promotion link is available in menu")
	public void basic_promotion_link_is_available_in_menu() {
		try {
			Thread.sleep(3000);
		//	log.info("Click on three lines");
			driver.findElement(By.xpath("//*[@id='nav-icon1']")).click();
			Thread.sleep(2000);
		//	log.info("Click on  Store Administration");
			driver.findElement(By.xpath("//span[contains(text(),'PRICING & PROMOTIONS ')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Promotions")).click();			
//			WebDriverWait wait = new WebDriverWait(driver, 50);
//			WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),' Sylphy Corp')]")));
//			element4.click();
//
//			
//			WebDriverWait waitss = new WebDriverWait(driver, 50);
//			WebElement element5 = waitss.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),' Bata QA ')]")));
//			element5.click();
			
		}catch (Exception e) {
			System.out.println("Exception Occured");
		}
		
	}
	@And("user is on Basic Promotion from menu")
	public void user_is_on_basic_promotion_from_menu() {
	    
	}
	@Then("Basic Promotion list screen is displayed")
	public void basic_promotion_list_screen_is_displayed() {
	  
	}
	@When("user clicks on Basic by clicking on plus button")
	public void user_clicks_on_basic_by_clicking_on_plus_button() {
	
	}
	@Then("user is navigated basic promotion creation page")
	public void user_is_navigated_basic_promotion_creation_page() {
	  
	}
	@When("user fills all the mandatory details in basic promotion")
	public void user_fills_all_the_mandatory_details_in_basic_promotion() {

	}
	
	@And("user clicks on save button in basic promotion")
	public void user_clicks_on_save_button_in_basic_promotion() throws Exception {
		BasicPromo1 promo1=new BasicPromo1();
		promo1.basicpromo1();
	//	
//		BasicPromo2 promo2=new BasicPromo2();
//		promo2.basicpromo2();
	//	
//		BasicPromo3 promo3=new BasicPromo3();
//		promo3.basicpromo3();
	//	
	//	
//		BasicPromo4 promo4=new BasicPromo4();
//		promo4.basicpromo4();
	//	
	//	
//		BasicPromo5 promo5=new BasicPromo5();
//		promo5.basicpromo5();
	//	
	//	
//		BasicPromo6 promo6=new BasicPromo6();
//		promo6.basicpromo6();
	//	
	//	
//		BasicPromo7 promo7=new BasicPromo7();
//		promo7.basicpromo7();
	//	
	//	
	//	
//		BasicPromo8 promo8=new BasicPromo8();
//		promo8.basicpromo8();
	}
	@Then("basic promotion record will save successfully")
	public void basic_promotion_record_will_save_successfully() {
	  
	}

}
