package com.etp.helper;

import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import com.etp.stepdefinition.EndlessAisle;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class EndlessAisleDB {
	private static final String JDBC_URL = "jdbc:mysql://172.24.2.216:51759/UnifiedDB";
	private static final String USERNAME = "jatin.pandey";
	private static final String PASSWORD = "3D82VLmkktCP";


 	public static  void endlessAisleInvoiceSave() {

		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
    String query = "SELECT * FROM `tbl_InvoiceNumbers` ORDER BY ID DESC LIMIT 1";
  	Statement stmt = connection.createStatement();
	ResultSet rs = stmt.executeQuery(query);
	while (rs.next()) { 
		String CSV_endlessaisleresult = ".\\CSV_Result\\endlessaisleresult.csv";
		try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_endlessaisleresult))) {
			writer.writeNext(new String[] { "After saving endlessaisle,we compare the Expected Result from UI with  the Actual Result from DB." });
			writer.writeNext(new String[] { "InvoiceNumber from UI", "InvoiceNumber from DB", "Result" });
			String Invoice = EndlessAisle.endlessaisle;	
			String Value2 = rs.getString("InvoiceNumber");
			String Value1 = Invoice;
			  
		      String result = Value1.compareTo(Value2) == 0 ? "Passed" : "Failed"; 
	            writer.writeNext(new String[] { Value1.toString(), Value2.toString(), result });
		
		}}

		}catch (Exception e) {
			System.out.println("exception occurred while fetching invoice from db");
		}
 	}}
