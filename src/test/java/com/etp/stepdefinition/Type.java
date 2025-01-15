package com.etp.stepdefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.etp.helper.HelperClass;

public class Type{
	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
	
	
	
		int i;
		String e= "(a + b) * (c + d)";
		String g="[(r*10+30)]";
		int count=0;
		String p="This is a world";
		
		String a=p.replaceAll(" ", "");
		
		System.out.println(a);
//		StringBuffer buffer=new StringBuffer();
//		buffer.append(g);
//		buffer.reverse();
		//System.out.print(buffer);
//		String a=buffer.toString();
//		
//		System.out.println(a);
		
//		  for ( i = 0; i < a.length(); i++) {
//	            char ch = a.charAt(i);
//	            if (ch == '(') {
//	                count++;
//	            } else if (ch == ')') {
//	                count--;
//	            }
//	        }
//		
//		
//		
//		System.out.println(count);
		
//		
//		if(g.contains("(") && g.contains(")") )
//		{
//		System.out.println("String contains parenthisis");
		
//		for(i=0;i<e.length();i++)
//		{
//			
//		}
		
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("")));
		
		
		
	//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
	
	}
	}

