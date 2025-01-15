package com.etp.commonlinks;

import org.openqa.selenium.By;

import com.etp.helper.HelperClass;

public class Modulesubmenu extends HelperClass {
	
	//-------------------------Product Management---------------------------//
	
	public void ProductCatalog() {
		try {
			driver.findElement(By.linkText("Product Catalog")).click();
		} catch (Exception e) {
			System.out.println("exception occured while clicking on Product Master" + " " + e);
		}
	}
	public void ProductMaster() {
		try {
			driver.findElement(By.linkText("Product Master")).click();
		} catch (Exception e) {
			System.out.println("exception occured while clicking on Product Master" + " " + e);
		}
	}
	public void ProductAlias() {
		try {
			driver.findElement(By.linkText("Product Alias")).click();
		} catch (Exception e) {
			System.out.println("exception occured while clicking on Product Alias" + " " + e);
		}
	}
	
	public void UOMConversion() {
		try {
			driver.findElement(By.linkText("UOM Conversion")).click();
		} catch (Exception e) {
			System.out.println("exception occured while clicking on Product Master" + " " + e);
		}
	}
	
	public void BrandStoreMapoping() {
		try {
			driver.findElement(By.linkText("Brand Store Attribute Mapping ")).click();
		} catch (Exception e) {
			System.out.println("exception occured while clicking on Product Master" + " " + e);
		}
	}
	public void HierarchyType() {
		try {
			driver.findElement(By.linkText("Hierarchy Type")).click();
		} catch (Exception e) {
			System.out.println("exception occured while clicking on Product Master" + " " + e);
		}
	}
	
	public void HierarchyCreation() {
		try {
			driver.findElement(By.linkText("Hierarchy Creation")).click();
		} catch (Exception e) {
			System.out.println("exception occured while clicking on Product Master" + " " + e);
		}
	}


	
	
	//---------------------------------Inventory Management--------------------------------------------------//
	
	public void StockTransaction() {
		try {
			driver.findElement(By.linkText("")).click();
		} catch (Exception e) {
			System.out.println("exception occured while clicking on Product Master" + " " + e);
		}
	}
	public void UnifiedInventory() {

	}

	

	public void PurchaseOrderReceiving() {

	}

	public void NodeSetup() {
		try {
			driver.findElement(By.linkText("Stock Order Type")).click();
		} catch (Exception e) {
			System.out.println("exception occured while clicking on Product Master" + " " + e);
		}
	}

	public void LocationMaster() {

	}

	public void PostalCodeMaster() {

	}

	public void VendorMaster() {

	}

	public void StockOderType() {
		try {
			driver.findElement(By.linkText("Stock Order Type")).click();
		} catch (Exception e) {
			System.out.println("exception occured while clicking on Product Master" + " " + e);
		}

	}

	public void CostList() {

	}

	public void StockTake() {

	}
	
	
	//----------------------------------------Order Management-------------------------------------------------//
	
	public void OrderProcesing() {

	}
	
	public void Manifest() {

	}

	public void SalesReturn() {

	}

	public void OrderRules() {

	}

	public void SmartOrderRouting() {
		try {
			driver.findElement(By.linkText("Stock Order Type")).click();
		} catch (Exception e) {
			System.out.println("exception occured while clicking on Product Master" + " " + e);
		}
	}
	
	
	public void BOD() {
		try {
			driver.findElement(By.linkText("Begin of Day")).click();
		} catch (Exception e) {
			System.out.println("exception occured while clicking on Product Master" + " " + e);
		}
		
	}
	
	public void EOD() {
		try {
			driver.findElement(By.linkText("End Of Day")).click();
		} catch (Exception e) {
			System.out.println("exception occured while clicking on Product Master" + " " + e);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------Pricing and Promotions------------------------------------------------//
	
	
	public void PriceList() {
		try {
			driver.findElement(By.linkText("Product Alias")).click();
		} catch (Exception e) {
			System.out.println("exception occured while clicking on Product Master" + " " + e);
		}
	}

	public void Promotion() {
		try {
			driver.findElement(By.linkText("Product Alias")).click();
		} catch (Exception e) {
			System.out.println("exception occured while clicking on Product Master" + " " + e);
		}
	}

	public void CampaignDefinition() {

	}

	public void MarkdownPricelist() {

	}

	public void RetailCalender() {
		try {
			driver.findElement(By.linkText("Product Alias")).click();
		} catch (Exception e) {
			System.out.println("exception occured while clicking on Product Master" + " " + e);
		}
	}

	public void PriceListRoundingOffRule() {

	}

	public void MarkdownSlabPrice() {

	}

	public void ChargeDefinition() {

	}

	public void ChargeModel() {

	}

	public void ChargeSlab() {

	}

	public void CurrencyRate() {

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//------------------------------------------Administration-------------------------------------------------//
	
	
	

	

	

	
	

	

	

	


	

	

	public void Group() {
		try {
			driver.findElement(By.linkText("Group")).click();
		} catch (Exception e) {
			System.out.println("exception occured while clicking on Group" + " " + e);
		}

	}

	public void CompanySetup() {
		try {
			driver.findElement(By.linkText("Company Setup")).click();
		} catch (Exception e) {
			System.out.println("exception occured while clicking on Company Setup" + " " + e);
		}

	}

	public void UserGroup() {

	}

	public void UserMangement() {

	}

	public void CommonMasters() {

	}

	public void PasswordPolicy() {

	}

	public void AccessControl() {

	}

	public void PromotionAccess() {

	}

	public void ReasonMaster() {

	}

	public void UploadDownloadHistory() {

	}

	public void CommunicationProvider() {

	}

	public void CommunicationTemplate() {

	}

	public void AuditRules() {

	}

	public void BatchJobScheduler() {

	}

	public void TagMaster() {

	}

	public void EDCMaster() {

	}

	public void EDCConfiguration() {

	}

	public void Banking() {

	}

	public void RetailConfigGroupMaster() {

	}

	public void PaymentModes() {

	}

	public void RetailConfigTemplate() {

	}

	public void NumberSeriesTemplate() {

	}

	public void NumberSeriesStore() {

	}

	public void EmployeeMaster() {

	}

	public void TargetMaster() {

	}

	public void StoreEDCConfiguration() {

	}

	public void ReturnTransferAndTenderPolicy() {

	}

	public void RetailConfigStoreSpecific() {

	}

	public void CustomerCircle() {

	}

	public void CustomerList() {

	}

	public void CustomerTemplate() {

	}

	public void AgeGroupDefinition() {

	}

	public void AddressMaster() {

	}

	public void GVUpload() {

	}

	public void DigitalReceiptSetup() {

	}

	public void ReportingAll() {

	}

	public void ReportingFavorite() {

	}

	public void ReportingShared() {

	}

	public void ReportingScheduled() {
	}
	
	public void Payout() {

	}

	public void MarketPlaceIntegration() {

	}

	public void CarrierIntegration() {

	}

	public void ECommerceIntegration() throws Exception {

		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'e-Commerce Integration')]")).click();
	}

	public void ChannelIntegration() {

	}

	public void APIList() {

	}

	public void APIDashboard() {

	}

	public void ManageGateway() {

	}

	public void ServiceDetails() {

	}

	public void ClientApps() {

	}
	

}
