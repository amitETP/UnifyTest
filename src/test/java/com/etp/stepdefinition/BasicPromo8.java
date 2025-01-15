package com.etp.stepdefinition;

import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.etp.helper.HelperClass;
import com.opencsv.CSVReader;

public class BasicPromo8 extends HelperClass {

	public void basicpromo8() throws Exception{
		// TODO Auto-generated method stub
		
		String CSV_file1 = ".\\CSV\\basicpromo.csv";
		CSVReader reader = null;
		
		
		
		try {
			 reader= new CSVReader(new FileReader(CSV_file1));
		     String[] cell=reader.readNext();

		     while((cell= reader.readNext())!=null)    	 
		    	 
		     {  
		    	 int i=0;
		    	 
		    	 String promoname = cell[i]; 
		         String fromdate = cell[i+1];
		         String  todate= cell[i+2];
//		         String  = cell[i+3];
//		         String  = cell[i+4];
//		         String  = cell[i+5];
		    	 
			// Create object of SimpleDateFormat class and decide the format
			DateFormat dateFormat = new SimpleDateFormat("dd");
			DateFormat dateFormat1 = new SimpleDateFormat("mm:ss");

			// System.out.println(dateFormat.format(date));
			// get current date time with Date()
			Date date = new Date();

			// Now format the date
			String date1 = dateFormat.format(date);
			String date2 = dateFormat1.format(date);

			// Print the Date
			int dateInt = Integer.parseInt(date1);
			System.out.println(dateInt);
			System.out.println(date2);

			// int FdateInt = dateInt +1;
			int FdateInt = dateInt;

			String FromDateF = String.valueOf(FdateInt);

			System.out.println(FromDateF);

			String FromDate = FromDateF;
			
			System.out.println("fill basic promo details");

			Thread.sleep(2000);
			WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(50));
			WebElement element3 = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='new-wrapper-id']//button[@id='plusButton']")));
			element3.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			WebElement element4 = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),' BASIC ')]")));
			element4.click();

		//	WebDriverWait apply = new WebDriverWait(driver, 50);
			WebElement element5 = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),' APPLY ')]")));
			element5.click();
//
		//	WebDriverWait clickpromo = new WebDriverWait(driver, 70);
			WebElement element6 = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[contains(text(),'Display Message on Checkout')]")));
			element6.click();

	//		WebDriverWait enterpromoname = new WebDriverWait(driver, 70);
			WebElement element7 = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='promoName']")));
			element7.sendKeys(promoname+date2);

			Thread.sleep(2000);
			driver.findElement(By.xpath("//textarea[@placeholder='Enter Promotion Description']"))
					.sendKeys("BasicPromotion"+date2);

			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			WebElement Elee1 = driver.findElement(By.xpath("//span[contains(text(),'Promotion Conditions')]"));
			Thread.sleep(1000);
			js1.executeScript("arguments[0].scrollIntoView();", Elee1);
			Thread.sleep(1000);

			// fromDate
//	    driver.findElement(By.xpath("(//*[@class='mat-datepicker-toggle-default-icon ng-star-inserted'])[1]")).click(); // Click on From  Calender
//	    List<WebElement> list1=driver.findElements(By.xpath("//*[@class='mat-calendar-body']/..//td")); // List of dates
//	   		
//	   		 int count1=list1.size();
//	   	//	 db.sysloginfo(log,"the no of days are:"+count1);
//	   		
//	   		for (int j=0;j<count1;j++)
//	   		{
//	   		Thread.sleep(1000);
//	   		String txt1=	driver.findElements(By.xpath("//*[@class='mat-calendar-body']/..//td")).get(j).getText();
//	   		// db.sysloginfo(log,"Selected Date:"+txt1);
	//
