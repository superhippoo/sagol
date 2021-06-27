package com.sagol.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class authcdUtil {
	
	public static String generateAuthcd() {
		Random generator = new Random();       
		int number = generator.nextInt(999999);
		return String.format("%06d", number);		
	}

}
