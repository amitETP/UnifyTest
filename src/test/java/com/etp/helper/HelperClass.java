package com.etp.helper;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HelperClass {
     
     public static WebDriver driver;
     
     private static Properties prop = new Properties();

     public static void loadProperties() throws IOException {
         FileReader reader = new FileReader(".\\src\\test\\java\\data.properties");
         prop.load(reader);
     }
     
     public static Properties getProperties() {
         return prop;
     }
     
     public static void openPage() throws Exception {	
    	   loadProperties(); 
    	 System.setProperty(prop.getProperty("chromedriver"),prop.getProperty("driverpath"));
    	 driver=new ChromeDriver();
    	 driver.manage().window().maximize();
         driver.get(prop.getProperty("url"));
     }
}
