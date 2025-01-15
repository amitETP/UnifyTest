package com.etp.stepdefinition;

import java.io.FileWriter;

import org.openqa.selenium.By;

import com.etp.commonlinks.ThreeDotsCommon;
import com.etp.helper.HelperClass;
import com.etp.helper.ShiftEndDB;
import com.opencsv.CSVWriter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShiftEnd extends HelperClass {
	public static String shiftendamount = null;
	String CSV_ShiftResult = ".\\CSV_Result\\shiftendresult2.csv";

	@Given("the user is on the billing screen for shift end")
	public void the_user_is_on_the_billing_screen_for_shift_end() throws Exception {

	}

	@And("the user clicks on the three dots for shift end")
	public void the_user_clicks_on_the_three_dots_for_shift_end() throws Exception {
		Thread.sleep(1000);
		ThreeDotsCommon dots = new ThreeDotsCommon();
		dots.threedots();
	}

	@Then("the user selects the shift end option")
	public void the_user_selects_the_shift_end_option() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'SHIFT END ')]")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[contains(text(),' Yes ')])[2]")).click();
	}

	@When("the user adds the amount for shift end")
	public void the_user_adds_the_amount_for_shift_end() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='inpWidth2 form-control'])[1]")).click();

		 Thread.sleep(4000);
		 shiftendamount= driver.findElement(By.xpath("(//span[@class='usd-no'])[2]")).getText();
		 
		 ShiftEndDB db = new ShiftEndDB();
			db.shiftEndDB();
	}

	@And("the user clicks on the shift end button")
	public void the_user_clicks_on_the_shift_end_button() throws Exception {
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//button[contains(text(),' SHIFT END ')])[1]")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),' Yes ')]")).click();

	}

	@Then("the shift end is done successfully")
	public void the_shift_end_is_done_successfully() throws Exception {
		
		try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_ShiftResult))) {
			writer.writeNext(new String[] { "After doing Shift End,we compare the Expected Result from UI with  the Actual Result from DB." });
			writer.writeNext(new String[] { "NetAmount from UI", "NetAmount from DB", "Result" });
	 Thread.sleep(10000);
	 String a = driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]")).getText();
	  System.out.println(a);
	  Thread.sleep(1000);
	 String Value1= driver.getCurrentUrl();
	 String Value2="https://test-unify.etpgroup.sg/";
		String result = Value1.equalsIgnoreCase(Value2) ? "Passed" : "Failed";
		writer.writeNext(new String[] { Value1.toString(), Value2.toString(), result });
	
	}
}
}