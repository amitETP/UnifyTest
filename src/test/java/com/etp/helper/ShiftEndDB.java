package com.etp.helper;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.etp.stepdefinition.ShiftBegin;
import com.etp.stepdefinition.ShiftEnd;
import com.opencsv.CSVWriter;

public class ShiftEndDB {
	
	private static final String JDBC_URL = "jdbc:mysql://172.24.2.216:51759/UnifiedDB";
	private static final String USERNAME = "jatin.pandey";
	private static final String PASSWORD = "3D82VLmkktCP";

	@SuppressWarnings("resource")
	public static void shiftEndDB() {
		String CSV_ShiftResult = ".\\CSV_Result\\shiftendresult1.csv";
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
			String query = "SELECT * FROM `tbl_ShiftTrnDenomination` WHERE GroupID=1948 AND CompanyID=1498 ORDER BY id DESC LIMIT 1";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_ShiftResult))) {
					writer.writeNext(new String[] { "While doing Shift End,we compare the Expected Result from UI with  the Actual Result from DB." });
					writer.writeNext(new String[] { "NetAmount from UI", "NetAmount from DB", "Result" });
					String expectedData = ShiftEnd.shiftendamount;
					System.out.println(expectedData);
					Double Value1 = rs.getDouble("Denominations");
					System.out.println("reportedamt :"+" "+Value1);
					Double Value2 = Double.parseDouble(expectedData);	
				
					System.out.println(Value2);
					if (Math.abs(Value2 - Value1) < 0.001) {
						String result = Value1.compareTo(Value2) == 0 ? "Passed" : "Failed";
						System.out.println("result:"+" "+result);
						writer.writeNext(new String[] { Value1.toString(), Value2.toString(), result });
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occurred while verifying db" + e);
		}
	}
}
