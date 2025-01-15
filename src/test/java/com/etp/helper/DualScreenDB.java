package com.etp.helper;

import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.etp.stepdefinition.DualScreen;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class DualScreenDB {

	private static final String JDBC_URL = "jdbc:mysql://172.24.2.216:51759/UnifiedDB";
	private static final String USERNAME = "jatin.pandey";
	private static final String PASSWORD = "3D82VLmkktCP";

	public static void dualscreenrrp() {
		String CSV_discountresult = ".\\CSV_Result\\dualscreenresult.csv";
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
			String query = "SELECT * FROM tbl_InvoiceLine ORDER BY ID DESC LIMIT 1";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_discountresult))) {
					writer.writeNext(new String[] {"While doing bill save,we compare the  Expected Result from UI with  the Actual Result from DB."});
					writer.writeNext(new String[] { "RRP from UI ", "RRP from DB", "Result" });
					String NetAmount = DualScreen.rrp;
					NetAmount = NetAmount.replace(",", "");
					BigDecimal Value2 = new BigDecimal(NetAmount);
					BigDecimal Value1 = rs.getBigDecimal("RRP").setScale(2, RoundingMode.HALF_UP);
					String result = Value1.compareTo(Value2) == 0 ? "Passed" : "Failed";
					writer.writeNext(new String[] { Value1.toString(), Value2.toString(), result });
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occurred while verifying db" + e);
		}
	}

	public static void dualscreenofferprice() {

		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {

			String query = "SELECT * FROM tbl_InvoiceLine ORDER BY ID DESC LIMIT 1";

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String CSV_discountresult = ".\\CSV_Result\\dualscreenresult.csv";

				try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_discountresult , true))) {
				//	writer.writeNext(new String[] {"While doing bill save,we compare the  Expected Result from UI with  the Actual Result from DB."});
					writer.writeNext(new String[] { "OfferPrice from UI ", "OfferPrice from DB", "Result" });
					String SalesPrice = DualScreen.salesprice;
					SalesPrice = SalesPrice.replace(",", "");
					BigDecimal Value2 = new BigDecimal(SalesPrice);
					BigDecimal Value1 = rs.getBigDecimal("OfferPrice").setScale(2, RoundingMode.HALF_UP);
					String result = Value1.compareTo(Value2) == 0 ? "Passed" : "Failed";
					writer.writeNext(new String[] { Value1.toString(), Value2.toString(), result });
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occurred while verifying db" + e);
		}
	}

	public static void dualscreennetamount() {

		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
			String query = "SELECT * FROM tbl_InvoiceLine ORDER BY ID DESC LIMIT 1";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String CSV_discountresult = ".\\CSV_Result\\dualscreenresult.csv";

				try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_discountresult ,true))) {
			//		writer.writeNext(new String[] {"While doing bill save,we compare the  Expected Result from UI with  the Actual Result from DB."});
					writer.writeNext(new String[] { "NetAmount from UI ", "NetAmount from DB", "Result" });
					String NetAmount = DualScreen.price;
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

	public static void dualscreeninvoice() {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
			String query = "SELECT * FROM `tbl_InvoiceNumbers` ORDER BY ID DESC LIMIT 1";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String CSV_discountresult = ".\\CSV_Result\\dualscreenresult.csv";
				try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_discountresult , true))) {
		//			writer.writeNext(new String[] {"While doing bill save,we compare the  Expected Result from UI with  the Actual Result from DB."});
					writer.writeNext(new String[] { "Invoice Number from UI ", "Invoice Number from DB", "Result" });
						String Invoice = DualScreen.dualscreeninvoice;
						String Value2 = rs.getString("InvoiceNumber");
						String result = Invoice.compareTo(Value2) == 0 ? "Passed" : "Failed";
						writer.writeNext(new String[] { Invoice, Value2, result });
					}
				}
			}
		 catch (Exception e) {
			System.out.println("Exception occurred while verifying db" + e);
		}
	}
}
