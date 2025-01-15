package com.etp.helper;

import java.io.FileWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.etp.stepdefinition.BillWithCharges;
import com.etp.stepdefinition.ProductScan;
import com.opencsv.CSVWriter;

public class BillWithChargesDB {

	private static final String JDBC_URL = "jdbc:mysql://172.24.2.216:51759/UnifiedDB";
	private static final String USERNAME = "jatin.pandey";
	private static final String PASSWORD = "3D82VLmkktCP";
	
	
	public static void headerChargesSave() throws Exception {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
			String CSV_billwithcharges = ".\\CSV_Result\\billwithcharges1.csv";
			String query = "SELECT * FROM tbl_InvoiceHeadChrgs ORDER BY ID DESC LIMIT 1";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_billwithcharges))) {
					// writer.writeNext(new String[] { "While doing bill save,we compare the
					// Expected Result from UI with the Actual Result from DB." });
					writer.writeNext(new String[] {"While doing bill save,we compare the Expected Result from UI with the Actual Result from DB." });
					writer.writeNext(new String[] { "Header Charges from UI", "Header Charges from DB", "Result" });
					String HeaderCharge = BillWithCharges.headercharges;
					HeaderCharge = HeaderCharge.replace(",", "");
					BigDecimal Value2 = new BigDecimal(HeaderCharge);
					BigDecimal Value1 = rs.getBigDecimal("ChargeAmt").setScale(2, RoundingMode.HALF_UP);
					String result = Value1.compareTo(Value2) == 0 ? "Passed" : "Failed";
					writer.writeNext(new String[] { Value1.toString(), Value2.toString(), result });
				}
			}
		}catch (Exception e) {
		System.out.println("Exception occurred while fetching headercharges"+e);
		}
	}

	public static void netAmount() {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
			String query = "SELECT * FROM tbl_InvoiceLine ORDER BY ID DESC LIMIT 1";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String CSV_billwithcharges = ".\\CSV_Result\\billwithcharges1.csv";
				try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_billwithcharges ,true))) {
					writer.writeNext(new String[] { "NetAmount from UI", "NetAmount from DB", "Result" });
					String NetAmount = BillWithCharges.netamount;
					NetAmount = NetAmount.replace(",", "");
					BigDecimal Value2 = new BigDecimal(NetAmount);
					BigDecimal Value1 = rs.getBigDecimal("LineNetAmt").setScale(2, RoundingMode.HALF_UP);
					String result = Value1.compareTo(Value2) == 0 ? "Passed" : "Failed";
					writer.writeNext(new String[] { Value1.toString(), Value2.toString(), result });
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occurred while verifying db" + e);
		}
	}

	public static void lineChargesSave() throws Exception {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
			String CSV_billwithcharges = ".\\CSV_Result\\billwithcharges1.csv";
			String query = "SELECT * FROM tbl_InvoiceLine ORDER BY ID DESC LIMIT 1";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_billwithcharges, true))) {
					// writer.writeNext(new String[] { "While doing bill save,we compare the
					// Expected Result from UI with the Actual Result from DB." });
					
					String LineCharge = BillWithCharges.linecharges;
					LineCharge = LineCharge.replace(",", "");
					BigDecimal Value2 = new BigDecimal(LineCharge);
					BigDecimal Value1 = rs.getBigDecimal("LineChargesTotal").setScale(2, RoundingMode.HALF_UP);
					String result = Value1.compareTo(Value2) == 0 ? "Passed" : "Failed";
					writer.writeNext(new String[] { Value1.toString(), Value2.toString(), result });
				}
			}
		}
	}

	public static void invoiceSave() throws Exception {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
			String CSV_billwithcharges = ".\\CSV_Result\\billwithcharges1.csv";
			String query = "SELECT * FROM `tbl_InvoiceNumbers` ORDER BY ID DESC LIMIT 1";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_billwithcharges, true))) {
					// writer.writeNext(new String[] { "While doing bill save,we compare the
					// Expected Result from UI with the Actual Result from DB." });
					writer.writeNext(new String[] { "Invoice from UI", "Invoice from DB", "Result" });
					String Value1 = BillWithCharges.invoice;
					String Value2 = rs.getString("InvoiceNumber");
					String result = Value1.equalsIgnoreCase(Value2) ? "Passed" : "Failed";
					writer.writeNext(new String[] { Value1.toString(), Value2.toString(), result });
				}
			}
		}
	}
}