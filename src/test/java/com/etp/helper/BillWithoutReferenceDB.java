package com.etp.helper;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.etp.stepdefinition.BillWithoutReference;
import com.opencsv.CSVWriter;

public class BillWithoutReferenceDB {
	private static final String JDBC_URL = "jdbc:mysql://172.24.2.216:51759/UnifiedDB";
	private static final String USERNAME = "jatin.pandey";
	private static final String PASSWORD = "3D82VLmkktCP";
    public static  void billWithoutReferrenceInvoice() {	
	try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
    String query = "SELECT * FROM `tbl_InvoiceNumbers` ORDER BY ID DESC LIMIT 1";  
  	Statement stmt = connection.createStatement();
	ResultSet rs = stmt.executeQuery(query);
	while (rs.next()) {
		String CSV_billwithoutreferenceresult = ".\\CSV_Result\\billwithoutreferenceresult.csv";
		try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_billwithoutreferenceresult))) {
			 writer.writeNext(new String[] { "After bill without reference ,we compare the Expected Result from UI with  the Actual Result from DB." });
			 writer.writeNext(new String[] { "InvoiceNumber from UI", "InvoiceNumber from DB", "Result" });
			String Invoice = BillWithoutReference.withoutreferenceinvoice;
			String Value1 = rs.getString("InvoiceNumber");
			String Value2 = Invoice;
			String result = Value1.equalsIgnoreCase(Value2) ? "Passed" : "Failed"; 
			writer.writeNext(new String[] { Value1, Value2, result });
		}}	
	}catch (Exception e) {
		System.out.println("exception occurred while fetching invoice from db");
	}
	}

}
