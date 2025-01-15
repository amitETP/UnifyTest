package com.etp.stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.etp.commonlinks.Modulemenu;
import com.etp.commonlinks.Modulesubmenu;
import com.etp.commonlinks.ThreeDotsCommon;
import com.etp.helper.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Ecommerce extends HelperClass{

	@Given("User is on homepage")
	public void user_is_on_homepage() throws Exception {
	   ThreeDotsCommon dots=new ThreeDotsCommon();
	   dots.threedots();
	}

	@When("user clicks on integration")
	public void user_clicks_on_integration() throws Exception {
	  Modulemenu a=new Modulemenu();
	  a.Integrations();
	  
	  Modulesubmenu menu=new Modulesubmenu();
	  menu.ECommerceIntegration();
	}

	@Then("user drag and drop")
	public void user_drag_and_drop() throws Exception {
		Thread.sleep(6000);
		  driver.findElement(By.xpath("//button[@class='hb-add-icon-btn']")).click();
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  // WebDriverWait to ensure elements are visible and interactable
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Wait for draggable element to be visible
	        WebElement draggable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='add-carrier-channel-tab cdk-drag ng-star-inserted'])[1]")));
	        
	        // Wait for droppable element to be visible
	        WebElement droppable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='drop-sec']")));


	 
	}
}
