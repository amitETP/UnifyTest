package com.etp.helper;

import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import com.etp.stepdefinition.ProductScan;
import com.etp.stepdefinition.TenderPromotion;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class TenderPromoDbVerify {
	private static final String JDBC_URL = "jdbc:mysql://172.24.2.216:51759/UnifiedDB";
	private static final String USERNAME = "jatin.pandey";
	private static final String PASSWORD = "3D82VLmkktCP";
 	public static  void tenderPromoNetAmount() {
 		String CSV_tenderresult = ".\\CSV_Result\\tenderresult.csv";
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
      String query = "SELECT * FROM tbl_InvoiceLine ORDER BY ID DESC LIMIT 1";
      
  	Statement stmt = connection.createStatement();
	ResultSet rs = stmt.executeQuery(query);
	while (rs.next()) { 
	try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_tenderresult))) {
		writer.writeNext(new String[] { "While doing bill save for tender promotion,we compare the Expected Result from UI with  the Actual Result from DB." });
		writer.writeNext(new String[] { "NetAmount from UI", "NetAmount from DB", "Result" });
		String NetAmount = TenderPromotion.tenderpromonetamount;	
		        NetAmount = NetAmount.replace(",", ""); 
				BigDecimal Value2 = new BigDecimal(NetAmount);
		        BigDecimal Value1 = rs.getBigDecimal("LineNetAmt").setScale(2, RoundingMode.HALF_UP);
			        	
		        String result = Value1.compareTo(Value2) == 0 ? "Passed" : "Failed"; 
	            writer.writeNext(new String[] { Value1.toString(), Value2.toString(), result });
	}}
		}catch (Exception e) {
			System.out.println("Exception occurred while verifying db"+e);
		}}
 	
 	public static void tenderPromoInvoiceSave() throws Exception {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
			String CSV_productscanresult2 = ".\\CSV_Result\\tenderpromoresult2.csv";
			String query = "SELECT * FROM `tbl_InvoiceNumbers` ORDER BY ID DESC LIMIT 1";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_productscanresult2))) {
				writer.writeNext(new String[] { "While saving ,we compare the Expected Result from UI with  the Actual Result from DB." });
				writer.writeNext(new String[] { "Invoice Number from UI", "Invoice Number from DB", "Result" });
				String Value1=TenderPromotion.tenderpromoinvoice;
				String Value2 = rs.getString("InvoiceNumber");
				String result = Value1.compareTo(Value2) == 0 ? "Passed" : "Failed";
				writer.writeNext(new String[] { Value1.toString(), Value2.toString(), result });
			}
				}
	}
	}
}


