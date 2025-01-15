package com.etp.stepdefinition;

import org.openqa.selenium.By;

import com.etp.commonlinks.ThreeDotsCommon;
import com.etp.helper.ClienttellingDB;
import com.etp.helper.HelperClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Clienttelling extends HelperClass{
	
	public static String clv;
	public static String transaction;

	@Given("the user is on client telling page")
	public void the_user_is_on_client_telling_page() throws Exception {
		Thread.sleep(1000);
		ThreeDotsCommon dots=new ThreeDotsCommon();
		dots.threedots();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//span[contains(text(),'CLIENTELING ')]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("(//button[contains(text(),' Yes ')])[2]")).click();
	}

	@When("the user search for customer")
	public void the_user_search_for_customer() throws Exception {
		Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@id='nameInput']")).sendKeys("Jatin");
	    
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("(//div[@class='optionClass ng-star-inserted'])[1]")).click();
	}

	@And("the user check for CLV value")
	public void the_user_check_for_clv_value() throws Exception {
		Thread.sleep(6000);
		clv=driver.findElement(By.xpath("(//div[@class='node-list-card-list-tab hb-cursor-pointer'])[2]/span")).getText();
	 	System.out.println("Value 1"+" "+clv);
	}

	@Then("the user check for total transactions")
	public void the_user_check_for_total_transactions() throws Exception {
		Thread.sleep(6000);
	    transaction=driver.findElement(By.xpath("(//div[@class='node-list-card-list-tab hb-cursor-pointer'])[3]/span")).getText();
		System.out.println("Value 2"+" "+transaction);
		
		ClienttellingDB clientelling=new ClienttellingDB();
		clientelling.clvamount();
		clientelling.transaction();
	}
}
