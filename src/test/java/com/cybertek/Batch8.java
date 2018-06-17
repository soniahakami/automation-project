package com.cybertek;

import com.github.javafaker.Faker;

public class Batch8 {
	
	public static void main(String [] args) {
		
		System.out.println("Hello");
		
		Faker faker = new Faker();
		String creditcard = faker.finance().creditCard();
		System.out.println(creditcard);
		
	}
		
		
		
	}


