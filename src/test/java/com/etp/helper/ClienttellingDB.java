package com.etp.helper;

import java.io.FileWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.etp.stepdefinition.Clienttelling;
import com.opencsv.CSVWriter;

public class ClienttellingDB {

	private static final String JDBC_URL = "jdbc:mysql://172.24.2.216:51759/UnifiedDB";
	private static final String USERNAME = "jatin.pandey";
	private static final String PASSWORD = "3D82VLmkktCP";

	public static void clvamount() throws Exception {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
			String query = "SELECT * FROM `tbl_Clientelling` WHERE GroupID=1948 AND CompanyID=1498 ORDER BY ID DESC LIMIT 1";
			String CSV_billwithwalkin = ".\\CSV_Result\\clienttellingresult.csv";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_billwithwalkin))) {
					String ClvAmount = Clienttelling.clv;
					ClvAmount = ClvAmount.replace(",", "");
					BigDecimal Value2 = new BigDecimal(ClvAmount); // Use BigDecimal for expected value
					BigDecimal Value1 = rs.getBigDecimal("TotalValue").setScale(2, RoundingMode.HALF_UP);
					String result = Value1.compareTo(Value2) == 0 ? "Passed" : "Failed";
					writer.writeNext(new String[] { Value1.toString(), Value2.toString(), result });

				} catch (Exception e) {
					System.out.println("Exception occurred while verifying db" + e);
				}
			}
		}
	}


public static void transaction() throws Exception {
	try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
		String query = "SELECT * FROM `tbl_Clientelling` WHERE GroupID=1948 AND CompanyID=1498 ORDER BY ID DESC LIMIT 1";
		String CSV_billwithwalkin = ".\\CSV_Result\\clienttellingresult.csv";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_billwithwalkin))) {
				writer.writeNext(new String[] { "Total No of Transaction on client telling " });
				String Transaction = Clienttelling.transaction;
				Transaction = Transaction.replace(",", "");
				BigDecimal Value2 = new BigDecimal(Transaction); // Use BigDecimal for expected value
				BigDecimal Value1 = rs.getBigDecimal("TotalTransactions").setScale(2, RoundingMode.HALF_UP);
				String result = Value1.compareTo(Value2) == 0 ? "Passed" : "Failed";
				writer.writeNext(new String[] { Value1.toString(), Value2.toString(), result });
			} catch (Exception e) {
				System.out.println("Exception occurred while verifying db" + e);
			}
		}
	}
}
}
