package com.virgingames.utils;

import com.github.javafaker.Faker;

import java.util.Random;

public class TestUtils {

	public static String generateFirstName() {
		Faker faker = new Faker();
		return faker.name().firstName();
	}
	public static String generateEmail() {
		Faker faker = new Faker();
		return faker.address().country();
	}
	public static String getRandomValue(){
		Random random = new Random();
		int randomInt = random.nextInt(100000);
		return Integer.toString(randomInt);
	}

	public static void main(String[] args) {
		Faker faker = new Faker();
		System.out.println(faker.address().country());
		System.out.println(faker.name().username());
	}

}