//	   	if(txt1.equals(FromDate)) 
//	   				{
//	   		 //    db.sysloginfo(log,"Click on From Date");
//	   			driver.findElements(By.xpath("//*[@class='mat-calendar-body']/..//td")).get(j).click();
//	   			break;
//	   				}
//	   		}

			// fromDate
			driver.findElement(By.xpath("(//*[@class='mat-datepicker-toggle-default-icon ng-star-inserted'])[1]"))
					.click();
			String f = fromdate;
			String[] dates = f.split(" ");

			driver.findElement(By.xpath("(//div[@class='mat-calendar-controls']/button)[1]")).click();

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

			// from time
			Thread.sleep(2000);
			// db.sysloginfo(log,"Click on From Time");
			driver.findElement(By.xpath("(//*[@class='ngx-material-timepicker-toggle'])[1]")).click();
			// Thread.sleep(3000);
			// db.sysloginfo(log,"Click on time HH (22)");

			driver.findElement(By.xpath(
					"//*[@class=\"clock-face__number clock-face__number--inner ng-star-inserted\"]/..//span[text()=' 22']"))
					.click();
			Thread.sleep(3000);

			// db.sysloginfo(log,"Click on OK");
			driver.findElement(By.xpath("(//*[@class='timepicker-button']/span)[2]")).click();
			Thread.sleep(2000);

			
			
			// to date

			driver.findElement(By.xpath("(//*[@class='mat-datepicker-toggle-default-icon ng-star-inserted'])[2]"))
					.click();
			String ff = todate;
			String[] dates1 = ff.split(" ");

			driver.findElement(By.xpath("(//div[@class='mat-calendar-controls']/button)[1]")).click();

			List<WebElement> years = driver.findElements(By.xpath("//td"));
			Thread.sleep(1000);
			int kk = 0;
			while (true) {
				if ((Integer.parseInt(dates1[2])) < (Integer
						.parseInt(driver.findElement(By.xpath("(//td[@role='gridcell'])[1]")).getText()))) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("//div[@class='mat-calendar-controls']/button[2]")).click();
					years = driver.findElements(By.xpath("//td"));
				}
				for (WebElement c : years) {
					if (dates1[2].equalsIgnoreCase(c.getText())) {
						c.click();
						kk = 1;
						break;
					}
				}
				if (kk == 1)
					break;
			}
			List<WebElement> months = driver.findElements(By.xpath("//td"));
			Thread.sleep(1000);
			for (WebElement c : months) {
				if (dates1[1].equalsIgnoreCase(c.getText())) {
					c.click();
					break;
				}
			}

			List<WebElement> caldates = driver.findElements(By.xpath("//td"));
			Thread.sleep(1000);
			for (WebElement c : caldates) {
				if (dates1[0].equalsIgnoreCase(c.getText())) {
					c.click();
					break;
				}
			}

			// To Time
			Thread.sleep(1000);
		//	db.sysloginfo(log, "Click on To Time");
			driver.findElement(By.xpath("(//*[@class='ngx-material-timepicker-toggle'])[2]")).click();
			
			Thread.sleep(1000);
			driver.findElement(By.xpath(
					"//*[@class=\"clock-face__number clock-face__number--inner ng-star-inserted\"]/..//span[text()=' 21']"))
					.click();
			Thread.sleep(1000);
		//	db.sysloginfo(log, "Click on OK");
			driver.findElement(By.xpath("(//*[@class='timepicker-button'])[2]")).click();
			
					
			//store attribute dropdown
			 WebElement Segmenttt= driver.findElement(By.xpath("//*[@ng-reflect-name='store']"));
			 Segmenttt.click();
				    List<WebElement> segmentDr = driver.findElements(By.tagName("mat-option"));
					 for(WebElement values:segmentDr)
					 {
						 String requiredvalue="Store"; 
						if(requiredvalue.equalsIgnoreCase(values.getText())) {
							System.out.println(values.getText());
							values.click();
							break;
						}
					 }
					 
					 Thread.sleep(1000);
					 
						//store attribute value dropdown
						
//						
									 Thread.sleep(6000);
										
									//    WebDriverWait waitsss = new WebDriverWait(driver, 1000);
										WebElement element63 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@ng-reflect-name='storeAttribValId']")));
										element63.click();
					  
					 Thread.sleep(1000);
					 driver.findElement(By.xpath("(//div[@class='mat-checkbox-inner-container'])[1]")).click();
						   
					Thread.sleep(1000);
					driver.findElement(By.xpath("//input[@id='invoiceTotalAmount']")).sendKeys("2");
					
					Thread.sleep(1000);				
					JavascriptExecutor js12 = (JavascriptExecutor) driver;
					WebElement Elee12 = driver.findElement(By.xpath("//span[contains(text(),'Promotion Action')]"));
					
					Thread.sleep(1000);
					js12.executeScript("arguments[0].scrollIntoView();", Elee12);
					
					Thread.sleep(4000);
					driver.findElement(By.xpath("//textarea[@id='promotionMessage']")).sendKeys("BasicPromotion"+date2);
					
					Thread.sleep(1000);
					driver.findElement(By.xpath("//span[contains(text(),'SAVE')]")).click();
					
					
					Thread.sleep(1000);
					driver.findElement(By.xpath("//button[contains(text(),' Yes ')]")).click();
					
					
				//	WebDriverWait waits = new WebDriverWait(driver, 50);
					WebElement element61 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),' Ok ')]")));
					element61.click();
					
					//Thread.sleep(3000);
					//driver.findElement(By.xpath("//button[contains(text(),' Ok ')]")).click();
			 }
		} catch (InterruptedException e) {
			// e.printStackTrace();
		
		}
		
	}

}
