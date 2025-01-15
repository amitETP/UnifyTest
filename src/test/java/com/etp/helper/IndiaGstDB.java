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

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class IndiaGstDB {
			private static final Logger logger = LogManager.getLogger(IndiaGstDB.class);
			private static final String JDBC_URL = "jdbc:mysql://172.24.2.216:51759/UnifiedDB";
			private static final String USERNAME = "jatin.pandey";
			private static final String PASSWORD = "3D82VLmkktCP";

		
		 	public static  void shiftdb() {
				try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
					String query = "SELECT * FROM `tbl_InvoiceLine` ORDER BY ID DESC LIMIT 1";
		      
		  	Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) { 
				String CSV_IndiaGSTResult = ".\\CSV Output\\indiagstresult.csv";
				String CSV_shiftbegin = ".\\CSV Output\\indiagstcharges.csv";
				CSVReader reader = null;
				reader = new CSVReader(new FileReader(CSV_shiftbegin));
				String[] cell = reader.readNext();

				try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_IndiaGSTResult))) {
					writer.writeNext(new String[] { "After saving bill ,we compare the Expected Result from UI with  the Actual Result from DB." });
					 writer.writeNext(new String[] { "Charges from UI ", "Charges from DB", "Result" });
				while ((cell = reader.readNext()) != null) {
					int i = 0;
					String Charges = cell[i];		

					Charges = Charges.replace(",", ""); 
					BigDecimal Value2 = new BigDecimal(Charges); 
			        BigDecimal Value1 = rs.getBigDecimal("LineChargesTotal").setScale(2, RoundingMode.HALF_UP);
	
			        String result = Value1.compareTo(Value2) == 0 ? "Passed" : "Failed"; 
		            writer.writeNext(new String[] { Value1.toString(), Value2.toString(), result });
				}
			}}}
					        
		catch (Exception e) {
				System.out.println("exception occurred while fetching invoice from db");
			}
		 	}}


