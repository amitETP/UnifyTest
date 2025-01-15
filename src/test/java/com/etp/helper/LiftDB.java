package com.etp.helper;

import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.opencsv.CSVWriter;

public class LiftDB {
	
	//private static final Logger logger = LogManager.getLogger(EndlessAisleDB.class);
	private static final String JDBC_URL = "jdbc:mysql://172.24.2.216:51759/UnifiedDB";
	private static final String USERNAME = "jatin.pandey";
	private static final String PASSWORD = "3D82VLmkktCP";



 //	public static  void liftdb() throws Exception {

		 public static void main(String[] args) throws Exception {
		        String query = "SELECT * FROM `tbl_LiftDropTrn` ORDER BY ID DESC LIMIT 1";
		        String CSV_liftdb = ".\\CSV_Result\\liftdb.csv";  

		        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		             Statement stmt = connection.createStatement();
		             ResultSet rs = stmt.executeQuery(query);
		             CSVWriter writer = new CSVWriter(new FileWriter(CSV_liftdb))) {

		           
		            writer.writeNext(new String[] { "InvoiceNumber from UI", "InvoiceNumber from DB", "Result" });
		            
		            while (rs.next()) {
		                String DBValue2 = rs.getString("LiftDropAmt");
		                double epsilon = 0.0001;  
		                double liftDropAmt = Double.parseDouble(DBValue2);  
		                double expectedResult = 6.0;  
		                double absLiftDropAmt = Math.abs(liftDropAmt);  

		               
		                System.out.println(DBValue2);
		                System.out.println(liftDropAmt);
		                System.out.println("LiftDropAmt (Absolute): " + absLiftDropAmt);
		                System.out.println("Expected Result: " + expectedResult);
		                
		                if (Math.abs(absLiftDropAmt - expectedResult) < epsilon) {
		                    String result = "Passed";
		                    writer.writeNext(new String[] { Double.toString(absLiftDropAmt), Double.toString(expectedResult), result });
		                } else {
		                    String result = "Failed";
		                    writer.writeNext(new String[] { Double.toString(absLiftDropAmt), Double.toString(expectedResult), result });
		                }
		            }

		        } 
		    }}
	