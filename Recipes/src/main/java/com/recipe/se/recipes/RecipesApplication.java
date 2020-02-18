package com.recipe.se.recipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecipesApplication {

	public static void main(String[] args) {
		System.out.println("Server is starting");

		SpringApplication.run(RecipesApplication.class, args);
	}

}
