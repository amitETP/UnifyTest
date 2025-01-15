package com.etp.stepdefinition;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.etp.commonlinks.Modulemenu;
import com.etp.commonlinks.Modulesubmenu;
import com.etp.commonlinks.ThreeDotsCommon;
import com.etp.helper.HelperClass;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BOD extends HelperClass {

	String CSV_BOD = ".\\CSV\\BOD.csv";
	CSVReader reader = null;

	@Given("Bod link is displayed in menu")
	public void bod_link_is_displayed_in_menu() {

		try {
			Thread.sleep(1000);
			ThreeDotsCommon lines = new ThreeDotsCommon();
			lines.threedots();

			Thread.sleep(1000);
			Modulemenu menu = new Modulemenu();
			menu.StoreAdministration();

		} catch (Exception e) {
			System.out.println("exception occurred while opening bod link" + e);
		}
	}

	@And("user is on bod link from menu")
	public void user_is_on_bod_link_from_menu() {

		Modulesubmenu submenu = new Modulesubmenu();
		submenu.BOD();
	}

	@Then("user select store from dropdown")
	public void user_select_store_from_dropdown() {
		try {

			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_BOD));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String select_store = cell[i];
				String select_store_name = cell[i + 1];
				String select_store_value = cell[i + 2];
				String select_calender = cell[i + 3];
				String select_calender_value = cell[i + 4];
				String select_date = cell[i + 5];
				String select_date_value = cell[i + 6];
				String select_month = cell[i + 7];
				String select_year = cell[i + 8];

				Thread.sleep(2000);
				WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(50));
				WebElement Selectstore = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@ng-reflect-placeholder='-Select Store-']")));
				Selectstore.click();
			//	select_store_value
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@placeholder='Search Store']")).sendKeys(select_store_value);
				//Thread.sleep(10000);
				WebElement a=waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='mat-option-text'])[1]")));
				a.click();
				
			//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
			//	WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[contains(text(),'SG05-Mumbai -MBOS')])[2]")));
				
			//	Thread.sleep(10000);
			//	driver.findElement(By.xpath("(//span[contains(text(),'SG05-Mumbai -MBOS')])[2]")).click();

				Thread.sleep(6000);
				driver.findElement(By.xpath("(//*[@class='mat-datepicker-toggle-default-icon ng-star-inserted'])[1]")).click();

				String f = select_calender_value;
				String[] dates = f.split(" ");

				Thread.sleep(1000);
				driver.findElement(By.xpath(select_date)).click();

				List<WebElement> year = driver.findElements(By.xpath("//td"));
				Thread.sleep(1000);
				int k = 0;
				while (true) {
					if ((Integer.parseInt(dates[2])) < (Integer
							.parseInt(driver.findElement(By.xpath("(//td[@role='gridcell'])[1]")).getText()))) {
						Thread.sleep(1000);
						driver.findElement(By.xpath("//div[@class='mat-calendar-controls']/button[2]")).click();
						year = driver.findElements(By.xpath("//td"));
					}
					for (WebElement c : year) {
						if (dates[2].equalsIgnoreCase(c.getText())) {
							System.out.println(c.getText());
							c.click();
							k = 1;
							break;
						}
					}
					if (k == 1)
						break;
				}
				List<WebElement> month = driver.findElements(By.xpath("//td"));
				Thread.sleep(1000);
				for (WebElement c : month) {
					if (dates[1].equalsIgnoreCase(c.getText())) {
						c.click();
						break;
					}
				}

				List<WebElement> caldate = driver.findElements(By.xpath("//td"));
				Thread.sleep(1000);
				for (WebElement c : caldate) {
					if (dates[0].equalsIgnoreCase(c.getText())) {
						c.click();
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("exection occured while selecting store" + e);
		}

	}

	@When("user clicks on Save")
	public void user_clicks_on_save() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(),' SAVE ')]")).click();
		} catch (Exception e) {
			System.out.println("execption occurred while save bod" + e);
		}
	}

	@Then("bod is done successfully")
	  public void bod_is_done_successfully() throws Exception {
		Thread.sleep(1000);
		reader = new CSVReader(new FileReader(CSV_BOD));
		String[] cell = reader.readNext();

		while ((cell = reader.readNext()) != null) {
			int i = 0;
        String CSV_bodresult = ".\\CSV_Result\\bodresult.csv";
        
        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_bodresult))) {
            writer.writeNext(new String[] { "After Successful Bod done, we compare the Expected Result with the Actual Result from UI." });
            writer.writeNext(new String[] { "Expected Result", "Actual Result from UI", "Result" });
            
            while ((cell = reader.readNext()) != null) {
                String message = cell[i + 9];
                String Value1 = message;
               // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                //WebElement bodSavedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Bod Saved Successfully')]")));
                String Value2=driver.findElement(By.xpath("//span[contains(text(),'Bod Saved Successfully')]")).getText();           
            	String result = Value1.equalsIgnoreCase(Value2)  ? "Passed" : "Failed";
				writer.writeNext(new String[] { Value1, Value2, result });
                
                // Initialize WebDriverWait
             
//
//                try {
//                 
//                	Thread.sleep(1000);
//                    WebElement bodSavedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                        By.xpath("//span[contains(text(),'Bod Saved Successfully')]")));
//                    Thread.sleep(1000);
//                    String Value2 = bodSavedElement.getText().trim();
//                    
//                    if (Value1.equalsIgnoreCase(Value2)) {
//                        result = "Passed";
//                        writer.writeNext(new String[] { Value1, Value2, result });
//                    }
                    
                    
//                    WebElement bodAlreadyDoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                        By.xpath("//span[contains(text(),'BOD IS ALREADY DONE FOR SELECTED DATE')]")));
//                    Thread.sleep(1000);
//                    WebElement eodNotDoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                        By.xpath("//span[contains(text(),'Eod Is Not Done For Previous Date. Please Do Eod Before Bod')]")));

                  
//                    String Value3 = bodAlreadyDoneElement.getText().trim();
//                    String Value4 = eodNotDoneElement.getText().trim();

                    // Compare the values and write the result
                   
//                    } else if (Value1.equalsIgnoreCase(Value3)) {
//                        result = "Failed";
//                        writer.writeNext(new String[] { Value1, Value3, result });
//                    } else if (Value1.equalsIgnoreCase(Value2)) {
//                        result = "Failed";
//                        writer.writeNext(new String[] { Value1, Value2, result });
//                    } else {
//                        // Fallback case when no match is found
//                        writer.writeNext(new String[] { Value1, "No Match Found", result });
//                    }
//                } catch (Exception e) {
////                    writer.writeNext(new String[] { message, "Unknown error: " + e.getMessage(), "Failed" });
////                    System.out.println("Element not found: " + message);
//                }
//            }
            System.out.println("CSV file has been written successfully.");
        } }catch (IOException e) {
            System.out.println("Error reading CSV or writing result: " + e.getMessage());
        }
	}}}

