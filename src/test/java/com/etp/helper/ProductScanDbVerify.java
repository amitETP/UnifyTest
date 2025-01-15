package com.etp.helper;

import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;


import com.etp.stepdefinition.Login;
import com.etp.stepdefinition.ProductScan;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;


public class ProductScanDbVerify {
	private static final String JDBC_URL = "jdbc:mysql://172.24.2.216:51759/UnifiedDB";
	private static final String USERNAME = "jatin.pandey";
	private static final String PASSWORD = "3D82VLmkktCP";

	public static void netAmount() throws Exception {
		 Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD); 
			String query = "SELECT * FROM tbl_InvoiceLine ORDER BY ID DESC LIMIT 1";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String CSV_productscanresult = ".\\CSV_Result\\productscanresult.csv";
					CSVWriter writer = new CSVWriter(new FileWriter(CSV_productscanresult)); 
					writer.writeNext(new String[] { "While doing bill save,we compare the Expected Result from UI with  the Actual Result from DB." });
					 writer.writeNext(new String[] { "NetAmount from UI", "NetAmount from DB", "Result" });
					String NetAmount = ProductScan.netamount;
					NetAmount = NetAmount.replace(",", "");
					BigDecimal Value2 = new BigDecimal(NetAmount);
					System.out.println("Value 2"+" "+Value2);
					BigDecimal Value1 = rs.getBigDecimal("LineNetAmt").setScale(2, RoundingMode.HALF_UP);
					String result = Value1.compareTo(Value2) == 0 ? "Passed" : "Failed";
					writer.writeNext(new String[] { Value1.toString(), Value2.toString(), result });
				}
			}
		
	
	
//	public static void finalAmount() {
//		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
//			String query = "SELECT * FROM tbl_InvoiceLine ORDER BY ID DESC LIMIT 1";
//			Statement stmt = connection.createStatement();
//			ResultSet rs = stmt.executeQuery(query);
//			while (rs.next()) {
//				String CSV_productscanresult = ".\\CSV_Result\\productscanresult.csv";
//				try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_productscanresult))) {
//					writer.writeNext(new String[] { "While doing bill save,we compare the Expected Result from UI with  the Actual Result from DB." });
//					 writer.writeNext(new String[] { "NetAmount from UI", "NetAmount from DB", "Result" });
//					String NetAmount = ProductScan.netamount;
//					NetAmount = NetAmount.replace(",", "");
//					BigDecimal Value2 = new BigDecimal(NetAmount);
//					System.out.println("Value 2"+" "+Value2);
//					BigDecimal Value1 = rs.getBigDecimal("LineNetAmt").setScale(2, RoundingMode.HALF_UP);
//					String result = Value1.compareTo(Value2) == 0 ? "Passed" : "Failed";
//					writer.writeNext(new String[] { Value1.toString(), Value2.toString(), result });
//				}
//			}
//		} catch (Exception e) {
//			System.out.println("Exception occurred while verifying db" + e);
//		}
//	}

	
//	public static void finalAmount() {
//	try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
//		String query = "SELECT * FROM tbl_InvoiceLine ORDER BY ID DESC LIMIT 1";
//		Statement stmt = connection.createStatement();
//		ResultSet rs = stmt.executeQuery(query);
//		while (rs.next()) {
//			String CSV_productscanresult = ".\\CSV_Result\\productscanresult.csv";
//			try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_productscanresult))) {
//				writer.writeNext(new String[] { "While doing bill save,we compare the Expected Result from UI with  the Actual Result from DB." });
//				 writer.writeNext(new String[] { "NetAmount from UI", "NetAmount from DB", "Result" });
//				String NetAmount = ProductScan.netamount;
//				NetAmount = NetAmount.replace(",", "");
//				BigDecimal Value2 = new BigDecimal(NetAmount);
//				System.out.println("Value 2"+" "+Value2);
//				BigDecimal Value1 = rs.getBigDecimal("LineNetAmt").setScale(2, RoundingMode.HALF_UP);
//				String result = Value1.compareTo(Value2) == 0 ? "Passed" : "Failed";
//				writer.writeNext(new String[] { Value1.toString(), Value2.toString(), result });
//			}
//		}
//	} catch (Exception e) {
//		System.out.println("Exception occurred while verifying db" + e);
//	}
//}
	
	public static void productScanInvoiceSave() throws Exception {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
			String CSV_productscanresult2 = ".\\CSV_Result\\productscanresult2.csv";
			String query = "SELECT * FROM `tbl_InvoiceNumbers` ORDER BY ID DESC LIMIT 1";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_productscanresult2))) {
				writer.writeNext(new String[] { "While doing bill save,we compare the Expected Result from UI with  the Actual Result from DB." });
				writer.writeNext(new String[] { "Invoice from UI", "Invoice from DB", "Result" });
				
				String Value1=ProductScan.productscaninvoice;
				String Value2 = rs.getString("InvoiceNumber");
				String result = Value1.compareTo(Value2) == 0 ? "Passed" : "Failed";
				writer.writeNext(new String[] { Value1.toString(), Value2.toString(), result });
			}
				}
	}
	}}
