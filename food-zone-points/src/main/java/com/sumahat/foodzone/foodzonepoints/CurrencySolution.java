package com.sumahat.foodzone.foodzonepoints;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencySolution {

	
	
	  public static void main(String[] args) {
	        /* Read input */
	        Scanner scanner = new Scanner(System.in);
	        BigDecimal payment = scanner.nextBigDecimal();
	        scanner.close();
	    //    for (int i = 0; i < 1000; i++) {
	     //   	payment = payment.add(new BigDecimal("0.2"));
	      //  }
	        
	        System.out.println("India: "  + payment);
	        /* Create custom Locale for India. 
	          I used the "IANA Language Subtag Registry" to find India's country code */
	        Locale indiaLocale = new Locale("en", "IN");

	        /* Create NumberFormats using Locales */
	        NumberFormat us     = NumberFormat.getCurrencyInstance(Locale.US);
	        NumberFormat india  = NumberFormat.getCurrencyInstance(indiaLocale);
	        NumberFormat china  = NumberFormat.getCurrencyInstance(Locale.CHINA);
	        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);

	        /* Print output */        
	        System.out.println("US: "     + us.format(payment));
	        System.out.println("India: "  + india.format(payment));
	        System.out.println("China: "  + china.format(payment));
	        System.out.println("France: " + france.format(payment));
	    }
}
