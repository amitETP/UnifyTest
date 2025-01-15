package com.etp.commonlinks;

import org.openqa.selenium.By;

import com.etp.helper.HelperClass;

public class Modulemenu extends HelperClass{
	
	 public void Dashboard() {
		 try {
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//span[contains(text(),'DASHBOARD ')]")).click();
			 }catch (Exception e) {
			 System.out.println("Expection occured while clicking on Product Management"+" "+e);
			}
	  }
	 
	 public void CallToAction() {
//		 try {
//			 Thread.sleep(1000);
//			 driver.findElement(By.xpath("//span[contains(text(),'CALL TO ACTION ')]")).click();
//			 }catch (Exception e) {
//			System.out.println("Expection occured while clicking on Product Management"+" "+e);
//			}
	  }
	 public void OrderManagement() {
//		 try {
//			 Thread.sleep(1000);
//			 driver.findElement(By.xpath("//span[contains(text(),'ORDER MANAGEMENT ')]")).click();
//			 }catch (Exception e) {
//			System.out.println("Expection occured while clicking on Product Management"+" "+e);
//			}
	  }
	 public void InventoryManagement() {
		 try {
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//span[contains(text(),'INVENTORY MANAGEMENT ')]")).click();
			 }catch (Exception e) {
			System.out.println("Expection occurred while clicking on Inventory Management"+" "+e);
			}
	  }
	 public void ProductManagement() {
	 try {
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//span[contains(text(),'PRODUCT MANAGEMENT ')]")).click();
	 }catch (Exception e) {
	 System.out.println("Expection occurred while clicking on Product Management"+" "+e);
	 }
	  }
	 public void PricingAndPromotion() {
		 try {
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//span[contains(text(),'PRICING & PROMOTIONS ')]")).click();
			 }catch (Exception e) {
			System.out.println("Expection occurred while clicking on Product Management"+" "+e);
			}	
	  }
	 public void StatementOfAccount() {
//		 try {
//			 Thread.sleep(1000);
//			 driver.findElement(By.xpath("//span[contains(text(),'STATEMENT OF ACCOUNT ')]")).click();
//			 }catch (Exception e) {
//			System.out.println("Expection occured while clicking on Product Management"+" "+e);
//			}
	  }
	 
	 public void Integrations() {
		 try {
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//span[contains(text(),'INTEGRATIONS ')]")).click();
			 }catch (Exception e) {
			System.out.println("Expection occured while clicking on Product Management"+" "+e);
			}
	  }
	 public void ApiManagement() {
//		 try {
//			 Thread.sleep(1000);
//			 driver.findElement(By.xpath("//span[contains(text(),'API MANAGEMENT ')]")).click();
//			 }catch (Exception e) {
//			System.out.println("Expection occured while clicking on Product Management"+" "+e);
//			}
	  }
	 public void Administration() {
		 try {
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//span[contains(text(),'ADMINISTRATION ')]")).click();
			 }catch (Exception e) {
			System.out.println("Expection occured while clicking on Administration"+" "+e);
			}
	  }
	 public void StoreMangement() {
		 try {
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//span[contains(text(),'STORE MANAGEMENT ')]")).click();
			 }catch (Exception e) {
			System.out.println("Expection occured while clicking on Administration"+" "+e);
			}
	  }
	 public void CRM() {
		 try {
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//span[contains(text(),'CRM ')]")).click();
			 }catch (Exception e) {
			System.out.println("Expection occured while clicking on Administration"+" "+e);
			}
	  }
	 
	 public void REPORTING() {
		 try {
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//span[contains(text(),'REPORTING ')]")).click();
			 }catch (Exception e) {
			System.out.println("Expection occurred while clicking on Administration"+" "+e);
			}
	  }
	 public void StoreAdministration() {
		 try {
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//span[contains(text(),'STORE ADMINISTRATION ')]")).click();
			 }catch (Exception e) {
			System.out.println("Expection occured while clicking on Administration"+" "+e);
			}
	 }
		 public void POS() {
			 try {
				 Thread.sleep(1000);
				 driver.findElement(By.xpath("//span[contains(text(),'POS ')]")).click();
				 }catch (Exception e) {
				System.out.println("Expection occured while clicking on POS"+" "+e);
				}
	  }
}

